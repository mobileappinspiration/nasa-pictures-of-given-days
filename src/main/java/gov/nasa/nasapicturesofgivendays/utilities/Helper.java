package gov.nasa.nasapicturesofgivendays.utilities;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class Helper {

	private Helper() {
	}

	public static String getCurrentDateAsString() {

		return LocalDate.now().toString();
	}

}
