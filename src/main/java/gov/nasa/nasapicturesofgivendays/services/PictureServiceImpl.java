package gov.nasa.nasapicturesofgivendays.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import gov.nasa.nasapicturesofgivendays.configurations.AppConfiguration;
import gov.nasa.nasapicturesofgivendays.entities.Picture;

@Service
@CacheConfig(cacheNames = { "picture" })
public class PictureServiceImpl implements PictureService {

	@Autowired
	private AppConfiguration appConfig;

	@Autowired
	private RestTemplate restTemplate;

	public PictureServiceImpl(AppConfiguration appConfig, RestTemplate restTemplate) {
		super();
		this.appConfig = appConfig;
		this.restTemplate = restTemplate;

	}

	private static final Logger log = LoggerFactory.getLogger(PictureService.class);

	@Cacheable(unless = "#result == null")
	@Override
	public Picture getPicture(Optional<Boolean> hd, Optional<String> date) {

		log.info("Trying to get picture info from Nasa's API for date {} ", date);
		// call Nasa's API to get picture of the day
		try {

			String hdQueryString = hd.isPresent() ? "&hd=" + hd.get() : "";
			String dateQueryString = date.isPresent() ? "&date=" + date.get() : "";
			String uri = appConfig.getServerUrl() + "?api_key=" + appConfig.getApiKey() + hdQueryString
					+ dateQueryString;

			return restTemplate.getForEntity(uri, Picture.class).getBody();

		} catch (Exception ex) {

			log.error(ex.getMessage());
			throw ex;

		}
	}

}
