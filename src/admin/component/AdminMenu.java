package admin.component;

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
import swing.component.AdminButtonMenu;
import swing.component.ImageAvatar;

public class AdminMenu extends JPanel {

	private ImageAvatar image;
	private JLabel name;
	private JPanel panelMenu;
	private JLabel role;
	private JScrollPane scroll;

	private EventMenu event;

	public AdminMenu() {
		initComponents();
		setOpaque(false);
		scroll.getViewport().setOpaque(false);
		scroll.setViewportBorder(null);
		panelMenu.setLayout(new MigLayout("wrap 2, fillx", "[center]0[center]", "[fill, 100]0[fill, 100]"));
	}

	public void initMenu(EventMenu event) {
		this.event = event;
		addMenu("1", "Add Question", 0);
		addMenu("2", "Delete Question", 1);
		addMenu("3", "Update Question", 2);
		addMenu("4", "Results", 3);
		addMenu("5", "All Questions", 4);
		addMenu("6", "Set Conditions", 5);
		addMenu("7", "Logout", 6);
	}

	private void addMenu(String icon, String text, int index) {
		AdminButtonMenu menu = new AdminButtonMenu();
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

	private void setSelected(AdminButtonMenu menu) {
		for (Component com : panelMenu.getComponents()) {
			if (com instanceof AdminButtonMenu) {
				AdminButtonMenu b = (AdminButtonMenu) com;
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
		image.setIcon(new ImageIcon(getClass().getResource("/admin/icon/adminimg.png")));

		name.setFont(new Font("sansserif", 1, 15));
		name.setForeground(new Color(237, 237, 237));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setText("Mamta Padole");

		role.setFont(new Font("sansserif", 1, 14));
		role.setForeground(new Color(200, 200, 200));
		role.setHorizontalAlignment(SwingConstants.CENTER);
		role.setText("Admin");

		scroll.setBorder(null);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		panelMenu.setOpaque(false);

		GroupLayout panelMenuLayout = new GroupLayout(panelMenu);
		panelMenu.setLayout(panelMenuLayout);
		panelMenuLayout.setHorizontalGroup(
				panelMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 218, Short.MAX_VALUE));
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
								.addComponent(scroll))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(43, 43, 43)
						.addComponent(image, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(name)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(role).addGap(30, 30, 30)
						.addComponent(scroll).addContainerGap()));
	}

}
