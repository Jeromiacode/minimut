import {Component, OnInit} from '@angular/core';
import {MenuItem} from 'primeng/api';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent implements OnInit {

  mainSidebar: MenuItem[];

  ngOnInit() {
    this.mainSidebar = [
          {
            label: 'Affiliate',
            expanded: true,
            items: [
              {
                label: 'Affiliates',
                icon: 'pi pi-users',
                routerLink: ['/affiliates/list']
              },
              {
                label: 'Create new affiliate',
                icon: 'pi pi-user-plus',
                routerLink: ['/affiliate/create']
              }
            ]
          },
      {
        label: 'Prestation',
        expanded: true,
        items: [
          {
            label: 'Prestations',
            icon: 'pi pi-book',
            routerLink: ['/prestations/list']
          },
          {
            label: 'Create new prestation',
            icon: 'pi pi-plus',
            routerLink: ['/prestation/create']
          }
        ]
      },
      {
        label: 'Requests',
        expanded: true,
        items: [
          {
            label: 'Create new request',
            icon: 'pi pi-plus',
            routerLink: ['/request/create']
          }
        ]
      }
        ]
  };
}
