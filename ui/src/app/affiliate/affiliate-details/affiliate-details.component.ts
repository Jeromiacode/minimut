import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AffiliateService} from '../affiliate.service';
import {Affiliate} from '../models/affiliate';

@Component({
  selector: 'app-affiliate-details',
  templateUrl: './affiliate-details.component.html'
})
export class AffiliateDetailsComponent implements OnInit {

  ngOnInit(): void {
    this.affiliateService.getAffiliateDetails(this.router.url.split('/')[2]).subscribe(affiliate => {
      this.affiliate = affiliate;
    });
  }

  affiliate: Affiliate;

  constructor(private router: Router,
              private affiliateService: AffiliateService) {
  }
}
