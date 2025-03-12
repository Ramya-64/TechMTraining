import { Component, Input } from '@angular/core';
import { SportsProduct } from '../../../model/sport';

@Component({
  selector: 'app-sportscard',
  templateUrl: './sportscard.component.html',
  styleUrls: ['./sportscard.component.css']
})
export class SportscardComponent {
  @Input() sport: SportsProduct = {
    id: '',
    title: '',
    description: '',
    rating: 0,
    reviews: 0,
    price: 0,
    mrp: 0,
    discount: 0,
    image: '',
    category: '',
    availability: '',
    shipping: '',
    tax_inclusive: false
  };
}
