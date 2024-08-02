import { Component } from '@angular/core';
import {
  IonHeader,
  IonToolbar,
  IonTitle,
  IonContent,
  IonButtons,
  IonButton,
  IonIcon,
  IonItem,
  IonLabel,
  IonText,
  IonThumbnail,
  IonList,
  IonListHeader,
  IonRow,
  IonCol,
  IonCard,
  IonSearchbar, IonImg } from '@ionic/angular/standalone';
import { ObjetItemComponent } from '../page/objet-item/objet-item.component';
import { Objet } from '../models/objet.model';
import { ObjetService } from '../services/objet.service';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { AlertController } from '@ionic/angular';
@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
  standalone: true,
  imports: [IonImg, 
    CommonModule,
    IonSearchbar,
    IonCard,
    IonCol,
    IonRow,
    IonListHeader,
    IonList,
    IonText,
    IonLabel,
    IonItem,
    IonIcon,
    IonButton,
    IonButtons,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonThumbnail,
    IonListHeader,
    IonSearchbar,
    ObjetItemComponent,
  ],
})
export class HomePage {
  objets: Objet[] = [];
  filteredObjets: Objet[] = [];

  constructor(private objetservice: ObjetService,private router :Router, private alertController: AlertController) {}
  ngOnInit(): void {
    this.objets = this.objetservice.getAllObjet();
  }
  goToDetailPage(id: number) {
    this.router.navigate(['home/detail',id]);
  }
  filterObjects(event: any) {
    const searchTerm = event.target.value.toLowerCase();
    if (searchTerm) {
      this.filteredObjets = this.objets.filter((objet) =>
        objet.nom.toLowerCase().includes(searchTerm)
      );
    } else {
      this.filteredObjets = this.objets;
    }
  }

  async filterObjectsByQR() {
    try {
      const code = await this.objetservice.startScan(0);
      console.log(code);
      const objet = this.objetservice.getObjet(Number(code));
      this.goToDetailPage(objet.id);
    } catch (e) {
      console.log(e);
      if (e instanceof Error) {
        this.showErrorModal(e.message);
      } else {
        this.showErrorModal('Une erreur inconnue est survenue');
      }
    }
  }
  async showErrorModal(message: any) {
    const alert = await this.alertController.create({
      header: 'Erreur',
      message: message,
      buttons: ['OK']
    });
    await alert.present();
  }
}
