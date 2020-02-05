package org.nasa.nasapicturesofgivendays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PictureController {

	@Autowired
	PictureService pictureService;

	@GetMapping(value = "/pictures")
	public Picture getPictureByDate(@RequestParam("hd") boolean hd, @RequestParam("date") String date) {
		return pictureService.getPicture(hd, date);

	}

}
