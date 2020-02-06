package gov.nasa.nasapicturesofgivendays.services;

import java.util.Optional;

import gov.nasa.nasapicturesofgivendays.entities.Picture;

public interface PictureService {

	Picture getPicture(Optional<Boolean> hd, Optional<String> date);

}
