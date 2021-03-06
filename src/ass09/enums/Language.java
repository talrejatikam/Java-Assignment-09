package ass09.enums;

public enum Language {
	ENGLISH("English"),
	HINDI("Hindi"),
	MALAYALAM("Malayalam"),
	TELUGU("Telugu"),
	PUNJABI("Punjabi");
	
	
	private String language;
	Language(String language){
		this.language = language;
	}
	
	public String value() {
		return this.language;
	}
}
