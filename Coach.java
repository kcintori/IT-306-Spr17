package project_part_5;

public class Coach {
	private String coachName;
	private String coachEmail;
	private String coachPhone;
	private String password;
	
	//Constructors
	public Coach(){}
	public Coach(String name){
		coachName = name;
	}
	
	//Accessors
	public String getCoachName() {return coachName;}
	public String getCoachEmail() {return coachEmail;}
	public String getCoachPhone() {return coachPhone;}
	
	//Mutators
	public void setCoachName(String name) {
		if(name.length() > 0)
			coachName = name;
	}
	
	public void setCoachEmail(String email) {
		if(email.length() > 0)
			coachEmail = email;
	}
	
	public void setCoachPhone(String phone) {
		if(phone.length() > 0)
			coachPhone = phone;
	}
	
	//Special Methods
	public void setPassword(String pass) {
		if(pass.length() > 6)
			password = pass;
	}
	
	public String toString() {
		String output = "";
		
		output += "Coach Name: " + coachName + "\n";
		output += "Phone: " + coachPhone + "\n";
		output += "Email: " + coachEmail;
		
		return output;
	}
}
