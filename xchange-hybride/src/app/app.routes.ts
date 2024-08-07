import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'home',
    children :[
      {
        path :'', 
        loadComponent: () => import('./home/home.page').then((m) => m.HomePage),
      },
      {
        path: 'detail/:id',
        loadComponent: () => import('./page/detail/detail.page').then( m => m.DetailPage)
      },
    ]
   
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full',
  },
  {
    path: 'historique',
    loadComponent: () => import('./page/historique/historique.page').then( m => m.HistoriquePage)
  },
 
];
