import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JewelCardComponent } from './jewelcard.component';

describe('JewelcardComponent', () => {
  let component: JewelCardComponent;
  let fixture: ComponentFixture<JewelCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [JewelCardComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(JewelCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
