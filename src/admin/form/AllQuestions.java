package admin.form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import database.ConnectionProvider;
import net.proteanit.sql.DbUtils;
import swing.component.PanelShadow;
import table.TableCustom;

public class AllQuestions extends JPanel {

	private JLabel header;
	private JScrollPane jScrollPane1;
	private JSeparator jSeparator2;
	private PanelShadow panelShadow1;
	private JTable queTable;

	public AllQuestions() {
		initComponents();
		setOpaque(false);
		init();
		try {
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select id,name,opt1,opt2,opt3,opt4,answer from question order by id");
			TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
			queTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			queTable.setModel(DbUtils.resultSetToTableModel(rs));
			queTable.setEnabled(false);
			rs.close();

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
		jScrollPane1 = new JScrollPane();
		queTable = new JTable();

		setBackground(new Color(64, 123, 255));
		setPreferredSize(new Dimension(996, 540));

		panelShadow1.setBackground(new Color(64, 123, 255));
		panelShadow1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panelShadow1.setPreferredSize(new Dimension(996, 514));

		header.setFont(new Font("Segoe UI", 0, 24));
		header.setText("All Questions");

		queTable.setModel(
				new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		queTable.setSelectionBackground(new Color(102, 102, 102));
		jScrollPane1.setViewportView(queTable);

		GroupLayout panelShadow1Layout = new GroupLayout(panelShadow1);
		panelShadow1.setLayout(panelShadow1Layout);
		panelShadow1Layout.setHorizontalGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jSeparator2)
				.addGroup(panelShadow1Layout.createSequentialGroup().addContainerGap()
						.addComponent(header, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 956,
						Short.MAX_VALUE));
		panelShadow1Layout.setVerticalGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelShadow1Layout.createSequentialGroup().addContainerGap().addComponent(header)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(panelShadow1,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(26, 26, 26).addComponent(panelShadow1,
						GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)));
	}

}
