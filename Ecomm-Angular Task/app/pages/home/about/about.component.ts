import { Component, Input } from '@angular/core';
import { service } from '../../../model/service';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent {
  @Input() service:service={id:'',title:'',description:'',image:''}
}
