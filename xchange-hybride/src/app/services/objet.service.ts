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
  uri = "https://xchange-server-rep-latest.onrender.com/"
 
  constructor(private http: HttpClient){
    //this.getAllObjet();
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
    this.http.get<Objet[]>(url).subscribe({
      next: (response) => {
        const objets = response.map((objet:any) => ({
          id: objet.id,
          nom: objet.nom,
          description: objet.description,
          valeur: objet.valeur,
          disponible: objet.disponible,
          proprietaire_id: objet.proprietaire.id,
          // img: this.transformerChaine(objet.nom)+".jpg"
          img: `data:image/png;base64,${objet.image}`
        }));
        console.log(objets)
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
  getAllObjet(): Observable<Objet[] | null> {
    const objets: Objet[] = [
      {
        id: 1,
        nom: 'Sac à main',
        valeur: 100,
        description: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Exercitationem, in eveniet. Eius, veniam doloremque. Deserunt assumenda asperiores laudantium et eius ipsam quos ipsa sed dolorum. Nesciunt nostrum vero libero assumenda.',
        disponible: true,
        proprietaire_id: 0,
        img: 'sac_a_main.jpg',
      },
      {
        id: 2,
        nom: 'Trousse',
        valeur: 100,
        description: 'Trousse de très bonne qualité',
        disponible: true,
        proprietaire_id: 0,
        img: 'trousse.jpg',
      },
      {
        id: 3,
        nom: 'Telephone S24',
        valeur: 100,
        description: 'Samsung de très bonne qualité',
        disponible: true,
        proprietaire_id: 0,
        img: 'telephone_s24.jpg',
      },
      {
        id: 4,
        nom: 'Cadre photo',
        valeur: 100,
        description: 'Cadre photo de très bonne qualité',
        disponible: true,
        proprietaire_id: 0,
        img: 'cadre_photo.jpg',
      },
      {
        id: 5,
        nom: 'Lunette de soleil',
        valeur: 100,
        description: 'Lunette de soleil, anti-UV',
        disponible: true,
        proprietaire_id: 0,
        img: 'lunette_de_soleil.jpg',
      },
    ];

    this._listeObjets.next(objets);

    return this._listeObjets.asObservable();
  }
}
