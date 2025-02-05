package repository;

import model.Booking;
import model.Cabin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByCabin(Cabin cabin);
}
