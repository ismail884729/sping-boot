package com.ismail.sports.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "player_name")
    private String playerName;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;

//    public Object getPosition() {
//        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'getPosition'");
//    }
//
//    public void setPosition(Object position) {
//        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'setPosition'");
//    }
//
//    public Object getJerseyNumber() {
//        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'getJerseyNumber'");
//    }
//
//    public void setJerseyNumber(Object jerseyNumber) {
//        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'setJerseyNumber'");
//    }

    // Constructors, getters, and setters
}
