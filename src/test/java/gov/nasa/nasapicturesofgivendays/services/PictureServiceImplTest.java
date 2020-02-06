package gov.nasa.nasapicturesofgivendays.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import gov.nasa.nasapicturesofgivendays.configurations.AppConfiguration;

@RunWith(MockitoJUnitRunner.class)
public class PictureServiceImplTest {

	@Mock
	private RestTemplate restTemplate;
	@Mock
	private AppConfiguration appConfig;

	@Mock
	private ResponseEntity<Object> reponseEntity;

	PictureService pictureService;

	@Before
	public void setUp() {

		pictureService = new PictureServiceImpl(appConfig, restTemplate);

		when(appConfig.getServerUrl()).thenReturn("testUrl");
		when(reponseEntity.getBody()).thenReturn(null);

	}

	@Test
	public void whenGetPictureThenRestTemplateWasCompletedSuccessfully() {

		when(restTemplate.getForEntity(anyString(), any())).thenReturn(reponseEntity);

		pictureService.getPicture(Optional.of(true), Optional.of("2020-2-6"));

		// then
		verify(appConfig, times(1)).getServerUrl();
		verify(restTemplate, times(1)).getForEntity(anyString(), any());
		verify(reponseEntity, times(1)).getBody();

	}

	@Test(expected = NullPointerException.class)
	public void whenGetPictureAndRestTemplateThrowException() {

		// when
		when(restTemplate.getForEntity(anyString(), any())).thenThrow(NullPointerException.class);
		pictureService.getPicture(Optional.of(false), Optional.of("2020-2-6"));

	}

}
