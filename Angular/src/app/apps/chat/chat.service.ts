import { Injectable } from '@angular/core';
import { User } from '../../core/models/auth.models';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ChatMessage, ChatUser } from './chat.model';
import { environment } from 'src/app/environments/environment';


const URL_BASE = environment.host + 'chat/';
@Injectable({
  providedIn: 'root'
})
export class ChatService {

  user: User = {
    id: 1,
    username: 'johndoe',
    firstName: 'John',
    lastName: 'Doe',
    email: 'johndoe@example.com'
  };
  messages: ChatMessage[] = [];
  allChat: ChatUser[] = [];

    constructor (private http: HttpClient) {
    }

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
    get(desti: String): any {
      return this.http.post<any>(URL_BASE+`/get/?sender=`+this.user?.id+`&desti=`+desti, { })
    }
    getAll(): any {
      const URL= URL_BASE+`getall?sender=`+this.user?.id;
      console.log(URL)
      return this.http.post<any>(URL, { });
    }
    send(desti: String,message: String): any {
      console.log(URL_BASE+`send?sender=`+this.user?.id+`&desti=`+desti);
      console.log({"message":message})
      return this.http.post<any>(URL_BASE+`send?sender=`+this.user?.id+`&desti=`+desti, {"message":message});
    }
    start(desti: number): any {
      return this.http.post<any>(URL_BASE+`/api/chat/start?sender=`+this.user?.id+`&desti=`+desti, { })
    }

}
