package gov.nasa.nasapicturesofgivendays.exceptions;

import lombok.Data;

@Data
public class WebRestException extends RuntimeException {

	private String code;
	private String message;
	private String service_version;
}
