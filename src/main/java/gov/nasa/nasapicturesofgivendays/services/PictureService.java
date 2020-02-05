package gov.nasa.nasapicturesofgivendays.services;

import gov.nasa.nasapicturesofgivendays.entities.Picture;

public interface PictureService {

	Picture getPicture(boolean hd, String date);

}
