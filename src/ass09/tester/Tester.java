package ass09.tester;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

import ass09.beans.Movie;
import ass09.database.*;
import ass09.utils.Utils;

public class Tester {
	static Scanner sc = new Scanner(System.in);
	
	static List<Movie> movies;

	public static List<Movie> readMovieData(String fileName) throws IOException{
		List<Movie> movies = new ArrayList<Movie>();
		String line;
		FileReader movieFile = new FileReader(fileName);
		BufferedReader br = new BufferedReader(movieFile);
		while((line=br.readLine())!=null) {
			movies.add(Utils.convStrToMovie(line));	
		}
		return movies;
	}
	
	public static List<Movie> getMovieReleasedInYear(int year){
		List<Movie> movieReleasedInyear = new ArrayList<Movie>();
		
		for(Movie movie :movies) {
			if(movie.getReleaseDate().getYear() == year) {
				movieReleasedInyear.add(movie);
			}
		}
		return movieReleasedInyear;
	}
	
	
	public static List<Movie> getMoviesByActor(String actorName){
		List<Movie> movieByActor = new ArrayList<Movie>();
		for(Movie movie:movies) {
				if(movie.getCasting().contains(actorName)) {
					movieByActor.add(movie);
			}
		}
		return movieByActor;
	}
	
	
	
	public static void updateRatings(int movieId, double rating ,List<Movie> movies) throws ClassNotFoundException, SQLException {
			for (Movie movie : movies) 
		 	{
				if(movie.getMovieId() == movieId)
					{
						movie.setRating(rating);
						DatabaseServices.updateMovieRating(movie, rating);
						System.out.println(movie.toString());
					}
		 	}
		}

	public static void updateBusinessDone(int movieId, double businessDone ,List<Movie> movies) throws ClassNotFoundException, SQLException {
			for (Movie movie : movies) 
		 	{
				if(movie.getMovieId() == movieId)
					{
						movie.setTotalBusinessDone(businessDone);
						DatabaseServices.updateMovieBusinessDone(movie, businessDone);
						System.out.println(movie.toString());
					}
		 	}
		}
		
	
	
	public static Set<Movie>businessDoneAboveValue(double amount) {
		Comparator<Movie> AmountComparator = new Comparator<Movie>(){
			
			public int compare(Movie m1,Movie m2) {
				   if(m1.getTotalBusinessDone()>m2.getTotalBusinessDone()) {
					   return -1;
				   }
				   else if(m1.getTotalBusinessDone() < m2.getTotalBusinessDone()){
					   return 1;
				   }
				   else {
					   return 0;
				   }
			}
		};
		Set<Movie> movieSet = new TreeSet<Movie>(AmountComparator);
		for(Movie movie:movies) {
			if(movie.getTotalBusinessDone() > amount) {
				movieSet.add(movie);
			}
		}		

		return movieSet;
		
	}
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		 movies = new ArrayList<Movie>();
		DatabaseServices databaseServices = new DatabaseServices();
	 	movies = readMovieData("Movies.txt");
	 	databaseServices.allMovieInDb(movies);
	 	while(true) {
	 	System.out.println("Movie System");
	 	System.out.println("1 - Getting Entire list of movies");
	 	System.out.println("2 - Getting list of movie in particular year");
	 	System.out.println("3 - Getting list of movie by actor/actoress name");
	 	System.out.println("4 - Updating movie Rating");
	 	System.out.println("5 - Updating Business Done");
	 	System.out.println("6 - Get list of movie in Descending order by given business");
	 	System.out.println("7 - Exit");
	 	int option = sc.nextInt();
	 	
	 	switch (option) {
	 	case 1: {
			System.out.println("Entire list of Movies");
		 	for (Movie movie : movies) 
				System.out.println(movie.toString());
			break;
		}
	 	
		case 2: {
			System.out.println("Enter the year for which u want the list of movies");
		 	for (Movie movie : getMovieReleasedInYear(sc.nextInt())) 
				System.out.println(movie.toString());
			break;
		}
		case 3: {
			System.out.println("Enter the Name for which u want the list of movies");
			sc.nextLine();
		 	for (Movie movie : getMoviesByActor(sc.nextLine())) 
				System.out.println(movie.toString());
			break;
		}
		case 4: {
			System.out.println("Enter the movie id for which you want to update the rating");
			int id = sc.nextInt();
			System.out.println("Enter the new rating which u want to set");
			double rating = sc.nextDouble();
			updateRatings(id,rating,movies);
		 	break;
		}
		case 5: {
			System.out.println("Enter the movie id for which you want to update the business done");
			int id = sc.nextInt();
			System.out.println("Enter the new value for business done ");
			double businessDone = sc.nextDouble();
			updateBusinessDone(id,businessDone,movies);
		 	break;
		}
		 
		case 6: {
			System.out.println("Enter the Business Amount for which you want to get the movies details");
			double amount = sc.nextDouble();
			for (Movie movie : businessDoneAboveValue(amount)) {
				System.out.println(movie.toString());
			}
		 	break;
		}
		case 7:
			System.exit(0);
		default:
			System.out.println("Invalid input :( \nplease try again :)");
		}
	 	
	 	}
		}
	}

