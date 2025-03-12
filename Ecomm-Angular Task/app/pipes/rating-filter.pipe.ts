import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'ratingFilter'
})
export class RatingFilterPipe implements PipeTransform {
  transform(products: any[], minRating: number): any[] {
    if (!products) return [];
    return products.filter(product => product.rating >= minRating);
  }
}
