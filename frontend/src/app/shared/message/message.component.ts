import { Component, Inject, OnInit } from '@angular/core';
import { MAT_SNACK_BAR_DATA } from '@angular/material/snack-bar';
import { Message, Type } from '../../models/Message.model';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.scss']
})
export class MessageComponent implements OnInit {

  title: string = ""

  constructor(
    @Inject(MAT_SNACK_BAR_DATA) public message: Message
  ) { }

  ngOnInit(): void {
    this.title = this.message.text
  }

}
