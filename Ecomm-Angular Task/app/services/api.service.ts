import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { WesternProduct } from '../model/west';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http:HttpClient) { }

  getServices(): Observable<any> {
    return this.http.get('http://localhost:4500/services'); // Now strongly typed
  }
  getProducts(): Observable<any> {
    return this.http.get('http://localhost:4500/products'); // Fetch products
  }
  getWesternProducts(): Observable<any> {
    return this.http.get('http://localhost:4500/western'); // Fetch Western products
  }
  getSportsProducts(): Observable<any> {
    return this.http.get('http://localhost:4500/sports'); // Fetch Sports products
  }
  getJewelProducts(): Observable<any> {
    return this.http.get('http://localhost:4500/jewel');
  }
  getBagProducts(): Observable<any> {
    return this.http.get('http://localhost:4500/bags'); // Fetch Bag products
  }
  getWatchesProducts(): Observable<any> {
    return this.http.get('http://localhost:4500/watches'); // Fetch Watches products
  }

}
