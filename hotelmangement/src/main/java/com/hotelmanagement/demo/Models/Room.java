package com.hotelmanagement.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.util.Lazy;

import javax.persistence.*;

@Entity
public class Room {
    @Id
    @Column(name = "room_no")
    private int id;
//    @OneToOne(mappedBy = "room")
//    private RoomCategory roomCategory;
    private String availability_status;

//  getters, setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvailability_status() {
        return availability_status;
    }

    public void setAvailability_status(String availability_status) {
        this.availability_status = availability_status;
    }

}
