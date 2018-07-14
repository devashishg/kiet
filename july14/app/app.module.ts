import { DataService } from './myservices/dataservice.service';
import { HighLightDirective } from './mydirectives/highlight.directive';
import { ShortenPipe } from './mypipes/shorten.pipe';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { BetterhighlightDirective } from './mydirectives/betterhighlight.directive';
import { DeptfilterPipe } from './deptfilter.pipe';
import { MakecapitalDirective } from './mydirectives/makecapital.directive';
import { AddempComponent } from './addemp/addemp.component';
import { ShowEmpComponent } from './show-emp/show-emp.component';
import { EditEmpComponent } from './edit-emp/edit-emp.component';
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
    EditEmpComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    DataService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
