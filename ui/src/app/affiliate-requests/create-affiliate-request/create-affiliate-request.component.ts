import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {AffiliateRequestService} from '../affiliate-request.service';
import {PrestationService} from '../../prestation/prestation.service';
import {AffiliateService} from '../../affiliate/affiliate.service';
import {Prestation} from '../../prestation/models/prestation';
import {Affiliate} from '../../affiliate/models/affiliate';
import {MessageService} from 'primeng/api';

@Component({
  selector: 'app-create-request',
  templateUrl: './create-affiliate-request.component.html',
  providers: [MessageService]
})
export class CreateAffiliateRequestComponent implements OnInit {

  ngOnInit(): void {
    this.requestForm = this.formBuilder.group({
      prestationCode: ['',
        [
          Validators.required,
          Validators.maxLength(6),
          Validators.minLength(6),
          Validators.pattern('^4[0-9]*$')]
      ],
      affiliateCode: ['', [
        Validators.required,
        Validators.maxLength(6),
        Validators.minLength(6),
        Validators.pattern('^[0-9]*$')]
      ],
      date: ['', [Validators.required]],
    });
    this.prestationService.getAllPrestations().subscribe(prestations => {
      this.prestations = prestations;
    });
    this.affiliateService.getAllAffiliates().subscribe(affiliates => {
      this.affiliates = affiliates;
    });
  }

  requestForm: FormGroup;
  affiliates: Affiliate[] = [];
  prestations: Prestation[] = [];
  prestationsCodes: string[];
  affiliatesCodes: string[];

  constructor(private requestService: AffiliateRequestService,
              private prestationService: PrestationService,
              private affiliateService: AffiliateService,
              private messageService: MessageService,
              private formBuilder: FormBuilder) { }

  get prestationStartDate() {
    const date = this.prestations.filter(prestation => prestation.code === this.prestationCode.value).map(selectedPrestation => selectedPrestation.startDate);
    return new Date(+date).toLocaleDateString();
  }

  get prestationEndDate() {
    const date = this.prestations.filter(prestation => prestation.code === this.prestationCode.value).map(selectedPrestation => selectedPrestation.endDate);
    return new Date(+date).toLocaleDateString();
  }

  get prestationCode() {
    return this.requestForm.controls['prestationCode'];
  }

  get date() {
    return this.requestForm.controls['date'];
  }

  get affiliateCode() {
    return this.requestForm.controls['affiliateCode'];
  }

  filterPrestationByCode(event: any): void {
    let filteredPrestations: any[] = [];

    for(let index = 0; index < this.prestations.length; index++) {
      if(this.prestations[index].code.toLowerCase().indexOf(event.query.toLowerCase()) === 0) {
        filteredPrestations.push(this.prestations[index].code);
      }
    }
    this.prestationsCodes = filteredPrestations;
  }

  filterAffiliateByCode(event: any): void {
    let filteredAffiliates: any[] = [];

    for(let index = 0; index < this.affiliates.length; index++) {
      if(this.affiliates[index].code.toLowerCase().indexOf(event.query.toLowerCase()) === 0) {
        filteredAffiliates.push(this.affiliates[index].code);
      }
    }
    this.affiliatesCodes = filteredAffiliates;
  }

  isDateValid(){
    if (this.date.value) {
      let selectedPrestation = this.prestations.filter(prestation => prestation.code === this.prestationCode.value)[0];
      let isDateInvalid = (this.date.value.getTime() < selectedPrestation.startDate) || (this.date.value.getTime() > selectedPrestation.endDate);
      return isDateInvalid ? this.date.setErrors({ invalidDate: true }) : this.date.setErrors(null);
    }
    return null;
  }

  createRequest(): void {
    const request = {
      prestationCode: this.prestationCode.value,
      affiliateCode: this.affiliateCode.value,
      date: this.date.value
    };
    this.requestService.createNewRequest(request).subscribe(() => {
      this.messageService.add({
        key: 'createRequestSuccess',
        severity: 'success',
        summary: 'Successful',
        detail: 'The request has been created',
        life: 3000
      });
      this.requestForm.reset();
    }, (error) => {
      this.messageService.add({
        key: 'createRequestError',
        severity: 'error',
        summary: 'Error',
        detail:  error.error.message,
        life: 3000
      });
    });
  }

  isInvalid(input: any): boolean {
    return input.invalid && (input.dirty || input.touched);
  }
}
