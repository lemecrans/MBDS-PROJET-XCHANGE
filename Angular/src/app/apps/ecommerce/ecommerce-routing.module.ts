import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


const routes: Routes = [
  { path: 'products-edit', loadChildren: () => import('./add-product/add-product.module').then(m => m.AddProductModule) },
  { path: 'checkout', loadChildren: () => import('./checkout/checkout.module').then(m => m.CheckoutModule) },
  { path: 'customers', loadChildren: () => import('./customer/customer.module').then(m => m.CustomerModule) },
  { path: 'dashboard', loadChildren: () => import('./dashboard/dashboard.module').then(m => m.DashboardModule) },
  { path: 'proposition/details', loadChildren: () => import('./order-detail/order-detail.module').then(m => m.OrderDetailModule) },
  { path: 'proposition', loadChildren: () => import('./orders/orders.module').then(m => m.OrdersModule) },
  { path: 'liste-objets', loadChildren: () => import('./products/products.module').then(m => m.ProductsModule) },
  { path: 'liste-objets/details', loadChildren: () => import('./product-detail/product-detail.module').then(m => m.ProductDetailModule) },
  { path: 'sellers', loadChildren: () => import('./seller/seller.module').then(m => m.SellerModule) },
  { path: 'shopping-cart', loadChildren: () => import('./shopping-cart/shopping-cart.module').then(m => m.ShoppingCartModule) },
  { path: 'map', loadChildren: () => import('./map/map.module').then(m => m.MapModule) }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EcommerceRoutingModule { }
