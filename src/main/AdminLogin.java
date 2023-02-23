package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import admin.main.AdminMain;
import app.bolivia.swing.JCTextField;
import rojerusan.RSPasswordTextPlaceHolder;

public class AdminLogin extends JFrame {
	private JButton back;
	private JButton header;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JButton login;
	private RSPasswordTextPlaceHolder pwdField;
	private JCheckBox showPwd;
	private JCTextField userField;

	public AdminLogin() {
		initComponents();
	}

	private void initComponents() {

		jPanel1 = new JPanel();
		header = new JButton();
		jLabel1 = new JLabel();
		jPanel2 = new JPanel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		jLabel7 = new JLabel();
		back = new JButton();
		login = new JButton();
		showPwd = new JCheckBox();
		userField = new JCTextField();
		pwdField = new RSPasswordTextPlaceHolder();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		getContentPane().setLayout(new AbsoluteLayout());

		jPanel1.setBackground(new Color(255, 255, 255));
		jPanel1.setPreferredSize(new Dimension(850, 735));

		header.setBackground(new Color(255, 255, 255));
		header.setFont(new Font("Century", 1, 23));
		header.setForeground(new Color(64, 123, 255));
		header.setText("ADMIN LOGIN");
		header.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		header.setBorderPainted(false);
		header.setFocusPainted(false);
		header.setHorizontalTextPosition(SwingConstants.CENTER);
		header.setMargin(null);

		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setIcon(new ImageIcon(getClass().getResource("/login/image/adminlogin.png")));

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 727, GroupLayout.PREFERRED_SIZE)
								.addComponent(header, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(27, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(header)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 702, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		getContentPane().add(jPanel1, new AbsoluteConstraints(0, 0, 760, -1));

		jPanel2.setBackground(new Color(64, 123, 255));
		jPanel2.setLayout(new AbsoluteLayout());

		jLabel2.setBackground(new Color(0, 0, 0));
		jLabel2.setFont(new Font("Cambria", 1, 36));
		jLabel2.setForeground(new Color(255, 255, 255));
		jLabel2.setText("Welcome !");
		jPanel2.add(jLabel2, new AbsoluteConstraints(150, 40, 180, -1));

		jLabel3.setBackground(new Color(0, 0, 0));
		jLabel3.setFont(new Font("Sanskrit Text", 1, 18));
		jLabel3.setForeground(new Color(255, 255, 255));
		jLabel3.setText("Login To Your Account");
		jPanel2.add(jLabel3, new AbsoluteConstraints(130, 110, -1, 50));

		jLabel4.setBackground(new Color(0, 0, 0));
		jLabel4.setFont(new Font("Georgia", 1, 16));
		jLabel4.setForeground(new Color(255, 255, 255));
		jLabel4.setIcon(new ImageIcon(getClass().getResource("/login/image/password.png")));
		jPanel2.add(jLabel4, new AbsoluteConstraints(80, 420, 50, 50));

		jLabel5.setBackground(new Color(64, 123, 255));
		jLabel5.setFont(new Font("Georgia", 1, 16));
		jLabel5.setForeground(new Color(255, 255, 255));
		jLabel5.setText("Password : ");
		jPanel2.add(jLabel5, new AbsoluteConstraints(140, 390, 100, 40));

		jLabel6.setBackground(new Color(64, 123, 255));
		jLabel6.setFont(new Font("Georgia", 1, 16));
		jLabel6.setForeground(new Color(255, 255, 255));
		jLabel6.setText("Username : ");
		jPanel2.add(jLabel6, new AbsoluteConstraints(140, 240, 100, 40));

		jLabel7.setBackground(new Color(0, 0, 0));
		jLabel7.setFont(new Font("Georgia", 1, 16));
		jLabel7.setForeground(new Color(255, 255, 255));
		jLabel7.setIcon(new ImageIcon(getClass().getResource("/login/image/username.png")));
		jPanel2.add(jLabel7, new AbsoluteConstraints(80, 270, 50, 50));

		back.setBackground(new Color(255, 255, 255));
		back.setFont(new Font("Georgia", 1, 18));
		back.setForeground(new Color(64, 123, 255));
		back.setText("Back");
		back.setFocusPainted(false);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				backActionPerformed(evt);
			}
		});
		jPanel2.add(back, new AbsoluteConstraints(300, 610, 120, 40));

		login.setBackground(new Color(255, 255, 255));
		login.setFont(new Font("Georgia", 1, 18));
		login.setForeground(new Color(64, 123, 255));
		login.setText("Login");
		login.setFocusPainted(false);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				loginActionPerformed(evt);
			}
		});
		jPanel2.add(login, new AbsoluteConstraints(100, 610, 120, 40));

		showPwd.setBackground(new Color(64, 123, 255));
		showPwd.setFont(new Font("Arial", 1, 12));
		showPwd.setForeground(new Color(255, 255, 255));
		showPwd.setText("Show Password");
		showPwd.setIconTextGap(7);
		showPwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				showPwdActionPerformed(evt);
			}
		});
		jPanel2.add(showPwd, new AbsoluteConstraints(130, 470, 130, 40));

		userField.setBackground(new Color(64, 123, 255));
		userField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 255, 255)));
		userField.setForeground(new Color(255, 255, 255));
		userField.setDragEnabled(true);
		userField.setFont(new Font("Segoe UI", 0, 15));
		userField.setPhColor(SystemColor.controlLtHighlight);
		userField.setPlaceholder("Enter Username");
		jPanel2.add(userField, new AbsoluteConstraints(140, 280, -1, -1));

		pwdField.setBackground(new Color(64, 123, 255));
		pwdField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 255, 255)));
		pwdField.setForeground(new Color(255, 255, 255));
		pwdField.setFont(new Font("Segoe UI", 0, 15));
		pwdField.setPhColor(new Color(255, 255, 255));
		pwdField.setPlaceholder("Enter Password");
		jPanel2.add(pwdField, new AbsoluteConstraints(140, 430, -1, -1));

		getContentPane().add(jPanel2, new AbsoluteConstraints(760, 0, 510, 740));

		pack();
		setLocationRelativeTo(null);
	}

	private void backActionPerformed(ActionEvent evt) {
		setVisible(false);
		new IndexPage().setVisible(true);
	}

	private void loginActionPerformed(ActionEvent evt) {
		if (userField.getText().equals("admin")
				&& Arrays.equals(pwdField.getPassword(), new char[] { 'a', 'd', 'm', 'i', 'n', '@', '1', '2', '3' })) {
			setVisible(false);
			new AdminMain().setVisible(true);
		} else {
			ImageIcon icon = new ImageIcon(getClass().getResource("wrongpassword.png"));
			JOptionPane.showMessageDialog(null,
					"<html><b style =\"color: red; font-size: 12px\">Incorrect Username or Password</b></html>",
					"Invalid Input", JOptionPane.INFORMATION_MESSAGE, icon);
		}
	}

	private void showPwdActionPerformed(ActionEvent evt) {
		if (showPwd.isSelected()) {
			pwdField.setEchoChar((char) 0);
		} else {
			pwdField.setEchoChar('*');
		}
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
			Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AdminLogin().setVisible(true);
			}
		});
	}

}
