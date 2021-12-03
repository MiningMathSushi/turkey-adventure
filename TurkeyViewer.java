package Thanksgiving;

import javax.swing.JFrame;

public class TurkeyViewer {
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();

		frame.setSize(500, 500);
		frame.setTitle("Turkey Platformer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		TurkeyComponent component = new TurkeyComponent();
		frame.add(component);
		
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
}
