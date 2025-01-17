import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductListComponent} from './product-list/product-list.component';
import {ProductCreateComponent} from './product-create/product-create.component';
import {ProductDetailComponent} from './product-detail/product-detail.component';
import {ProductEditComponent} from './product-edit/product-edit.component';
import {ProductDeleteComponent} from './product-delete/product-delete.component';


const routes: Routes = [
  {path: "home", component: ProductListComponent},
  {path: "create", component: ProductCreateComponent},
  {path: "detail/:id", component: ProductDetailComponent},
  {path: "home/edit/:id", component: ProductEditComponent},
  {path: "home/delete/:id", component: ProductDeleteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
