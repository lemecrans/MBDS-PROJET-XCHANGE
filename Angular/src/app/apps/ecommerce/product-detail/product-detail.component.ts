import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { BreadcrumbItem } from 'src/app/shared/page-title/page-title.model';
import { Product } from '../shared/ecommerce.model';
import { Objet } from 'src/app/shared/models/objet.model';
import { ObjetService } from '../../../shared/services/objet.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-ecommerce-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit {

  pageTitle: BreadcrumbItem[] = [];
  product: Product = {};
  objet: Partial<Objet> = {};

  constructor (private route: ActivatedRoute,private objetService : ObjetService, private router: Router) { }

  ngOnInit(): void {
    this.pageTitle = [{ label: 'Ecommerce', path: '/' }, { label: 'Product Detail', path: '/', active: true }];
    // fetches product details
    this.route.queryParams.subscribe(params => {
      this.objetService.getObjectById(params.id).subscribe({
        next: (response: Objet) => {
          this.objet = response;
          this.objet.image = `data:image/png;base64,${response.image}`
        },
        error: (error) => {
          this.router.navigate(['/apps/ecommerce/products'])
        }
      });
    });
  }

}
