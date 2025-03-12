import { Component, OnInit } from '@angular/core';
import { WesternProduct } from '../../model/west';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-western',
  templateUrl: './western.component.html',
  styleUrls: ['./western.component.css']
})
export class WesternComponent implements OnInit {
  westernList: WesternProduct[] = [];
  filteredWest: WesternProduct[] = []; // Filtered sports product list
      minPrice: number = 0;
        maxPrice: number = Infinity;
        selectedPriceRange: string = '';

  constructor(private api: ApiService) {}

  ngOnInit() {
    this.api.getWesternProducts().subscribe({
      next: (result: WesternProduct[]) => {
        this.westernList = result;
      },
      error: (error) => console.log(error)
    });
  }
  applyFilters() {
    console.log("Applying Filters...");
    console.log("Selected Price Range:", this.selectedPriceRange);
    console.log("Min Price:", this.minPrice);
    console.log("Max Price:", this.maxPrice);

    this.filteredWest = this.westernList.filter(west => {
      return west.price >= this.minPrice && west.price <= this.maxPrice;
    });

    console.log("Filtered Sports Products:", this.filteredWest);
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



