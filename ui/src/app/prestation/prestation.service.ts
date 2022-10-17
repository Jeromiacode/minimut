import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Prestation} from './models/prestation';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PrestationService {

  constructor(private http: HttpClient) { }

  getAllPrestations(): Observable<Prestation[]> {
    return this.http.get<Prestation[]>('http://localhost:8080/prestations');
  }

  createNewPrestation(prestation: Prestation): Observable<Prestation> {
    return this.http.post<Prestation>('http://localhost:8080/prestations', prestation);
  }

  deletePrestationByCode(prestationCode: string): Observable<Prestation> {
    return this.http.delete<Prestation>('http://localhost:8080/prestations/' + prestationCode);
  }
}
