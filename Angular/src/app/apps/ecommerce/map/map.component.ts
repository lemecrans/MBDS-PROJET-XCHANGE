import { Component, OnInit } from '@angular/core';
import { BreadcrumbItem } from 'src/app/shared/page-title/page-title.model';
import * as L from 'leaflet';
@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss']
})
export class MapComponent implements OnInit {

  private map!: L.Map;

  pageTitle: BreadcrumbItem[] = [];

  constructor() { }

  ngOnInit(): void {
    this.pageTitle = [{ label: 'Ecommerce', path: '/' }, { label: 'Add / Edit Product', path: '/', active: true }];
  }

  private initMap(): void {
    // Initialiser la carte avec les coordonnées d'Antananarivo et un niveau de zoom approprié
    const map = L.map('map').setView([-18.8792, 47.5079], 12); // 12 est le niveau de zoom pour une vue détaillée

    // Ajouter les tuiles OpenStreetMap
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(map);

    // Ajouter un marqueur à Antananarivo
    L.marker([-18.8792, 47.5079]).addTo(map)
      .bindPopup('Antananarivo')
      .openPopup();
  }
  
  ngAfterViewInit(): void {
    this.initMap();
  }

  

}
