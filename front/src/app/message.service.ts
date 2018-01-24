import {Injectable} from '@angular/core';

@Injectable()
export class MessageService {

  private _data: any = {};

  get data(): any {
    return this._data;
  }

  set data(value: any) {
    this._data = value;
  }
}
