package ass09.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import ass09.enums.Category;
import ass09.enums.Language;

public class Movie implements Serializable{
	
	private int movieId;
	private String movieName;
	private Category movieType;
	private Language language;
	private LocalDate releaseDate;
	private List<String> casting;
	private double rating;
	private double totalBusinessDone;
	
	
	public Movie() {
		super();
	}
	

	public Movie(int movieId, String movieName, Category movieType, Language language, LocalDate releaseDate,
			List<String> casting, double rating, double totalBusinessDone) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieType = movieType;
		this.language = language;
		this.releaseDate = releaseDate;
		this.casting = casting;
		this.rating = rating;
		this.totalBusinessDone = totalBusinessDone;
	}


	
	
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieType=" + movieType + ", language="
				+ language + ", releaseDate=" + releaseDate + ", casting=" + casting + ", rating=" + rating
				+ ", totalBusinessDone=" + totalBusinessDone + "]";
	}


	public static Movie convStrToMovie(String str) {
		Object[] objArr = new Object[8];
		String contents[] =  Pattern.compile(",").split(str);
		int movieID = Integer.valueOf(contents[0]);
		
		String movieName = contents[1];
		
		Language language = Language.ENGLISH;
		for(Language lang:Language.values()){
			if(lang.toString() == contents[2]) {
				language = lang;
				break;
			}
		}
		
		Category movieType = Category.ADVENTURE;
		for(Category cat: Category.values()) {
			if(cat.toString() == contents[3]) {
				movieType = cat;
				break;
			}
		}
		
		LocalDate date = LocalDate.parse(contents[4].toString(), DateTimeFormatter.ofPattern("dd/MM/yy"));
		
		List<String> casting = new ArrayList<String>();
		for(String s:contents[5].split(":")) {
			casting.add(s);
		}
		
		double rating = Double.valueOf(contents[6]);
		double totalBusinessDone = Double.valueOf(contents[7]);
		 
		
		return new Movie(movieID,movieName,movieType,language,date,casting,rating,totalBusinessDone);
		
	}
	
	
	
	
	
	
	
	
	
	public int getMovieId() {
		return movieId;
	}


	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


	public String getMovieName() {
		return movieName;
	}


	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public Category getMovieType() {
		return movieType;
	}


	public void setMovieType(Category movieType) {
		this.movieType = movieType;
	}


	public Language getLanguage() {
		return language;
	}


	public void setLanguage(Language language) {
		this.language = language;
	}


	public LocalDate getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}


	public List<String> getCasting() {
		return casting;
	}


	public void setCasting(List<String> casting) {
		this.casting = casting;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public double getTotalBusinessDone() {
		return totalBusinessDone;
	}


	public void setTotalBusinessDone(double totalBusinessDone) {
		this.totalBusinessDone = totalBusinessDone;
	}
	
	
	
	
	
}
