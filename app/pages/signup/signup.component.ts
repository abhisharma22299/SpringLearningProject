import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';
import { JsonPipe } from '@angular/common';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import{FormsModule} from  '@angular/forms';

import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [FormsModule,MatIconModule,MatInputModule, JsonPipe,RouterOutlet,MatFormFieldModule,MatButtonModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent implements OnInit {
hide: any;
constructor( private userService:UserService){}
public user={
  userName:'',
  firstName:'',
  lastName:'',
  password:'',
  phone:'',
  email:''
}
ngOnInit(): void {}
FormSubmit(){
  if(this.user.userName=='' || this.user.userName==null){
    console.log("Something went wrong ");
    return;
  }
  console.log(this.user);
  alert("submit");
// add user : user service 
// this.userService.addUser(this.user).subscribe(
//   (data)=>{
// // form success
// console.log("success");
//   },
//   (error)=>{
// // form error 
// console.log("Something went wrong in adding user");
//   }

//);

}


}
