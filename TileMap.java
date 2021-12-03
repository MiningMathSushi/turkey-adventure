package Thanksgiving;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class TileMap {
	private int[][] tileMap;

	public TileMap(int[][] tileMap) {
		this.tileMap = tileMap;
	}
	public TileMap(String map) {

		String[] rows = map.split("\n");

		int[][] intarr = new int[rows[0].length()][rows.length];

		for(int i = 0; i < rows.length; i++) {
			String row = rows[i];
			char[] ch = row.toCharArray();
			for(int j = 0; j < ch.length; j++) {
				intarr[j][i] = Character.getNumericValue(ch[j]);
			}
		}
		
		this.tileMap = intarr;
	}

	public int getrows() {
		return tileMap[0].length;
	}

	public int getcols() {
		return tileMap.length;
	}

	public int getTile(int x, int y) {
		return tileMap[x][y];
	}

	public Rectangle2D.Double getTileBox(int x, int y) {
		int xScale = 500/tileMap.length;
		int yScale = 500/tileMap[0].length;

		return new Rectangle2D.Double(x*xScale,y*yScale,xScale,yScale);
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		int xScale = 500/tileMap.length;
		int yScale = 500/tileMap[0].length;


		for(int i =0; i<tileMap.length;i++) {
			for(int j = 0; j<tileMap[0].length;j++) {
				if(tileMap[i][j] == 1) {
					g2.setColor(Color.BLACK);
				}
				else if(tileMap[i][j] == 2) {
					g2.setColor(new Color(0,140,0));
				}
				else if(tileMap[i][j] == 3) {
					g2.setColor(new Color(180,0,0));
				}
				if(tileMap[i][j] > 0) {
					g2.fillRect(i*xScale,j*yScale,xScale,yScale);
				}
			}
		}
	}

}
