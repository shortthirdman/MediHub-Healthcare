import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { SharedModule } from './shared/shared.module';

import { DoctorsModule } from './pages/doctors/doctors.module';
import { PatientsModule } from './pages/patients/patients.module';
import { PharmacyModule } from './pages/pharmacy/pharmacy.module';
import { BillingModule } from './pages/billing/billing.module';
import { PaymentsModule } from './pages/payments/payments.module';
import { AdminCentreModule } from './pages/admin-centre/admin-centre.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
	BrowserAnimationsModule,
    AppRoutingModule,
    SharedModule,
    DoctorsModule,
    PatientsModule,
    PharmacyModule,
    BillingModule,
    PaymentsModule,
    AdminCentreModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
