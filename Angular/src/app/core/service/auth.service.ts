import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, map } from 'rxjs/operators';

import { User } from '../models/auth.models';
import { environment } from 'src/app/environments/environment';
import { throwError } from 'rxjs';

const URL_BASE = environment.host + 'auth/';
@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    user: any | null = null;

    constructor (private http: HttpClient) {
    }

    /**
     * Returns the current user
     */
    public currentUser(): User | null {
        if (!this.user) {
            this.user = JSON.parse(sessionStorage.getItem('currentUser')!);
        }
        return this.user;
    }

    /**
     * Performs the login auth
     * @param email email of user
     * @param password password of user
     */
    login(email: string, password: string): any {
        const url = URL_BASE + 'login';
        const body = {
            "email": email,
            "password": password
        };
        // console.log("=====================================================");
        // console.log(body);
    
        return this.http.post<any>(url, body)
            .pipe(
                map(response => {
                    if (response) {
                        const user = {
                            email: response.email,
                            id: response.id,
                            nombreDeNotes: response.nombreDeNotes,
                            noteMoyenne: response.noteMoyenne,
                            role: response.role,
                            username: response.username,
                            token: response.token 
                        };
                        this.user = user;
                        this.user.token = response.token;
                        sessionStorage.setItem('currentUser', JSON.stringify(this.user));
                    }
                    return response.user;
                }),
                // Interception et gestion des erreurs
                catchError(error => {
                    console.error('Erreur de login :', error);
                    let errorMessage = 'Une erreur s\'est produite lors de la connexion.';
                    if (error.status === 401) {
                        errorMessage = 'Email ou mot de passe incorrect.';
                    } else if (error.status === 500) {
                        errorMessage = 'Erreur serveur, veuillez réessayer plus tard.';
                    }
                    // Vous pouvez renvoyer l'erreur ou afficher un message d'erreur à l'utilisateur
                    return throwError(() => new Error(errorMessage));
                })
            );
    }
    

    /**
     * Performs the signup auth
     * @param name name of user
     * @param email email of user
     * @param password password of user
     */
    signup(name: string, email: string, password: string): any {
        return this.http.post<any>(`/api/signup`, { name, email, password })
            .pipe(map(user => user));

    }



    /**
     * Logout the user
     */
    logout(): void {
        // remove user from session storage to log user out
        sessionStorage.removeItem('currentUser');
        this.user = null;
    }
}

