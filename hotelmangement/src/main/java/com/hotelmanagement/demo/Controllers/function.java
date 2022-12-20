package com.hotelmanagement.demo.Controllers;
import com.hotelmanagement.demo.Models.Guest;
import com.hotelmanagement.demo.Repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class function {
    @Autowired
    private GuestRepository guestFunction;


    @GetMapping("/check-in")
    public String showCheckIn(Model model) {
        model.addAttribute("inputToFunction", new InputToFunction());

        return "check-in";
    }

    @PostMapping("/check-in")
    public String checkInF(@ModelAttribute InputToFunction inputToFunction, Model model) {
        model.addAttribute("inputToFunction", inputToFunction);
        System.out.println(inputToFunction.getId());
        System.out.println("check in ");

        String status = guestFunction.getStatus(inputToFunction.getId());

            if (status.equalsIgnoreCase("booking")) {
                guestFunction.checkInById(inputToFunction.getId());
            }

        return "check-in";
    }

    @GetMapping("/check-out")
    public String showCheckOut(Model model) {
        model.addAttribute("inputToFunction", new InputToFunction());

        return "check-out";
    }

    @PostMapping("/check-out")
    public String checkOutF(@ModelAttribute InputToFunction inputToFunction, Model model) {
        model.addAttribute("inputToFunction", inputToFunction);
        System.out.println(inputToFunction.getId());
        System.out.println("check out ");

        String status = guestFunction.getStatus(inputToFunction.getId());
        int guestId = inputToFunction.getId();
        Guest selectedGuest = guestFunction.getGuest(guestId);
        int room_no = selectedGuest.getRoom_no();

        if (status.equalsIgnoreCase("check in")) {
            guestFunction.releaseRoom(room_no);
            guestFunction.checkOutById(guestId);
        }
        return "check-in";
    }


    @PostMapping("/booking")
    public String cancelBookingF(@ModelAttribute InputToFunction inputToFunction, Model model) {
        model.addAttribute("inputToFunction", inputToFunction);
        System.out.println(inputToFunction.getId());
        System.out.println("processing..... ");

        String status = guestFunction.getStatus(inputToFunction.getId());
        int guestId = inputToFunction.getId();
        Guest selectedGuest = guestFunction.getGuest(guestId);
        int room_no = selectedGuest.getRoom_no();

        if (status.equalsIgnoreCase("booking")) {
            guestFunction.releaseRoom(room_no);
            guestFunction.deleteGuestById(guestId);
            System.out.println("cancel booking ");
        }
        return "redirect:/booking";
    }


}



