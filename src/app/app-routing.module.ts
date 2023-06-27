import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminloginComponent } from './admin/adminlogin/adminlogin.component';
import { CreateComponent } from './admin/create/create.component';
import { AboutComponent } from './pages/about/about.component';
import { CartComponent } from './pages/cart/cart.component';
import { ContactComponent } from './pages/contact/contact.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { MenuComponent } from './pages/menu/menu.component';
import { PaymentComponent } from './pages/payment/payment.component';
import { ResetpasswordComponent } from './pages/resetpassword/resetpassword.component';
import { SignupComponent } from './pages/signup/signup.component';
import { TableComponent } from './pages/table/table.component';

const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'home',component:HomeComponent},
  {path:'menu',component:MenuComponent},
  {path:'menu/:id',component:MenuComponent},
  {path:'about',component:AboutComponent},
  {path:'contact',component:ContactComponent},
  {path:'login',component:LoginComponent},
  {path:'cart',component:CartComponent},
  {path:'signup',component:SignupComponent},
  {path:'reset-password',component:ResetpasswordComponent},
  {path:'payment',component:PaymentComponent},
  {path:'admin',component:AdminloginComponent},
  {path:'create',component:CreateComponent},
  {path:'table',component:TableComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
