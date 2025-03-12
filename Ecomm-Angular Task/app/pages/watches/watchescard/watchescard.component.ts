import { Component, Input } from '@angular/core';
import { WatchProduct } from '../../../model/watch';

@Component({
  selector: 'app-watchescard',
  templateUrl: './watchescard.component.html',
  styleUrls: ['./watchescard.component.css']
})
export class WatchesCardComponent {
  @Input() watch: WatchProduct = {
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
