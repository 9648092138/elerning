import { Component, OnInit } from '@angular/core';

@Component({
selector: 'app-sidebar',
templateUrl: './sidebar.component.html',
styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit { 
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