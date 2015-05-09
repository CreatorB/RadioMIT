package id.creatorb.radioMIT;

import android.content.Context;
import android.content.Intent;

public class Receiver extends android.content.BroadcastReceiver {
		   
	public void onReceive(Context ctx, Intent intent) {
		if (intent.getAction().equals(
				android.media.AudioManager.ACTION_AUDIO_BECOMING_NOISY)) {
			Intent myIntent = new Intent(ctx, ServiceMediaPlayer.class);
			ctx.stopService(myIntent);
		}
	}
}
