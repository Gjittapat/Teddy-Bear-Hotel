package com.hotelmanagement.demo.Controllers;



import com.hotelmanagement.demo.Repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController {

    @Autowired
    private GuestRepository  g;

    @GetMapping("/booking")
    public String showBooked(Model model) {
        // show booking table
        model.addAttribute("bookings", g.getBookedGuest());
        // pass in an empty object(InputToFunction) to receive guest_id for deletion
        model.addAttribute("inputToFunction", new InputToFunction());
        return "booking";
    }
}
