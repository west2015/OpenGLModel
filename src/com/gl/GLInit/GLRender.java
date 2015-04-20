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
		// �����Ļ����Ȼ���
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		// ���õ�ǰ��ģ�͹۲����
		gl.glLoadIdentity();
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		float radio = (float) width / height;

		// ����OpenGL�ӿ�
		gl.glViewport(0, 0, width, height);
		
		// ����͸��ͶӰ����
		gl.glMatrixMode(GL10.GL_PROJECTION);
		
		// ��λ��ͶӰ����
		gl.glLoadIdentity();
		
		// �����ӿڴ�С
		gl.glFrustumf(-radio, radio, -1, 1, 1, 10);
		
		// ѡ��ģ�͹۲����
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		
		// ��λ���۲����
		gl.glLoadIdentity();
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// ��ɫ����
		gl.glClearColor(0, 0, 0, 0);
		
		// ��ɫ����
//		gl.glClearColor(0, 0, 1.0f, 0);
		
		// ��ɫ����
//		gl.glClearColor(1.0f, 0, 0, 0);
		
		// ������Ӱƽ��
		gl.glShadeModel(GL10.GL_SMOOTH);
		
		// ������Ȳ���
		gl.glEnable(GL10.GL_DEPTH_TEST);
		
		// �����Ȼ�������
		gl.glClearDepthf(1.0f);
		
		// ��Ȳ��Ե�����
		gl.glDepthFunc(GL10.GL_LEQUAL);
		
		// ��ϸ��͸������
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
	}

	// ��ȡ���λ�������
	public IntBuffer getIntBuffer(int[] vertexes){
		IntBuffer buffer;
		
		ByteBuffer qbb = ByteBuffer.allocateDirect(vertexes.length * 4);
		
		qbb.order(ByteOrder.nativeOrder());
		
		buffer = qbb.asIntBuffer();
		buffer.put(vertexes);
		buffer.position(0);
		
		return buffer;
	}

	// ��ȡ�ֽ��ͻ�������
	public ByteBuffer getByteBuffer(byte[] vertexes){
		ByteBuffer buffer = null;
		
		buffer = ByteBuffer.allocateDirect(vertexes.length);
		buffer.put(vertexes);
		buffer.position(0);
		
		return buffer;
	}
		
}
