package ass09.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import ass09.beans.Movie;
import ass09.enums.Category;
import ass09.enums.Language;

public class Utils {
	public static Movie convStrToMovie(String str) {
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
	
	
	
	
	
	
}
