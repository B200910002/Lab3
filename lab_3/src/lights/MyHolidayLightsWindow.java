package lights;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;

/**
 * JFrame that contains a display of holiday lights and an 'Exit' button.
 * @author uuu
 *
 */
public class MyHolidayLightsWindow extends JFrame {
	
	private static final long serialVersionUID = -722257469624438083L;
	private HolidayLights hl;
	private static final int millsPerFrame = 500;
	
	public MyHolidayLightsWindow(HolidayLights hl) {
		// Sets up the title bar
		super("Lab 0: Holiday Lights");
		
		this.hl = hl;
		this.setup();
	}
	
	private void setup() {
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.setPreferredSize(new Dimension(900,600));

		LightWindow lw = new LightWindow(hl);
		JScrollPane jsp = new JScrollPane(lw);
		contentPane.add(jsp, BorderLayout.CENTER);
		
		Button but = new Button("Exit");
		but.addActionListener(new ActionListener() {
			                    public void actionPerformed(ActionEvent e) {
			                        System.exit(0);
			                    }
			                });
		contentPane.add(but, BorderLayout.EAST);
		
		// makes clicking 'x' actually close on macs
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(contentPane);
	}
	
	private static class LightWindow extends JComponent {
		
		private static final long serialVersionUID = 9104734488769833572L;

		private HolidayLights hl;
		private Timer timer;
		private List<Light> lightState;
		
		public LightWindow(HolidayLights hl) {
			this.hl = hl;
			this.timer = new Timer(MyHolidayLightsWindow.millsPerFrame, new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					update();
				}
			});
			this.lightState = hl.next();
			timer.start();
		}
				
		@Override public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			int curX = 200;
			int curY = 20;
			int dive = this.lightState.size()/4;

			for (int i = 0; i < dive; i++) {
				Light l = this.lightState.get(i);
				if (l.isOn()) {
					g2d.setColor(Color.YELLOW);
					if (l instanceof ColoredLight) {
						ColoredLight cl = (ColoredLight) l;
						g2d.setColor(cl.getColor());
					}
					g2d.fillOval(curX, curY, 26, 60);
					g2d.setColor(Color.BLACK);
					g2d.drawOval(curX, curY, 26, 60);
				} else {
					g2d.setColor(Color.BLACK);
					g2d.drawOval(curX, curY, 26, 60);
				}
				
				// draw line across the top
				if (i < dive - 1) {
				g2d.setColor(new Color(0,100,0));
				Stroke oldStroke = g2d.getStroke();
				g2d.setStroke(new BasicStroke(6.0f));
				g2d.drawArc(curX+13, curY-15, 50, 25, 0, 180);
				g2d.setStroke(oldStroke);
				}
				
				curX += 50;
			}
			
			curY+=75;
			for (int i = dive; i < dive*2; i++) {
				Light l = this.lightState.get(i);
				if (l.isOn()) {
					g2d.setColor(Color.YELLOW);
					if (l instanceof ColoredLight) {
						ColoredLight cl = (ColoredLight) l;
						g2d.setColor(cl.getColor());
					}
					g2d.fillOval(curX, curY, 60, 26);
					g2d.setColor(Color.BLACK);
					g2d.drawOval(curX, curY, 60, 26);
				} else {
					g2d.setColor(Color.BLACK);
					g2d.drawOval(curX, curY, 60, 26);
				}
				
				// draw line across the right
				if (i < dive*2 - 1) {
				g2d.setColor(new Color(0,100,0));
				Stroke oldStroke = g2d.getStroke();
				g2d.setStroke(new BasicStroke(6.0f));
				g2d.drawArc(curX+50, curY+13, 25, 50, 270, 180);
				g2d.setStroke(oldStroke);
				}
				
				curY += 50;
			}
			
			curX-=50;
			for (int i = dive*2; i < dive*3; i++) {
				Light l = this.lightState.get(i);
				if (l.isOn()) {
					g2d.setColor(Color.YELLOW);
					if (l instanceof ColoredLight) {
						ColoredLight cl = (ColoredLight) l;
						g2d.setColor(cl.getColor());
					}
					g2d.fillOval(curX, curY, 26, 60);
					g2d.setColor(Color.BLACK);
					g2d.drawOval(curX, curY, 26, 60);
				} else {
					g2d.setColor(Color.BLACK);
					g2d.drawOval(curX, curY, 26, 60);
				}
				
				// draw line across the bottom
				if (i < dive*3 - 1) {
				g2d.setColor(new Color(0,100,0));
				Stroke oldStroke = g2d.getStroke();
				g2d.setStroke(new BasicStroke(6.0f));
				g2d.drawArc(curX-37, curY+52, 50, 25, 180, 180);
				g2d.setStroke(oldStroke);
				}
				
				curX -= 50;
			}
			
			curX-=40;
			curY-=40;
			for (int i = dive*3; i < dive*4; i++) {
				Light l = this.lightState.get(i);
				if (l.isOn()) {
					g2d.setColor(Color.YELLOW);
					if (l instanceof ColoredLight) {
						ColoredLight cl = (ColoredLight) l;
						g2d.setColor(cl.getColor());
					}
					g2d.fillOval(curX, curY, 60, 26);
					g2d.setColor(Color.BLACK);
					g2d.drawOval(curX, curY, 60, 26);
				} else {
					g2d.setColor(Color.BLACK);
					g2d.drawOval(curX, curY, 60, 26);
				}
				
				// draw line across the right
				if (i < dive*4 - 1) {
				g2d.setColor(new Color(0,100,0));
				Stroke oldStroke = g2d.getStroke();
				g2d.setStroke(new BasicStroke(6.0f));
				g2d.drawArc(curX-15, curY-35, 25, 50, 90, 180);
				g2d.setStroke(oldStroke);
				}
				
				curY -= 50;
			}
			
		}
		
		private void update() {
			this.lightState = this.hl.next();
			repaint();
		}	
}
}