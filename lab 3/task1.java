import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import javax.swing.JFrame;

public class task2 implements GLEventListener{
 
 private GLU glu;
 
 @Override
 public void display(GLAutoDrawable drawable) {
  final GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();
       
        //for 3 digit
        //for 3 top head
        MidLinePointCircle(gl, 40, 40, 5);
        MidLinePointCircle(gl, 45, 40, 5);
        MidLinePointCircle(gl, 50, 40, 5);
        MidLinePointCircle(gl, 55, 40, 5);
        MidLinePointCircle(gl, 60, 40, 5);
        MidLinePointCircle(gl, 65, 40, 5);
        MidLinePointCircle(gl, 70, 40, 5);
        MidLinePointCircle(gl, 75, 40, 5);
        MidLinePointCircle(gl, 80, 40, 5);
        MidLinePointCircle(gl, 85, 40, 5);
        //for 3 bottom feet
        MidLinePointCircle(gl, 40, -40, 5);
        MidLinePointCircle(gl, 45, -40, 5);
        MidLinePointCircle(gl, 50, -40, 5);
        MidLinePointCircle(gl, 55, -40, 5);
        MidLinePointCircle(gl, 60, -40, 5);
        MidLinePointCircle(gl, 65, -40, 5);
        MidLinePointCircle(gl, 70, -40, 5);
        MidLinePointCircle(gl, 75, -40, 5);
        MidLinePointCircle(gl, 80, -40, 5);
        MidLinePointCircle(gl, 85, -40, 5);
        //for 3 middle belly
        MidLinePointCircle(gl, 40, 0, 5);
        MidLinePointCircle(gl, 45, 0, 5);
        MidLinePointCircle(gl, 50, 0, 5);
        MidLinePointCircle(gl, 55, 0, 5);
        MidLinePointCircle(gl, 60, 0, 5);
        MidLinePointCircle(gl, 65, 0, 5);
        MidLinePointCircle(gl, 70, 0, 5);
        MidLinePointCircle(gl, 75, 0, 5);
        MidLinePointCircle(gl, 80, 0, 5);
        MidLinePointCircle(gl, 85, 0, 5);
        //for 3 spine
        MidLinePointCircle(gl, 85, 40, 5);
        MidLinePointCircle(gl, 85, 30, 5);
        MidLinePointCircle(gl, 85, 20, 5);
        MidLinePointCircle(gl, 85, 10, 5);
        MidLinePointCircle(gl, 85, 0, 5);
        MidLinePointCircle(gl, 85, -10, 5);
        MidLinePointCircle(gl, 85, -20, 5);
        MidLinePointCircle(gl, 85, -30, 5);
        MidLinePointCircle(gl, 85, -40, 5);
        
        
        

  
 }
 @Override
 public void dispose(GLAutoDrawable arg0) {
  //method body
 }

 @Override
 public void init(GLAutoDrawable gld) {
  GL2 gl = gld.getGL().getGL2();
  glu = new GLU();

  gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
  gl.glViewport(-100, -50, 50, 100);
  gl.glMatrixMode(GL2.GL_PROJECTION);
  gl.glLoadIdentity();
  glu.gluOrtho2D(-100.0, 100.0, -100.0, 100.0);
 }



 @Override
 public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
  // method body
 }

 /* Edited */
 private void MidLinePointCircle(GL2 gl, int p1 , int q1 ,int radius) { // (x1,y1) - centre of circle and r - is radius

        gl.glPointSize(3.0f);
        gl.glColor3d(0.5, 1, 0.8);

        int p = 0;
        int q = radius;
        int s = 1 - radius;
        
        draw8Way(gl,p,q, p1,q1);
        
        while (q > p) {
            if (s < 0) { //E is chosen
             s = s + ((2*p)+3);
             p++;
            }
            
            else { //SE is chosen
                s = s + ((2*p)-(2*q)+5);
                p++;
             q--;
            }
        
            draw8Way(gl , p , q , p1 , q1);
            
            
        }
    }
    
    
    
    private void draw8Way(GL2 gl, int p, int q, int p1, int q1) {
        gl.glBegin(GL2.GL_POINTS);
        gl.glVertex2d(p+p1, q+q1);
        gl.glVertex2d(q+p1, p+q1);
        gl.glVertex2d(-p+p1,q+q1);
        gl.glVertex2d(-q+p1,p+q1);
        gl.glVertex2d(-p+p1,-q+q1);
        gl.glVertex2d(-q+p1,-p+q1);
        gl.glVertex2d(p+p1, -q+q1);
        gl.glVertex2d(q+p1, -p+q1);
        gl.glEnd();
    }

 public static void main(String[] args) {
  //getting the capabilities object of GL2 profile
  final GLProfile profile = GLProfile.get(GLProfile.GL2);
  GLCapabilities capabilities = new GLCapabilities(profile);
  // The canvas 
  final GLCanvas glcanvas = new GLCanvas(capabilities);
  task2 l = new task2();
  glcanvas.addGLEventListener(l);
  glcanvas.setSize(400, 400);
  //creating frame
  final JFrame frame = new JFrame ("Line Algorithm: Mid Point Circle(17201023)");
  //adding canvas to frame
  frame.getContentPane().add(glcanvas);
  frame.setSize(frame.getContentPane().getPreferredSize());
  frame.setVisible(true);
 } 
}
