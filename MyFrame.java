import java.awt.event.*;
import java.util.Calendar;

import javax.swing.*;
import java.awt.*;
import javax.swing.Timer;

public class MyFrame extends JFrame implements ActionListener{

	int HMove = 1;
	int JMove = 1;
	int KMove = 1;
	int LMove = 1;

	Image image;
	Graphics graphics;
	Box player;
	Box HBlock;
	Box JBlock;
	Box KBlock;
	Box LBlock;
	boolean gameOver;
	boolean victory;
	Timer timer;

	
	
	MyFrame(){
		timer = new Timer(5, this);
		timer.start();
		player = new Box(1000,900,200,100,Color.blue);
		HBlock = new Box(600,0,200,100,Color.red);
		JBlock = new Box(800,0,200,100,Color.yellow);
		KBlock = new Box(1000,0,200,100,Color.green);
		LBlock = new Box(1200,0,200,100,Color.pink);
		
		gameOver = false;
		victory = false;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(2048,1152);
		this.setVisible(true);
		this.addKeyListener(new AL());
	}
	
	public void paint(Graphics g) {
		image = createImage(this.getWidth(),this.getHeight());
		graphics = image.getGraphics();
		g.drawImage(image,0,0,this);
		
		player.draw(g);
		HBlock.draw(g);
		JBlock.draw(g);
		KBlock.draw(g);
		LBlock.draw(g);
		
		if(gameOver) {
			HMove = 0;
			JMove = 0;
			KMove = 0;
			LMove = 0;
			g.setColor(Color.RED);
			g.setFont(new Font("MV Boli",Font.PLAIN,100));
			g.drawString("GAME OVER!", 724, 576);
		}

		if(victory)
		{
			HMove = 0;
			JMove = 0;
			KMove = 0;
			LMove = 0;
			g.setColor(Color.yellow);
			g.setFont(new Font("MV Boli",Font.PLAIN,100));
			g.drawString("Congratulations!", 724, 576);
		}
	}
	
	public void checkCollision() {
		if(player.intersects(HBlock)) {
			HMove = (int) ((Math.random()*10)+3);
			HBlock.setLocation(600, 0);
		}
		if(player.intersects(JBlock)) {
			JMove = (int) ((Math.random()*10)+3);
			JBlock.setLocation(800, 0);
		}
		if(player.intersects(KBlock)) {
			KMove = (int) ((Math.random()*10)+3);
			KBlock.setLocation(1000, 0);
		}
		if(player.intersects(LBlock)) {
			LMove = (int) ((Math.random()*10)+3);
			LBlock.setLocation(1200, 0);
		}
	}

	public void setVictory(boolean e)
	{
		victory = e;
	}


	
	public class AL extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
			repaint();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		HBlock.setLocation(600, (int) HBlock.getY()+HMove);
		JBlock.setLocation(800, (int) JBlock.getY()+JMove);
		KBlock.setLocation(1000, (int) KBlock.getY()+KMove);
		LBlock.setLocation(1200, (int) LBlock.getY()+LMove);
		checkCollision();
		repaint();
		if (HBlock.getY() > 1200 || JBlock.getY() > 1200 || KBlock.getY() > 1200 || LBlock.getY() > 1200)
		{
			gameOver = true;
		}
	}
}