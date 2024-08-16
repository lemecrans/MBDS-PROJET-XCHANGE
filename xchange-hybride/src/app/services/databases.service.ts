import { Injectable, signal, WritableSignal } from '@angular/core';
import {
  CapacitorSQLite,
  SQLiteConnection,
  SQLiteDBConnection,
} from '@capacitor-community/sqlite';
import { Objet } from '../models/objet.model';

const DB_USERS = 'xchangeuserdb';

@Injectable({
  providedIn: 'root',
})
export class DatabasesService {
  private sqlite: SQLiteConnection = new SQLiteConnection(CapacitorSQLite);
  private database!: SQLiteDBConnection;
  private historiques: WritableSignal<Objet[]> = signal<Objet[]>([]);

  constructor() {}

  async initialzPlugin() {
    this.database = await this.sqlite.createConnection(
      DB_USERS,
      false,
      'no-encryption',
      1,
      false
    );
    await this.database.open();
    const schema = `CREATE TABLE IF NOT EXISTS historique (
      id INTEGER PRIMARY KEY,
      nom VARCHAR(255),
      valeur INTEGER,
      description TEXT,
      disponible BOOLEAN,
      proprietaire_id INTEGER,
      img TEXT
    );`;
    await this.database.execute(schema);
    this.loadHistorique();
    return true;
  }

  async loadHistorique() {
    const historiques = await this.database.query('SELECT * FROM historique;');
    this.historiques.set(historiques.values || []);
  }

  async addHistorique(objet: Objet) {
    const query = `
    INSERT INTO historique (nom, valeur, description, disponible, proprietaire_id, img) 
    VALUES ('${objet.nom}', ${objet.valeur}, '${objet.description}', ${
      objet.disponible ? 1 : 0
    }, ${objet.proprietaire_id}, '${objet.img}');
  `;
    try {
      const result = await this.database.execute(query);
      console.log('Historique ajouté avec succès');
      this.loadHistorique();
      return result;
    } catch (error) {
      console.error("Erreur lors de l'ajout de l'historique :", error);
    }
  }
  async deleteHistorique(objetId: number) {
    const query = `DELETE FROM historique WHERE id = ${objetId};`;
  
    try {
      const result = await this.database.execute(query);
      console.log('Historique supprimé avec succès');
      this.loadHistorique();
      return result;
    } catch (error) {
      console.error("Erreur lors de la suppression de l'historique :", error);
    }
  }

  getHistorique(){
    return this.historiques;
  }
  
}
