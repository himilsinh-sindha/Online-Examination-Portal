package student.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import event.EventMenu;
import net.miginfocom.swing.MigLayout;
import swing.component.ImageAvatar;
import swing.component.StudentButtonMenu;

public class StudentMenu extends JPanel {

	private ImageAvatar image;
	private JLabel name;
	private JPanel panelMenu;
	private JLabel role;
	private JScrollPane scroll;

	private EventMenu event;

	public StudentMenu() {
		initComponents();
		setOpaque(false);
		scroll.getViewport().setOpaque(false);
		scroll.setViewportBorder(null);
		panelMenu.setLayout(new MigLayout("wrap 1, fillx", "[center]0[center]", "[fill, 100]0[fill, 100]"));
	}

	public void initMenu(EventMenu event) {
		this.event = event;
		addMenu("1", "Profile", 0);
		addMenu("2", "Start Exam", 1);
		addMenu("3", "Logout", 2);
	}

	private void addMenu(String icon, String text, int index) {
		StudentButtonMenu menu = new StudentButtonMenu();
		menu.setIconName(icon);
		menu.setText(text);
		if (index == 0) {
			menu.setSelected(true);
		}
		menu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				event.selected(index);
				setSelected(menu);
			}
		});
		panelMenu.add(menu, " w 110");
	}

	private void setSelected(StudentButtonMenu menu) {
		for (Component com : panelMenu.getComponents()) {
			if (com instanceof StudentButtonMenu) {
				StudentButtonMenu b = (StudentButtonMenu) com;
				b.setSelected(false);
			}
		}
		menu.setSelected(true);
	}

	private void initComponents() {

		image = new ImageAvatar();
		name = new JLabel();
		role = new JLabel();
		scroll = new JScrollPane();
		panelMenu = new JPanel();

		image.setForeground(new Color(240, 240, 240));
		image.setBorderSize(3);
		image.setIcon(new ImageIcon(getClass().getResource("/student/icon/studentimg.png")));

		name.setFont(new Font("sansserif", 1, 15));
		name.setForeground(new Color(237, 237, 237));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setText("Rohit Sharma");

		role.setFont(new Font("sansserif", 1, 14));
		role.setForeground(new Color(200, 200, 200));
		role.setHorizontalAlignment(SwingConstants.CENTER);
		role.setText("Student");

		scroll.setBorder(null);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		panelMenu.setOpaque(false);

		GroupLayout panelMenuLayout = new GroupLayout(panelMenu);
		panelMenu.setLayout(panelMenuLayout);
		panelMenuLayout.setHorizontalGroup(
				panelMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 198, Short.MAX_VALUE));
		panelMenuLayout.setVerticalGroup(
				panelMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 377, Short.MAX_VALUE));

		scroll.setViewportView(panelMenu);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(image, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(name, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(role, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(43, 43, 43)
						.addComponent(image, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(name)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(role).addGap(30, 30, 30)
						.addComponent(scroll).addContainerGap()));
	}

}
