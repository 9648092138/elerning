import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SelectCategeryComponent } from './select-categery/select-categery.component';
import { CourseCreationLoginComponent } from './course-components/course-creation-login/course-creation-login.component'; 
import { DashboardComponent } from './course-components/dashboard/dashboard.component';
import { YourClassroomComponent } from './course-components/your-classroom/your-classroom.component';
import { StudentsComponent } from './course-components/users/students/students.component';
import { TeachersComponent } from './course-components/users/teachers/teachers.component';
import { AffiliatesComponent } from './course-components/users/affiliates/affiliates.component';
import { ThemeComponent } from './course-components/site/theme/theme.component';
import { DomainsComponent } from './course-components/site/domains/domains.component';
import { NavigationComponent } from './course-components/site/navigation/navigation.component';
import { PagesComponent } from './course-components/site/pages/pages.component';
import { CustomCodeComponent } from './course-components/site/custom-code/custom-code.component';
import { TransactionComponent } from './course-components/sales/transaction/transaction.component';
import { StatementsComponent } from './course-components/sales/statements/statements.component';
import { BreakdownComponent } from './course-components/sales/breakdown/breakdown.component';
import { AccountComponent } from './course-components/emails/account/account.component';
import { TemplateComponent } from './course-components/emails/template/template.component';
import { TemplateEditorComponent } from './course-components/emails/template-editor/template-editor.component';
import { ListsComponent } from './course-components/emails/lists/lists.component';
import { HistoryEdmComponent } from './course-components/emails/history-edm/history-edm.component';
import { ComposeEdmComponent } from './course-components/emails/compose-edm/compose-edm.component'; 
import { GeneralComponent } from './course-components/Settings/general/general.component';
import { PaymentComponent } from './course-components/Settings/payment/payment.component';
import { NotificationsComponent } from './course-components/Settings/notifications/notifications.component';
import { PlanComponent } from './course-components/Settings/plan/plan.component';
import { BillingComponent } from './course-components/Settings/billing/billing.component';
import { TeacherViewLoginComponent } from './teacher-components/teacher-view-login/teacher-view-login.component';
import { TeacherDashboardComponent } from './teacher-components/teacher-dashboard/teacher-dashboard.component';
import { SetHomworkComponent } from './teacher-components/set-homwork/set-homwork.component';
import { SetAssignmentComponent } from './teacher-components/set-assignment/set-assignment.component';
import { TStudentsComponent } from './teacher-components/t-students/t-students.component';
import { TTemplateComponent } from './teacher-components/t-emails/t-template/t-template.component';
import { TTemplateEditorComponent } from './teacher-components/t-emails/t-template-editor/t-template-editor.component';
import { THistoryComponent } from './teacher-components/t-emails/t-history/t-history.component';
import { TComposeEdmComponent } from './teacher-components/t-emails/t-compose-edm/t-compose-edm.component';
import { BasicInfoComponent } from './course-components/Create-a-Course/basic-info/basic-info.component';
import { CurriculumComponent } from './course-components/Create-a-Course/curriculum/curriculum.component';
import { PricingComponent } from './course-components/Create-a-Course/pricing/pricing.component';
import { FlatPackComponent } from './course-components/Create-a-Course/flat-pack/flat-pack.component';
import { ReportsComponent } from './course-components/Create-a-Course/reports/reports.component';
import { CoursePreviewComponent } from './course-components/create-a-Course/course-preview/course-preview.component';
import { SitepcourseComponent } from './course-components/site/site-preview/sitepcourse/sitepcourse.component';
import { SitepdetailsComponent } from './course-components/site/site-preview/sitepdetails/sitepdetails.component';
import { TBasicInfoComponent } from './teacher-components/teach-create-a-course/t-basic-info/t-basic-info.component';
import { TCurriculumComponent } from './teacher-components/teach-create-a-course/t-curriculum/t-curriculum.component';
import { TReportsComponent } from './teacher-components/teach-create-a-course/t-reports/t-reports.component';
import { TCoursePrevComponent } from './teacher-components/teach-create-a-course/t-course-prev/t-course-prev.component';
import { CourseLibraryComponent } from './teacher-components/course-library/course-library.component';
import { StudentDashboardComponent } from './student-view-components/student-dashboard/student-dashboard.component';
import { StudentPreviewComponent } from './student-view-components/student-preview/student-preview.component';


const routes: Routes = [
  { path: '', component:SelectCategeryComponent,},
  { path: 'course-creation-login', component:CourseCreationLoginComponent,},
  { path: 'dashboard', component:DashboardComponent,},
  { path: 'your-classroom', component:YourClassroomComponent,},
  { path: 'students', component:StudentsComponent, },
  { path: 'teachers', component:TeachersComponent,},
  { path: 'Affiliates', component:AffiliatesComponent,},
  { path: 'theme', component:ThemeComponent,},
  { path: 'domains', component:DomainsComponent,},
  { path: 'navigation', component:NavigationComponent,},
  { path: 'pages', component:PagesComponent,},
  { path: 'custom-code', component:CustomCodeComponent,},
  { path: 'transaction', component:TransactionComponent,},
  { path: 'statements', component:StatementsComponent,},
  { path: 'breakdown', component:BreakdownComponent,},
  { path: 'account', component:AccountComponent,},
  { path: 'template', component:TemplateComponent,},
  { path: 'template-editor', component: TemplateEditorComponent,},
  { path: 'lists', component: ListsComponent,},
  { path: 'history-edm', component: HistoryEdmComponent,},
  { path: 'compose-edm', component: ComposeEdmComponent,},
  { path: 'general', component: GeneralComponent,},
  { path: 'payment', component: PaymentComponent,},
  { path: 'notifications', component: NotificationsComponent,},
  { path: 'plan', component: PlanComponent,},
  { path: 'billing', component: BillingComponent,},
  { path: 'teacher-view-login', component: TeacherViewLoginComponent,},
  { path: 'teacher-dashboard', component: TeacherDashboardComponent,},
  { path: 'sethomwork', component: SetHomworkComponent,},
  { path: 'setassignment', component: SetAssignmentComponent,},
  { path: 'tstudents', component: TStudentsComponent,},
  { path: 'ttemplate', component: TTemplateComponent,},
  { path: 'ttemplateeditor', component: TTemplateEditorComponent,},
  { path: 'thistory', component: THistoryComponent,},
  { path: 'tcomposeedm', component: TComposeEdmComponent,},
  { path: 'basicinfo', component: BasicInfoComponent,},
  { path: 'curriculum', component: CurriculumComponent,},
  { path: 'pricing', component: PricingComponent,},
  { path: 'flatpack', component: FlatPackComponent,},
  { path: 'reports', component: ReportsComponent,},
  { path: 'coursepreview', component: CoursePreviewComponent,},
  { path: 'sitepcourse', component: SitepcourseComponent,},
  { path: 'sitepdetails', component: SitepdetailsComponent,},
  { path: 'tbasicinfo', component: TBasicInfoComponent,},
  { path: 'tcurriculum', component: TCurriculumComponent,},
  { path: 'treports', component: TReportsComponent,},
  { path: 'tcourseprev', component: TCoursePrevComponent,},
  { path: 'courselibrary', component: CourseLibraryComponent,},
  { path: 'studentdashboard', component: StudentDashboardComponent,},
  { path: 'studentpreview', component: StudentPreviewComponent,},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
