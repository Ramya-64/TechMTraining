import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { AboutComponent } from './pages/home/about/about.component';
import { ProductsComponent } from './pages/products/products.component';
import { WesternComponent } from './pages/western/western.component';
import { SportsComponent } from './pages/sports/sports.component';
import { JewelComponent } from './pages/jewel/jewel.component';
import { BagsComponent } from './pages/bags/bags.component';
import { WatchesComponent } from './pages/watches/watches.component';
import { LoginComponent } from './common/login/login.component';

const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'services/:id',component:AboutComponent},
  {path:'products',component:ProductsComponent},
  {path:'western',component:WesternComponent},
  {path:'sports',component:SportsComponent},
  {path:'jewel',component:JewelComponent},
  {path:'bags',component:BagsComponent},
  {path:'watches',component:WatchesComponent},
  {path:'login',component:LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
