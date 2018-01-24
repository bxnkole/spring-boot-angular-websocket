package com.banks.wsninja.repo;

import com.banks.wsninja.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by banks on 1/18/18.
 */
public interface RoomRepo extends JpaRepository<Room, Long> {
}
