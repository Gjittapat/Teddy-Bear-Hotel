package com.hotelmanagement.demo.Repositories;

import com.hotelmanagement.demo.Models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query(value = "INSERT INTO room(room_no, availability_status) VALUES (1,\"Available\"),(2,\"Available\"),(3,\"Available\"),(4,\"Available\"),(5,\"Available\"),(6,\"Available\"),(7,\"Available\"),(8,\"Available\"),(9,\"Available\"),(10,\"Available\");\n",nativeQuery = true)
    void insertRoom();

    @Query(value = "insert into Room_Category (Room_No, Room_type, Bed_type, Rate) values\n" +
            "(1, 'deluxe', 'single', 3500), (2, 'junior suite', 'double', 4500), (3, 'deluxe', 'double', 3500),\n" +
            "(4, 'junior suite', 'single', 4500), (5, 'superior suite', 'double', 5500), (6, 'superior', 'single', 5500),\n" +
            "(7, 'deluxe', 'single', 3500), (8, 'superior suite', 'double', 5500), (9, 'junior suite', 'double', 4500),\n" +
            "(10, 'superior', 'double', 5500);", nativeQuery = true)
    void insertRoomCategory();
}
