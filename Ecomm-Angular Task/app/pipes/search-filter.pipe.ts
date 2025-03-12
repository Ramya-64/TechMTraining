import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchFilter'
})
export class SearchFilterPipe implements PipeTransform {

  transform(products: any[], searchQuery: string, priceRange: string): any[] {
    if (!products) return [];
    if (!searchQuery && !priceRange) return products;

    // Convert searchQuery to lowercase for case-insensitive search
    searchQuery = searchQuery.toLowerCase();

    // Filter by search term
    let filteredProducts = products.filter(product =>
      product.name.toLowerCase().includes(searchQuery)
    );

    // Filter by price range
    if (priceRange) {
      let [min, max] = priceRange.split('-').map(Number);
      filteredProducts = filteredProducts.filter(product => 
        max ? product.price >= min && product.price <= max : product.price >= min
      );
    }

    return filteredProducts;
  }
}
