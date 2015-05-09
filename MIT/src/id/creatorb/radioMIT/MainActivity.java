package id.creatorb.radioMIT;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button stopButton = null;
	private Button playButton = null;
	
	//Settings
	Settings settings = new Settings();
	private final String EMAILADD = settings.getEmailAddress();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//Allow hardware audio buttons to control volume
		setVolumeControlStream(AudioManager.STREAM_MUSIC);

		clickListeners(); //Start click listeners

	}

	private void clickListeners(){
//		Play button
		playButton = (Button)findViewById(R.id.PlayButton);
		playButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), 
						ServiceMediaPlayer.class);
				intent.putExtra(ServiceMediaPlayer.START_PLAY, true);
				startService(intent);

			}
		});

		//Stop button
		stopButton = (Button)findViewById(R.id.StopButton);
		stopButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//Get new MediaPlayerService activity
				Intent intent = new Intent(getApplicationContext(),
						ServiceMediaPlayer.class);
				stopService(intent);
			}
		});

		//Email Button click list
		final View EmailPress = (Button)this.findViewById(R.id.emailBtn);
		EmailPress.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view){

				Intent emailIntent = new Intent(Intent.ACTION_SEND);
				emailIntent.setType("message/rfc822");
				emailIntent.putExtra(Intent.EXTRA_EMAIL  , new String[]{EMAILADD});
				//i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
				//i.putExtra(Intent.EXTRA_TEXT   , "body of email");
				try {
					startActivity(Intent.createChooser(emailIntent, "Send email..."));
				} catch (android.content.ActivityNotFoundException ex) {
					Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
				}

			}
		});

		//Website Button
		final View WWWPress = (Button)this.findViewById(R.id.websiteBtn);
		WWWPress.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view){

				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(settings.getWebsiteURL())); //URL
				startActivity (browserIntent);

			}
		});

		//SMS Button
		final View TxtPress = (Button)this.findViewById(R.id.txtBtn);
		TxtPress.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view){

				Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" +settings.getSmsNumber()));
				startActivity(smsIntent);

			}
		});
	}

}


