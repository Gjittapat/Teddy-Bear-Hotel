package com.hotelmanagement.demo.Controllers;

import com.hotelmanagement.demo.Models.Room;
import com.hotelmanagement.demo.Models.RoomCategory;
import com.hotelmanagement.demo.Repositories.RoomCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomCategoryController {
    @Autowired
    private RoomCategoryRepository roomCategoryRepository;

    @PostMapping("/RoomCategory")
    RoomCategory newRoomCategory(@RequestBody RoomCategory newRoomCategory){
        return  roomCategoryRepository.save(newRoomCategory);
    }


    @GetMapping(value = "/RoomCategory")
    List<RoomCategory> getRoomCategory(){
        return roomCategoryRepository.findAll();
    }




}
