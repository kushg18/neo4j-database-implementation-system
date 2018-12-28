package dbsi;

public class Actor {
	private static long uniqueCount = 10000000;
	private long actorid;
	private String actor;
	Actor(String actor){
		this.setActorid(uniqueCount);
		this.setActor(actor);
		uniqueCount += 1;
	}
	public long getActorid() {
		return actorid;
	}
	public void setActorid(long actorid) {
		this.actorid = actorid;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
}
