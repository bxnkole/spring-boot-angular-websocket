import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {RouterModule} from '@angular/router';

import {AppComponent} from './app.component';
import {AppService} from "./app.service";
import {RoomComponent} from "./room/room.component";
import {MessageService} from "./message.service";

@NgModule({
  declarations: [
    AppComponent,
    RoomComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(
      [
        {path: '', component: AppComponent},
        {path: 'room/:id', component: RoomComponent}
      ],
      {useHash: true}
    )
  ],
  providers: [AppService, MessageService],
  bootstrap: [AppComponent],
  exports: [RouterModule]
})
export class AppModule {
}
