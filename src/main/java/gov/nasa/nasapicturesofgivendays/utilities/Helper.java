package gov.nasa.nasapicturesofgivendays.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.nasa.nasapicturesofgivendays.configurations.AppConfiguration;

@Service
public class Helper {

	@Autowired
	AppConfiguration appConfig;

	private Helper() {
	}

	public static String getCurrentDateAsString() {
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat();
		return dateFormat.format(date);
	}

}
