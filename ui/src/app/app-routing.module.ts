import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CreateAffiliateComponent} from './affiliate/create-affiliate/create-affiliate.component';
import {AffiliatesListComponent} from './affiliate/affiliates-list/affiliates-list.component';
import {AffiliateDetailsComponent} from './affiliate/affiliate-details/affiliate-details.component';
import {UpdateAffiliateComponent} from './affiliate/update-affiliate/update-affiliate.component';
import {CreatePrestationComponent} from './prestation/create-prestation/create-prestation.component';
import {PrestationsListComponent} from './prestation/prestations-list/prestations-list.component';
import {CreateAffiliateRequestComponent} from './affiliate-requests/create-affiliate-request/create-affiliate-request.component';

const routes: Routes = [
  {
    path: 'affiliates/list',
    component: AffiliatesListComponent
  },
  {
    path: 'affiliate/create',
    component: CreateAffiliateComponent
  },
  {
    path: 'affiliate/update/:nationalNumber',
    component: UpdateAffiliateComponent
  },
  {
    path: 'affiliate/:nationalNumber',
    component: AffiliateDetailsComponent
  },
  {
    path: 'prestations/list',
    component: PrestationsListComponent
  },
  {
    path: 'prestation/create',
    component: CreatePrestationComponent
  },
  {
    path: 'request/create',
    component: CreateAffiliateRequestComponent
  },
  {
    path: '',
    redirectTo: 'affiliates/list',
    pathMatch: 'full'
  },
  {
    path: '**',
    component: AffiliatesListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
