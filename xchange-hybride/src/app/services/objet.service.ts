import { Injectable } from '@angular/core';
import { Objet } from '../models/objet.model';
import { CapacitorBarcodeScanner } from '@capacitor/barcode-scanner';
import { BehaviorSubject, map, Observable, of, take } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ObjetService {

  private _listeObjets = new BehaviorSubject<Objet[]| null>(null);
  private _objet  = new BehaviorSubject<Objet| null>(null);
  uri = "http://192.168.43.96:8080/"
 
  constructor(private http: HttpClient){
    // this.getAllObjet();
    this.getListObjet();
  }
  get listeObjets() {
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
  

  getListObjet(): Observable<Objet[] | null> {
 
    const url = this.uri+'api/objet';
    console.log(url)
    const headers = {'Authorization' : 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbmRyaWFubWF0dGF4QGdtYWlsLmNvbSIsImlhdCI6MTcyMzk3MDM1NiwiZXhwIjoxNzIzOTczOTU2fQ.DZA5Mu1GaE2I_guwvImq_PlYYxNXa29V4h1MSr2r948'}
    console.log(headers)
    this.http.get<Objet[]>(url, { headers }).subscribe({
      next: (response) => {
        const objets = response.map((objet:any) => ({
          id: objet.id,
          nom: objet.nom,
          description: objet.description,
          valeur: objet.valeur,
          disponible: objet.disponible,
          proprietaire_id: objet.proprietaire.id,
          img: this.transformerChaine(objet.nom)+".jpg"
        }));
        this._listeObjets.next(objets);
      },
      error: (error) => {
        console.error('Une erreur est survenue : ', error);
        this._listeObjets.next(null);
      }
    });

    return this._listeObjets.asObservable();
  }
  transformerChaine(chaine: string): string {
    const minuscule = chaine.toLowerCase();
  
    const sansAccents = minuscule.normalize("NFD").replace(/[\u0300-\u036f]/g, "");
  
    const resultat = sansAccents.replace(/\s+/g, "_");
  
    return resultat;
  }
  //static
  /*getAllObjet(): Observable<Objet[] | null> {
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
  }*/
}
