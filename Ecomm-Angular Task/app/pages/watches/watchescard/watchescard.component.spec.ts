import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WatchesCardComponent } from './watchescard.component';

describe('WatchCardComponent', () => {
  let component: WatchesCardComponent;
  let fixture: ComponentFixture<WatchesCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [WatchesCardComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(WatchesCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
