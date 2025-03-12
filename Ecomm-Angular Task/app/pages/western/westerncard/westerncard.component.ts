import { Component, Input } from '@angular/core';
import { WesternProduct } from '../../../model/west';

@Component({
  selector: 'app-westerncard',
  templateUrl: './westerncard.component.html',
  styleUrls: ['./westerncard.component.css']
})
export class WesternCardComponent {
  @Input() west: WesternProduct = {
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
