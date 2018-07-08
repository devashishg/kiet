import { HighLightDirective } from './mydirectives/highlight.directive';
import { ShortenPipe } from './mypipes/shorten.pipe';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { BetterhighlightDirective } from './mydirectives/betterhighlight.directive';
import { DeptfilterPipe } from './deptfilter.pipe';
import { MakecapitalDirective } from './mydirectives/makecapital.directive';
import {HttpClientModule} from '@angular/common/http';
@NgModule({
  declarations: [
    AppComponent,
    ShortenPipe,
    HighLightDirective,
    BetterhighlightDirective,
    DeptfilterPipe,
    MakecapitalDirective
  ],
  imports: [
    BrowserModule,
   FormsModule,
   HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
