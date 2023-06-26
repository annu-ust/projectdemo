package ReservationTable.reservationtable.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ReservationTable.reservationtable.model.Reservation;

public interface ReservationRepo extends JpaRepository<Reservation, Long> {

}
