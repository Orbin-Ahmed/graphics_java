import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
public class task2 implements GLEventListener {
 private GLU glu;
  @Override
  public void display(GLAutoDrawable drawable) {
   final GL2 gl = drawable.getGL().getGL2();
   
   MPL(gl, -50, 10, 50, 10);
   MPL(gl, -40, 0, 40, 0);
   MPL(gl, -50, 10, -40, 0);
   MPL(gl, 50, 10, 40, 0);
   
   MPL(gl, 10, 60, 30, 10);
   MPL(gl, 10, 10, 10, 60);
   
   MPL(gl, 10, 40, -10, 10);
      
   gl.glEnd();
  }
  @Override
  public void dispose(GLAutoDrawable arg0) {
    
  }
  
  @Override
  public void init(GLAutoDrawable gld) {
   GL2 gl = gld.getGL().getGL2();
   glu = new GLU();
   gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
   gl.glViewport(-100, -100,100, 100);
   gl.glMatrixMode(GL2.GL_PROJECTION);
   gl.glLoadIdentity();
   glu.gluOrtho2D(-100.0, 100.0, -100.0, 100.0);
 }
  
  @Override
public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
    
  }
static int dx, dy, b, zone;
  
public void MPL(GL2 gl, int x1, int y1, int x2, int y2) {
    gl.glPointSize(3.0f);
    gl.glColor3d(0, 1, 1);
    gl.glBegin(GL2.GL_POINTS);
    findZone(x1, y1, x2, y2);
    System.out.println(zone);
    int new_x1, new_y1, new_x2, new_y2;
    new_x1 = convertX(x1, y1);
    new_y1 = convertY(x1, y1);
    
    new_x2 = convertX(x2, y2);
    new_y2 = convertY(x2, y2);
    System.out.println(new_x2 + " " + new_y2);
    x1 = new_x1;
    x2 = new_x2;
    y1 = new_y1;
    y2 = new_y2;
    int dx = x2 - x1;
    int dy = y2 - y1;
    int dinit = (2 * dy) - dx;
    int dE = 2 * dy;
    int dNE = 2 * (dy - dx);
    int y = y1;
    int x = x1;
    while (x <= x2) {
        gl.glVertex3f(convertX_to_m(x, y), convertY_to_m(x, y), 0);
        x++;
        if (dinit > 0) {
          y++;
          dinit = dinit + dNE;
        } else {
          dinit = dinit + dE;
        }
      }
  }
  
 static int findZone(int x1, int y1, int x2, int y2) {
    zone = 0;
    dx = x2 - x1;
    dy = y2 - y1;
    if (Math.abs(dx) > Math.abs(dy)) {
      if (dx > 0 && dy >= 0)
        zone = 0;
      else if (dx < 0 && dy > 0)
        zone = 3;
      else if (dx < 0 && dy < 0)
        zone = 4;
      else if (dx > 0 && dy < 0)
        zone = 7;
      
    } else {
      if (dx >= 0 && dy > 0)
        zone = 1;
      else if (dx < 0 && dy > 0)
        zone = 2;
      else if (dx < 0 && dy < 0)
        zone = 5;
      else if (dx > 0 && dy < 0)
        zone = 6;
    }
    return zone;
  }
  
static int convertX(int x, int y) {
    int x_main;
    if (zone == 1) {
      x_main = y;
    } else if (zone == 2) {
      x_main = y;
    } else if (zone == 3) {
      x_main = -x;
    } else if (zone == 4) {
      x_main = -x;
    } else if (zone == 5) {
      x_main = -y;
    } else if (zone == 6) {
      x_main = -y;
    } else if (zone == 7) {
      x_main = x;
    } else {
      x_main = x;
    }
    
    return x_main;
  }
  
static int convertX_to_m(int x, int y) {
    
    if (zone == 1) {
      x = y;
    } else if (zone == 2) {
      x = -y;
    } else if (zone == 3) {
      x = -x;
    } else if (zone == 4) {
      x = -x;
    } else if (zone == 5) {
      x = -y;
    } else if (zone == 6) {
      x = y;
    } else if (zone == 7) {
      x = x;
    } else {
      x = x;
    }
    
    return x;
  }
  static int convertY(int x, int y) {
    int y_main = y;
    if (zone == 1) {
      y_main = x;
    } else if (zone == 2) {
      y_main = -x;
    } else if (zone == 3) {
      y_main = y;
    } else if (zone == 4) {
      y_main = -y;
    } else if (zone == 5) {
      y_main = -x;
    } else if (zone == 6) {
      y_main = x;
    } else if (zone == 7) {
      y_main = -y;
    }
    
    return y_main;
  }
  
static int convertY_to_m(int x, int y) {
    
    if (zone == 1) {
      y = x;
    } else if (zone == 2) {
      y = x;
    } else if (zone == 3) {
      y = y;
    } else if (zone == 4) {
      y = -y;
    } else if (zone == 5) {
      y = -x;
    } else if (zone == 6) {
      y = -x;
    } else if (zone == 7) {
      y = -y;
    } else {
      y = y;
    }
    
    return y;
  }
  
 public static void main(String[] args) {
    final GLProfile profile = GLProfile.get(GLProfile.GL2);
    GLCapabilities capabilities = new GLCapabilities(profile);
    final GLCanvas glcanvas = new GLCanvas(capabilities);
    task2 l = new task2();
    glcanvas.addGLEventListener(l);
    glcanvas.setSize(400, 400);
    final JFrame frame = new JFrame("Nouka");
    frame.getContentPane().add(glcanvas);
    frame.setSize(frame.getContentPane().getPreferredSize());
    frame.setVisible(true);
  }
}

