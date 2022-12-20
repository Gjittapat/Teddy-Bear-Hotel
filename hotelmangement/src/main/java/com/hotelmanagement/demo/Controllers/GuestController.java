package com.hotelmanagement.demo.Controllers;


import com.hotelmanagement.demo.Models.Guest;
import com.hotelmanagement.demo.Repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
public class GuestController {
    @Autowired
    private GuestRepository guestRepository;


    @GetMapping({"/guest"})
    public String showUserList(Model model) {
    model.addAttribute("guests", this.guestRepository.findAll());
    return "guest";
}

    @GetMapping("/get-booked-guests")
    public List<Guest> getBookedGuests(){
        return guestRepository.getBookedGuest();
    }


    @GetMapping("/add-guest")
    public String showAddGuest(Model model){
        model.addAttribute("guest", new Guest());

        return "add-guest";}

    @PostMapping("/add-guest")
    public String createUser(Model model, @ModelAttribute Guest guest) {
        int roomRequestNo = guest.getRoom_no();
        String status = guestRepository.getRoomStatus(roomRequestNo);
        if(status.equalsIgnoreCase("Available")){
            guestRepository.takeRoom(roomRequestNo);
            guestRepository.save(guest);
        }
        return "redirect:/guest";
    }





}
