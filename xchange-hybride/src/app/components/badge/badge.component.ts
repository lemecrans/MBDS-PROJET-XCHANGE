import { CommonModule } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { IonIcon } from "@ionic/angular/standalone";

@Component({
  selector: 'app-badge',
  templateUrl: './badge.component.html',
  styleUrls: ['./badge.component.scss'],
  standalone: true,
  imports :[
    IonIcon,
    CommonModule 
  ]
})
export class BadgeComponent  {
  @Input() icon! : string;
  @Input() texte! : string;
  @Input() couleur!: string;

}
