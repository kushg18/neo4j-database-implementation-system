package dbsi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.unsafe.batchinsert.BatchInserter;
import org.neo4j.unsafe.batchinsert.BatchInserters;

public class Main {
	static BatchInserter batch;
	private static GraphDatabaseService dbsiIMDB = new GraphDatabaseFactory().newEmbeddedDatabase(new File("/Users/kushalgevaria/Documents/Neo4j/dbsiIMDB"));
	Label movieLabel = Label.label("Movie"); // label of movie
	Label actorLabel = Label.label("Actor"); // label of actor
	Label directorLabel = Label.label("Director"); // label of director
	Label genreLabel = Label.label("Genre"); // label of genre

	public GraphDatabaseService getDbsiIMDB() {
		return dbsiIMDB;
	}
	
	/**
	* Create Database
	*/
	public void createDatabase(){
		try {
			System.out.println("Connecting Neo4j---------->");
			// Please change this according to your computer configurations
			batch = BatchInserters.inserter(new File("/Users/kushalgevaria/Documents/Neo4j/dbsiIMDB"));
			batch.shutdown();
			System.out.println("Disconnected Neo4j<---------");
		} catch (IOException e) {
			batch.shutdown();
			e.printStackTrace();
		}

	}
	
	/**
	* Create movie node
	*/
	public void createMovie(String m, String d, String a, String g){
		System.out.println("Creating Movie Object -->");
		String movieName = m;
		String directorName = d;
		String actorName = a;
		String genreName = g;
		
		try (Transaction tx = getDbsiIMDB().beginTx()) {

			Node dNode = getDbsiIMDB().findNode(directorLabel, "name", directorName);
			if(dNode == null){
				Director director = new Director(directorName);
				dNode = getDbsiIMDB().createNode();
				dNode.addLabel(directorLabel);
				dNode.setProperty("name", director.getDirector());
				System.out.println("Created New Director: "+ (String) dNode.getProperty("name"));
			}else{
				System.out.println("Director Already Exists: " + (String)dNode.getProperty("name"));
			}
			
			Node mNode = getDbsiIMDB().findNode(movieLabel, "name", movieName);
			if(mNode == null){
				Movie movie = new Movie(movieName);
				mNode = getDbsiIMDB().createNode();
				mNode.addLabel(movieLabel);
				mNode.setProperty("name", movie.getMovie());
				System.out.println("Created New Movie: "+ (String) mNode.getProperty("name"));
			}else{
				System.out.println("Movie Already Exists: " + (String)mNode.getProperty("name"));
			}
			
			Node aNode = getDbsiIMDB().findNode(actorLabel, "name", actorName);
			if(aNode == null){
				Actor actor = new Actor(actorName);
				aNode = getDbsiIMDB().createNode();
				aNode.addLabel(actorLabel);
				aNode.setProperty("name", actor.getActor());
				System.out.println("Created New Actor: "+ (String) aNode.getProperty("name"));
			}else{
				System.out.println("Actor Already Exists: " + (String)aNode.getProperty("name"));
			}
			
			Node gNode = getDbsiIMDB().findNode(genreLabel, "name", genreName);
			if(gNode == null){
				Genre genre = new Genre(genreName);
				gNode = getDbsiIMDB().createNode();
				gNode.addLabel(genreLabel);
				gNode.setProperty("name", genre.getGenre());
				System.out.println("Created New Genre: "+ (String) gNode.getProperty("name"));
			}else{
				System.out.println("Genre Already Exists: " + (String)gNode.getProperty("name"));
			}
			tx.success();
			
			// Creating all Relationships
//			batch = BatchInserters.inserter(new File("/Users/kushalgevaria/Documents/Neo4j/dbsiIMDB"));
			System.out.println("Creating relationships for movie, actor, director, genre -->");	
			boolean dMovieRelationshipExist = false;
			for(Relationship r : dNode.getRelationships()) {
				Node tempMovie = r.getEndNode();
				System.out.println(tempMovie.getProperty("name")+ " " + movieName);
				if (tempMovie.getProperty("name").equals(movieName)){
					dMovieRelationshipExist = true;
					System.out.println("Relationship Exist Between movie and director");
					break;
				}
			}
			if(!dMovieRelationshipExist){
				RelationshipType directorMovieConnection = RelationshipType.withName("directed");
				dNode.createRelationshipTo(mNode, directorMovieConnection);
//				batch.createRelationship(dNode.getId(), mNode.getId(), directorMovieConnection, null);
				
			}
			
			boolean aMovieRelationshipExist = false;
			for(Relationship r : aNode.getRelationships()) {
				Node tempMovie = r.getEndNode();
				if (tempMovie.getProperty("name").equals(movieName)){
					aMovieRelationshipExist = true;
					System.out.println("Relationship Exist Between movie and actor");
					break;
				}
			}
			if(!aMovieRelationshipExist){
				RelationshipType actorMovieConnection = RelationshipType.withName("actedIn");
				aNode.createRelationshipTo(mNode, actorMovieConnection);
//				batch.createRelationship(aNode.getId(), mNode.getId(), actorMovieConnection, null);
			}
			
			boolean gMovieRelationshipExist = false;
			for(Relationship r : gNode.getRelationships()) {
				Node tempMovie = r.getEndNode();
				if (tempMovie.getProperty("name").equals(movieName)){
					gMovieRelationshipExist = true;
					System.out.println("Relationship Exist Between movie and genre");
					break;
				}
			}
			if(!gMovieRelationshipExist){
				RelationshipType genreMovieConnection = RelationshipType.withName("isGenreOf");
				gNode.createRelationshipTo(mNode, genreMovieConnection);
//				batch.createRelationship(gNode.getId(), mNode.getId(), genreMovieConnection, null);
			}
			System.out.println("<-- Created relationships for movie, actor, director, genre");
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("<-- Disconnected Neo4j");
		}
	}
	
	/**
	* Update movie node
	*/
	public String updateMovie(String oldName, String newName){
		String result = "";
		try (Transaction tx = getDbsiIMDB().beginTx()) {
			Node mNode = getDbsiIMDB().findNode(movieLabel, "name", oldName);
			if(mNode == null){
				result = "Movie Does Not Exist: "+ oldName; 
			}else{
				mNode.setProperty("name", newName);
				result = "Movie Updated: " + (String)mNode.getProperty("name");
			}			
			tx.success();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return result;
	}
	
	/**
	* Update genre node
	*/
	public String updateGenre(String oldName, String newName){
		String result = "";
		try (Transaction tx = getDbsiIMDB().beginTx()) {
			Node gNode = getDbsiIMDB().findNode(genreLabel, "name", oldName);
			if(gNode == null){
				result = "Genre Does Not Exist: "+ oldName;
			}else{
				gNode.setProperty("name", newName);
				result = "Genre Updated: " + (String)gNode.getProperty("name");
			}
			tx.success();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return result;
	}

	/**
	* Update actor node
	*/
	public String updateActor(String oldName, String newName){
		String result = "";
		try (Transaction tx = getDbsiIMDB().beginTx()) {
			Node aNode = getDbsiIMDB().findNode(actorLabel, "name", oldName);
			if(aNode == null){
				result = "Actor Does Not Exist: "+ oldName;
			}else{
				aNode.setProperty("name", newName);
				result = "Actor Updated: " + (String)aNode.getProperty("name");
			}
			tx.success();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return result;
	}

	/**
	* Update director node
	*/
	public String updateDirector(String oldName, String newName){
		String result = "";
		try (Transaction tx = getDbsiIMDB().beginTx()) {
			Node dNode = getDbsiIMDB().findNode(directorLabel, "name", oldName);
			if(dNode == null){
				result = "Director Does Not Exist: "+ oldName;
			}else{
				dNode.setProperty("name", newName);
				result = "Director Updated: " + (String)dNode.getProperty("name");
			}
			tx.success();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return result;
	}
	
	/**
	* Delete movie node
	*/
	public String deleteMovie(String name){
		String result = "";
		try (Transaction tx = getDbsiIMDB().beginTx()) {
			Node mNode = getDbsiIMDB().findNode(movieLabel, "name", name);
			if(mNode == null){
				result = "Movie Does Not Exist: "+ name;
			}else{
				for(Relationship r : mNode.getRelationships()) {
					r.delete();
				}
				mNode.delete();
				result = "Successfully deleted movie with it's relationships: "+ name;
			}
			tx.success();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return result;
	}
	
	/**
	* Delete genre node
	*/
	public String deleteGenre(String name){
		String result = "";
		try (Transaction tx = getDbsiIMDB().beginTx()) {
			Node gNode = getDbsiIMDB().findNode(genreLabel, "name", name);
			if(gNode == null){
				result = "Genre Does Not Exist: "+ name;
			}else{
				for(Relationship r : gNode.getRelationships()) {
					r.delete();
				}
				gNode.delete();
				result = "Successfully deleted genre with it's relationships: "+ name;
			}
			tx.success();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return result;
	}
	
	/**
	* Delete actor node
	*/
	public String deleteActor(String name){
		String result = "";
		try (Transaction tx = getDbsiIMDB().beginTx()) {
			Node aNode = getDbsiIMDB().findNode(actorLabel, "name", name);
			if(aNode == null){
				result = "Actor Does Not Exist: "+ name;
			}else{
				for(Relationship r : aNode.getRelationships()) {
					r.delete();
				}
				aNode.delete();
				result = "Successfully deleted actor with it's relationships: "+ name;
			}
			tx.success();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return result;
	}

	/**
	* Delete director node
	*/
	public String deleteDirector(String name){
		String result = "";
		try (Transaction tx = getDbsiIMDB().beginTx()) {
			Node dNode = getDbsiIMDB().findNode(directorLabel, "name", name);
			if(dNode == null){
				result = "Director Does Not Exist: "+ name;
			}else{
				for(Relationship r : dNode.getRelationships()) {
					r.delete();
				}
				dNode.delete();
				result = "Successfully deleted director with it's relationships: "+ name;
			}
			tx.success();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return result;
	}
	
	/**
	* Search movie by director
	*/
	public ArrayList<String> searchMoviebyDirector(String name){
		ArrayList<String> moviesByDirector = new ArrayList<String>(); 
		try (Transaction tx = getDbsiIMDB().beginTx()) {
			Node dNode = getDbsiIMDB().findNode(directorLabel, "name", name);
			if(dNode == null){
				return moviesByDirector;
			}else{
				for (Relationship r : dNode.getRelationships()) {
					Node tempMovie = r.getEndNode();
					moviesByDirector.add((String)tempMovie.getProperty("name"));
				}
				tx.success();
				System.out.println(moviesByDirector);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return moviesByDirector; 
	}
	
	/**
	* Search movie by actor
	*/
	public ArrayList<String> searchMoviebyActor(String name){
		ArrayList<String> moviesByActor = new ArrayList<String>(); 
		try (Transaction tx = getDbsiIMDB().beginTx()) {
			Node aNode = getDbsiIMDB().findNode(actorLabel, "name", name);
			if(aNode == null){
				return moviesByActor;
			}else{
				for (Relationship r : aNode.getRelationships()) {
					Node tempMovie = r.getEndNode();
					moviesByActor.add((String)tempMovie.getProperty("name"));
				}
				tx.success();
				System.out.println(moviesByActor);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}	
		return moviesByActor;
	}
	
	/**
	* Search movie by genre
	*/
	public ArrayList<String> searchMoviebyGenre(String name){
		ArrayList<String> moviesByGenre = new ArrayList<String>(); 
		try (Transaction tx = getDbsiIMDB().beginTx()) {
			Node gNode = getDbsiIMDB().findNode(genreLabel, "name", name);
			if(gNode == null){
				return moviesByGenre;
			}else{
				for (Relationship r : gNode.getRelationships()) {
					Node tempMovie = r.getEndNode();
					moviesByGenre.add((String)tempMovie.getProperty("name"));
				}
				tx.success();
				System.out.println(moviesByGenre);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}	
		return moviesByGenre;
	}
	
	/**
	 * This is the main method of this program which starts the neo4j connection
	 * and calls the method to start inserting imdb data and nodes for movies, actors, genres 
	 * and directors and relationships between them.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		Main mainObj = new Main();
		mainObj.createDatabase(); // initial step to create a database
		mainObj.createMovie("The Reader", "Stephen Daldry", "Kate Winslet", "Drama");
		mainObj.searchMoviebyDirector("Stephen Daldry");
		
		
		mainObj.updateGenre("Drama", "Action");
		mainObj.updateActor("Zoe Saldana", "Zoe");
		mainObj.updateDirector("Zoe", "Zoe");
		mainObj.updateMovie("Avator", "Avatar");
		
		mainObj.deleteGenre("Action");
		mainObj.deleteActor("Zoe");
		mainObj.deleteDirector("Christopher Nolan");
		mainObj.deleteMovie("Avatar");
		
		mainObj.searchMoviebyDirector("James Cameron");
		mainObj.searchMoviebyActor("Kate Winslet");
		mainObj.searchMoviebyGenre("Drama");
	}
}
