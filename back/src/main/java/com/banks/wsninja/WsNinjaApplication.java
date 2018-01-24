package com.banks.wsninja;

import com.banks.wsninja.domain.Room;
import com.banks.wsninja.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class WsNinjaApplication implements CommandLineRunner{

	private final RoomRepo roomRepo;

	@Autowired
	public WsNinjaApplication(RoomRepo roomRepo) {
		this.roomRepo = roomRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(WsNinjaApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		for (String rooms : Arrays.asList("Messi", "Ronaldo", "Neymar")) {
			Room room = new Room(rooms);

			roomRepo.save(room);
		}
	}
}
