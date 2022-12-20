package com.hotelmanagement.demo.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
public class RoomCategory {

    @Id
    @Column(name = "room_no")
    private int id;
    private String roomType;
    private String bedType;
    private int rate;

//    @OneToOne()
//    @JoinColumn(name = "room_no")
//    @JsonIgnore
//    private Room room;

//  getters, setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

//    public Room getRoom() {
//        return room;
//    }
//
//    public void setRoom(Room room) {
//        this.room = room;
//    }
}
