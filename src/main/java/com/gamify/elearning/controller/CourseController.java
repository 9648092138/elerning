package com.gamify.elearning.controller;

import com.gamify.elearning.dto.CourseDTO2;
import com.gamify.elearning.entity.*;
import com.gamify.elearning.repository.*;
import com.gamify.elearning.repository.projection.CourseProjection;
import com.gamify.elearning.repository.projection.SearchCourseProjection;
import com.ideyatech.opentides.core.web.controller.BaseRestController;
import com.ideyatech.opentides.um.repository.UserRepository;
import com.ideyatech.opentides.um.util.SecurityUtil;
import com.ideyatech.opentides.um.validator.CourseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 
 * @author johanna@ideyatech.com
 *
 */
@BasePathAwareController
//@RestController
@RequestMapping("/api/course")
public class CourseController extends BaseRestController<Course> {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private VideoRepository videoRepository;

	@Autowired
	private PreviewVideoRepository previewVideoRepository;
	
	@Autowired
	private BadgeRepository badgeRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LessonRepository lessonRepository;

	@Autowired
	private UserCourseRepository userCourseRepository;
	
	@Autowired
	private ELearningUserRepository elearningUserRepository;

	@Autowired
	CourseValidator courseValidator;

	@Autowired
	private CourseProgressRepository courseProgressRepository;

	@Autowired
	private VideoProgressRepository videoProgressRepository;

	@Autowired
	private ElementRepository elementRepository;

	@Autowired
	private QuizResultRepository quizResultRepository;
	
	@Autowired
	private ElementProgressRepository elementProgressRepository;
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getCourses() {
		if (SecurityUtil.currentUserHasPermission("ACCESS_ALL"))
			return ResponseEntity.ok(courseRepository.findAll());
		else {
			List<Course> result = (List<Course>) courseRepository.getAllNotDeletedCourses();
			List<CourseProjection> projected = new ArrayList<>();
            for (Course course : result) {
                projected.add(projectionFactory.createProjection(CourseProjection.class, course));
            }
			return ResponseEntity.ok(projected);
		}
	}

	@GetMapping("/findAll/count")
	public @ResponseBody ResponseEntity<?> getAllCoursesCount() {
        return ResponseEntity.ok(courseRepository.countAllNotDeletedCourses());
	}

	@GetMapping("/findAll/count-exclude-owned")
	public @ResponseBody ResponseEntity<?> getAllCoursesCountExcludeOwned() {
		String userId = SecurityUtil.getJwtSessionUser().getId();
		return ResponseEntity.ok(courseRepository.countAllExceptOwned(userId));
	}

	@GetMapping("/find/{page}/{size}")
	public @ResponseBody ResponseEntity<?> getRecentCourses(@PathVariable Integer page, @PathVariable Integer size) {
		String userId = SecurityUtil.getJwtSessionUser().getId();
		List<Course> courses = courseRepository.findAllExceptOwned(userId, 
						new PageRequest(page, size, new Sort(Sort.Direction.DESC, "createDate")));
		List<CourseProjection> projected = new ArrayList<>();
		for (Course course : courses) {
            projected.add(projectionFactory.createProjection(CourseProjection.class, course));
        }

		return ResponseEntity.ok(projected);
	}

	@GetMapping("/findpopular/{page}/{size}")
	public @ResponseBody ResponseEntity<?> getPopularCourses(@PathVariable Integer page, @PathVariable Integer size) {
		String userId = SecurityUtil.getJwtSessionUser().getId();
		List<Map<String, Object>> courses = userCourseRepository.findPopularCourses(new PageRequest(page, size));
		List<Map<String, Object>> projected = new ArrayList<>();
		for (Map<String, Object> map: courses) {
			Course course = (Course) map.get("course");
			CourseProjection proj = projectionFactory.createProjection(CourseProjection.class, course);
			Map<String, Object> newMap = new HashMap<>();
			newMap.put("course", proj);
			newMap.put("takers", map.get("takers"));
			projected.add(newMap);
		}
		return ResponseEntity.ok(projected);
	}

	@GetMapping("/findpopular/count")
	public @ResponseBody ResponseEntity<?> getPopularCoursesCount() {
		List<Map<String, Object>> records = userCourseRepository.getAllPopularCoursesCnt();
		return ResponseEntity.ok(records.size());
	}

	@GetMapping("/findowned/{page}/{size}")
	public @ResponseBody ResponseEntity<?> getOwnedCourses(@PathVariable Integer page, @PathVariable Integer size) {
		String userId = SecurityUtil.getJwtSessionUser().getId();
		List<Course> courses = courseRepository.getOwnedCourses(userId, new PageRequest(page, size));
		
		List<CourseProjection> projected = new ArrayList<>();
        for (Course course : courses) {
            projected.add(projectionFactory.createProjection(CourseProjection.class, course));
        }

		return ResponseEntity.ok(projected);
	}

	@GetMapping("/findowned/count")
	public @ResponseBody ResponseEntity<?> getOwnedCoursesCount() {
		String userId = SecurityUtil.getJwtSessionUser().getId();
		return ResponseEntity.ok(courseRepository.getOwnedCoursesCount(userId));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getCourseById(@PathVariable String id) {
		Course course = null;
		List<Course> courseList = courseRepository.getCourseByIdNotDeleted(id);
		if(courseList.size() > 0) course = courseList.get(0);
        CourseProjection success = projectionFactory.createProjection(CourseProjection.class, course);
		return ResponseEntity.ok(success);
	}

	@RequestMapping(value = "/progress/percent/{courseId}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getCourseProgressPercent(@PathVariable String courseId) {
		String userId = SecurityUtil.getJwtSessionUser().getId();
		CourseProgress courseProgress = courseProgressRepository.getCourseProgressByCourseAndUser(courseId, userId);
		if (courseProgress == null) {
			return ResponseEntity.ok(0);
		} else {
			int totalNumElem = getTotalNumElem(courseRepository.findOne(courseId));
			
			List<ElementProgress> elemProgress = courseProgress.getElementLogs();
			int countFinished = 0;
			for (ElementProgress elemProg: elemProgress) {
				if (elemProg.isCompleted()) {
					countFinished++;
				}
			}
			float percentFinished = (float) countFinished / (float) totalNumElem * 100f;
			return ResponseEntity.ok(Math.round(percentFinished));
		}
	}

	private int getTotalNumElem(Course course) {
		int total = 0;
		for (Lesson lesson: course.getLessons()) {
			total += lesson.getNumOfElements();
		}
		return total;
	}
	
	@RequestMapping(value = "/progress/{courseId}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getCourseProgress(@PathVariable String courseId){
		String userId = SecurityUtil.getJwtSessionUser().getId();
		ELearningUser user = elearningUserRepository.findOne(userId);
		CourseProgress courseProgress = getOrCreateCourseProgress(user, courseId);

		Map<String, Object> courseProgMap = new HashMap<>();

		courseProgMap.put("courseId", courseProgress.getCourse().getId());

		
		List<Map<String, Object>> elemProgList = new ArrayList<>();
		if (courseProgress.getElementLogs() != null) {
			for (ElementProgress elemProg: courseProgress.getElementLogs()) {
				Map<String, Object> elemProgMap = new HashMap<>();
				elemProgMap.put("id", elemProg.getElement().getId());
				elemProgMap.put("completed", elemProg.isCompleted());
				if (elemProg.getElement() instanceof Quiz) {
					List<QuizResult> results = quizResultRepository.getResultsByQuizAndUser(elemProg.getElement().getId(), user.getId());
					if (results.size() > 0) {
						QuizResult result = results.get(0);
						elemProgMap.put("score", result.getScore());
						elemProgMap.put("totalItems", result.getTotalItems());
						elemProgMap.put("passed", result.getPassed());
					}
				}
				elemProgList.add(elemProgMap);
			}
		}

		courseProgMap.put("elements", elemProgList);

		return ResponseEntity.ok(courseProgMap);
	}
	
	private CourseProgress getOrCreateCourseProgress(ELearningUser user, String courseId){
		CourseProgress courseProgress = courseProgressRepository.getCourseProgressByCourseAndUser(courseId, user.getId());
		if(courseProgress == null){
			courseProgress = new CourseProgress();
			courseProgress.setCourse(courseRepository.findOne(courseId));
			courseProgress.setUser(user);
			courseProgress = courseProgressRepository.save(courseProgress);
		}
		return courseProgress;
	}

	@GetMapping("/progress/{courseId}/{elementId}")
	public @ResponseBody ResponseEntity<?> recordElementProgress(@PathVariable String courseId, @PathVariable String elementId){

		String userId = SecurityUtil.getJwtSessionUser().getId();
		ELearningUser user = elearningUserRepository.findOne(userId);
		CourseProgress courseProgress = getOrCreateCourseProgress(user, courseId);
		Element element = elementRepository.findOne(elementId);
		if(element instanceof Video) {
			VideoProgress videoProg = videoProgressRepository.getVideoProgressByCourseProgressElementAndUser(courseProgress.getId(), element.getId(), user.getId());
			if(videoProg == null){
				videoProg = new VideoProgress();
				videoProg.setUser(user);
				videoProg.setCourseProgress(courseProgress);
				videoProg.setElement(element);
			}
			videoProg.setCompleted(true);
			videoProgressRepository.save(videoProg);
		} else if(element instanceof Quiz) {
			ElementProgress quizElemProgress = elementProgressRepository.getElementProgressByCourseProgressElementAndUser(courseProgress.getId(), element.getId(), user.getId());
			if (quizElemProgress == null) {
				quizElemProgress = new ElementProgress();
				quizElemProgress.setUser(user);
				quizElemProgress.setCourseProgress(courseProgress);
				quizElemProgress.setElement(element);
			}
			quizElemProgress.setCompleted(true);
			elementProgressRepository.save(quizElemProgress);
		}

		if (!courseProgress.getFinished()) {
			courseProgress = getOrCreateCourseProgress(user, courseId); // Get again so that the newly saved element is included
			boolean finishedAll = true;
			for (ElementProgress elemProg: courseProgress.getElementLogs()) {
				if (!elemProg.isCompleted()) {
					finishedAll = false;
				}
			}
			courseProgress.setFinished(finishedAll);
			courseProgressRepository.save(courseProgress);
		}
		
		return ResponseEntity.ok("Successfully Recorded Element Progress");
	}
	
	@PostMapping("add")
	public @ResponseBody ResponseEntity<?> addCourse(@RequestBody CourseDTO2 courseDto2, BindingResult bindingResult,
			HttpServletRequest request) {
		String userId = SecurityUtil.getJwtSessionUser().getId();
		ELearningUser user = elearningUserRepository.findOne(userId);

		// courseValidator.validate(courseDto2, bindingResult);
		// if (bindingResult.hasErrors()) {
		// 	List<MessageResponse> messageResponses = CrudUtil.convertErrorMessage(bindingResult, request.getLocale(),
		// 			messageSource);
		// 	return ResponseEntity.badRequest().body(messageResponses);
		// }
		
		Course course = null;

		if(courseDto2.getId() == null || courseDto2.getId().isEmpty()) {
			course = new Course();
			course.setNumOfLessons(0);
			course.setUser(user);
			String vimeoId = courseDto2.getVimeoId();
			String fileName = courseDto2.getFileName();
			if(courseDto2.getBadgeId() != null && !courseDto2.getBadgeId().isEmpty()) {
				Badge badge = badgeRepository.findOne(courseDto2.getBadgeId());
				if(badge != null) {
					Set<Badge> badges = new HashSet<>();
			        badges.add(badge);
			        course.setBadges(badges);
				}
			}
			course.setTitle(courseDto2.getTitle());
			course.setDescription(courseDto2.getDescription());
			course.setTags(courseDto2.getTags());
			course = courseRepository.save(course);
			// if(previewVideo != null /*&& video.getYoutubeId() != null && !video.getYoutubeId().isEmpty()*/) {
			// 	previewVideo.setCourse(course);mes
			// 	previewVideoRepository.save(previewVideo);
			// }

			if (vimeoId != null && !vimeoId.isEmpty()) {
				PreviewVideo newPreview = new PreviewVideo();
				newPreview.setVimeoId(vimeoId);
				newPreview.setCourse(course);
				newPreview.setFileName(fileName);
				previewVideoRepository.save(newPreview);
			}
			
			if (course != null) {
				return ResponseEntity.ok(projectionFactory.createProjection(CourseProjection.class, course));
			}
		} else {
			course = courseRepository.findOne(courseDto2.getId());
			if(course != null) {
				course.setTitle(courseDto2.getTitle());
				course.setDescription(courseDto2.getDescription());
				course.setTags(courseDto2.getTags());
				if(courseDto2.getBadgeId() != null && !courseDto2.getBadgeId().isEmpty()) {
					Badge badge = badgeRepository.findOne(courseDto2.getBadgeId());
					if(badge != null) {
						Set<Badge> badges = new HashSet<>();
				        badges.add(badge);
				        course.setBadges(badges);
					}
				}
			}
			
			String vimeoId = courseDto2.getVimeoId();
			String fileName = courseDto2.getFileName();
			PreviewVideo previewVideo = previewVideoRepository.findByCourseId(course.getId());
			if (previewVideo == null) {
				previewVideo = new PreviewVideo();
			}
			if(previewVideo.getVimeoId() == null || !previewVideo.getVimeoId().equals(vimeoId)) {
				previewVideo.setVimeoId(vimeoId);
				previewVideo.setCourse(course);
				previewVideo.setFileName(fileName);
				previewVideoRepository.save(previewVideo);
			}

			course = courseRepository.save(course);
			if (course != null) {
				return ResponseEntity.ok(projectionFactory.createProjection(CourseProjection.class, course));
			}
		}

		return new ResponseEntity<String>("Could not save course.", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping("/{id}/delete")
	public @ResponseBody ResponseEntity<?> deleteCourse(@PathVariable String id, HttpServletRequest httpRequest) {
		Course course = courseRepository.findOne(id);
		if (course == null) {
			return new ResponseEntity<String>("The course you are trying to delete does not exist.",
					HttpStatus.BAD_REQUEST);
		}
		course.setDeleted(true);
		courseRepository.save(course);
		return ResponseEntity.ok("Successfully deleted course.");

	}

//	@GetMapping("/search/{keyword}")
	public @ResponseBody ResponseEntity<?> search(@PathVariable String keyword, HttpServletRequest httpRequest) {
		Date startTime = new Date();
		int maxResults = 12;
		List<Course> courses = courseRepository.searchCourse(keyword, new PageRequest(0, maxResults));
		int maxSuggestions = 6;
		List<String> suggestions = new ArrayList<>();
		for (Course course: courses) {
			String[] tags = course.getTags().split(",");
			if (maxSuggestions <= 0) {
				break;
			}
			for (String tag: tags) {
				if (tag.contains(keyword)) {
					if (maxSuggestions-- > 0) {
						String tagLower = tag.toLowerCase();
						if (!suggestions.contains(tagLower)) {
							suggestions.add(tagLower);
						}
					}
					else {
						break;
					}
				}
			}
		}

		int maxCourses = 6;
		List<SearchCourseProjection> projected = new ArrayList<>();
        for (Course course : courses) {
			if (maxCourses-- > 0) {
				projected.add(projectionFactory.createProjection(SearchCourseProjection.class, course));
			} else if (maxSuggestions-- > 0) {
				projected.add(projectionFactory.createProjection(SearchCourseProjection.class, course));
			}
		}

		Map<String, List<? extends Object>> resultsAndSuggestions = new HashMap<>();
		resultsAndSuggestions.put("courses", projected);
		resultsAndSuggestions.put("suggestions", suggestions);

		Date endTime = new Date();
		System.out.println(endTime.getTime()-startTime.getTime());

		return ResponseEntity.ok(resultsAndSuggestions);
	}

	@GetMapping("/search/{keyword}")
	public @ResponseBody ResponseEntity<?> search2(@PathVariable String keyword, HttpServletRequest httpRequest) {
		Date startTime = new Date();
		int maxResults = 12;
		int maxSuggestions = 6;
		List<Course> courses = courseRepository.searchCourse(keyword, new PageRequest(0, maxResults));

		List<String> suggestions = new ArrayList<>();
		for (Course course: courses) {
			System.out.println(course.getTitle());
			String[] tags = course.getTags().split(",");
			if (maxSuggestions <= 0) {
				break;
			}
			for (String tag: tags) {
				if (tag.contains(keyword)) {
					if (maxSuggestions-- > 0) {
						String tagLower = tag.toLowerCase();
						if (!suggestions.contains(tagLower)) {
							suggestions.add(tagLower);
						}
					}
					else {
						break;
					}
				}
			}
		}

		int maxCourses = 6;
		List<SearchCourseProjection> projected = new ArrayList<>();
		for (Course course : courses) {
			if (maxCourses-- > 0 || maxSuggestions-- >0) {
				projected.add(projectionFactory.createProjection(SearchCourseProjection.class, course));
			} else break;
		}

		Map<String, List<? extends Object>> resultsAndSuggestions = new HashMap<>();
		resultsAndSuggestions.put("courses", projected);
		resultsAndSuggestions.put("suggestions", suggestions);

		Date endTime = new Date();
		System.out.println(endTime.getTime()-startTime.getTime());

		return ResponseEntity.ok(resultsAndSuggestions);
	}

	@GetMapping("/full-search/{keyword}")
	public @ResponseBody ResponseEntity<?> fullSearch(@PathVariable String keyword, HttpServletRequest httpRequest) {
		int maxResults = 12;
		List<Course> courses = courseRepository.searchCourse(keyword, new PageRequest(0, maxResults));
		int maxSuggestions = 6;
		List<String> suggestions = new ArrayList<>();
		for (Course course: courses) {
			String[] tags = course.getTags().split(",");
			if (maxSuggestions <= 0) {
				break;
			}
			for (String tag: tags) {
				if (tag.contains(keyword)) {
					if (maxSuggestions-- > 0) {
						String tagLower = tag.toLowerCase();
						if (!suggestions.contains(tagLower)) {
							suggestions.add(tagLower);
						}
					}
					else {
						break;
					}
				}
			}
		}

		int maxCourses = 6;
		List<SearchCourseProjection> projected = new ArrayList<>();
        for (Course course : courses) {
			if (maxCourses-- > 0) {
				projected.add(projectionFactory.createProjection(SearchCourseProjection.class, course));
			} else if (maxSuggestions-- > 0) {
				projected.add(projectionFactory.createProjection(SearchCourseProjection.class, course));
			}
		}
		
		Map<String, List<? extends Object>> resultsAndSuggestions = new HashMap<>();
		resultsAndSuggestions.put("courses", projected);
		resultsAndSuggestions.put("suggestions", suggestions);

		return ResponseEntity.ok(resultsAndSuggestions);
	}

	@GetMapping("/temp/fix-data")
	public @ResponseBody ResponseEntity<?> fixData() {
		List<Course> courses = (List<Course>) courseRepository.findAll();
		for (Course course: courses) {
			for (int i = 0; i < course.getLessons().size(); i++) {
				Lesson lesson = course.getLessons().get(i);
				lesson.setOrdinal(i+1);
				lesson.setNumOfElements(lesson.getElements().size());
				int quizCount = 0;
				int videoCount = 0;
				for (int j = 0; j < lesson.getElements().size(); j++) {
					Element elem = lesson.getElements().get(j);
					elem.setOrdinal(j+1);
					if (elem instanceof Quiz) {
						Quiz quiz = (Quiz) elem;
						for (int k = 0; k < quiz.getQuestions().size(); k++) {
							Question question = quiz.getQuestions().get(k);
							question.setOrdinal(k+1);
							for (int l = 0; l < question.getChoices().size(); l++) {
								Choice choice = question.getChoices().get(l);
								choice.setOrdinal(l+1);
							}
						}
						quizCount++;
					} else if (elem instanceof Video) {
						videoCount++;
					}
				}
				lesson.setNumOfQuizzes(quizCount);
				lesson.setNumOfVideos(videoCount);
			}
		}
		return ResponseEntity.ok("OK");
	}

}
