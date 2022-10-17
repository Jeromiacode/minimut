import {Component, OnInit} from '@angular/core';
import {AffiliateService} from '../affiliate.service';
import {Affiliate} from '../models/affiliate';
import {MessageService, ConfirmationService} from 'primeng/api';
import {Router} from '@angular/router';
import {Table} from 'primeng/table';

@Component({
  selector: 'app-affiliates-list',
  templateUrl: './affiliates-list.component.html',
  providers: [ConfirmationService, MessageService]
})
export class AffiliatesListComponent implements OnInit {

  ngOnInit() {
    this.affiliateService.getAllAffiliates().subscribe(affiliates => {
      this.affiliates = affiliates;
    });
  }

  affiliates: Affiliate[] = [];

  constructor(private affiliateService: AffiliateService,
              private messageService: MessageService,
              private router: Router,
              private confirmationService: ConfirmationService) {
  }

  deleteAffiliate(affiliate: Affiliate) {
    this.confirmationService.confirm({
      message: `Do you really want to delete ${affiliate.firstName} ${affiliate.lastName} ?`,
      header: 'Confirm',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.affiliateService.deleteAffiliateByNationalNumber(affiliate.nationalNumber).subscribe(() => {
          this.affiliates = this.affiliates.filter(affiliates => affiliates.nationalNumber !== affiliate.nationalNumber);
          this.messageService.add({
            key: 'deleteSuccess',
            severity: 'success',
            summary: 'Successful',
            detail: 'Affiliate Deleted',
            life: 3000
          });
        }, () => {
          this.messageService.add({
            key: 'deleteError',
            severity: 'error',
            summary: 'Error',
            detail: 'Delete affiliate failed',
            life: 3000
          });
        });
      }
    });
  }

  clear(table: Table) {
    table.clear();
  }

  navigateToAffiliateDetails(affiliate: Affiliate) {
    this.router.navigate(['affiliate/' + affiliate.nationalNumber]);
  }

  navigateToUpdateForm(affiliate: Affiliate) {
    this.router.navigate(['affiliate/update/' + affiliate.nationalNumber]);
  }
}
