import { Component } from '@angular/core';
import { IonApp, IonRouterOutlet } from '@ionic/angular/standalone';
import { addIcons } from 'ionicons';

import {arrowBack, checkmarkCircleOutline, closeCircleOutline, closeOutline, ellipsisHorizontalCircle, eyeOutline, listOutline, qrCodeOutline, remove, scanOutline, sparklesOutline} from 'ionicons/icons';
import { DatabasesService } from './services/databases.service';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  standalone: true,
  imports: [IonApp, IonRouterOutlet],
})
export class AppComponent {
  constructor(private database:DatabasesService) {
    this.addAllIcons();
    this.initApp();
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
      closeOutline,
      eyeOutline,
      sparklesOutline,
      remove,
    });
  }
  async initApp(){
    await this.database.initialzPlugin();
  }
}
