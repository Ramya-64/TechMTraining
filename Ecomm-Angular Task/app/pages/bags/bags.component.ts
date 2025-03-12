import { Component, OnInit } from '@angular/core';
import { BagProduct } from '../../model/bag';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-bags',
  templateUrl: './bags.component.html',
  styleUrls: ['./bags.component.css']
})
export class BagsComponent  {
  bagList: BagProduct[] = [];
  filteredBag: BagProduct[] = []; // Filtered sports product list
    minPrice: number = 0;
      maxPrice: number = Infinity;
      selectedPriceRange: string = '';

  constructor(private api: ApiService) {}

  ngOnInit() {
    this.api.getBagProducts().subscribe({
      next: (result: BagProduct[]) => {
        this.bagList = result;
      },
      error: (error) => console.log(error)
    });
  }
  applyFilters() {
    console.log("Applying Filters...");
    console.log("Selected Price Range:", this.selectedPriceRange);
    console.log("Min Price:", this.minPrice);
    console.log("Max Price:", this.maxPrice);

    this.filteredBag = this.bagList.filter(bag => {
      return bag.price >= this.minPrice && bag.price <= this.maxPrice;
    });

    console.log("Filtered Sports Products:", this.filteredBag);
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


