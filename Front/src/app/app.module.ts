import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { LoginComponent } from './form/connexion-form/login.component';
import { HttpClientModule } from '@angular/common/http';
import { authInterceptorProviders } from './_helper/auth.interceptor';
import { HomeComponent } from './home/home.component';

@NgModule({
   declarations: [
      AppComponent,
      LoginComponent,
      HomeComponent
   ],
   imports: [
      AppRoutingModule,
      BrowserModule,
      BrowserAnimationsModule,
      HttpClientModule,
      MatButtonModule,
      MatCardModule,
      MatFormFieldModule,
      MatIconModule,
      MatInputModule,
      FormsModule,
      ReactiveFormsModule
   ],
   providers: [
      authInterceptorProviders
   ],
   bootstrap: [
      AppComponent
   ]
})
export class AppModule { }
