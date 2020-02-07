package gov.nasa.nasapicturesofgivendays.configurations;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
@Getter
@Configuration
public class AppConfiguration {

	@Value("${app.apiKey}")
	private String apiKey;

	@Value("${app.nasa.server.url}")
	private String serverUrl;

	@Value("${app.dateTime.format}")
	private String dateTimeFormat;

}
