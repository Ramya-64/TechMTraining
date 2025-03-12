import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WesternCardComponent } from './westerncard.component';

describe('WesterncardComponent', () => {
  let component: WesternCardComponent;
  let fixture: ComponentFixture<WesternCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [WesternCardComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(WesternCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
