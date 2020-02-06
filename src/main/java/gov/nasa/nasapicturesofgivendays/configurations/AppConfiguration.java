package gov.nasa.nasapicturesofgivendays.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

	public String getServerUrl() {
		return serverUrl;
	}

	public String getApiKey() {
		return apiKey;
	}

	@Value("${app.apiKey}")
	private String apiKey;

	@Value("${app.nasa.server.url}")
	private String serverUrl;

	@Value("${app.dateTime.format}")
	private String dateTimeFormat;

	public String getDateTimeFormat() {
		return dateTimeFormat;
	}
}
