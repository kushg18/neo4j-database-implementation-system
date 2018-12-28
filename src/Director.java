package dbsi;

public class Director {
	private static long uniqueCount = 20000000;
	private long directorid;
	private String director;
	Director(String director){
		this.setDirectorid(uniqueCount);
		this.setDirector(director);
		uniqueCount += 1; 
	}
	public long getDirectorid() {
		return directorid;
	}
	public void setDirectorid(long directorid) {
		this.directorid = directorid;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
}
