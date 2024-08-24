import { Component, OnInit } from '@angular/core';
import { BreadcrumbItem } from 'src/app/shared/page-title/page-title.model';
import * as L from 'leaflet';
import { PropositionEchangeService } from 'src/app/shared/services/proposition-echange.service';
import { PropositionEchange } from 'src/app/shared/models/propositionEchange.model';
import { Utilisateur } from 'src/app/shared/models/utilisateur.model';

const iconRetinaUrl = 'src/assets/marker-icon-2x.png';
const iconUrl = 'src/assets/marker-icon.png';
const shadowUrl = 'src/assets/marker-shadow.png';
const iconDefault = L.icon({
  iconRetinaUrl,
  iconUrl,
  shadowUrl,
  iconSize: [25, 41],
  iconAnchor: [12, 41],
  popupAnchor: [1, -34],
  tooltipAnchor: [16, -28],
  shadowSize: [41, 41]
});
L.Marker.prototype.options.icon = iconDefault;
@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss']
})
export class MapComponent implements OnInit {

  private map!: L.Map;
  propositions : PropositionEchange[] = []
  myPropositions : PropositionEchange[] = []

  pageTitle: BreadcrumbItem[] = [];

  currentUser! : Utilisateur;

  constructor(private propositionEchangeService: PropositionEchangeService) { }

  ngOnInit(): void {
    this.pageTitle = [{ label: 'Ecommerce', path: '/' }, { label: 'Add / Edit Product', path: '/', active: true }];
  }

  getAllEchange(){
    this.currentUser = new Utilisateur(1,'polyphia@gmail.com','password','Tim henson','ADMIN',0,2)

    this.propositionEchangeService.getAllProposition().subscribe({
      next: (propositions) => {
        this.propositions = propositions;
        this.filterPropositions()
        this.initMap()
      },
      error: (err) => {
        console.error('Erreur lors de la récupération des propositions:', err);
      },
      complete: () => {
        console.log('La récupération des propositions est terminée.');
      }
    });
  }

  private filterPropositions(): void {
    if (this.currentUser.id === undefined) return;

    this.myPropositions = this.propositions.filter(proposition =>
      proposition.proposant.id === this.currentUser.id ||
      proposition.destinataire.id === this.currentUser.id
    );
  }

  private initMap(): void {
    const map = L.map('map').setView([-18.8792, 47.5079], 12);
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(map);

    this.addMarkersToMap(map)
  }

  addMarkersToMap(map: L.Map) {
    this.myPropositions.forEach((proposition) => {
      const marker = L.marker([proposition.latitude, proposition.longitude])
        .addTo(map)
        .bindPopup(`Proposant: ${proposition.proposant.username}<br>Destinataire: ${proposition.destinataire.username}<br>Date: ${proposition.dateProposition}<br>État: ${proposition.etat}`)
        .openPopup();
    });
  }

  
  ngAfterViewInit(): void {
    this.getAllEchange()
  }

  

}
