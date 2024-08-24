import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { environment } from 'src/app/environments/environment';
import { Objet } from 'src/app/shared/models/objet.model';

const URL_BASE = environment.host + 'objet';

@Injectable({
  providedIn: 'root'
})
export class ObjetService {
  

  private _listeMesObjets = new BehaviorSubject<any[]| null>(null);

  private _listeObjets = new BehaviorSubject<Objet[]| null>(null)
  
  constructor(private http: HttpClient) { 

  }

  getAllObject(): Observable<Objet[]> {
    return this.http.get<Objet[]>(URL_BASE);
  }

  getObjectById(id: any): Observable<Objet>{
    return this.http.get<Objet>(URL_BASE+'/'+id)
  }

  get listeMesObjets() {
    return this._listeMesObjets.asObservable();
  }
  getListObjet(): Observable<any[] | null> {
 
    const url = URL_BASE+'/objet';
    console.log(url)
    const headers = {'Authorization' : 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbmRyaWFubWF0dGF4QGdtYWlsLmNvbSIsImlhdCI6MTcyMzk3MDM1NiwiZXhwIjoxNzIzOTczOTU2fQ.DZA5Mu1GaE2I_guwvImq_PlYYxNXa29V4h1MSr2r948'}
    console.log(headers)
    this.http.get<any[]>(url, { headers }).subscribe({
      next: (response) => {
        const objets = response.map((objet:any) => ({
          id: objet.id,
          nom: objet.nom,
          description: objet.description,
          valeur: objet.valeur,
          disponible: objet.disponible,
          proprietaire_id: objet.proprietaire.id,
          img:`data:image/png;base64,${objet.image}`
        }));
        this._listeMesObjets.next(objets);
      },
      error: (error) => {
        console.error('Une erreur est survenue : ', error);
        this._listeMesObjets.next(null);
      }
    });

    return this._listeMesObjets.asObservable();
  }

}
