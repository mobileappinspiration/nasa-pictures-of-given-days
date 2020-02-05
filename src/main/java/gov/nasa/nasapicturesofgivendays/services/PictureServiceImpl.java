package gov.nasa.nasapicturesofgivendays.services;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import gov.nasa.nasapicturesofgivendays.configurations.AppConfiguration;
import gov.nasa.nasapicturesofgivendays.entities.Picture;

@Service
@CacheConfig(cacheNames = { "picture" })
public class PictureServiceImpl implements PictureService {

	@Autowired
	AppConfiguration appConfig;

	@Autowired
	RestTemplate restTemplate;

	private static final Logger LOG = LoggerFactory.getLogger(PictureService.class);

	@Cacheable(unless = "#result == null")
	@Override
	public Picture getPicture(boolean hd, String date) {
		LOG.info("Trying to get picture info from Nasa for date {} ", date);
		return getPictureInfoFromNasa(appConfig.getApiKey(), hd, date);
	}

	private Picture getPictureInfoFromNasa(String apiKey, boolean hd, String date) {
		// call Nasa's API to get picture
		try {

			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<Picture> entity = new HttpEntity<>(headers);

			String uri = appConfig.getServerUrl() + "?api_key=" + apiKey + "&hd=" + hd + "&date=" + date;
			return restTemplate.exchange(uri, HttpMethod.GET, entity, Picture.class).getBody();

		} catch (Exception ex) {

			LOG.error(ex.getMessage());
			throw ex;

		}

	}

}
