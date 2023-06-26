package ReservationTable.reservationtable.model;

import java.time.LocalDateTime;

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
	    private String phoneNumber;
	    private LocalDateTime dateTime;
	    private int numberOfPeople;
	    private boolean confirmed;

	    // Constructors, getters, and setters
	    public Reservation() {
			// TODO Auto-generated constructor stub
		}

		public Reservation(Long id, String name, String email, String phoneNumber, LocalDateTime dateTime,
				int numberOfPeople, boolean confirmed) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.dateTime = dateTime;
			this.numberOfPeople = numberOfPeople;
			this.confirmed = confirmed;
		}

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

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public LocalDateTime getDateTime() {
			return dateTime;
		}

		public void setDateTime(LocalDateTime dateTime) {
			this.dateTime = dateTime;
		}

		public int getNumberOfPeople() {
			return numberOfPeople;
		}

		public void setNumberOfPeople(int numberOfPeople) {
			this.numberOfPeople = numberOfPeople;
		}

		public boolean isConfirmed() {
			return confirmed;
		}

		public void setConfirmed(boolean confirmed) {
			this.confirmed = confirmed;
		}
		
	    
	    
}