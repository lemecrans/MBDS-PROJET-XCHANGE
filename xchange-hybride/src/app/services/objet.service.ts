import { Injectable } from '@angular/core';
import { Objet } from '../models/objet.model';
import { CapacitorBarcodeScanner } from '@capacitor/barcode-scanner';
import { BehaviorSubject, map, Observable, of, take } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ObjetService {

  private _listeObjets = new BehaviorSubject<Objet[]| null>(null);
  private _objet  = new BehaviorSubject<Objet| null>(null);

 
  constructor(){
    this.getAllObjet();
  }
  get listeObjets() {
    return this._listeObjets.asObservable();
  }
  getAllObjet(): Observable<Objet[] | null> {
    const objets: Objet[] = [
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

    this._listeObjets.next(objets);

    return this._listeObjets.asObservable();
  }
  getObjet(id: number): Observable<Objet | null> {
    return this._listeObjets.pipe(
      take(1),
      map((objets: Objet[] | null) => {
        const objet = objets?.find((o: Objet) => o.id === id) || null;
        this._objet.next(objet);
        return objet;
      })
    );
  }
 
  async startScan(val?: number) {
    try {
      const result = await CapacitorBarcodeScanner.scanBarcode({
        hint: val || 17,
        cameraDirection: 1,
      });
      console.log(result);
      return result.ScanResult;
    } catch (e) {
      throw e;
    }
  }
  ajoutHistorique(){}
  


}
