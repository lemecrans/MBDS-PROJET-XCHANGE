import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/app/environments/environment';

const URL_BASE = environment.host + 'objet';

@Injectable({
  providedIn: 'root'
})
export class ObjetService {

  constructor(private http: HttpClient) { }

  getAllObject(){

    return this.http.get(URL_BASE);
    
  }


}
