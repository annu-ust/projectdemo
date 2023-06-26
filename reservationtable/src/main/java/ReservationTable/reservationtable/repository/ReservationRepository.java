package ReservationTable.reservationtable.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ReservationTable.reservationtable.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    long countByDateTimeAndConfirmed(LocalDateTime dateTime, boolean confirmed);
}