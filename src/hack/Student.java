package hack;

import java.util.List;

public class Student {
	private String name;
	private List<String> subjects;
	private List<String> days;
	
	Student(String name, List<String> subjects, List<String> days){
		this.name = name;
		this.subjects = subjects;
		this.days = days;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	
	public void setDays(List<String> days) {
		this.days = days;
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<String> getSubjects() {
		return this.subjects;
	}
	
	public List<String> getDays() {
		return this.days;
	}

}
