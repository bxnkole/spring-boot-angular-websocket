package com.banks.wsninja.repo;

import com.banks.wsninja.domain.Gist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by banks on 1/18/18.
 */
public interface GistRepo extends JpaRepository<Gist, Long> {
    List<Gist> findByRoomId(Long roomId);
}
