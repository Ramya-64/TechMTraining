import { Component } from '@angular/core';
import { Product } from '../../model/product';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent {
  productsList: Product[] = [];   // Original product list
  filteredProducts: Product[] = []; // Filtered product list
  minPrice: number = 0;
  maxPrice: number = Infinity;
  selectedPriceRange: string = '';

  constructor(private api: ApiService) {}

  ngOnInit() {
    this.api.getProducts().subscribe({
      next: (result: Product[]) => {
        this.productsList = result;
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

    this.filteredProducts = this.productsList.filter(product => {
      return product.price >= this.minPrice && product.price <= this.maxPrice;
    });

    console.log("Filtered Products:", this.filteredProducts);
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
