package com.gl.GLInit;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;

public class GLRender implements Renderer{

	float xrot,yrot,zrot;
	
	@Override
	public void onDrawFrame(GL10 gl) {
		// 清除屏幕和深度缓存
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		// 重置当前的模型观察矩阵
		gl.glLoadIdentity();
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		float radio = (float) width / height;

		// 设置OpenGL视口
		gl.glViewport(0, 0, width, height);
		
		// 设置透视投影矩阵
		gl.glMatrixMode(GL10.GL_PROJECTION);
		
		// 单位化投影矩阵
		gl.glLoadIdentity();
		
		// 设置视口大小
		gl.glFrustumf(-radio, radio, -1, 1, 1, 10);
		
		// 选择模型观察矩阵
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		
		// 单位化观察矩阵
		gl.glLoadIdentity();
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// 黑色背景
		gl.glClearColor(0, 0, 0, 0);
		
		// 蓝色背景
//		gl.glClearColor(0, 0, 1.0f, 0);
		
		// 红色背景
//		gl.glClearColor(1.0f, 0, 0, 0);
		
		// 启用阴影平滑
		gl.glShadeModel(GL10.GL_SMOOTH);
		
		// 启动深度测试
		gl.glEnable(GL10.GL_DEPTH_TEST);
		
		// 清除深度缓冲数据
		gl.glClearDepthf(1.0f);
		
		// 深度测试的类型
		gl.glDepthFunc(GL10.GL_LEQUAL);
		
		// 精细的透视修正
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
	}

	// 获取整形缓冲数据
	public IntBuffer getIntBuffer(int[] vertexes){
		IntBuffer buffer;
		
		ByteBuffer qbb = ByteBuffer.allocateDirect(vertexes.length * 4);
		
		qbb.order(ByteOrder.nativeOrder());
		
		buffer = qbb.asIntBuffer();
		buffer.put(vertexes);
		buffer.position(0);
		
		return buffer;
	}

	// 获取字节型缓冲数据
	public ByteBuffer getByteBuffer(byte[] vertexes){
		ByteBuffer buffer = null;
		
		buffer = ByteBuffer.allocateDirect(vertexes.length);
		buffer.put(vertexes);
		buffer.position(0);
		
		return buffer;
	}
		
}
