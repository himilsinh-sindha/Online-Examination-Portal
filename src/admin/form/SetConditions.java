package admin.form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import database.ConnectionProvider;
import swing.component.PanelShadow;
import swing.component.Spinner;

public class SetConditions extends JPanel {

	private JLabel header;
	private Spinner hourSpin;
	private JSeparator jSeparator2;
	private Spinner marksSpin;
	private Spinner minSpin;
	private PanelShadow panelShadow1;
	private JButton save;
	private Spinner secSpin;
	private JLabel setMarks;
	private JLabel setTime;

	static public int limitsec;
	static public int limitmin;
	static public int limithr;
	static public int um;

	public SetConditions() {
		initComponents();
		setOpaque(false);
		init();
	}

	private void init() {

	}

	private void initComponents() {

		panelShadow1 = new PanelShadow();
		setMarks = new JLabel();
		jSeparator2 = new JSeparator();
		save = new JButton();
		hourSpin = new Spinner();
		secSpin = new Spinner();
		marksSpin = new Spinner();
		minSpin = new Spinner();
		setTime = new JLabel();
		header = new JLabel();

		setBackground(new Color(64, 123, 255));

		panelShadow1.setBackground(new Color(64, 123, 255));
		panelShadow1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panelShadow1.setPreferredSize(new Dimension(996, 514));

		setMarks.setFont(new Font("Segoe UI", 0, 20));
		setMarks.setText("Set Unit Marks :");

		save.setBackground(new Color(255, 255, 255));
		save.setFont(new Font("Arial", 1, 22));
		save.setForeground(new Color(0, 0, 0));
		save.setText("Save");
		save.setFocusPainted(false);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				saveActionPerformed(evt);
			}
		});

		hourSpin.setBackground(new Color(255, 255, 255));
		hourSpin.setForeground(new Color(0, 0, 0));
		hourSpin.setModel(new SpinnerNumberModel(0, 0, 3, 1));
		hourSpin.setLabelText("Hours");
		hourSpin.setMinimumSize(new Dimension(15, 30));

		secSpin.setBackground(new Color(255, 255, 255));
		secSpin.setForeground(new Color(0, 0, 0));
		secSpin.setModel(new SpinnerNumberModel(0, 0, 60, 1));
		secSpin.setLabelText("Seconds");

		marksSpin.setBackground(new Color(255, 255, 255));
		marksSpin.setForeground(new Color(0, 0, 0));
		marksSpin.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		marksSpin.setLabelText("Unit Marks");
		marksSpin.setName("");

		minSpin.setBackground(new Color(255, 255, 255));
		minSpin.setForeground(new Color(0, 0, 0));
		minSpin.setModel(new SpinnerNumberModel(0, 0, 60, 1));
		minSpin.setLabelText("Minutes");

		setTime.setFont(new Font("Segoe UI", 0, 20));
		setTime.setText("Set Time :");

		header.setFont(new Font("Segoe UI", 0, 24));
		header.setText("Set Time & Marks");

		GroupLayout panelShadow1Layout = new GroupLayout(panelShadow1);
		panelShadow1.setLayout(panelShadow1Layout);
		panelShadow1Layout.setHorizontalGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jSeparator2)
				.addGroup(panelShadow1Layout.createSequentialGroup().addGroup(panelShadow1Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelShadow1Layout
								.createSequentialGroup().addGap(87, 87, 87)
								.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addComponent(setTime).addComponent(setMarks))
								.addGap(40, 40, 40)
								.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(marksSpin, GroupLayout.PREFERRED_SIZE, 154,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(hourSpin, GroupLayout.PREFERRED_SIZE, 120,
												GroupLayout.PREFERRED_SIZE))
								.addGap(49, 49, 49)
								.addComponent(minSpin, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addGap(75, 75, 75)
								.addComponent(secSpin, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(panelShadow1Layout.createSequentialGroup().addContainerGap().addComponent(header,
								GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
						.addGroup(panelShadow1Layout.createSequentialGroup().addGap(396, 396, 396).addComponent(save,
								GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(162, Short.MAX_VALUE)));
		panelShadow1Layout.setVerticalGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelShadow1Layout.createSequentialGroup().addContainerGap().addComponent(header)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
						.addGap(93, 93, 93)
						.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(hourSpin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(secSpin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(minSpin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(setTime))
						.addGap(43, 43, 43)
						.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(marksSpin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(setMarks))
						.addGap(67, 67, 67).addComponent(save).addContainerGap(95, Short.MAX_VALUE)));

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(panelShadow1, GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(26, 26, 26).addComponent(panelShadow1,
						GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	}

	private void saveActionPerformed(ActionEvent evt) {
		limitsec = (Integer) secSpin.getValue();
		limitmin = (Integer) minSpin.getValue();
		limithr = (Integer) hourSpin.getValue();
		um = (Integer) marksSpin.getValue();
		try {
			Connection con = ConnectionProvider.getCon();
			PreparedStatement ps = con
					.prepareStatement("update examinfo set id=?,limitsec=?,limitmin=?,limithr=?,um=? where id=1");
			ps.setString(1, String.valueOf(1));
			ps.setString(2, String.valueOf(limitsec));
			ps.setString(3, String.valueOf(limitmin));
			ps.setString(4, String.valueOf(limithr));
			ps.setString(5, String.valueOf(um));
			ps.executeUpdate();
		} catch (Exception e) {
			JFrame jf = new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf, e);
		}

		ImageIcon icon = new ImageIcon(getClass().getResource("done.png"));
		JOptionPane.showMessageDialog(null,
				"<html><b style =\"color: black; font-size: 12px\">Saved Successfully</b></html>", "Done",
				JOptionPane.INFORMATION_MESSAGE, icon);

	}

}
