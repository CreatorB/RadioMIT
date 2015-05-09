/**
 * Settings for app including URLS and other features. 
 */

package id.creatorb.radioMIT;

public class Settings {
	/********ALL EDITABLE SETTINGS ARE HERE *****/

	//Name of radio station
	private String radioName = "MIT Live Streaming";

	//URL of the radio stream
	private String radioStreamURL = "http://103.29.215.141:8383";
	
	//Contact button email address
	private String emailAddress = "info@mit.or.id";
	
	//Contact button phone number
//	private String phoneNumber = "087890001233";

	//Contact button website URL
	private String websiteURL = "http://mit.or.id";
	
	//Contact button SMS number
	private String smsNumber = "087890001233";
	
	//Message to be shown in notification center whilst playing
	private String mainNotificationMessage = "Listening MIT";

	//TOAST notification when play button is pressed
	private String playNotificationMessage = "Connect to MIT channel, please wait...";
	
	//Enable console output for streaming info (Buffering etc) - Disable = false
	private boolean allowConsole = true;
	//end setting
	
	public String getRadioName(){
		return radioName;
	}
	
	public String getRadioStreamURL(){
		return radioStreamURL;
	}

	public String getEmailAddress(){
		return emailAddress;
	}
	
	public String getWebsiteURL(){
		return websiteURL;
	}
	
	public String getSmsNumber(){
		return smsNumber;
	}
	
	public String getMainNotificationMessage(){
		return mainNotificationMessage;
	}
	
	public String getPlayNotificationMessage(){
		return playNotificationMessage;
	}

	public boolean getAllowConsole(){
		return allowConsole;
	}
}



