import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Objet } from 'src/app/models/objet.model';
import { IonImg, IonButtons, IonButton, IonIcon } from "@ionic/angular/standalone";

@Component({
  selector: 'app-objet-item',
  templateUrl: './objet-item.component.html',
  styleUrls: ['./objet-item.component.scss'],
  standalone: true,
  imports: [IonIcon, IonButton, IonButtons, IonImg, CommonModule] 
})
export class ObjetItemComponent  {
  @Input()
  objet!: Objet;
  
  constructor() { }


}
