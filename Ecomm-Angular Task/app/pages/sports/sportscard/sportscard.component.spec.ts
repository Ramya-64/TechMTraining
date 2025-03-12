import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SportscardComponent } from './sportscard.component';

describe('SportscardComponent', () => {
  let component: SportscardComponent;
  let fixture: ComponentFixture<SportscardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SportscardComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SportscardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
