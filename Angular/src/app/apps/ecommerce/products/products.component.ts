import { Component, OnInit } from '@angular/core';
import { BreadcrumbItem } from 'src/app/shared/page-title/page-title.model';
import { PRODUCTLIST } from '../shared/data';
import { Product } from '../shared/ecommerce.model';
import { ObjetService } from 'src/app/shared/services/objet.service';
import { Objet } from 'src/app/shared/models/objet.model';

@Component({
  selector: 'app-ecommerce-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {

  pageTitle: BreadcrumbItem[] = [];
  products: Product[] = [];
  searchTerm: string = '';
  page = 1;
  pageSize = 8;
  
  objets : Objet[] = []

  constructor (private objetService: ObjetService) { }

  ngOnInit(): void {
    this.pageTitle = [{ label: 'Ecommerce', path: '/' }, { label: 'Products', path: '/', active: true }];
    this._fetchData();
    
    this.getAllObjets();
  }

  getAllObjets(){
    this.objetService.getAllObject().subscribe(
      (data: Objet[]) => {
        this.objets = data
        this.objets = data.map((item: Objet) => ({
          ...item,
          image: `data:image/png;base64,${item.image}`
        }));
      },
      (error) => {
        console.error('Erreur lors de la récupération des données', error);
      }
    );
  }
  
  /**
   * fetches product list
   */
  _fetchData(): void {
    this.products = PRODUCTLIST;
  }

  /**
   * Search Method
  */
  searchData(searchTerm: string): void {
    if (searchTerm === '') {
      this.getAllObjets()
    }
    else {
      let updatedData = this.objets;
      updatedData = updatedData.filter(objet => objet.nom?.toLowerCase().includes(searchTerm));
      this.objets = updatedData;
    }
  }


}
