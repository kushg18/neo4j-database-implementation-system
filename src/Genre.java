package dbsi;

public class Genre {
	private static long uniqueCount = 30000000;
	private long genreid;
	private String genre; 
	Genre(String genre){
		this.setGenreid(uniqueCount);
		this.setGenre(genre);
		uniqueCount += 1;
	}
	public long getGenreid() {
		return genreid;
	}
	public void setGenreid(long genreid) {
		this.genreid = genreid;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
}
