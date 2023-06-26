package ReservationTable.reservationtable.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String datetime;
    private int guests;
    private String specialRequests;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public int getGuests() {
		return guests;
	}
	public void setGuests(int guests) {
		this.guests = guests;
	}
	public String getSpecialRequests() {
		return specialRequests;
	}
	public void setSpecialRequests(String specialRequests) {
		this.specialRequests = specialRequests;
	}
	public Reservation(Long id, String name, String email, String datetime, int guests, String specialRequests) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.datetime = datetime;
		this.guests = guests;
		this.specialRequests = specialRequests;
	}

    // Constructors, getters, and setters
    public Reservation() {
		// TODO Auto-generated constructor stub
	}
}