import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {AccordionModule} from 'primeng/accordion';
import {TableModule} from 'primeng/table';
import {ButtonModule} from 'primeng/button';
import {PanelMenuModule} from 'primeng/panelmenu';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {InputTextModule} from 'primeng/inputtext';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CheckboxModule} from 'primeng/checkbox';
import {InputMaskModule} from 'primeng/inputmask';
import {DropdownModule} from 'primeng/dropdown';
import {AffiliatesListComponent} from './affiliate/affiliates-list/affiliates-list.component';
import {CreateAffiliateComponent} from './affiliate/create-affiliate/create-affiliate.component';
import {ConfirmDialogModule} from 'primeng/confirmdialog';
import {ToastModule} from 'primeng/toast';
import {AffiliateDetailsComponent} from './affiliate/affiliate-details/affiliate-details.component';
import {UpdateAffiliateComponent} from './affiliate/update-affiliate/update-affiliate.component';
import {CreatePrestationComponent} from './prestation/create-prestation/create-prestation.component';
import {PrestationsListComponent} from './prestation/prestations-list/prestations-list.component';
import {InputNumberModule} from 'primeng/inputnumber';
import {CreateAffiliateRequestComponent} from './affiliate-requests/create-affiliate-request/create-affiliate-request.component';
import {AutoCompleteModule} from 'primeng/autocomplete';

@NgModule({
  declarations: [
    AppComponent,
    AffiliatesListComponent,
    CreateAffiliateComponent,
    AffiliateDetailsComponent,
    UpdateAffiliateComponent,
    CreatePrestationComponent,
    PrestationsListComponent,
    CreateAffiliateRequestComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AccordionModule,
    TableModule,
    ButtonModule,
    PanelMenuModule,
    BrowserAnimationsModule,
    CalendarModule,
    InputTextModule,
    FormsModule,
    CheckboxModule,
    InputMaskModule,
    DropdownModule,
    AppRoutingModule,
    ReactiveFormsModule,
    ConfirmDialogModule,
    InputNumberModule,
    AutoCompleteModule,
    ToastModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
