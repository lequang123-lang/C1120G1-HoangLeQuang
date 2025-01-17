import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import { Product } from '../module/product';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.scss']
})
export class ProductCreateComponent implements OnInit {
  // tslint:disable-next-line:no-output-on-prefix no-output-rename
  @Output('productCreate') onCreate = new EventEmitter<Product>();
  public product: Product | undefined;
  public xuatXu: string[] = ['My', 'TQ', 'VN', 'Anh'];
  public tempXuatXu: string;
  createForm: FormGroup;

  constructor() { }

  ngOnInit(): void {
    this.createFormFunction();
  }
  createFormFunction() {
    this.createForm = new FormGroup({
      nameProduct: new FormControl('', [Validators.required]),
      priceProduct: new FormControl('', [Validators.required]),
      dateRelease: new FormControl('', [Validators.required]),
      nationRelease: new FormControl('', [Validators.required]),
      status: new FormControl('', [Validators.required])
    });
  }

  create() {
    this.onCreate.emit(this.createForm.value);
  }

  choosePlace(value: string) {
    this.tempXuatXu = value;
  }

}
