package gov.nasa.nasapicturesofgivendays.utilities;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class HelperTest {

	@Test
	public void getCurrentDateAsStringTest() {

		String expectedDate = LocalDate.now().toString();
		assertEquals(expectedDate, Helper.getCurrentDateAsString());
	}

}
