package swing.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.GroupLayout;
import javax.swing.JPanel;

public class PanelBackground extends JPanel {

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
		repaint();
	}

	private int round = 15;

	public PanelBackground() {
		initComponents();
		setOpaque(false);
		setBackground(new Color(242, 242, 242));
		setForeground(new Color(23, 102, 255));
	}

	private void initComponents() {

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 507, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 280, Short.MAX_VALUE));
	}

	@Override
	public void paint(Graphics grphcs) {
		Graphics2D g2 = (Graphics2D) grphcs.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int width = getWidth();
		int height = getHeight();
		int header = 200;
		g2.setColor(getBackground());
		g2.fillRoundRect(0, 0, width, height, round, round);
		Area area = new Area(new RoundRectangle2D.Double(0, 0, width, header, round, round));
		area.add(new Area(new Rectangle2D.Double(0, header - 10, width, 10)));
		g2.setColor(getForeground());
		g2.fill(area);
		g2.dispose();
		super.paint(grphcs);
	}

}
