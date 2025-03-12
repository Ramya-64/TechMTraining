import { Component, OnInit } from '@angular/core';
import { JewelProduct } from '../../model/jewels';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-jewel',
  templateUrl: './jewel.component.html',
  styleUrls: ['./jewel.component.css']
})
export class JewelComponent {
  jewelList: JewelProduct[] = [];
  filteredJewel: JewelProduct[] = []; // Filtered sports product list
  minPrice: number = 0;
    maxPrice: number = Infinity;
    selectedPriceRange: string = '';

  constructor(private api: ApiService) {}

  ngOnInit() {
    this.api.getJewelProducts().subscribe({
      next: (result: JewelProduct[]) => {
        this.jewelList = result;
      },
      error: (error) => console.log(error)
    });
  }
  applyFilters() {
    console.log("Applying Filters...");
    console.log("Selected Price Range:", this.selectedPriceRange);
    console.log("Min Price:", this.minPrice);
    console.log("Max Price:", this.maxPrice);

    this.filteredJewel = this.jewelList.filter(jewel => {
      return jewel.price >= this.minPrice && jewel.price <= this.maxPrice;
    });

    console.log("Filtered Sports Products:", this.filteredJewel);
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

