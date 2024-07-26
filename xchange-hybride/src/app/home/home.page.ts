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
  IonSearchbar,
} from '@ionic/angular/standalone';
import { ObjetItemComponent } from '../page/objet-item/objet-item.component';
import { Objet } from '../models/objet.model';
import { ObjetService } from '../services/objet.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
  standalone: true,
  imports: [
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

  constructor(private objetservice: ObjetService) {}
  ngOnInit(): void {
    this.objets = this.objetservice.getAllObjet();
  }
}
