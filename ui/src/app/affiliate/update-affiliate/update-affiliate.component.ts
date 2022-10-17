import {Component, OnInit} from '@angular/core';
import {Gender} from '../models/gender';
import {AffiliateService} from '../affiliate.service';
import {Router} from '@angular/router';
import {Affiliate} from '../models/affiliate';
import {MessageService} from 'primeng/api';

@Component({
  selector: 'app-update-affiliate',
  templateUrl: './update-affiliate.component.html',
  providers: [MessageService]
})
export class UpdateAffiliateComponent implements OnInit {

  ngOnInit() {
    this.affiliateService.getAffiliateDetails(this.router.url.split('/')[3]).subscribe(affiliate => {
      this.affiliate = affiliate;
      const [birthDay, birthMonth, birthYear] = this.affiliate.birthdate.split('/');
      const [moveInDay, moveInMonth, moveInYear] = this.affiliate.addresses[0].moveInDate.split('/');
      this.code = this.affiliate.code;
      this.nationalNumber = this.affiliate.nationalNumber;
      this.firstName = this.affiliate.firstName;
      this.lastName = this.affiliate.lastName;
      this.email = this.affiliate.email;
      this.phoneNumber = this.affiliate.phoneNumber;
      this.birthdate = new Date(+birthYear, +birthMonth - 1, +birthDay);
      this.street = this.affiliate.addresses[0].street;
      this.streetNumber = this.affiliate.addresses[0].streetNumber;
      this.postalCode = this.affiliate.addresses[0].postalCode;
      this.city = this.affiliate.addresses[0].city;
      this.moveInDate = new Date(+moveInYear, +moveInMonth - 1, +moveInDay);
      this.isMain = this.affiliate.addresses[0].isMain;
    });
  }

  selectedGender: Gender;
  genders: Gender[] = [
    {
      name: 'Male',
      value: 'MALE'
    },
    {
      name: 'Female',
      value: 'FEMALE'
    }
  ];
  affiliate: Affiliate;

  code: string;
  nationalNumber: string;
  firstName: string;
  lastName: string;
  email: string;
  phoneNumber: string;
  birthdate: Date;
  street: string;
  streetNumber: string;
  postalCode: string;
  city: string;
  moveInDate: Date;
  isMain = true;

  constructor(private affiliateService: AffiliateService,
              private messageService: MessageService,
              private router: Router) {
  }

  updateAffiliate() {
    this.affiliate = {
      code: this.code,
      nationalNumber: this.nationalNumber,
      firstName: this.firstName,
      lastName: this.lastName,
      email: this.email,
      phoneNumber: this.phoneNumber,
      gender: this.selectedGender.value,
      birthdate: this.birthdate?.toLocaleDateString(),
      addresses: [
        {
          street: this.street,
          streetNumber: this.streetNumber,
          postalCode: this.postalCode,
          city: this.city,
          moveInDate: this.moveInDate?.toLocaleDateString(),
          isMain: this.isMain
        }
      ]
    };
    this.affiliateService.updateAffiliate(this.affiliate.nationalNumber, this.affiliate).subscribe(() => {
      this.messageService.add({
        key: 'updateSuccess',
        severity: 'success',
        summary: 'Successful',
        detail: 'Affiliate Updated',
        life: 3000
      });
    }, () => {
      this.messageService.add({
        key: 'updateError',
        severity: 'error',
        summary: 'Error',
        detail: 'The affiliate couldn\'t be updated !',
        life: 3000
      });
    });
  }

  isFormUnchanged(): boolean {
    if (this.affiliate !== undefined) {
      const [birthDay, birthMonth, birthYear] = this.affiliate.birthdate.split('/');
      const [moveInDay, moveInMonth, moveInYear] = this.affiliate.addresses[0].moveInDate.split('/');
      if ((this.code === this.affiliate.code) &&
        (this.nationalNumber === this.affiliate.nationalNumber) &&
        (this.firstName === this.affiliate.firstName) &&
        (this.lastName === this.affiliate.lastName) &&
        (this.email === this.affiliate.email) &&
        (this.phoneNumber === this.affiliate.phoneNumber) &&
        (this.birthdate.toLocaleDateString() === new Date(+birthYear, +birthMonth - 1, +birthDay).toLocaleDateString()) &&
        (this.selectedGender.value === this.affiliate.gender) &&
        (this.street === this.affiliate.addresses[0].street) &&
        (this.streetNumber === this.affiliate.addresses[0].streetNumber) &&
        (this.postalCode === this.affiliate.addresses[0].postalCode) &&
        (this.moveInDate.toLocaleDateString() === new Date(+moveInYear, +moveInMonth - 1, +moveInDay).toLocaleDateString()) &&
        (this.city === this.affiliate.addresses[0].city)) {
        return true;
      }
    }
    return false;
  };

  navigateToList() {
    this.router.navigate(['affiliates/list']);
  }
}
