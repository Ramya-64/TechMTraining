import { Component } from '@angular/core';
import { service } from '../../model/service';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  aboutlist:service[]=[]
  constructor(private api:ApiService){

  }
  ngOnInit(){ 
    this.api.getServices().subscribe({
        next:(result:service[])=>this.aboutlist = result,
        error:(error)=>console.log(error)
    });
  }

}
