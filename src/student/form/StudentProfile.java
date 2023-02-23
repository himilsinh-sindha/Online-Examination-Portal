package student.form;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import database.ConnectionProvider;
import swing.component.PanelShadow;

public class StudentProfile extends JPanel {

	private JLabel address;
	private JTextField addressField;
	private JLabel contactNo;
	private JTextField contactNoField;
	private JLabel email;
	private JTextField emailField;
	private JLabel fatherName;
	private JTextField fatherNameField;
	private JLabel gender;
	private JTextField genderField;
	private JLabel header;
	private JSeparator jSeparator2;
	private JLabel motherName;
	private JTextField motherNameField;
	private JLabel name;
	private JTextField nameField;
	private PanelShadow panelShadow1;
	private JLabel prn;
	private JTextField prnField;
	private JLabel rollNo;
	private JTextField rollNoField;

	public StudentProfile() {
		initComponents();
		setOpaque(false);
		init();
		try {
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select *from student where PRN=8021075144");
			if (rs.next()) {
				prnField.setText(rs.getString(1));
				rollNoField.setText(rs.getString(2));
				nameField.setText(rs.getString(3));
				fatherNameField.setText(rs.getString(5));
				motherNameField.setText(rs.getString(6));
				genderField.setText(rs.getString(7));
				contactNoField.setText(rs.getString(8));
				emailField.setText(rs.getString(9));
				addressField.setText(rs.getString(10));
				rollNoField.setEditable(false);
				nameField.setEditable(false);
				fatherNameField.setEditable(false);
				motherNameField.setEditable(false);
				genderField.setEditable(false);
				contactNoField.setEditable(false);
				emailField.setEditable(false);
				addressField.setEditable(false);
				prnField.setEditable(false);
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
		rollNo = new JLabel();
		name = new JLabel();
		gender = new JLabel();
		contactNo = new JLabel();
		email = new JLabel();
		motherName = new JLabel();
		fatherName = new JLabel();
		nameField = new JTextField();
		fatherNameField = new JTextField();
		motherNameField = new JTextField();
		genderField = new JTextField();
		contactNoField = new JTextField();
		emailField = new JTextField();
		jSeparator2 = new JSeparator();
		rollNoField = new JTextField();
		address = new JLabel();
		addressField = new JTextField();
		prn = new JLabel();
		prnField = new JTextField();

		setBackground(new Color(64, 123, 255));

		panelShadow1.setBackground(new Color(64, 123, 255));
		panelShadow1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		header.setFont(new Font("Segoe UI", 0, 24));
		header.setText("Student Profile");

		rollNo.setFont(new Font("Segoe UI", 0, 16));
		rollNo.setText("Roll Number :");

		name.setFont(new Font("Segoe UI", 0, 16));
		name.setText("Name :");

		gender.setFont(new Font("Segoe UI", 0, 16));
		gender.setText("Gender :");

		contactNo.setFont(new Font("Segoe UI", 0, 16));
		contactNo.setText("Contact Number :");

		email.setFont(new Font("Segoe UI", 0, 16));
		email.setText("Email :");

		motherName.setFont(new Font("Segoe UI", 0, 16));
		motherName.setText("Mother's Name :");

		fatherName.setFont(new Font("Segoe UI", 0, 16));
		fatherName.setText("Father's Name :");

		nameField.setFont(new Font("Segoe UI", 1, 14));

		fatherNameField.setFont(new Font("Segoe UI", 1, 14));

		motherNameField.setFont(new Font("Segoe UI", 1, 14));

		genderField.setFont(new Font("Segoe UI", 1, 14));

		contactNoField.setFont(new Font("Segoe UI", 1, 14));

		emailField.setFont(new Font("Segoe UI", 1, 14));

		rollNoField.setFont(new Font("Segoe UI", 1, 14));

		address.setFont(new Font("Segoe UI", 0, 16));
		address.setText("Address :");

		addressField.setFont(new Font("Segoe UI", 1, 14));

		prn.setFont(new Font("Segoe UI", 0, 16));
		prn.setText("PRN :");

		prnField.setFont(new Font("Segoe UI", 1, 14));

		GroupLayout panelShadow1Layout = new GroupLayout(panelShadow1);
		panelShadow1.setLayout(panelShadow1Layout);
		panelShadow1Layout.setHorizontalGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jSeparator2)
				.addGroup(panelShadow1Layout.createSequentialGroup().addGroup(panelShadow1Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(panelShadow1Layout.createSequentialGroup().addContainerGap().addComponent(header,
								GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
						.addGroup(panelShadow1Layout.createSequentialGroup().addGroup(panelShadow1Layout
								.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(panelShadow1Layout.createSequentialGroup().addGap(200, 200, 200)
										.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addComponent(prn).addComponent(rollNo).addComponent(name)
												.addComponent(fatherName)))
								.addGroup(GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
										.addContainerGap()
										.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(gender, GroupLayout.Alignment.TRAILING)
												.addComponent(motherName, GroupLayout.Alignment.TRAILING)
												.addComponent(email, GroupLayout.Alignment.TRAILING)
												.addComponent(contactNo, GroupLayout.Alignment.TRAILING)
												.addComponent(address, GroupLayout.Alignment.TRAILING))))
								.addGap(30, 30, 30)
								.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(addressField, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
										.addComponent(prnField, GroupLayout.PREFERRED_SIZE, 408,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(rollNoField, GroupLayout.PREFERRED_SIZE, 408,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(nameField).addComponent(fatherNameField)
										.addComponent(motherNameField).addComponent(genderField)
										.addComponent(contactNoField).addComponent(emailField))))
						.addContainerGap(299, Short.MAX_VALUE)));
		panelShadow1Layout
				.setVerticalGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(panelShadow1Layout.createSequentialGroup().addContainerGap().addComponent(header)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
								.addGap(31, 31, 31)
								.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(prnField, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(prn))
								.addGap(18, 18, 18)
								.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(rollNoField, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(rollNo))
								.addGap(18, 18, 18)
								.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(name))
								.addGap(18, 18, 18)
								.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(fatherNameField, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(fatherName))
								.addGap(18, 18, 18)
								.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(motherNameField, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(motherName))
								.addGap(18, 18, 18)
								.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(genderField, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(gender))
								.addGap(18, 18, 18)
								.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(contactNoField, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(contactNo))
								.addGap(18, 18, 18)
								.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(emailField, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(email))
								.addGap(18, 18, 18)
								.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(addressField, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(address))
								.addContainerGap(71, Short.MAX_VALUE)));

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(panelShadow1,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(14, Short.MAX_VALUE).addComponent(panelShadow1,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(29, 29, 29)));
	}

}
