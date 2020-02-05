package gov.nasa.nasapicturesofgivendays.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

	public String getApiKey() {
		return apiKey;
	}

	@Value("${app.apiKey}")
	private String apiKey;

}
