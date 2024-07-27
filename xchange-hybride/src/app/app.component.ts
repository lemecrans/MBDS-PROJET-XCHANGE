import { Component } from '@angular/core';
import { IonApp, IonRouterOutlet } from '@ionic/angular/standalone';
import { addIcons } from 'ionicons';

import {arrowBack, checkmarkCircleOutline, closeCircleOutline, closeOutline, ellipsisHorizontalCircle, listOutline, qrCodeOutline, scanOutline} from 'ionicons/icons';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  standalone: true,
  imports: [IonApp, IonRouterOutlet],
})
export class AppComponent {
  constructor() {
    this.addAllIcons();
  }

  addAllIcons() {
    addIcons({
      listOutline,
      scanOutline,
      ellipsisHorizontalCircle,
      arrowBack,
      checkmarkCircleOutline,
      closeCircleOutline,
      qrCodeOutline,
      closeOutline
      
    });
  }
}
