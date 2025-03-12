import { Component, Input } from '@angular/core';
import { Product } from '../../../model/product';

@Component({
  selector: 'app-indian',
  templateUrl: './indian.component.html',
  styleUrls: ['./indian.component.css']
})
export class IndianComponent {
  @Input() product: Product = {
    id: '',
    title: '',
    description: '',
    rating: 0,
    reviews: 0,
    price: 0,
    mrp: 0,
    discount: 0,
    image: ''
  };
}
