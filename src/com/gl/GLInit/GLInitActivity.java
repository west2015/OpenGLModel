package com.gl.GLInit;

import android.app.Activity;
import android.os.Bundle;

public class GLInitActivity extends Activity{
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		MySurfaceView mySurfaceView = new MySurfaceView(this);
		setContentView(mySurfaceView);
	}
}
