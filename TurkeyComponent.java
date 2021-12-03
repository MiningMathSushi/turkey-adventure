package Thanksgiving;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;



public class TurkeyComponent extends JComponent implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Turkey turkey;

	private boolean w,s,a,d;
	private JLabel message;

	private int currentLevel;
	private int maxLevels;
	private ArrayList<TileMap> levels = new ArrayList<TileMap>();
	
	private boolean isPlaying;
	private ImageIcon img;
	
	private int FPS = 90;
	private long targetTime = 1000 / FPS;

	public TurkeyComponent() {
		setPreferredSize(new Dimension(500,500));
		isPlaying = true;
		turkey = new Turkey(0,250);
		currentLevel = 0;
		
		img = new ImageIcon("turkey.jpeg");
		int[][] hi = {{0, 0, 0, 0, 1}, {0, 0, 0, 1, 1}, {0, 0, 1, 1, 1}, {0, 0, 0, 0, 1}, {0, 3, 1, 2, 1}};

		String hi3 = 	"00000\n"
				+ 		"00002\n"
				+ 		"00101\n"
				+ 		"01103\n"
				+ 		"11111";

		int[][] hi2 = {		{0,0,0,0,0,0,0,0,1,1},
				{0,0,0,0,0,0,0,1,2,1},
				{0,0,0,0,0,0,3,2,2,1},
				{0,0,0,0,0,1,2,2,2,1},
				{0,0,0,0,3,2,2,2,2,1},
				{0,0,0,1,2,2,2,2,2,1},
				{0,0,3,2,2,2,2,2,2,1},
				{0,0,1,1,1,1,1,1,1,1},
				{0,0,0,0,0,0,0,0,0,1},
				{0,0,0,0,0,0,0,0,2,1}};

		TileMap level1 = new TileMap(hi);
		TileMap level2 = new TileMap(hi2);
		TileMap level3 = new TileMap(hi3);
		

		levels.add(level1);
		levels.add(level2);
	
		levels.add(level3);
		levels.add(new TileMap("111111111\n"
				+ "200000001\n"
				+ "200000001\n"
				+ "333333001\n"
				+ "001111100\n"
				+ "000000000\n"
				+ "000000001\n"
				+ "000000001\n"
				+ "113333311"));
		levels.add(new TileMap("11111111\n"
				+ "00001111\n"
				+ "00001112\n"
				+ "00001100\n"
				+ "00001000\n"
				+ "00300000\n"
				+ "11111111"));
		levels.add(new TileMap("1111111111\n"
				+ "1110000000\n"
				+ "1100113100\n"
				+ "000003300\n"
				+ "0000333300\n"
				+ "1033333322\n"
				+ "1111111111"));
		
		levels.add(new TileMap(   "333333333333\n"
								+ "0110010111\n"
								+ "0101010110\n"
								+ "0110010111\n"
								+ "0000000000\n"
								+ "0000000000\n"
								+ "0000300000\n"
								+ "0000003000\n"
								+ "10000003200\n"
								+ "333333333333"));
		
		levels.add(new TileMap( 
                "011101110101\n"
              + "010001110010\n"
              + "011101001010\n"
              + "000000000000\n"
              + "000000000000\n"
              + "003000000000\n"
              + "003003000030\n"
              + "100100300300\n"
              + "333333322333"));
		
		levels.add(new TileMap( 
				  "010001110100\n"
				+ "010001010100\n"
				+ "011101110111\n"
				+ "000000000000\n"
				+ "000000000000\n"
				+ "000003000000\n"
				+ "003003003003\n"
				+ "100100100102\n"
				+ "333333333332"));
		
		levels.add(new TileMap(   "000000000000000003000000000\n"
								+ "000000000000000003000000000\n"
								+ "000000000000000003000000000\n"
								+ "000000310000003333000000032\n"
								+ "000000303300030000000000030\n"
								+ "000010000000000000000001000\n"
								+ "001100000000000000000310000\n"
								+ "003000000010000000000300000\n"
								+ "133333333331113333111333333"));
		

		maxLevels = levels.size();

		w=false;
		s=false;
		a=false;
		d=false;

		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

		message = new JLabel("HI");
		add(message);
	}

	public void updateTurkey(Turkey turkey, int num) {
		Rectangle2D.Double tileBox; 

		Rectangle2D.Double turkeyBox = turkey.hitbox();
		Rectangle2D.Double turkeyBoxX = new Rectangle2D.Double(turkeyBox.x+turkey.getdx(),turkeyBox.y,turkeyBox.width,turkeyBox.height*0.99);
		Rectangle2D.Double turkeyBoxY = new Rectangle2D.Double(turkeyBox.x,turkeyBox.y+turkey.getdy(),turkeyBox.width,turkeyBox.height);

		turkey.setdx(turkey.getdx()*0.864);
		turkey.setdy(turkey.getdy()+0.256);
		TileMap level = levels.get(num);
		
		loop:
			for(int i =0; i<level.getcols();i++) {
				for(int j = 0; j<level.getrows();j++) {
					tileBox = level.getTileBox(i,j);

					if(level.getTile(i, j) == 1 ) {
						if(turkeyBoxX.intersects(tileBox)) {
							turkey.setdx(0);

						}
						if(turkeyBoxY.intersects(tileBox)) {
							turkey.setdy(0);
						}
					}
					else if (level.getTile(i, j) == 2 && turkeyBox.intersects(tileBox)) {
						turkey.setX(0);
						turkey.setY(250);
						if((currentLevel+1) % maxLevels == 0) {
							isPlaying = false;
						}
						else {
							currentLevel ++;
						}
						break loop;

					}
					else if (level.getTile(i, j) == 3 && turkeyBox.intersects(tileBox)) {
						turkey.setX(0);
						turkey.setY(250);
						turkey.death++;
						break loop;
					}
				}
			}

		if(turkey.getY() > 500){
			turkey.setY(250);
			turkey.setX(0);
			turkey.death++;
		}
		turkey.update();


	}

	public void paintComponent(Graphics g) {
		if(isPlaying) {
			long start, elapsed, wait;
			start = System.nanoTime();
			
			processInput();
			updateTurkey(turkey, currentLevel);
			
			turkey.draw(g);
			levels.get(currentLevel).draw(g);
			g.setColor(Color.GRAY);
			g.setFont(new Font("Georgia",Font.BOLD,20));
			g.drawString("Deaths: " + turkey.death, 30, 20);
			g.drawString("Level: " + (currentLevel+1),400,20);
			
			elapsed = System.nanoTime() - start;
			
			wait = targetTime - elapsed/1000000;
			if(wait<0) {
				wait = 0;
			}
			try {
				Thread.sleep(wait);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			repaint();
		}
		else {
			g.drawImage(img.getImage(), 0, 0, 616, 462, null);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Georgia",Font.BOLD,100));
			g.drawString("You Win!", 10, 250);
		}
	}

	public void processInput() {
		if(w) {
			if(turkey.getdy() == 0) {
				turkey.addforce(0, -8);
			}

		}
		if(a) {
			turkey.addforce(-0.768, 0);
		}
		if(s) {
			//Nothing for now
		}
		if(d) {

			turkey.addforce(0.768, 0);
		}
	}



	@Override
	public void keyTyped(KeyEvent e) {


	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			d=true;
			break;
		case KeyEvent.VK_LEFT:
			a=true;
			break;
		case KeyEvent.VK_UP:
			w=true;
			break;
		}		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			d=false;
			break;
		case KeyEvent.VK_LEFT:
			a=false;
			break;
		case KeyEvent.VK_UP:
			w=false;
			break;
		}
	}


}
