
public class Time {
	
	private int hour;
	private int minute;
	private String meridiem ;
	
	public Time(int hour, int minute, String meridiem) {
		this.hour = hour;
		this.minute = minute;
		this.meridiem = meridiem;
	}
	
	public int getHour(){
		return hour;
	}
	
	public int getMinute(){
		return minute;
	}
	
	public String getMeridiem(){
		return meridiem;
	}
	
	public void setHour(int hour){ 
        this.hour = hour;
    }
	
	public void setMinute(int minute){ 
        this.minute = minute;
    }
	
	public void setMeridiem(String meridiem){ 
        this.meridiem = meridiem;
    }
	
}
