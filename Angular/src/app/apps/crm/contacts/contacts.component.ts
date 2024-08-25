import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Column } from 'src/app/shared/advanced-table/advanced-table.component';
import { BreadcrumbItem } from 'src/app/shared/page-title/page-title.model';
import { CRMCustomer } from '../shared/crm.model';
import { CRMCUSTOMERS } from '../shared/data';
import { ObjetService } from 'src/app/shared/services/objet.service';
import { ActivatedRoute, NavigationStart, Router } from '@angular/router';
import { Objet } from 'src/app/shared/models/objet.model';

@Component({
  selector: 'app-crm-contacts',
  templateUrl: './contacts.component.html',
  styleUrls: ['./contacts.component.scss']
})
export class ContactsComponent implements OnInit {

  pageTitle: BreadcrumbItem[] = [];
 
  objet: Partial<Objet> = {};
  updateObjetFormGroup!: FormGroup;
  previousUrl: string | null = null;
  @ViewChild('advancedTable') advancedTable: any;
  @ViewChild('content', { static: true }) content: any;

  constructor (
    private sanitizer: DomSanitizer,
    public activeModal: NgbModal,
    private fb: FormBuilder,
    private objetService : ObjetService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.pageTitle = [{ label: 'CRM', path: '/' }, { label: 'Contacts', path: '/', active: true }];
    this.router.events.subscribe(event => {
      if (event instanceof NavigationStart) {
        this.previousUrl = event.url;
      }
    });
    this._fetchData();
  }
  /**
   * fetch objet to update
   */
  _fetchData(): void {
    this.route.queryParams.subscribe(params => {
      this.objetService.getObjectById(params.id).subscribe({
        next: (response: Objet) => {
          this.objet = response;
          console.log("==========================================")
          console.log(this.objet);
        },
        error: (error) => {
          this.router.navigate([this.previousUrl || '']);
        }
      });
    });
  }

  modifier(){

  }

}
