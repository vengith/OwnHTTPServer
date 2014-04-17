package givenpackage;

public enum ContentType {
	TEXT("text/plain"), HTML("text/html"), 
	MP4("video/mp4"), MP3("audio/mpeg"), 
	JPEG("image/jpeg"), PNG("image/png"), GIF("image/gif");

	private final String contentString;

	private ContentType(String string) {
		contentString = string;
	}
	
	public String getContentString() {
		return contentString;
	}

}
