package controller;

import model.Booking;
import model.Cabin;
import service.BookingService;
import service.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private CabinService cabinService;

    @PostMapping("/book")
    public Booking bookCabin(@RequestBody Booking booking) {
        return bookingService.bookCabin(booking);
    }

    @GetMapping("/cabin/{cabinId}")
    public List<Booking> getCabinBookings(@PathVariable Long cabinId) {
        Cabin cabin = cabinService.getAllCabins().stream()
                                  .filter(c -> c.getId().equals(cabinId))
                                  .findFirst()
                                  .orElseThrow(() -> new RuntimeException("Cabin not found"));
        return bookingService.getCabinBookings(cabin);
    }
}
