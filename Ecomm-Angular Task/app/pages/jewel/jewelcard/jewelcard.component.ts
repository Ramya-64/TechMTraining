import { Component, Input } from '@angular/core';
import { JewelProduct } from '../../../model/jewels';

@Component({
  selector: 'app-jewelcard',
  templateUrl: './jewelcard.component.html',
  styleUrls: ['./jewelcard.component.css']
})
export class JewelCardComponent {
  @Input() jewel: JewelProduct = {
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
