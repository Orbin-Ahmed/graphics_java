import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import java.util.Random;

import javax.swing.JFrame;

class ThirdGLEventListener implements GLEventListener {
/**
 * Interface to the GLU library.
 */
private GLU glu;

/**
 * Take care of initialization here.
 */
public void init(GLAutoDrawable gld) {
    GL2 gl = gld.getGL().getGL2();
    glu = new GLU();

    gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    gl.glViewport(-250, -150, 250, 150);
    gl.glMatrixMode(GL2.GL_PROJECTION);
    gl.glLoadIdentity();
    glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);
}

/**
 * Take care of drawing here.
 */
public void display(GLAutoDrawable drawable) {
    GL2 gl = drawable.getGL().getGL2();
    gl.glPointSize(3);
    gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
    gl.glColor3d(0, 1, 1);
    gl.glBegin(GL2.GL_POINTS);
    for(int i = 0;i<200;i++) {
     if(i%3==0) {
      gl.glVertex2d(-80, 100-i);
     }
     else {
      
     }
    }
    gl.glEnd();
    dda(gl,80,-100,80,100);
    dda(gl,-80,0,80,0);
}
private void dda(GL2 gl, float x1,float y1,float x2,float y2) {
 gl.glBegin(GL2.GL_POINTS);
 float x=x1;
 float y=y1;
 float m =(y2-y1)/(x2-x1);
 gl.glVertex2d(x,y);
 if(-1<m && m<=1) {
  for(float i = x; i<x2; i++) {
   x=x+1;
   y=y+m;
   gl.glVertex2d(x, y);
  }
 }
 else {
  for(float i=y;i<y2;i++) {
   x=x+(1/m);
   y=y+1;
   gl.glVertex2d(x, y);
  }
 }
 gl.glEnd();
 
 
}

public void reshape(GLAutoDrawable drawable, int x, int y, int width,
        int height) {
}

public void displayChanged(GLAutoDrawable drawable,
        boolean modeChanged, boolean deviceChanged) {
}

public void dispose(GLAutoDrawable arg0)
{
 
}
}
public class task3_17201023
{
public static void main(String args[])
{
 //getting the capabilities object of GL2 profile
 final GLProfile profile=GLProfile.get(GLProfile.GL2);
 GLCapabilities capabilities=new GLCapabilities(profile);
 // The canvas
 final GLCanvas glcanvas=new GLCanvas(capabilities);
 ThirdGLEventListener b=new ThirdGLEventListener();
 glcanvas.addGLEventListener(b);
 glcanvas.setSize(400, 400);
 //creating frame
 final JFrame frame=new JFrame("Basic frame");
 //adding canvas to frame
 frame.add(glcanvas);
 frame.setSize(640,480);
 frame.setVisible(true);
}
}

