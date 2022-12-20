package com.hotelmanagement.demo.Controllers;
//import java.util.List;

import com.hotelmanagement.demo.Models.Room;
import com.hotelmanagement.demo.Repositories.GuestRepository;
import com.hotelmanagement.demo.Repositories.RoomCategoryRepository;
import com.hotelmanagement.demo.Repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private RoomCategoryRepository roomCategoryRepository;

    @PostMapping("/room/add-room")
    Room newRoom(@RequestBody Room newRoom){
        return roomRepository.save(newRoom);

    }

    @GetMapping("/")
    public String showUserList(Model model) {
        model.addAttribute("rooms", roomRepository.findAll());
        model.addAttribute("roomCategories", roomCategoryRepository.findAll());

        return "room";
    }


    }





