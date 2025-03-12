import { Component, Input } from '@angular/core';
import { BagProduct } from '../../../model/bag';

@Component({
  selector: 'app-bagcard',
  templateUrl: './bagcard.component.html',
  styleUrls: ['./bagcard.component.css']
})
export class BagCardComponent {
  @Input() bag: BagProduct = {
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
