package gov.nasa.nasapicturesofgivendays.entities;

public class Picture {

	public Picture(String date, String hdurl, String title, String url) {
		super();
		this.date = date;
		this.hdurl = hdurl;
		this.title = title;
		this.url = url;
	}

	private String copyright;
	private String date;
	private String explanation;
	private String hdurl;
	private String mediaType;
	private String serviceVersion;
	private String title;
	private String url;

	public String getCopyright() {
		return copyright;
	}

	public String getDate() {
		return date;
	}

	public String getExplanation() {
		return explanation;
	}

	public String getHdurl() {
		return hdurl;
	}

	public String getMediaType() {
		return mediaType;
	}

	public String getServiceVersion() {
		return serviceVersion;
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}
}
