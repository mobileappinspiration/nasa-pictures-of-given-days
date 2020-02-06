package gov.nasa.nasapicturesofgivendays.controllers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import gov.nasa.nasapicturesofgivendays.entities.Picture;
import gov.nasa.nasapicturesofgivendays.services.PictureService;
import gov.nasa.nasapicturesofgivendays.utilities.Helper;

@RunWith(SpringRunner.class)
@WebMvcTest(PictureController.class)
public class PictureControllerUnitTest {

	@MockBean
	private PictureService pictureService;

	@Autowired
	private MockMvc mvc;

	@Test
	public void whenGetPicturesWithOnlyApiKey_ThenReturnPictureAndItsInfo200OK() throws Exception {

		Picture expectedResult = new Picture(Helper.getCurrentDateAsString(), "this picture's explanation",
				"Lunar Eclipse Perspectives", "test url");
		;

		Optional<Boolean> hd = Optional.of(true);
		Optional<String> date = Optional.of(expectedResult.getDate());
		given(pictureService.getPicture(hd, date)).willReturn(expectedResult);

		mvc.perform(MockMvcRequestBuilders.get("/pictures").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
