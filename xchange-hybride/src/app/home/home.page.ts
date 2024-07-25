import { Component } from '@angular/core';
import {
  IonHeader,
  IonToolbar,
  IonTitle,
  IonContent,
  IonButtons,
  IonButton,
  IonIcon,
  IonRow,
  IonListHeader,
  IonCol,
  IonSearchbar,
  IonCard,
  IonItem,
  IonLabel,
  IonText,
  IonThumbnail,
} from '@ionic/angular/standalone';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
  standalone: true,
  imports: [
    IonItem,
    IonLabel,
    IonCard,
    IonSearchbar,
    IonCol,
    IonListHeader,
    IonRow,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonIcon,
    IonButton,
    IonButtons,
    IonThumbnail,
    IonText,
  ],
})
export class HomePage {
  constructor() {}
}
