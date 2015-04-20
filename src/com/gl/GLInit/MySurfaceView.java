package com.gl.GLInit;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

public class MySurfaceView extends GLSurfaceView{

	private final float TOUCH_SCALE_FACOTOR = 180.0f / 320;

	private GLRender _render = new GLRender();
	
	private float _preX = 0.0f;
	private float _preY = 0.0f;
	
	public MySurfaceView(Context context) {
		super(context);
		this.setRenderer((Renderer) _render);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event){
		float x = event.getX();
		float y = event.getY();
		switch(event.getAction()){
		case MotionEvent.ACTION_MOVE:
			float dx = x - _preX;
			float dy = y - _preY;
			_render.zrot += dx * TOUCH_SCALE_FACOTOR;
			_render.xrot += dy * TOUCH_SCALE_FACOTOR;
			this.requestRender();
			break;
		}
		
		_preX = x;
		_preY = y;
		return true;
	}
	
}
