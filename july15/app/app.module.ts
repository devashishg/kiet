import { DataService } from './myservices/dataservice.service';
import { HighLightDirective } from './mydirectives/highlight.directive';
import { ShortenPipe } from './mypipes/shorten.pipe';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { BetterhighlightDirective } from './mydirectives/betterhighlight.directive';
import { DeptfilterPipe } from './deptfilter.pipe';
import { MakecapitalDirective } from './mydirectives/makecapital.directive';
import { AddempComponent } from './addemp/addemp.component';
import { ShowEmpComponent } from './show-emp/show-emp.component';
import { EditEmpComponent } from './edit-emp/edit-emp.component';
import { HomeComponent } from './home/home.component';
import {Routes, RouterModule} from '@angular/router';

const appRoutes: Routes = [
    {
      path: '',
      component: HomeComponent
    },
    {
      path: 'addemp',
      component: AddempComponent
    },
    {
      path: 'editemp',
      component: EditEmpComponent
    },
    {
      path: 'getemp',
      component: ShowEmpComponent
    }
];



@NgModule({
  declarations: [
    AppComponent,
    ShortenPipe,
    HighLightDirective,
    BetterhighlightDirective,
    DeptfilterPipe,
    MakecapitalDirective,
    AddempComponent,
    ShowEmpComponent,
    EditEmpComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    DataService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
