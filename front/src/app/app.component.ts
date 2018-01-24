import {Component, OnInit} from '@angular/core';
import {AppService} from "./app.service";
import SockJS from 'sockjs-client';
import Stomp from 'stompjs';
import {MessageService} from "./message.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'app';
  rooms = [];
  msgs = [];
  stompClient: any;

  ngOnInit(): void {
    this.as.getRooms().subscribe(res => {
      this.rooms = res;
    });

    this.initWs();
  }

  private initWs() {
    this.stompClient = Stomp.over(new SockJS("http://localhost:1993/main-ws"));
    this.stompClient.connect({}, () => {
      this.stompClient.subscribe("/topic/sportsRoom", (msg) => {
        this.msgs.push(msg.body);
      });
    });
  }

  constructor(private as: AppService, private ms: MessageService, private router: Router) {

  }

  sendMessage(message) {
    this.stompClient.send("/talk-about-sports", {}, message);
  }

  goToRoom(room) {
    // alert(JSON.stringify(room));
    this.ms.data.room = room;
    this.router.navigate([`room/${room.id}`])
  }
}
