import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-teacher-sidebar',
  templateUrl: './teacher-sidebar.component.html',
  styleUrls: ['./teacher-sidebar.component.scss']
})
export class TeacherSidebarComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  status: boolean = false;
  clickEvent() {
  this.status = !this.status;
  }
  toggleClass() {
  const sidenavHide = document.getElementById("sideNav");
  sidenavHide.classList.toggle("mobileSidenav");
  const changeClass = document.getElementById("iconClick");
  changeClass.classList.toggle("iconClick");
  
  // alert('click seccess');
  }

}
