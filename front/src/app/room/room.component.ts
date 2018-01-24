import {Component, OnInit} from "@angular/core"
import {AppService} from "../app.service";
import SockJS from 'sockjs-client';
import Stomp from 'stompjs';
import {MessageService} from "../message.service";

@Component({
  templateUrl: "./room.component.html"
})
export class RoomComponent implements OnInit {
  roomId;
  gists: any[];
  stompClient: any;

  ngOnInit(): void {
    this.roomId = this.ms.data.room.id;

    this.as.getGists(this.roomId).subscribe(res => this.gists = res);

    this.stompClient = Stomp.over(new SockJS("http://localhost:1993/main-ws"));
    this.stompClient.connect({}, () => {
      this.stompClient.subscribe(`/topic/room/${this.roomId}`, (msg) => {
        this.gists.push(msg.body);
      });
    });
  }

  constructor(private as: AppService, private ms: MessageService) {

  }

  postToRoom(msg) {
    this.stompClient.send(`/talk-about-sports/${this.roomId}`, {}, msg);
  }

}
