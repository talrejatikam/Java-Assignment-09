package ass09.tester;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

import ass09.beans.Movie;
import ass09.database.*;
import ass09.utils.Utils;

public class Tester {
	
	
	List<Movie> movies;

	public static List<Movie> readMovieData(String fileName) throws IOException{
		List<Movie> movies = new ArrayList<Movie>();
		String line;
		FileReader movieFile = new FileReader(fileName);
		BufferedReader br = new BufferedReader(movieFile);
		while((line=br.readLine())!=null) {
			String[] enteries = line.split(",");
			movies.add(Utils.convStrToMovie(line));
			
		}
		
		
		return movies;
	}
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		List<Movie> movies = new ArrayList<Movie>();
		DatabaseServices databaseServices = new DatabaseServices();
	 	movies = readMovieData("Movies.txt");
	 	
	 	for (Movie movie : movies) {
			System.out.println(movie.toString());
		}
databaseServices.allMovieInDb(movies);
//		System.out.println("all set");
	}
}
