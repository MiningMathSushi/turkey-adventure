package Thanksgiving;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Turkey {
	private double x;
	private double y;
	private double width;
	private double height;
	private double dx;
	private double dy;
	private boolean facingLeft;
	public int death;

	public Turkey(double x, double y) {
		this.x = x;
		this.y = y;
		this.dx = 0;
		this.dy = 0;
		this.death = 0;
		this.width = 45;
		this.height = 69;
	}


	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getdx() {
		return dx;
	}

	public double getdy() {
		return dy;
	}

	public void addforce(double x, double y) {
		dx += x;
		dy += y;
	}

	public void setX(double num) {
		x = num;
	}
	public void setY(double num) {
		y = num;
	}
	public void setdx(double num) {
		dx = num;
	}
	public void setdy(double num) {
		dy = num;
	}

	public void move(double x,double y) {
		this.x += x;
		this.y += y;
	}

	public Rectangle2D.Double hitbox() {
		return new Rectangle2D.Double(x,y,width,height);
	}

	public void update() {
		x+=dx;
		y+=dy;
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		Color brown = new Color(111, 78, 55);
		
		/*x+45-start-width...
		y+69-start-height...*/
		if(dx < 0) {
			facingLeft = true;
		}
		else if(dx > 0) {
			facingLeft = false;
		}
		if(facingLeft) {
			Ellipse2D.Double head = new Ellipse2D.Double(2+x, 8+y, 25, 25);
			g2.setColor(brown);
			g2.fill(head);
			g2.setColor(Color.black);
			g2.draw(head);

			Ellipse2D.Double body = new Ellipse2D.Double(5+x, 28+y, 40, 30);
			g2.setColor(Color.black);
			g2.draw(body);
			g2.setColor(brown);
			g2.fill(body);

			Ellipse2D.Double wing = new Ellipse2D.Double(5+x, 28+y, 30, 20);
			g2.setColor(Color.black);
			g2.draw(wing);
			g2.setColor(brown);
			g2.fill(wing);

			Ellipse2D.Double eye1 = new Ellipse2D.Double(5+x, 15+y, 5, 5);
			g2.setColor(Color.BLACK);
			g2.fill(eye1);

			Ellipse2D.Double eye2 = new Ellipse2D.Double(11+x, 15+y, 5, 5);
			g2.setColor(Color.BLACK);
			g2.fill(eye2);

			Ellipse2D.Double beak1 = new Ellipse2D.Double(2+x, 23+y, 5, 5);
			g2.setColor(Color.YELLOW);
			g2.fill(beak1);
			g2.setColor(Color.black);
			g2.draw(beak1);

			Ellipse2D.Double beak2 = new Ellipse2D.Double(x, 25+y, 5, 5);
			g2.setColor(Color.YELLOW);
			g2.fill(beak2);
			g2.setColor(Color.black);
			g2.draw(beak2);

			Ellipse2D.Double neckbeard = new Ellipse2D.Double(5+x, 28+y, 5, 10);
			g2.setColor(Color.RED);
			g2.fill(neckbeard);
			g2.setColor(Color.black);
			g2.draw(neckbeard);

			Ellipse2D.Double foot1 = new Ellipse2D.Double(17+x, 56+y, 5, 13);
			g2.setColor(Color.YELLOW);
			g2.fill(foot1);
			g2.setColor(Color.black);
			g2.draw(foot1);

			Ellipse2D.Double foot2 = new Ellipse2D.Double(27+x, 56+y, 5, 13);
			g2.setColor(Color.YELLOW);
			g2.fill(foot2);
			g2.setColor(Color.black);
			g2.draw(foot2);

			Ellipse2D.Double hat = new Ellipse2D.Double(6+x, y, 5, 10);
			g2.setColor(Color.RED);
			g2.fill(hat);
			g2.setColor(Color.black);
			g2.draw(hat);
		}
		else {
			Ellipse2D.Double head = new Ellipse2D.Double(x+45-2-25, y+8, 25, 25);
			g2.setColor(brown);
			g2.fill(head);
			g2.setColor(Color.black);
			g2.draw(head);

			Ellipse2D.Double body = new Ellipse2D.Double(x+45-5-40, y+28, 40, 30);
			g2.setColor(Color.black);
			g2.draw(body);
			g2.setColor(brown);
			g2.fill(body);

			Ellipse2D.Double wing = new Ellipse2D.Double(x+45-5-30, y+28, 30, 20);
			g2.setColor(Color.black);
			g2.draw(wing);
			g2.setColor(brown);
			g2.fill(wing);

			Ellipse2D.Double eye1 = new Ellipse2D.Double(x+45-5-5, y+15, 5, 5);
			g2.setColor(Color.BLACK);
			g2.fill(eye1);

			Ellipse2D.Double eye2 = new Ellipse2D.Double(x+45-11-5, y+15, 5, 5);
			g2.setColor(Color.BLACK);
			g2.fill(eye2);

			Ellipse2D.Double beak1 = new Ellipse2D.Double(x+45-2-5, y+23, 5, 5);
			g2.setColor(Color.YELLOW);
			g2.fill(beak1);
			g2.setColor(Color.black);
			g2.draw(beak1);

			Ellipse2D.Double beak2 = new Ellipse2D.Double(x+45-5, y+25, 5, 5);
			g2.setColor(Color.YELLOW);
			g2.fill(beak2);
			g2.setColor(Color.black);
			g2.draw(beak2);

			Ellipse2D.Double neckbeard = new Ellipse2D.Double(x+45-5-5, y+28, 5, 10);
			g2.setColor(Color.RED);
			g2.fill(neckbeard);
			g2.setColor(Color.black);
			g2.draw(neckbeard);

			Ellipse2D.Double foot1 = new Ellipse2D.Double(x+45-17-5, y+56, 5, 13);
			g2.setColor(Color.YELLOW);
			g2.fill(foot1);
			g2.setColor(Color.black);
			g2.draw(foot1);

			Ellipse2D.Double foot2 = new Ellipse2D.Double(x+45-27-5, y+56, 5, 13);
			g2.setColor(Color.YELLOW);
			g2.fill(foot2);
			g2.setColor(Color.black);
			g2.draw(foot2);

			Ellipse2D.Double hat = new Ellipse2D.Double(x+45-6-5, y, 5, 10);
			g2.setColor(Color.RED);
			g2.fill(hat);
			g2.setColor(Color.black);
			g2.draw(hat);
		}
	}
}
