import {Component} from '@angular/core';
import {AffiliateService} from '../affiliate.service';
import {Gender} from '../models/gender';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create-affiliate',
  templateUrl: './create-affiliate.component.html'
})

export class CreateAffiliateComponent {

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
  isMain= true;

  constructor(private affiliateService: AffiliateService, private router: Router) {}

  addAffiliate() {
    const affiliate = {
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
    this.affiliateService.createNewAffiliate(affiliate).subscribe(() => {
      this.router.navigate(['affiliate/' + affiliate.nationalNumber])
    });
  };

  isFormInvalid(): boolean {

    if (!(this.code) ||
      !(this.nationalNumber) ||
      !(this.firstName) ||
      !(this.lastName) ||
      !(this.email) ||
      !(this.phoneNumber) ||
      !(this.street) ||
      !(this.streetNumber) ||
      !(this.postalCode) ||
      !(this.city) ||
      !(this.moveInDate)) {
      return true;
    }

    return false;
  };
}
