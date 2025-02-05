package service;

import model.Booking;
import model.Cabin;
import repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public Booking bookCabin(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getCabinBookings(Cabin cabin) {
        return bookingRepository.findByCabin(cabin);
    }
}
