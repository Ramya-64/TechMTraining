import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { CartComponent } from './pages/cart/cart.component';
import { ProductsComponent } from './pages/products/products.component';
import { HelpComponent } from './pages/help/help.component';
import { MenuComponent } from './common/menu/menu.component';
import { AboutComponent } from './pages/home/about/about.component';
import { HttpClientModule } from '@angular/common/http';
import { IndianComponent } from './pages/products/indian/indian.component';
import { WesternCardComponent } from './pages/western/westerncard/westerncard.component';
import { SearchFilterPipe } from './pipes/search-filter.pipe';
import { PriceFilterPipe } from './pipes/price-filter.pipe';
import { RatingFilterPipe } from './pipes/rating-filter.pipe';
import { WesternComponent } from './pages/western/western.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SportsComponent } from './pages/sports/sports.component';
import { SportscardComponent } from './pages/sports/sportscard/sportscard.component';
import { JewelComponent } from './pages/jewel/jewel.component';
import { JewelCardComponent } from './pages/jewel/jewelcard/jewelcard.component';
import { BagsComponent } from './pages/bags/bags.component';
import { BagCardComponent } from './pages/bags/bagcard/bagcard.component';
import { WatchesComponent } from './pages/watches/watches.component';
import { WatchesCardComponent } from './pages/watches/watchescard/watchescard.component';
import { LoginComponent } from './common/login/login.component';  // ✅ Add FormsModule
import { ReactiveFormsModule } from '@angular/forms';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CartComponent,
    ProductsComponent,
    HelpComponent,
    MenuComponent,
    AboutComponent,
    IndianComponent,
    SearchFilterPipe,
    PriceFilterPipe,
    RatingFilterPipe,
    WesternComponent,
    WesternCardComponent,
    SportsComponent,
    SportscardComponent,
    JewelComponent,
    JewelCardComponent,
    BagsComponent,
    BagCardComponent,
    WatchesComponent,
    WatchesCardComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule // ✅ Import FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
