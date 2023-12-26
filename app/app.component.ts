import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import { NavbarComponent } from "./components/navbar/navbar.component"; 
import { SignupComponent } from './pages/signup/signup.component';
import { JsonPipe } from '@angular/common';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import{FormsModule} from  '@angular/forms'
import { HttpClientModule } from '@angular/common/http';

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    imports: [FormsModule,HttpClientModule, MatIconModule,MatInputModule, JsonPipe,CommonModule, SignupComponent,RouterOutlet, MatButtonModule, MatFormFieldModule, NavbarComponent]
})
export class AppComponent {
  title = 'ExamPortal';

}
