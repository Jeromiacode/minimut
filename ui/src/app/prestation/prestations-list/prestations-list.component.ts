import {Component, OnInit} from '@angular/core';
import {Prestation} from '../models/prestation';
import {PrestationService} from '../prestation.service';
import {ConfirmationService, MessageService} from 'primeng/api';
import {Table} from 'primeng/table';

@Component({
  selector: 'app-prestations-list',
  templateUrl: './prestations-list.component.html',
  providers: [MessageService, ConfirmationService]
})
export class PrestationsListComponent implements OnInit {

  ngOnInit(): void {
    this.prestationService.getAllPrestations().subscribe(prestations => {
      this.prestations = prestations;
    });
  }

  prestations: Prestation[] = [];

  constructor(private messageService: MessageService,
             private prestationService: PrestationService,
             private confirmationService: ConfirmationService) {}


  deletePrestation(prestation: Prestation) {
    this.confirmationService.confirm({
      message: `Do you really want to delete ${prestation.code} - ${prestation.description} ?`,
      header: 'Confirm',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.prestations = this.prestations.filter(prestations => prestations.code !== prestation.code);
        this.prestationService.deletePrestationByCode(prestation.code).subscribe(() => {
          this.messageService.add({
            key: 'deleteSuccess',
            severity: 'success',
            summary: 'Successful',
            detail: 'Prestation deleted',
            life: 3000
          });
        }, () => {
          this.messageService.add({
            key: 'deleteError',
            severity: 'error',
            summary: 'Error',
            detail: 'Delete prestation failed',
            life: 3000
          });
        });
      }
    });
  }

  clear(table: Table) {
    table.clear();
  }
}
