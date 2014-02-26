package handlers;

public class ShowFile {
	private String name;
	private String location;
	
	public ShowFile(String name, String location){
		this.name = name;
		this.location = location;
	}
	
	public String getLocation(){
		return location;
	}

	public String toString() {
		return name;
	}
}
