package student.form;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import database.ConnectionProvider;
import rojeru_san.RSLabelFecha;

public class StudentExam extends JFrame {

	private JLabel date;
	private RSLabelFecha dateField;
	private JLabel header;
	private JLabel hrField;
	private JLabel jLabel21;
	private JLabel jLabel22;
	private JLabel jLabel23;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JPanel jPanel3;
	private JLabel minField;
	private JLabel name;
	private JLabel nameField;
	private JButton next;
	private JButton previous;
	private JLabel prn;
	private JLabel prnField;
	private JLabel queName;
	private JLabel queNo;
	private JLabel queNoField;
	private JRadioButton rButton1;
	private JRadioButton rButton2;
	private JRadioButton rButton3;
	private JRadioButton rButton4;
	private JLabel rollNo;
	private JLabel rollNoField;
	private JLabel secField;
	private JButton submit;
	private JLabel tHrField;
	private JLabel tMinField;
	private JLabel tSecField;
	private JLabel timeTaken;
	private JLabel totalQue;
	private JLabel totalQueField;
	private JLabel totalTime;

	public int id = 1;
	public String answer;
	public int count = 0;
	public int min = 0;
	public int sec = 0;
	public int hr = 0;
	public int marks = 0;
	public int ch = 0;
	public int op = 0;
	public int limitsec;
	public int limitmin;
	public int limithr;
	public int um;
	
	Connection con = ConnectionProvider.getCon();

	public void beforeAnswerCheck() {
		if (id == 2) {
			previous.setVisible(false);
		} else {
			previous.setVisible(true);
		}
		next.setVisible(true);

		try {
			Statement st = con.createStatement();
			ResultSet rsl = st.executeQuery("select * from question where id=" + id);
			while (rsl.next()) {
				ch = rsl.getInt("ch");
			}
		} catch (Exception e) {
		}

		String studentAnswer = "";
		if (rButton1.isSelected()) {
			studentAnswer = rButton1.getText();
			op = 1;
		} else if (rButton2.isSelected()) {
			studentAnswer = rButton2.getText();
			op = 2;
		} else if (rButton3.isSelected()) {
			studentAnswer = rButton3.getText();
			op = 3;
		} else if (rButton4.isSelected()) {
			studentAnswer = rButton4.getText();
			op = 4;
		} else {
			op = 0;
			studentAnswer = "";
		}

		if (studentAnswer.equals(answer)) {
			if (ch != 1) {
				marks = marks + um;
				ch = 1;
				try {
					PreparedStatement st = con.prepareStatement("update question set ch=? where id=?");
					st.setInt(1, ch);
					st.setInt(2, id);
					st.executeUpdate();
				} catch (Exception e) {
				}
			}
		} else {
			if (ch == 1) {
				marks = marks - um;
				ch = 0;
				try {
					PreparedStatement st = con.prepareStatement("update question set ch=? where id=?");
					st.setInt(1, ch);
					st.setInt(2, id);
					st.executeUpdate();
				} catch (Exception e) {
				}
			}
		}

		try {
			PreparedStatement st = con.prepareStatement("update question set op=? where id=?");
			st.setInt(1, op);
			st.setInt(2, id);
			st.executeUpdate();
		} catch (Exception e) {
		}

		rButton1.setSelected(false);
		rButton2.setSelected(false);
		rButton3.setSelected(false);
		rButton4.setSelected(false);

		id = id - 1;
		try {
			Statement st = con.createStatement();
			ResultSet rsl = st.executeQuery("select * from question where id=" + id);
			while (rsl.next()) {
				ch = rsl.getInt("ch");
				op = rsl.getInt("op");
			}
		} catch (Exception e) {
		}

		if (op != 0) {
			switch (op) {
			case 1:
				rButton1.setSelected(true);
				break;
			case 2:
				rButton2.setSelected(true);
				break;
			case 3:
				rButton3.setSelected(true);
				break;
			case 4:
				rButton4.setSelected(true);
				break;
			}
		}

	}

	public void answerCheck() {
		previous.setVisible(true);
		try {
			Statement st = con.createStatement();
			ResultSet rsl = st.executeQuery("select * from question where id=" + id);
			while (rsl.next()) {
				ch = rsl.getInt("ch");
				op = rsl.getInt("op");
			}
		} catch (Exception e) {
		}

		String studentAnswer = "";
		if (rButton1.isSelected()) {
			studentAnswer = rButton1.getText();
			op = 1;
		} else if (rButton2.isSelected()) {
			studentAnswer = rButton2.getText();
			op = 2;
		} else if (rButton3.isSelected()) {
			studentAnswer = rButton3.getText();
			op = 3;
		} else if (rButton4.isSelected()) {
			studentAnswer = rButton4.getText();
			op = 4;
		} else {
			op = 0;
			studentAnswer = "";
		}

		if (studentAnswer.equals(answer)) {
			if (ch != 1) {
				marks = marks + um;
				ch = 1;
				try {
					PreparedStatement st = con.prepareStatement("update question set ch=? where id=?");
					st.setInt(1, ch);
					st.setInt(2, id);
					st.executeUpdate();
				} catch (Exception e) {
				}
			}
		} else {
			if (ch == 1) {
				marks = marks - um;
				ch = 0;
				try {
					PreparedStatement st = con.prepareStatement("update question set ch=? where id=?");
					st.setInt(1, ch);
					st.setInt(2, id);
					st.executeUpdate();
				} catch (Exception e) {
				}
			}
		}

		try {
			PreparedStatement st = con.prepareStatement("update question set op=? where id=?");
			st.setInt(1, op);
			st.setInt(2, id);
			st.executeUpdate();
		} catch (Exception e) {
		}
		rButton1.setSelected(false);
		rButton2.setSelected(false);
		rButton3.setSelected(false);
		rButton4.setSelected(false);

		id = id + 1;
		try {
			Statement st = con.createStatement();
			ResultSet rsl = st.executeQuery("select * from question where id=" + id);
			while (rsl.next()) {
				op = rsl.getInt("op");
			}
		} catch (Exception e) {
		}
		if (op != 0) {
			switch (op) {
			case 1:
				rButton1.setSelected(true);
				break;
			case 2:
				rButton2.setSelected(true);
				break;
			case 3:
				rButton3.setSelected(true);
				break;
			case 4:
				rButton4.setSelected(true);
				break;
			}
		}

		if (id == count) {
			next.setVisible(false);
		} else {
			next.setVisible(true);
		}
	}

	public void question() {
		try {
			Statement st = con.createStatement();
			ResultSet rsl = st.executeQuery("select *from question where id=" + id);
			while (rsl.next()) {
				queNoField.setText(rsl.getString(1));
				queName.setText(rsl.getString(2));
				rButton1.setText(rsl.getString(3));
				rButton2.setText(rsl.getString(4));
				rButton3.setText(rsl.getString(5));
				rButton4.setText(rsl.getString(6));
				answer = rsl.getString(7);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void submit() {
		String rollNo = rollNoField.getText();
		beforeAnswerCheck();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update student set marks='" + marks + "' where rollNo='" + rollNo + "'");
			PreparedStatement ps1 = con.prepareStatement("UPDATE question SET ch=0 WHERE ch=1");
			ps1.executeUpdate();
			PreparedStatement ps2 = con.prepareStatement("UPDATE question SET op=0");
			ps2.executeUpdate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		time.stop();
		setVisible(false);

	}

	public StudentExam() {
		initComponents();

	}

	Timer time;

	public StudentExam(String rollNo) {
		initComponents();

		if (id == 1) {
			previous.setVisible(false);
		} else {
			previous.setVisible(true);
		}

		try {
			Statement st = con.createStatement();
			ResultSet rsk = st.executeQuery("select *from question");
			while (rsk.next()) {
				count++;
			}
			totalQueField.setText("" + count);
			rsk.close();
		} catch (Exception e) {
		}

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select *from examinfo where id=1");
			if (rs.next()) {
				limitsec = rs.getInt(2);
				limitmin = rs.getInt(3);
				limithr = rs.getInt(4);
				um = rs.getInt(5);
			}
			rs.close();
		} catch (Exception e) {
		}
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select *from student where PRN=8021075144");
			if (rs.next()) {
				prnField.setText(rs.getString(1));
				rollNoField.setText(rs.getString(2));
				nameField.setText(rs.getString(3));
			}
		} catch (Exception e) {
		}

		question();
		setLocationRelativeTo(this);
		time = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				hrField.setText(String.valueOf(limithr));
				minField.setText(": " + String.valueOf(limitmin));
				secField.setText(": " + String.valueOf(limitsec));

				tSecField.setText(": " + String.valueOf(sec));
				tMinField.setText(": " + String.valueOf(min));
				tHrField.setText(String.valueOf(hr));

				if (hr == limithr && min == limitmin && sec == limitsec) {

					time.stop();
					JOptionPane.showMessageDialog(null, "Exam time limit is over!!");
					answerCheck();
					submit();
				}
				sec++;
				if (sec == 60) {
					sec = 0;
					min++;

					if (min == 60) {
						min = 0;
						hr++;

					}

				}

			}
		});
		time.start();
	}

	private void initComponents() {

		jPanel1 = new JPanel();
		header = new JLabel();
		date = new JLabel();
		totalTime = new JLabel();
		timeTaken = new JLabel();
		tHrField = new JLabel();
		tMinField = new JLabel();
		tSecField = new JLabel();
		dateField = new RSLabelFecha();
		jLabel21 = new JLabel();
		jLabel22 = new JLabel();
		jLabel23 = new JLabel();
		hrField = new JLabel();
		minField = new JLabel();
		secField = new JLabel();
		jPanel2 = new JPanel();
		nameField = new JLabel();
		rollNoField = new JLabel();
		prnField = new JLabel();
		prn = new JLabel();
		name = new JLabel();
		totalQue = new JLabel();
		totalQueField = new JLabel();
		queNo = new JLabel();
		queNoField = new JLabel();
		rollNo = new JLabel();
		jPanel3 = new JPanel();
		queName = new JLabel();
		rButton1 = new JRadioButton();
		rButton2 = new JRadioButton();
		rButton3 = new JRadioButton();
		rButton4 = new JRadioButton();
		next = new JButton();
		submit = new JButton();
		previous = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBackground(new Color(255, 255, 255));
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		setForeground(Color.white);
		setUndecorated(true);
		getContentPane().setLayout(new AbsoluteLayout());

		jPanel1.setBackground(new Color(64, 123, 255));

		header.setFont(new Font("Segoe UI", 1, 38));
		header.setForeground(new Color(255, 255, 255));
		header.setText("Examination Portal");

		date.setFont(new Font("Segoe UI", 1, 18));
		date.setForeground(new Color(255, 255, 255));
		date.setText("Date :");

		totalTime.setFont(new Font("Segoe UI", 1, 19));
		totalTime.setForeground(new Color(255, 255, 255));
		totalTime.setText("Total Time :");

		timeTaken.setFont(new Font("Segoe UI", 1, 19));
		timeTaken.setForeground(new Color(255, 255, 255));
		timeTaken.setText("Time Taken : ");

		tHrField.setFont(new Font("Segoe UI", 1, 18));
		tHrField.setForeground(new Color(255, 51, 51));
		tHrField.setText("00");

		tMinField.setFont(new Font("Segoe UI", 1, 18));
		tMinField.setForeground(new Color(255, 51, 51));
		tMinField.setText(": 00");

		tSecField.setFont(new Font("Segoe UI", 1, 18));
		tSecField.setForeground(new Color(255, 51, 51));
		tSecField.setText(": 00");

		dateField.setForeground(new Color(255, 255, 255));
		dateField.setFont(new Font("Segoe UI", 1, 18));

		jLabel21.setFont(new Font("Segoe UI", 1, 18));
		jLabel21.setForeground(new Color(255, 51, 51));
		jLabel21.setText("00");

		jLabel22.setFont(new Font("Segoe UI", 1, 18));
		jLabel22.setForeground(new Color(255, 51, 51));
		jLabel22.setText(": 00");

		jLabel23.setFont(new Font("Segoe UI", 1, 18));
		jLabel23.setForeground(new Color(255, 51, 51));
		jLabel23.setText(": 00");

		hrField.setBackground(new Color(255, 255, 255));
		hrField.setFont(new Font("Segoe UI", 1, 18));
		hrField.setForeground(new Color(255, 255, 255));
		hrField.setText("00");

		minField.setBackground(new Color(255, 255, 255));
		minField.setFont(new Font("Segoe UI", 1, 18));
		minField.setForeground(new Color(255, 255, 255));
		minField.setText(": 00");

		secField.setFont(new Font("Segoe UI", 1, 18));
		secField.setForeground(new Color(255, 255, 255));
		secField.setText(": 00");

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel1Layout.createSequentialGroup().addComponent(header)
										.addGap(290, 290, 290).addComponent(date)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(dateField, GroupLayout.PREFERRED_SIZE, 103,
												GroupLayout.PREFERRED_SIZE)
										.addGap(118, 118, 118).addComponent(totalTime, GroupLayout.PREFERRED_SIZE, 112,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(timeTaken))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel21)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel22)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel23,
												GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
										.addGroup(jPanel1Layout.createSequentialGroup().addComponent(tHrField)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(tMinField)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(tSecField, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(jPanel1Layout.createSequentialGroup().addComponent(hrField)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(minField)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(secField, GroupLayout.PREFERRED_SIZE, 42,
														GroupLayout.PREFERRED_SIZE))))
						.addGap(79, 79, 79)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(64, 64, 64)
								.addGroup(jPanel1Layout
										.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(timeTaken)
										.addComponent(tHrField).addComponent(tMinField).addComponent(tSecField))
								.addGap(64, 64, 64)
								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel21).addComponent(jLabel22).addComponent(jLabel23)))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(8, 8, 8).addGroup(jPanel1Layout
								.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(dateField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(header, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(date)))))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(28, 28, 28)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(hrField).addComponent(minField).addComponent(secField))
								.addComponent(totalTime))
						.addGap(0, 0, Short.MAX_VALUE)));

		getContentPane().add(jPanel1, new AbsoluteConstraints(0, 0, 1270, 130));

		jPanel2.setBackground(new Color(64, 123, 255));
		jPanel2.setForeground(new Color(255, 255, 255));
		jPanel2.setPreferredSize(new Dimension(625, 735));

		nameField.setFont(new Font("Segoe UI", 1, 18));
		nameField.setForeground(new Color(255, 255, 255));

		rollNoField.setFont(new Font("Segoe UI", 1, 18));
		rollNoField.setForeground(new Color(255, 255, 255));

		prnField.setFont(new Font("Segoe UI", 1, 18));
		prnField.setForeground(new Color(255, 255, 255));

		prn.setFont(new Font("Segoe UI", 1, 18));
		prn.setForeground(new Color(255, 255, 255));
		prn.setText("PRN :");

		name.setFont(new Font("Segoe UI", 1, 18));
		name.setForeground(new Color(255, 255, 255));
		name.setText("Name :");

		totalQue.setFont(new Font("Segoe UI", 1, 18));
		totalQue.setForeground(new Color(255, 255, 255));
		totalQue.setText("Total Question :");

		totalQueField.setFont(new Font("Segoe UI", 1, 18));
		totalQueField.setForeground(new Color(255, 255, 255));
		totalQueField.setText("00");

		queNo.setFont(new Font("Segoe UI", 1, 18));
		queNo.setForeground(new Color(255, 255, 255));
		queNo.setText("Question Number :");

		queNoField.setFont(new Font("Segoe UI", 1, 18));
		queNoField.setForeground(new Color(255, 255, 255));
		queNoField.setText("00");

		rollNo.setFont(new Font("Segoe UI", 1, 18));
		rollNo.setForeground(new Color(255, 255, 255));
		rollNo.setText("Roll Number :");

		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(34, 34, 34).addGroup(jPanel2Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addComponent(rollNo, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(rollNoField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel2Layout.createSequentialGroup().addComponent(name).addGap(18, 18, 18)
								.addComponent(nameField, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addComponent(queNo, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(queNoField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addComponent(totalQue, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(totalQueField,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addComponent(prn, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(prnField, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(12, Short.MAX_VALUE)));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(158, 158, 158)
								.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(prn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(prnField, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(rollNo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(rollNoField, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(name, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(nameField, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(totalQue).addComponent(totalQueField))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(queNo).addComponent(queNoField))
								.addContainerGap(463, Short.MAX_VALUE)));

		getContentPane().add(jPanel2, new AbsoluteConstraints(0, 0, 270, 770));

		jPanel3.setBackground(new Color(255, 255, 255));

		queName.setBackground(new Color(255, 255, 255));
		queName.setFont(new Font("Segoe UI", 1, 24));
		queName.setText("What is Java ?");

		rButton1.setFont(new Font("Segoe UI", 1, 24));
		rButton1.setText("a");
		rButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rButton1ActionPerformed(evt);
			}
		});

		rButton2.setFont(new Font("Segoe UI", 1, 24));
		rButton2.setText("b");
		rButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rButton2ActionPerformed(evt);
			}
		});

		rButton3.setFont(new Font("Segoe UI", 1, 24));
		rButton3.setText("c");
		rButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rButton3ActionPerformed(evt);
			}
		});

		rButton4.setFont(new Font("Segoe UI", 1, 24));
		rButton4.setText("d");
		rButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rButton4ActionPerformed(evt);
			}
		});

		next.setBackground(new Color(255, 255, 255));
		next.setFont(new Font("Arial", 1, 22));
		next.setForeground(new Color(0, 0, 0));
		next.setText("Next");
		next.setFocusPainted(false);
		next.setFocusable(false);
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				nextActionPerformed(evt);
			}
		});

		submit.setBackground(new Color(255, 255, 255));
		submit.setFont(new Font("Arial", 1, 22));
		submit.setForeground(new Color(0, 0, 0));
		submit.setText("Submit");
		submit.setFocusPainted(false);
		submit.setFocusable(false);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				submitActionPerformed(evt);
			}
		});

		previous.setBackground(new Color(255, 255, 255));
		previous.setFont(new Font("Arial", 1, 22));
		previous.setForeground(new Color(0, 0, 0));
		previous.setText("Previous");
		previous.setFocusPainted(false);
		previous.setFocusable(false);
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				previousActionPerformed(evt);
			}
		});

		GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGap(106, 106, 106).addGroup(jPanel3Layout
						.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(queName, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
						.addComponent(rButton1, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
						.addComponent(rButton4, GroupLayout.PREFERRED_SIZE, 848, GroupLayout.PREFERRED_SIZE)
						.addComponent(rButton3, GroupLayout.PREFERRED_SIZE, 848, GroupLayout.PREFERRED_SIZE)
						.addComponent(rButton2, GroupLayout.PREFERRED_SIZE, 848, GroupLayout.PREFERRED_SIZE)
						.addGroup(jPanel3Layout.createSequentialGroup()
								.addComponent(previous, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addGap(88, 88, 88)
								.addComponent(next, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addGap(77, 77, 77)
								.addComponent(submit, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addGap(287, 287, 287)))
						.addContainerGap(44, Short.MAX_VALUE)));
		jPanel3Layout
				.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
								.addGap(43, 43, 43).addComponent(queName).addGap(62, 62, 62)
								.addComponent(rButton1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGap(29, 29, 29)
								.addComponent(rButton2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGap(29, 29, 29)
								.addComponent(rButton3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGap(29, 29, 29)
								.addComponent(rButton4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
								.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(next).addComponent(submit).addComponent(previous))
								.addGap(95, 95, 95)));

		getContentPane().add(jPanel3, new AbsoluteConstraints(270, 130, 1000, 640));

		setSize(new Dimension(1266, 765));
		setLocationRelativeTo(null);
	}

	private void submitActionPerformed(ActionEvent evt) {
		int a = JOptionPane.showConfirmDialog(null, "Do You Really Want To Submit", "Select",
				JOptionPane.YES_NO_OPTION);
		if (a == 0) {
			submit();
			try {
				Statement st = con.createStatement();
				st.executeUpdate("update student set marks='" + marks + "' where rollNo='45'");
				marks = 0;
				id = 1;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}

	}

	private void nextActionPerformed(ActionEvent evt) {
		answerCheck();
		question();
	}

	private void rButton4ActionPerformed(ActionEvent evt) {
		if (rButton4.isSelected()) {
			rButton1.setSelected(false);
			rButton2.setSelected(false);
			rButton3.setSelected(false);
		}
	}

	private void rButton3ActionPerformed(ActionEvent evt) {
		if (rButton3.isSelected()) {
			rButton1.setSelected(false);
			rButton2.setSelected(false);
			rButton4.setSelected(false);
		}

	}

	private void rButton2ActionPerformed(ActionEvent evt) {
		if (rButton2.isSelected()) {
			rButton1.setSelected(false);
			rButton3.setSelected(false);
			rButton4.setSelected(false);
		}
	}

	private void rButton1ActionPerformed(ActionEvent evt) {
		if (rButton1.isSelected()) {
			rButton2.setSelected(false);
			rButton3.setSelected(false);
			rButton4.setSelected(false);
		}
	}

	private void previousActionPerformed(ActionEvent evt) {
		beforeAnswerCheck();
		question();
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
			Logger.getLogger(StudentExam.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(StudentExam.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(StudentExam.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(StudentExam.class.getName()).log(Level.SEVERE, null, ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new StudentExam().setVisible(true);
			}
		});
	}

}