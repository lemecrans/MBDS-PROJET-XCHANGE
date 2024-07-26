import { Injectable } from '@angular/core';
import { Objet } from '../models/objet.model';

@Injectable({
  providedIn: 'root'
})
export class ObjetService {
  getAllObjet():Objet[]{
    return  [
      {
        id: 1,
        nom: 'Sac à main',
        valeur: 100,
        description: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Exercitationem, in eveniet. Eius, veniam doloremque. Deserunt assumenda asperiores laudantium et eius ipsam quos ipsa sed dolorum. Nesciunt nostrum vero libero assumenda.',
        disponible: true,
        proprietaire_id: 0,
        img: 'bag.jpg',
      },
      {
        id: 2,
        nom: 'Trousse',
        valeur: 100,
        description: 'Trousse de très bonne qualité',
        disponible: true,
        proprietaire_id: 0,
        img: 'pencil.jpg',
      },
      {
        id: 3,
        nom: 'Telephone S24',
        valeur: 100,
        description: 'Samsung de très bonne qualité',
        disponible: true,
        proprietaire_id: 0,
        img: 'phone.jpg',
      },
      {
        id: 4,
        nom: 'Cadre photo',
        valeur: 100,
        description: 'Cadre photo de très bonne qualité',
        disponible: true,
        proprietaire_id: 0,
        img: 'bag.jpg',
      },
      {
        id: 5,
        nom: 'Lunette de soleil',
        valeur: 100,
        description: 'Lunette de soleil, anti-UV',
        disponible: true,
        proprietaire_id: 0,
        img: 'sunglass.jpg',
      },
    ];
  }
  getObjet(id:number):Objet | undefined{
    return this.getAllObjet().find((objet)=> objet.id === id);
  }
}
