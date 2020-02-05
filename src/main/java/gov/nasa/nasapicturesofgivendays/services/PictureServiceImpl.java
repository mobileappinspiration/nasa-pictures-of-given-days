package gov.nasa.nasapicturesofgivendays.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import gov.nasa.nasapicturesofgivendays.configurations.AppConfiguration;
import gov.nasa.nasapicturesofgivendays.entities.Picture;

@Service
@CacheConfig(cacheNames = { "picture" })
public class PictureServiceImpl implements PictureService {

	@Autowired
	AppConfiguration appConfig;
	private static final Logger LOG = LoggerFactory.getLogger(PictureService.class);

	@Cacheable
	@Override
	public Picture getPicture(boolean hd, String date) {
		LOG.info("Trying to get picture info from Nasa for date {} ", date);
		return getPictureInfoFromNasa(appConfig.getApiKey(), hd, date);
	}

	private Picture getPictureInfoFromNasa(String apiKey, boolean hd, String date) {
		// call Nasa's API to get picture here

		Picture picture = new Picture("1", "2", "3", "4");
		return picture;
	}

}
