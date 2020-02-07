package gov.nasa.nasapicturesofgivendays.entities;

import lombok.Data;

@Data
public class Picture {

	private String copyright;
	private String date;
	private String explanation;
	private String hdurl;
	private String media_type;
	private String service_version;
	private String title;
	private String url;

	public Picture(String date, String explanation, String title, String url) {

		super();
		this.date = date;
		this.explanation = explanation;
		this.title = title;
		this.url = url;
	}

	public Picture() {
		super();
	}

}
