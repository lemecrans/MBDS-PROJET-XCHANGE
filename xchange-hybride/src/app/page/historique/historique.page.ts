import { CommonModule } from '@angular/common';
import { Component, inject, OnDestroy, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';

import {
  IonContent,
  IonHeader,
  IonTitle,
  IonToolbar,
  IonButtons,
  IonButton,
  IonIcon,
  IonBackButton,
  IonCol,
  IonText,
  IonRow,
  IonLabel,
  IonImg,
  IonCard,
  IonItem,
  IonThumbnail, IonList } from '@ionic/angular/standalone';
import { Subscription } from 'rxjs';
import { ObjetService } from 'src/app/services/objet.service';

@Component({
  selector: 'app-historique',
  templateUrl: './historique.page.html',
  styleUrls: ['./historique.page.scss'],
  standalone: true,
  imports: [IonList, 
    IonItem,
    IonCard,
    IonImg,
    IonLabel,
    IonRow,
    IonBackButton,
    IonIcon,
    IonButton,
    IonButtons,
    IonContent,
    IonHeader,
    IonTitle,
    IonToolbar,
    IonButtons,
    IonButtons,
    IonCol,
    IonText,
    IonItem,
    IonThumbnail,
    RouterModule,
    CommonModule,
  ],
})
export class HistoriquePage implements OnInit, OnDestroy {
  historique: any = null;
  historiqueSub!: Subscription;
  toastData: any = {};

  private objetService = inject(ObjetService);

  constructor() {}

  ngOnInit() {
    this.historiqueSub = this.objetService.listeObjets.subscribe({
      next: (liste) => {
        // console.log(liste);
        this.historique =liste;
      },
    });
  }

  ngOnDestroy(): void {
    if (this.historiqueSub) this.historiqueSub.unsubscribe();
  }
}
