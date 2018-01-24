package com.banks.wsninja.controller;

import com.banks.wsninja.domain.Gist;
import com.banks.wsninja.domain.Room;
import com.banks.wsninja.repo.GistRepo;
import com.banks.wsninja.repo.RoomRepo;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by banks on 1/18/18.
 */
@RestController
@CrossOrigin("*")
public class MainController {

    private final RoomRepo roomRepo;
    private final GistRepo gistRepo;
    private final SimpMessagingTemplate simpMessagingTemplate;

    public MainController(RoomRepo roomRepo, GistRepo gistRepo, SimpMessagingTemplate simpMessagingTemplate) {
        this.roomRepo = roomRepo;
        this.gistRepo = gistRepo;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/talk-about-sports/{id}")
//    @SendTo("/topic/room/{id}")
    public String a(@Payload String msg, @DestinationVariable Long id) {
        Gist gist = new Gist();
        gist.setRoom(roomRepo.findOne(id));
        gist.setText(msg);

        gistRepo.save(gist);

        simpMessagingTemplate.convertAndSend("/topic/room/" + id, msg);
        return msg;
    }

    @GetMapping("/rooms")
    public List<Room> b() {
        return this.roomRepo.findAll();
    }

    @GetMapping("/gists")
    public List<Gist> b(@RequestParam Long roomId) {
        return this.gistRepo.findByRoomId(roomId);
    }

}
