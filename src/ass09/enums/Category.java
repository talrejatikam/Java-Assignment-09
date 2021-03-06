package ass09.enums;

public enum Category {
	ADVENTURE("Adventure"),
	HORROR("Horror"),
	SCIFI("Scifi"),
	EMOTIONAL("Emotional");
	
	String categoryType;
	Category(String categoryType){
		this.categoryType = categoryType;
	}
	
	public String value() {
		return this.categoryType;
	}

}
