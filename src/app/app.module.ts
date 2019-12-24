import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule} from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SelectCategeryComponent } from './select-categery/select-categery.component';
import { CourseCreationLoginComponent } from './course-components/course-creation-login/course-creation-login.component';
import { SidebarComponent } from './course-components/layouts/sidebar/sidebar.component';
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
import { UserHeaderComponent } from './course-components/users/user-header/user-header.component';
import { SiteHeaderComponent } from './course-components/site/site-header/site-header.component';
import { TransactionComponent } from './course-components/sales/transaction/transaction.component';
import { StatementsComponent } from './course-components/sales/statements/statements.component';
import { BreakdownComponent } from './course-components/sales/breakdown/breakdown.component';
import { SalesHeaderComponent } from './course-components/sales/sales-header/sales-header.component';
import { EmailHeaderComponent } from './course-components/emails/email-header/email-header.component';
import { AccountComponent } from './course-components/emails/account/account.component';
import { TemplateComponent } from './course-components/emails/template/template.component';
import { TemplateEditorComponent } from './course-components/emails/template-editor/template-editor.component';
import { ListsComponent } from './course-components/emails/lists/lists.component';
import { HistoryEdmComponent } from './course-components/emails/history-edm/history-edm.component';
import { ComposeEdmComponent } from './course-components/emails/compose-edm/compose-edm.component';
import { SettingHeaderComponent } from './course-components/Settings/setting-header/setting-header.component';
import { GeneralComponent } from './course-components/Settings/general/general.component';
import { PaymentComponent } from './course-components/Settings/payment/payment.component';
import { NotificationsComponent } from './course-components/Settings/notifications/notifications.component';
import { PlanComponent } from './course-components/Settings/plan/plan.component';
import { BillingComponent } from './course-components/Settings/billing/billing.component';
import { TeacherViewLoginComponent } from './teacher-components/teacher-view-login/teacher-view-login.component';
import { TeacherDashboardComponent } from './teacher-components/teacher-dashboard/teacher-dashboard.component';
import { TeacherSidebarComponent } from './teacher-components/teacher-sidebar/teacher-sidebar.component';
import { SetHomworkComponent } from './teacher-components/set-homwork/set-homwork.component';
import { SetAssignmentComponent } from './teacher-components/set-assignment/set-assignment.component';
import { TStudentsComponent } from './teacher-components/t-students/t-students.component';
import { TEmailHeaderComponent } from './teacher-components/t-emails/t-email-header/t-email-header.component';
import { TTemplateComponent } from './teacher-components/t-emails/t-template/t-template.component';
import { TTemplateEditorComponent } from './teacher-components/t-emails/t-template-editor/t-template-editor.component';
import { THistoryComponent } from './teacher-components/t-emails/t-history/t-history.component';
import { TComposeEdmComponent } from './teacher-components/t-emails/t-compose-edm/t-compose-edm.component';
import { CourseHeaderComponent } from './course-components/Create-a-Course/course-header/course-header.component';
import { BasicInfoComponent } from './course-components/Create-a-Course/basic-info/basic-info.component';
import { CurriculumComponent } from './course-components/Create-a-Course/curriculum/curriculum.component';
import { PricingComponent } from './course-components/Create-a-Course/pricing/pricing.component';
import { FlatPackComponent } from './course-components/Create-a-Course/flat-pack/flat-pack.component';
import { ReportsComponent } from './course-components/Create-a-Course/reports/reports.component';
import { CoursePreviewComponent } from './course-components/create-a-Course/course-preview/course-preview.component';
import { PreviewHeaderComponent } from './course-components/site/site-preview/preview-header/preview-header.component';
import { SitepcourseComponent } from './course-components/site/site-preview/sitepcourse/sitepcourse.component';
import { SitepdetailsComponent } from './course-components/site/site-preview/sitepdetails/sitepdetails.component';
import { TCourseHeaderComponent } from './teacher-components/teach-create-a-course/t-course-header/t-course-header.component';
import { TBasicInfoComponent } from './teacher-components/teach-create-a-course/t-basic-info/t-basic-info.component';
import { TCurriculumComponent } from './teacher-components/teach-create-a-course/t-curriculum/t-curriculum.component';
import { TReportsComponent } from './teacher-components/teach-create-a-course/t-reports/t-reports.component';
import { TCoursePrevComponent } from './teacher-components/teach-create-a-course/t-course-prev/t-course-prev.component';
import { CourseLibraryComponent } from './teacher-components/course-library/course-library.component';
import { StudentDashboardComponent } from './student-view-components/student-dashboard/student-dashboard.component';
import { StudentPreviewComponent } from './student-view-components/student-preview/student-preview.component';

@NgModule({
  declarations: [
    AppComponent,
    SelectCategeryComponent,
    CourseCreationLoginComponent,
    SidebarComponent,
    DashboardComponent,
    YourClassroomComponent,
    StudentsComponent,
    TeachersComponent,
    AffiliatesComponent,
    ThemeComponent,
    DomainsComponent,
    NavigationComponent,
    PagesComponent,
    CustomCodeComponent,
    UserHeaderComponent,
    SiteHeaderComponent,
    TransactionComponent,
    StatementsComponent,
    BreakdownComponent,
    SalesHeaderComponent,
    EmailHeaderComponent,
    AccountComponent,
    TemplateComponent,
    TemplateEditorComponent,
    ListsComponent,
    HistoryEdmComponent,
    ComposeEdmComponent,
    SettingHeaderComponent,
    GeneralComponent,
    PaymentComponent,
    NotificationsComponent,
    PlanComponent,
    BillingComponent,
    TeacherViewLoginComponent,
    TeacherDashboardComponent,
    TeacherSidebarComponent,
    SetHomworkComponent,
    SetAssignmentComponent,
    TStudentsComponent,
    TEmailHeaderComponent,
    TTemplateComponent,
    TTemplateEditorComponent,
    THistoryComponent,
    TComposeEdmComponent,
    CourseHeaderComponent,
    BasicInfoComponent,
    CurriculumComponent,
    PricingComponent,
    FlatPackComponent,
    ReportsComponent,
    CoursePreviewComponent,
    PreviewHeaderComponent,
    SitepcourseComponent,
    SitepdetailsComponent,
    TCourseHeaderComponent,
    TBasicInfoComponent,
    TCurriculumComponent,
    TReportsComponent,
    TCoursePrevComponent,
    CourseLibraryComponent,
    StudentDashboardComponent,
    StudentPreviewComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot([],{useHash: true}),
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
