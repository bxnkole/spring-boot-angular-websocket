package com.banks.wsninja.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by banks on 1/18/18.
 */
@Entity
@Data
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Room(String name) {
        this.name = name;
    }
}
