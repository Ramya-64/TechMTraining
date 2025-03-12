import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BagCardComponent } from './bagcard.component';

describe('BagcardComponent', () => {
  let component: BagCardComponent;
  let fixture: ComponentFixture<BagCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BagCardComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BagCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
