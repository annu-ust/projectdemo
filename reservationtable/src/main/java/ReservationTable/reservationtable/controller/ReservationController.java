package ReservationTable.reservationtable.controller;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ReservationTable.reservationtable.model.Reservation;
import ReservationTable.reservationtable.repository.ReservationRepo;
@Controller
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationRepo reservationRepository;

    @Autowired
    public ReservationController(ReservationRepo reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

//    @GetMapping(value="/form")
//    public String showReservationForm(Model model) {
//        model.addAttribute("reservation", new Reservation());
//        return "reservation-form";
//    }
    @GetMapping(value="/forms")
    public ResponseEntity<?>fetchall(){
    	return ResponseEntity.ok().body(reservationRepository.findAll());
    	}
//    @PostMapping(value="/submit")
//    public String submitReservationForm(@RequestBody Reservation reservation, RedirectAttributes redirectAttributes) {
//        reservationRepository.save(reservation);
//        redirectAttributes.addFlashAttribute("successMessage", "Reservation made successfully!");
//        return "redirect:/reservation/form";
//    }
    @PostMapping("/submit")
    public ResponseEntity<?> createProduct(@RequestBody Reservation reservation){
    	return ResponseEntity.status(HttpStatus.SC_CREATED).body(reservationRepository.save(reservation));}
}
