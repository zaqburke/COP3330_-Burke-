package p4;

public class TaskItem {
	 private String name;
	 private String duedate;
	 private String description;
	 private boolean isCompleted = false;
	 public TaskItem(String userName, String userDueDate, String userDescription, boolean completion) {
	        this.name = userName;
	        this.duedate = userDueDate;
	        this.description = userDescription;
	        this.isCompleted = completion;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getName() {
	        return name;
	    }
	    public void setDueDate(String dueDate) {
	        this.duedate = dueDate;
	    }
	    public String getDueDate() {
	        return duedate;
	    }
	    public void setDescription(String description) {
	        this.description = description;
	    }
	    public String getDescription() {
	        return description;
	    }
	    public boolean isCompleted() {
	        return isCompleted;
	    }
	    public void unsetCompleted(){
	        this.isCompleted = false;
	    }
	    public void setCompleted() {
	        this.isCompleted = true;
	    }
	    public String toString() {
	        return "[" + duedate + "] " + name + ": " + description;
	    }
	    public String toStringFile() {
	        return name + "\n" + description + "\n" + "" + duedate + "\n" + isCompleted;
}
}
	   

	    

	   

	    


	
