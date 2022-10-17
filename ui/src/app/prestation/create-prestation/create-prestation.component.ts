import {Component, OnInit} from '@angular/core';
import {PrestationService} from '../prestation.service';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Category} from '../models/category';

@Component({
  selector: 'app-create-prestation',
  templateUrl: './create-prestation.component.html'
})
export class CreatePrestationComponent implements OnInit {

  ngOnInit() {
    this.prestationForm = this.formBuilder.group({
      code: [4, [
        Validators.required,
        Validators.maxLength(6),
        Validators.minLength(6),
        Validators.pattern('^4[0-9]*$')]
      ],
      description: ['', [Validators.required]],
      startDate: ['', [Validators.required]],
      endDate: ['', [Validators.required]],
      price: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      category: ['', [Validators.required]],
      submitted: false,
    }, { validators: [this.areDatesValid]});
  }

  prestationForm: FormGroup;
  categories: Category[] = [
    {
      name: 'Transportation',
      value: 'TRANSPORTATION'
    },
    {
      name: 'Intensive care',
      value: 'INTENSIVE_CARE'
    },
    {
      name: 'Regular',
      value: 'REGULAR'
    },
    {
      name: 'Juvenile',
      value: 'JUVENILE'
    },
    {
      name: 'Elderly',
      value: 'ELDERLY'
    }
  ];

  constructor(private prestationService: PrestationService, private formBuilder: FormBuilder) {}

  addPrestation() {
    const prestation = {
      code: this.prestationForm.value.code,
      description: this.prestationForm.value.description,
      startDate: this.prestationForm.value.startDate,
      endDate: this.prestationForm.value.endDate,
      price: this.prestationForm.value.price,
      category: this.prestationForm.value.category,
    };
    this.prestationService.createNewPrestation(prestation).subscribe(() => {
      this.prestationForm.value.submitted = true;
    });
  }

  areDatesValid(prestationForm: FormControl) {
    if (prestationForm.value.startDate && prestationForm.value.endDate) {
      const isValidDates = prestationForm.value.endDate >= prestationForm.value.startDate;
      return isValidDates ? prestationForm.get('endDate')?.setErrors(null) : prestationForm.get('endDate')?.setErrors({ invalidDate: true });
    }
    return null;
  }
}
