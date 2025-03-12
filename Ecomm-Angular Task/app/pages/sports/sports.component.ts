import { Component, OnInit } from '@angular/core';
import { SportsProduct } from '../../model/sport';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-sports',
  templateUrl: './sports.component.html',
  styleUrls: ['./sports.component.css']
})
export class SportsComponent  {
  sportsList: SportsProduct[] = [];   // Original sports product list
  filteredSports: SportsProduct[] = []; // Filtered sports product list
  minPrice: number = 0;
  maxPrice: number = Infinity;
  selectedPriceRange: string = '';

  constructor(private api: ApiService) {}

  ngOnInit() {
    this.api.getSportsProducts().subscribe({
      next: (result: SportsProduct[]) => {
        this.sportsList = result;
        this.applyFilters();
      },
      error: (error) => console.log(error)
    });
  }

  applyFilters() {
    console.log("Applying Filters...");
    console.log("Selected Price Range:", this.selectedPriceRange);
    console.log("Min Price:", this.minPrice);
    console.log("Max Price:", this.maxPrice);

    this.filteredSports = this.sportsList.filter(sport => {
      return sport.price >= this.minPrice && sport.price <= this.maxPrice;
    });

    console.log("Filtered Sports Products:", this.filteredSports);
  }

  onPriceFilterChange() {
    switch (this.selectedPriceRange) {
      case '0-500':
        this.minPrice = 0;
        this.maxPrice = 500;
        break;
      case '500-1000':
        this.minPrice = 500;
        this.maxPrice = 1000;
        break;
      case '1000-2000':
        this.minPrice = 1000;
        this.maxPrice = 2000;
        break;
      case '2000':
        this.minPrice = 2000;
        this.maxPrice = Infinity;
        break;
      default:
        this.minPrice = 0;
        this.maxPrice = Infinity;
    }

    this.applyFilters();
  }
}
