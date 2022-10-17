import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Affiliate} from './models/affiliate';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AffiliateService {

  constructor(private http: HttpClient) { }

  getAllAffiliates(): Observable<Affiliate[]> {
    return this.http.get<Affiliate[]>('http://localhost:8080/affiliates');
  }

  getAffiliateDetails(nationalNumber: string): Observable<Affiliate> {
    return this.http.get<Affiliate>('http://localhost:8080/affiliates/' + nationalNumber);
  }

  createNewAffiliate(affiliate: Affiliate): Observable<Affiliate> {
    return this.http.post<Affiliate>('http://localhost:8080/affiliates', affiliate);
  }

  updateAffiliate(nationalNumber: string, affiliate: Affiliate): Observable<Affiliate> {
    return this.http.put<Affiliate>('http://localhost:8080/affiliates/' + nationalNumber, affiliate);
  }

  deleteAffiliateByNationalNumber(nationalNumber: string): Observable<Affiliate> {
    return this.http.delete<Affiliate>('http://localhost:8080/affiliates/' + nationalNumber);
  }
}
