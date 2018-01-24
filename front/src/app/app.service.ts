import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/map'

@Injectable()
export class AppService {

  constructor(private http: Http) {
  }

  getRooms(): Observable<any> {
    return this.http.get("http://localhost:1993/rooms").map(res => res.json())
  }

  getGists(id): Observable<any> {
    return this.http.get(`http://localhost:1993/gists?roomId=${id}`).map(res => res.json())
  }
}
