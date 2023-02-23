package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DebugGraphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class IndexPage extends JFrame {

	private JButton admin;
	private JButton exit;
	private JLabel jLabel3;
	private JButton student;

	public IndexPage() {
		initComponents();
	}

	private void initComponents() {

		exit = new JButton();
		admin = new JButton();
		student = new JButton();
		jLabel3 = new JLabel();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setForeground(Color.white);
		setUndecorated(true);
		getContentPane().setLayout(new AbsoluteLayout());

		exit.setBackground(new Color(255, 255, 255));
		exit.setFont(new Font("Arial", 1, 18));
		exit.setIcon(new ImageIcon(getClass().getResource("/login/image/close.png")));
		exit.setBorder(null);
		exit.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		exit.setDefaultCapable(false);
		exit.setFocusPainted(false);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				exitActionPerformed(evt);
			}
		});
		getContentPane().add(exit, new AbsoluteConstraints(1230, 10, 30, 30));

		admin.setBackground(new Color(0, 0, 0));
		admin.setFont(new Font("Century", 1, 28));
		admin.setForeground(new Color(64, 123, 255));
		admin.setText("Admin");
		admin.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(64, 123, 255)));
		admin.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		admin.setFocusPainted(false);
		admin.setMaximumSize(new Dimension(119, 39));
		admin.setMinimumSize(new Dimension(119, 39));
		admin.setPreferredSize(new Dimension(119, 39));
		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				adminActionPerformed(evt);
			}
		});
		getContentPane().add(admin, new AbsoluteConstraints(290, 520, 195, -1));

		student.setBackground(new Color(0, 0, 0));
		student.setFont(new Font("Century", 1, 28));
		student.setForeground(new Color(64, 123, 255));
		student.setText("Student");
		student.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(64, 123, 255)));
		student.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		student.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		student.setFocusPainted(false);
		student.setName("");
		student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				studentActionPerformed(evt);
			}
		});
		getContentPane().add(student, new AbsoluteConstraints(740, 520, 194, -1));

		jLabel3.setIcon(new ImageIcon(getClass().getResource("/login/image/indexbg.jpg")));
		getContentPane().add(jLabel3, new AbsoluteConstraints(0, 0, -1, -1));

		pack();
		setLocationRelativeTo(null);
	}

	private void exitActionPerformed(ActionEvent evt) {
		int a = JOptionPane.showConfirmDialog(null, "Do You Really Want To Exit Application ?", "EXIT",
				JOptionPane.YES_NO_OPTION);
		if (a == 0) {
			System.exit(0);
		}
	}

	private void adminActionPerformed(ActionEvent evt) {
		setVisible(false);
		new AdminLogin().setVisible(true);
	}

	private void studentActionPerformed(ActionEvent evt) {
		setVisible(false);
		new StudentLogin().setVisible(true);
	}

	public static void main(String args[]) {

		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(IndexPage.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(IndexPage.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(IndexPage.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(IndexPage.class.getName()).log(Level.SEVERE, null, ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new IndexPage().setVisible(true);
			}
		});
	}
}
