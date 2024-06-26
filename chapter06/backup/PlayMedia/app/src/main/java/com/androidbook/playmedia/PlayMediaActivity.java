package com.androidbook.playmedia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PlayMediaActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.initView();
    }
    
    private void initView(){
    	Button playButton = ( Button )super.findViewById( R.id.play );
    	Button stopButton = ( Button )super.findViewById( R.id.stop );
    	playButton.setOnClickListener( clickListener );
    	stopButton.setOnClickListener( clickListener );
    }
    
    private OnClickListener clickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch ( v.getId() ) {
			case R.id.play:
//				startService( new Intent( "com.androidbook.playmedia.Music" ) );
				Intent intent = new Intent();
				intent.setAction("com.androidbook.playmedia.Music");
				//不加这句话的话 android 5.0以上会报：Service Intent must be explitict 2018.12.10
				intent.setPackage("com.androidbook.playmedia");
				startService(intent);
				break;

			case R.id.stop:
				stopService( new Intent( "com.androidbook.playmedia.Music" ) );
				break;
				
			default:
				break;
			}
			
		}
	};
}