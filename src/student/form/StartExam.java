package student.form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import database.ConnectionProvider;
import swing.component.PanelShadow;

public class StartExam extends JPanel {

	private JLabel examDuration;
	private JLabel header;
	private JLabel hrField;
	private JTextArea instructions;
	private JScrollPane jScrollPane2;
	private JSeparator jSeparator1;
	private JLabel minField;
	private JLabel numQue;
	private PanelShadow panelShadow1;
	private JLabel secField;
	private JButton startExam;
	private JLabel totalQueField;

	public String rollNo;
	public int count;

	public StartExam() {
		initComponents();
		setOpaque(false);

		try {
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select *from examinfo");
			while (rs.next()) {
				hrField.setText("" + rs.getInt("limithr"));
				minField.setText(": " + rs.getInt("limitmin"));
				secField.setText(": " + rs.getInt("limitsec"));
			}
			rs.close();
			ResultSet rsk = st.executeQuery("select *from question");
			while (rsk.next()) {
				count++;
			}
			totalQueField.setText("" + count);
			rsk.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public StartExam(String rollNo1) {
		initComponents();
		instructions.setEditable(false);
		rollNo = rollNo1;
	}

	private void initComponents() {

		panelShadow1 = new PanelShadow();
		examDuration = new JLabel();
		header = new JLabel();
		jSeparator1 = new JSeparator();
		startExam = new JButton();
		numQue = new JLabel();
		minField = new JLabel();
		hrField = new JLabel();
		secField = new JLabel();
		totalQueField = new JLabel();
		jScrollPane2 = new JScrollPane();
		instructions = new JTextArea();

		setBackground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(1117, 615));

		panelShadow1.setBackground(new Color(255, 255, 255));
		panelShadow1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panelShadow1.setPreferredSize(new Dimension(1117, 651));

		examDuration.setFont(new Font("Segoe UI", 0, 20));
		examDuration.setForeground(new Color(0, 0, 0));
		examDuration.setText("Exam Duration : ");

		header.setFont(new Font("Century", 1, 30));
		header.setText("INSTRUCTIONS");

		startExam.setBackground(new Color(255, 255, 255));
		startExam.setFont(new Font("Arial", 1, 22));
		startExam.setForeground(new Color(0, 0, 0));
		startExam.setText("Start Exam");
		startExam.setFocusPainted(false);
		startExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				startExamActionPerformed(evt);
			}
		});

		numQue.setFont(new Font("Segoe UI", 0, 20));
		numQue.setForeground(new Color(0, 0, 0));
		numQue.setText("Number Of Questions :");

		minField.setBackground(new Color(255, 255, 255));
		minField.setFont(new Font("Segoe UI", 1, 18));
		minField.setForeground(new Color(255, 0, 0));
		minField.setText(": 00");

		hrField.setBackground(new Color(255, 255, 255));
		hrField.setFont(new Font("Segoe UI", 1, 18));
		hrField.setForeground(new Color(255, 0, 0));
		hrField.setText("00");

		secField.setFont(new Font("Segoe UI", 1, 18));
		secField.setForeground(new Color(255, 0, 0));
		secField.setText(": 00");

		totalQueField.setFont(new Font("Segoe UI", 1, 18));
		totalQueField.setForeground(new Color(255, 0, 0));
		totalQueField.setText("00");

		instructions.setEditable(false);
		instructions.setColumns(20);
		instructions.setFont(new Font("Segoe UI", 0, 20));
		instructions.setRows(5);
		instructions.setText(
				"During the exam :\n\n   1)  The student may not use his or her TextBook , Course notes , or recieve help from a invigilator or any \n        other outside source.\n\n   2) Students must complete all the multiple choice questions within given time frame alloted for \n       the exam.\n\n   3) Students must not stop the session and then return to it. This is especially important in the online\n        environment where the system will \" Time Out\" and not allow the student to re-enter the exam.             ");
		jScrollPane2.setViewportView(instructions);

		GroupLayout panelShadow1Layout = new GroupLayout(panelShadow1);
		panelShadow1.setLayout(panelShadow1Layout);
		panelShadow1Layout.setHorizontalGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelShadow1Layout.createSequentialGroup().addComponent(header)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(panelShadow1Layout.createSequentialGroup().addContainerGap()
						.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jSeparator1).addComponent(jScrollPane2)))
				.addGroup(panelShadow1Layout.createSequentialGroup().addGroup(panelShadow1Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(panelShadow1Layout.createSequentialGroup().addGap(180, 180, 180)
								.addComponent(numQue, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(totalQueField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addGap(173, 173, 173).addComponent(examDuration)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(hrField)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(minField)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(secField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addGroup(panelShadow1Layout.createSequentialGroup().addGap(438, 438, 438)
								.addComponent(startExam)))
						.addGap(0, 222, Short.MAX_VALUE)));
		panelShadow1Layout.setVerticalGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelShadow1Layout.createSequentialGroup().addComponent(header)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
						.addGap(60, 60, 60)
						.addGroup(panelShadow1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(examDuration, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(hrField).addComponent(minField).addComponent(secField)
								.addComponent(numQue, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(totalQueField))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
						.addComponent(startExam).addGap(29, 29, 29)));

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(panelShadow1,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panelShadow1, GroupLayout.PREFERRED_SIZE, 617, GroupLayout.PREFERRED_SIZE)
								.addGap(129, 129, 129)));
	}

	private void startExamActionPerformed(ActionEvent evt) {
		setVisible(false);
		new StudentExam(rollNo).setVisible(true);

	}

}
