package ex17;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DubFrame extends JFrame {

	public DubFrame() {
		Container c = getContentPane();
		c.setBackground(Color.CYAN);
		c.add(new JLabel("hello world"));
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("nihaoma");
		setVisible(true);
		setSize(400, 300);
	}
	
	public static void main(String[] args) {
		new DubFrame();
	}
}
