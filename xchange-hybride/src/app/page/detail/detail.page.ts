import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {
  IonContent,
  IonHeader,
  IonTitle,
  IonToolbar,
  IonButtons,
  IonButton, IonIcon, IonImg, IonLabel, IonModal } from '@ionic/angular/standalone';
import { Objet } from 'src/app/models/objet.model';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { ObjetService } from 'src/app/services/objet.service';
import { BadgeComponent } from 'src/app/components/badge/badge.component';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.page.html',
  styleUrls: ['./detail.page.scss'],
  standalone: true,
  imports: [IonModal, IonLabel, IonImg, IonIcon, 
    IonButton,
    IonButtons,
    IonContent,
    IonHeader,
    IonTitle,
    IonToolbar,
    CommonModule,
    FormsModule,
    RouterModule,
    BadgeComponent,
    IonLabel
  ],
})
export class DetailPage implements OnInit {
  id!: number;
  objet!: Objet;
  showQrCode = false;
  constructor(
    private activatedRoute: ActivatedRoute,
    private objetService: ObjetService
  ) {
    const id = this.activatedRoute.snapshot.paramMap.get('id');
    if (id !== null) {
      this.id = parseInt(id);
    }
  }

  ngOnInit() {
    const objet = this.objetService.getObjet(this.id);
    if (objet) this.objet = objet;
  }
  getQrcodeData(){
    this.showQrCode = true;
    setTimeout(() => {
      // this.getBarcode(item.barcode); 
    }, 500);
  }
}
