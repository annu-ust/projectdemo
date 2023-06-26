package ReservationTable.reservationtable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class ReservationtableApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationtableApplication.class, args);
	}

}
