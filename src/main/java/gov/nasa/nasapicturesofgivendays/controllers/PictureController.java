package gov.nasa.nasapicturesofgivendays.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.nasa.nasapicturesofgivendays.entities.Picture;
import gov.nasa.nasapicturesofgivendays.services.PictureService;

@RestController
public class PictureController {

	@Autowired
	PictureService pictureService;

	@GetMapping(value = "/pictures")
	public Picture getPictureByDate(@RequestParam("hd") boolean hd, @RequestParam("date") String date) {
		return pictureService.getPicture(hd, date);

	}

}