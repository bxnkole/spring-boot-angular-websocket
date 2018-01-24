package com.banks.wsninja.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by banks on 1/18/18.
 */
@Entity
@Data
@NoArgsConstructor
public class Gist {

    @Id
    @GeneratedValue
    private Long id;

    private String text;

    @ManyToOne
    private Room room;

    public Gist(String text) {
        this.text = text;
    }
}
