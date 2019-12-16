package com.gamify.elearning.repository;

import java.util.List;

import com.gamify.elearning.entity.Course;
import com.ideyatech.opentides.core.repository.BaseEntityRepository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;

public interface CourseRepository extends BaseEntityRepository<Course, String> {

    @Query(value="select course from Course course where course.user.id = :id and course.deleted = false")
    List<Course> getOwnedCourses(@Param("id") String userId, Pageable pageable);

    @Query(value="select count(course) from Course course where course.user.id = :id and course.deleted = false")
    List<Course> getOwnedCoursesCount(@Param("id") String userId);

    @Query(value="select course from Course course where course.user.id != :id and course.deleted = false")
    List<Course> findAllExceptOwned(@Param("id") String userId, Pageable pageable);

    @Query(value="select count(course) from Course course where course.user.id != :id and course.deleted = false")
    int countAllExceptOwned(@Param("id") String userId);

    @Query(value="select course from Course course where course.deleted = false and (course.title like %:keyword% or course.tags like %:keyword%)")
    List<Course> searchCourse(@Param("keyword") String keyword, Pageable pageable);

//    @Query(value="select course from Course course where course.user.id = :id and course.lessons[0].deleted = false")
//    Course getCourseWithoutDeletedLessons(@Param("id") String id);

    @Query(value="select course from Course course where course.deleted = false")
    List<Course> getAllNotDeletedCourses();

    @Query(value="select count(course.id) from Course course where course.deleted = false")
    List<Course> countAllNotDeletedCourses();

    @Query(value="select course from Course course where course.deleted = false and course.id = :id")
    List<Course> getCourseByIdNotDeleted(@Param("id") String courseId);

}
