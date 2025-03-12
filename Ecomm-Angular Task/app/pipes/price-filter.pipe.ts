import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'priceFilter',
  pure: false // Make it reactive to changes
})
export class PriceFilterPipe implements PipeTransform {
  transform(items: any[], minPrice: number, maxPrice: number): any[] {
    if (!items) return [];
    if (!minPrice && !maxPrice) return items;

    return items.filter(item =>
      (!minPrice || item.price >= minPrice) &&
      (!maxPrice || item.price <= maxPrice)
    );
  }
}
