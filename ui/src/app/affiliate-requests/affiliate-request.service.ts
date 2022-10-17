import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AffiliateRequest} from './models/affiliate-request';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AffiliateRequestService {

  constructor(private http: HttpClient) { }

  getAllRequests(): Observable<AffiliateRequest[]> {
    return this.http.get<AffiliateRequest[]>('http://localhost:8080/requests');
  }

  createNewRequest(request: AffiliateRequest): Observable<AffiliateRequest> {
    return this.http.post<AffiliateRequest>('http://localhost:8080/requests', request);
  }
}
