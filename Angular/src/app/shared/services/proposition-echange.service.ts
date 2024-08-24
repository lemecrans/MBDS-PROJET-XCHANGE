import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/app/environments/environment';
import { PropositionEchange } from '../models/propositionEchange.model';

const URL_BASE = environment.host + 'propositions';
@Injectable({
  providedIn: 'root'
})
export class PropositionEchangeService {

  constructor(private http: HttpClient) { }

  getAllProposition(): Observable<PropositionEchange[]>{
    return this.http.get<PropositionEchange[]>(URL_BASE)
  }
}
