package gov.nasa.nasapicturesofgivendays.controllers;

import java.util.Optional;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.nasa.nasapicturesofgivendays.services.PictureService;

@CrossOrigin
@RestController
@Api(value = "Report resource provider")
public class PictureController {

	@Autowired
	PictureService pictureService;

	@ApiOperation(value = "Get NASA image for a given day")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved images"),
			@ApiResponse(code = 400, message = "Bad request. Required parameter is missing.")
	})
	@GetMapping(value = "/images",produces = "application/json")
	public ResponseEntity<Object> getImageByDate(
			@ApiParam(name = "hd", value = "if hd image is in [true,false]", defaultValue = "false")
			@RequestParam(value = "hd", required = false) Boolean hd,
			@ApiParam(name = "date", value = "string date format should be in [02/27/17, 2020-3-29, June 2, 2018, Jul-13-2016]", defaultValue = "")
			@RequestParam(value = "date", required = false) String date) {

		//Attention: Optional type will not work with SwaggerDefinition;
		//swagger will not generate RequestParam if it is Optional- Optional<Boolean>
		return ResponseEntity.status(HttpStatus.OK).body(pictureService.getPicture(Optional.ofNullable(hd),Optional.ofNullable(date)));
	}




}