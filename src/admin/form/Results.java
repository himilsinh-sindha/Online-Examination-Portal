package admin.form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import database.ConnectionProvider;
import net.proteanit.sql.DbUtils;
import swing.component.PanelShadow;
import table.TableCustom;

public class Results extends JPanel {

	private JTextField filterField;
	private JLabel filterTitle;
	private JLabel header;
	private JScrollPane jScrollPane2;
	private JSeparator jSeparator2;
	private PanelShadow panelShadow1;
	private JTable resultTable;
	
	Connection con = ConnectionProvider.getCon();

	public Results() {
		initComponents();
		setOpaque(false);
		init();
		try {
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select *from student");
			TableCustom.apply(jScrollPane2, TableCustom.TableType.DEFAULT);
			resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			resultTable.setModel(DbUtils.resultSetToTableModel(rs));
			resultTable.setEnabled(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	private void init() {

	}

	private void initComponents() {

		panelShadow1 = new PanelShadow();
		header = new JLabel();
		jSeparator2 = new JSeparator();
		filterTitle = new JLabel();
		filterField = new JTextField();
		jScrollPane2 = new JScrollPane();
		resultTable = new JTable();

		setBackground(new Color(64, 123, 255));

		panelShadow1.setBackground(new Color(64, 123, 255));
		panelShadow1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		header.setFont(new Font("Segoe UI", 0, 24));
		header.setText("Results");

		filterTitle.setFont(new Font("Cambria", 1, 17));
		filterTitle.setText("Filter Students By Marks");

		filterField.setFont(new Font("Segoe UI", 0, 16));

		filterField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				filterFieldKeyReleased(evt);
			}
		});

		resultTable
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "PRN", "Title 2", "Title 3", "Title 4" }));
		resultTable.setShowGrid(false);
		jScrollPane2.setViewportView(resultTable);

		GroupLayout panelShadow1Layout = new GroupLayout(panelShadow1);
		panelShadow1.setLayout(panelShadow1Layout);
		panelShadow1Layout.setHorizontalGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jSeparator2)
				.addGroup(panelShadow1Layout.createSequentialGroup().addContainerGap().addGroup(panelShadow1Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(panelShadow1Layout.createSequentialGroup().addGroup(panelShadow1Layout
								.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(header, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
								.addGroup(panelShadow1Layout.createSequentialGroup().addGap(14, 14, 14)
										.addComponent(filterTitle, GroupLayout.PREFERRED_SIZE, 203,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18).addComponent(filterField, GroupLayout.PREFERRED_SIZE, 253,
												GroupLayout.PREFERRED_SIZE)))
								.addGap(0, 456, Short.MAX_VALUE))
						.addComponent(jScrollPane2)).addContainerGap()));
		panelShadow1Layout.setVerticalGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelShadow1Layout.createSequentialGroup().addContainerGap().addComponent(header)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
						.addGap(26, 26, 26)
						.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(filterTitle).addComponent(filterField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(16, Short.MAX_VALUE)));

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(panelShadow1,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(26, 26, 26).addComponent(panelShadow1,
						GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	}

	private void filterFieldKeyReleased(KeyEvent evt) {
		float marks;
		if (filterField.getText().equals("")) {
			marks = 0.0f;
		} else {
			marks = Float.parseFloat(filterField.getText());
		}
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select *from student where marks >=" + marks + "");
			resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			resultTable.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			JFrame jf = new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf, e);
		}
	}

}
