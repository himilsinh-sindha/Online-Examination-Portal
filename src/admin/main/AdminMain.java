package admin.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import admin.component.AdminMenu;
import admin.form.AddQuestions;
import admin.form.AllQuestions;
import admin.form.DeleteQuestions;
import admin.form.Results;
import admin.form.SetConditions;
import admin.form.UpdateQuestions;
import event.EventMenu;
import main.AdminLogin;
import swing.component.PanelBackground;
import swing.component.ScrollBarCustom;

public class AdminMain extends JFrame {

	private JPanel body;
	private JButton exit;
	private AdminMenu menu;
	private PanelBackground panelBackground1;
	private JScrollPane scroll;

	public AdminMain() {
		initComponents();
		setBackground(new Color(0, 0, 0, 0));
		EventMenu eventMenu = new EventMenu() {
			@Override
			public void selected(int index) {
				switch (index) {
				case 0:
					showForm(new AddQuestions());
					break;
				case 1:
					showForm(new DeleteQuestions());
					break;
				case 2:
					showForm(new UpdateQuestions());
					break;
				case 3:
					showForm(new Results());
					break;
				case 4:
					showForm(new AllQuestions());
					break;
				case 5:
					showForm(new SetConditions());
					break;
				case 6:
					int a = JOptionPane.showConfirmDialog(null, "Do You Really Want To Logout ?", "LOGOUT",
							JOptionPane.YES_NO_OPTION);
					if (a == 0) {
						setVisible(false);
						new AdminLogin().setVisible(true);
					}
					break;

				default:
					break;
				}
			}
		};
		menu.initMenu(eventMenu);
		scroll.setVerticalScrollBar(new ScrollBarCustom());
		scroll.getViewport().setOpaque(false);
		scroll.setViewportBorder(null);
		showForm(new AddQuestions());
	}

	private void showForm(Component com) {
		body.removeAll();
		body.add(com);
		body.revalidate();
		body.repaint();
	}

	private void initComponents() {

		panelBackground1 = new PanelBackground();
		menu = new AdminMenu();
		scroll = new JScrollPane();
		body = new JPanel();
		exit = new JButton();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);

		scroll.setBorder(null);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		body.setOpaque(false);
		body.setLayout(new BorderLayout());
		scroll.setViewportView(body);

		exit.setIcon(new ImageIcon(getClass().getResource("/admin/icon/close.png")));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				exitActionPerformed(evt);
			}
		});

		GroupLayout panelBackground1Layout = new GroupLayout(panelBackground1);
		panelBackground1.setLayout(panelBackground1Layout);
		panelBackground1Layout.setHorizontalGroup(panelBackground1Layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelBackground1Layout.createSequentialGroup().addContainerGap()
						.addComponent(
								menu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelBackground1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 1158, Short.MAX_VALUE)
								.addGroup(panelBackground1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(exit, GroupLayout.PREFERRED_SIZE, 37,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		panelBackground1Layout.setVerticalGroup(panelBackground1Layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelBackground1Layout.createSequentialGroup().addContainerGap()
						.addGroup(panelBackground1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(menu, GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
								.addGroup(panelBackground1Layout.createSequentialGroup()
										.addComponent(exit, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18).addComponent(scroll)))
						.addContainerGap()));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(panelBackground1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(panelBackground1,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

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

	public static void main(String args[]) {

		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(AdminMain.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(AdminMain.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(AdminMain.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(AdminMain.class.getName()).log(Level.SEVERE, null, ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AdminMain().setVisible(true);
			}
		});
	}

}
