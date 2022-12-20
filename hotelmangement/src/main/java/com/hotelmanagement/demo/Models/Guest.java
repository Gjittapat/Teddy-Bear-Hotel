package com.hotelmanagement.demo.Models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
// note: remove payment, booking tables
// 1 guest per 1 room
// if guest_status == "booking" or "check in" --> unavailable/ else("check out" or null) == available
@Entity
public class Guest {
    @Id
    @Column(name = "guest_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private int room_no;
    @Column(nullable = false)
    private  String guestName;
    @Column(nullable = false)
    private String guestStatus;
    @Column(nullable = false)
    private String guestCitizenNum;
    @Column(nullable = false)
    private String guest_phone;



    // constructor
    public Guest() {
        this.guestStatus = "booking";
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestStatus() {
        return guestStatus;
    }

    public void setGuestStatus(String guestStatus) {
        this.guestStatus = guestStatus;
    }

    public String getGuestCitizenNum() {
        return guestCitizenNum;
    }

    public void setGuestCitizenNum(String guestCitizenNum) {
        this.guestCitizenNum = guestCitizenNum;
    }

    public String getGuest_phone() {
        return guest_phone;
    }

    public void setGuest_phone(String guest_phone) {
        this.guest_phone = guest_phone;
    }

    public int getRoom_no() {
        return room_no;
    }

    public void setRoom_no(int room_no) {
        this.room_no = room_no;
    }


//    public List<Booking> getBooking() {
//        return booking;
//    }
//
//    public void setBooking(List<Booking> booking) {
//        this.booking = booking;
//    }

}
