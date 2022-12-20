package com.hotelmanagement.demo.Repositories;

import com.hotelmanagement.demo.Models.Room;
import com.hotelmanagement.demo.Models.RoomCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomCategoryRepository  extends JpaRepository<RoomCategory, Integer> {
    @Query(value = "select room_no from room_category", nativeQuery = true)
    List<Integer> showroomCategory();
}
