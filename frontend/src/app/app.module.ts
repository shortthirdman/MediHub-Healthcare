import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule, DatePipe, AsyncPipe, DecimalPipe } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { SharedModule } from './shared/shared.module';

import { DoctorsModule } from './pages/doctors/doctors.module';
import { PatientsModule } from './pages/patients/patients.module';
import { PharmacyModule } from './pages/pharmacy/pharmacy.module';
import { BillingModule } from './pages/billing/billing.module';
import { PaymentsModule } from './pages/payments/payments.module';
import { AdminCentreModule } from './pages/admin-centre/admin-centre.module';
import { AuthModule } from './auth/auth.module';
import { authInterceptorProviders } from './auth/auth.interceptor';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
	  BrowserAnimationsModule,
    HttpClientModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,

    AppRoutingModule,
    SharedModule,
    DoctorsModule,
    PatientsModule,
    PharmacyModule,
    BillingModule,
    PaymentsModule,
    AdminCentreModule,
    AuthModule
  ],
  providers: [DatePipe, AsyncPipe, DecimalPipe, authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
