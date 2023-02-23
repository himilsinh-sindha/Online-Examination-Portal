package admin.form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import database.ConnectionProvider;
import swing.component.PanelShadow;

public class DeleteQuestions extends JPanel {

	private JLabel ans;
	private JTextField ansField;
	private JButton clear;
	private JButton delete;
	private JLabel header;
	private JTextField idField;
	private JSeparator jSeparator2;
	private JLabel opt1;
	private JTextField opt1Field;
	private JLabel opt2;
	private JTextField opt2Field;
	private JLabel opt3;
	private JTextField opt3Field;
	private JLabel opt4;
	private JTextField opt4Field;
	private PanelShadow panelShadow1;
	private JLabel qId;
	private JLabel que;
	private JTextField queField;
	private JButton search;
	
	Connection con = ConnectionProvider.getCon();

	public DeleteQuestions() {
		initComponents();
		setOpaque(false);
		init();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select count(id) from question");
			if (rs.next()) {
				int id = rs.getInt(1);
				id += 1;
				String str = String.valueOf(id);
				idField.setText(str);
				rs.close();
			} else {
				idField.setText("1");
			}
		} catch (Exception e) {
			JFrame jf = new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf, e);
		}
	}

	private void init() {

	}

	private void initComponents() {

		panelShadow1 = new PanelShadow();
		header = new JLabel();
		qId = new JLabel();
		que = new JLabel();
		opt3 = new JLabel();
		opt4 = new JLabel();
		ans = new JLabel();
		opt2 = new JLabel();
		opt1 = new JLabel();
		queField = new JTextField();
		opt1Field = new JTextField();
		opt2Field = new JTextField();
		opt3Field = new JTextField();
		opt4Field = new JTextField();
		ansField = new JTextField();
		delete = new JButton();
		clear = new JButton();
		jSeparator2 = new JSeparator();
		idField = new JTextField();
		search = new JButton();

		setBackground(new Color(64, 123, 255));
		setPreferredSize(new Dimension(996, 540));

		panelShadow1.setBackground(new Color(64, 123, 255));
		panelShadow1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		header.setFont(new Font("Segoe UI", 0, 24));
		header.setText("Delete Question");

		qId.setFont(new Font("Segoe UI", 0, 16));
		qId.setText("Question ID : ");

		que.setFont(new Font("Segoe UI", 0, 16));
		que.setText("Question : ");

		opt3.setFont(new Font("Segoe UI", 0, 16));
		opt3.setText("Option 3 : ");

		opt4.setFont(new Font("Segoe UI", 0, 16));
		opt4.setText("Option 4 : ");

		ans.setFont(new Font("Segoe UI", 0, 16));
		ans.setText("Answer    : ");

		opt2.setFont(new Font("Segoe UI", 0, 16));
		opt2.setText("Option 2 :");

		opt1.setFont(new Font("Segoe UI", 0, 16));
		opt1.setText("Option 1 : ");

		delete.setBackground(new Color(255, 255, 255));
		delete.setFont(new Font("Arial", 1, 22));
		delete.setForeground(new Color(0, 0, 0));
		delete.setText("Delete");
		delete.setFocusPainted(false);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				deleteActionPerformed(evt);
			}
		});

		clear.setBackground(new Color(255, 255, 255));
		clear.setFont(new Font("Arial", 1, 22));
		clear.setForeground(new Color(0, 0, 0));
		clear.setText("Clear");
		clear.setFocusPainted(false);
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				clearActionPerformed(evt);
			}
		});

		idField.setFont(new Font("Segoe UI", 1, 16));
		idField.setForeground(new Color(255, 0, 51));

		search.setBackground(new Color(255, 255, 255));
		search.setFont(new Font("Arial", 1, 20));
		search.setForeground(new Color(0, 0, 0));
		search.setText("Search");
		search.setFocusPainted(false);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				searchActionPerformed(evt);
			}
		});

		GroupLayout panelShadow1Layout = new GroupLayout(panelShadow1);
		panelShadow1.setLayout(panelShadow1Layout);
		panelShadow1Layout.setHorizontalGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jSeparator2)
				.addGroup(GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(panelShadow1Layout.createSequentialGroup().addComponent(opt3)
										.addGap(18, 18, 18).addComponent(opt3Field, GroupLayout.PREFERRED_SIZE, 773,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(panelShadow1Layout.createSequentialGroup().addComponent(opt4)
										.addGap(18, 18, 18).addComponent(opt4Field, GroupLayout.PREFERRED_SIZE, 773,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(panelShadow1Layout.createSequentialGroup().addComponent(ans)
										.addGap(18, 18, 18).addComponent(ansField, GroupLayout.PREFERRED_SIZE, 773,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(panelShadow1Layout.createSequentialGroup()
										.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(opt1).addComponent(opt2))
										.addGap(18, 18, 18)
										.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(opt2Field, GroupLayout.PREFERRED_SIZE, 773,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(opt1Field, GroupLayout.PREFERRED_SIZE, 773,
														GroupLayout.PREFERRED_SIZE)))
								.addGroup(panelShadow1Layout.createSequentialGroup().addComponent(qId)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(idField, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE)
										.addGap(28, 28, 28).addComponent(search))
								.addGroup(panelShadow1Layout.createSequentialGroup().addComponent(que)
										.addGap(18, 18, 18).addComponent(queField, GroupLayout.PREFERRED_SIZE, 773,
												GroupLayout.PREFERRED_SIZE)))
						.addGap(84, 84, 84))
				.addGroup(panelShadow1Layout.createSequentialGroup()
						.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(panelShadow1Layout.createSequentialGroup().addContainerGap().addComponent(
										header, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
								.addGroup(panelShadow1Layout.createSequentialGroup().addGap(217, 217, 217)
										.addComponent(delete, GroupLayout.PREFERRED_SIZE, 120,
												GroupLayout.PREFERRED_SIZE)
										.addGap(124, 124, 124).addComponent(clear, GroupLayout.PREFERRED_SIZE, 120,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelShadow1Layout
				.setVerticalGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(panelShadow1Layout.createSequentialGroup().addContainerGap().addComponent(header)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
								.addGap(16, 16, 16)
								.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(qId)
										.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(search))
								.addGap(20, 20, 20)
								.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(que).addComponent(queField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(20, 20, 20)
								.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(opt1).addComponent(opt1Field, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(20, 20, 20)
								.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(opt2).addComponent(opt2Field, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(20, 20, 20)
								.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(opt3).addComponent(opt3Field, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(20, 20, 20)
								.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(opt4).addComponent(opt4Field, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(23, 23, 23)
								.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(ans).addComponent(ansField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(41, 41, 41)
								.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(clear).addComponent(delete))
								.addContainerGap(39, Short.MAX_VALUE)));

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(panelShadow1,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(26, 26, 26).addComponent(panelShadow1,
						GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
	}

	private void deleteActionPerformed(ActionEvent evt) {

		String id = idField.getText();
		int temp = Integer.parseInt(id);
		int sample;
		try {
			PreparedStatement ps = con.prepareStatement("delete from question where id=?");
			ps.setString(1, id);
			ps.executeUpdate();
			PreparedStatement kp;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select *from question where id>=" + (temp + 1));
			while (rs.next()) {
				sample = temp + 1;
				kp = con.prepareStatement("update question set id=" + temp + " where id=" + sample);
				kp.executeUpdate();
				temp++;
			}
			
			rs.close();
			JFrame jf = new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf, "Succesfully deleted");
			setVisible(false);
			new DeleteQuestions().setVisible(true);

		} catch (Exception e) {
			JFrame jf = new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf, e);
		}

	}

	private void clearActionPerformed(ActionEvent evt) {
		idField.setText("");
		queField.setText("");
		opt1Field.setText("");
		opt2Field.setText("");
		opt3Field.setText("");
		opt4Field.setText("");
		ansField.setText("");
		idField.setEditable(true);
	}

	private void searchActionPerformed(ActionEvent evt) {

		String id = idField.getText();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select *from question where id='" + id + "'");
			if (rs.next()) {
				queField.setText(rs.getString(2));
				opt1Field.setText(rs.getString(3));
				opt2Field.setText(rs.getString(4));
				opt3Field.setText(rs.getString(5));
				opt4Field.setText(rs.getString(6));
				ansField.setText(rs.getString(7));
				idField.setEditable(false);
			} else {
				JFrame jf = new JFrame();
				jf.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(jf, "Question Id does not Exist");
			}
			
			rs.close();
		} catch (Exception e) {
			JFrame jf = new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf, e);
		}
	}

}
