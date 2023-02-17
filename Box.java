import java.awt.*;
import java.awt.event.*;


public class Box extends Rectangle{

	Color color;
	
	Box(int x, int y, int width, int height, Color color){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.color=color;
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_H) {
			this.x=600;
		}
		if(e.getKeyCode() == KeyEvent.VK_J) {
			this.x=800;
		}
		if(e.getKeyCode() == KeyEvent.VK_K) {
			this.x=1000;
		}
		if(e.getKeyCode() == KeyEvent.VK_L) {
			this.x=1200;
		}
	}
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.width, this.height);
	}
}