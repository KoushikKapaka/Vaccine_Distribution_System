package mainUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

class CVDetailsPanelUI extends JFrame implements ActionListener {

	String date = "2021-12-11";
	JTextField tname, tmno, tadr, ta, fdov;
	JLabel r, dov;
	public String pass="Koushik@808";//Enter your database password here
	JButton sub;
	String fd = "", sd = "";
	JCheckBox y, n;

	CVDetailsPanelUI() {
		super("Vaccine Distribution System");
		setSize(435, 431);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		Container c = super.getContentPane();
		c.setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		JLabel j = new JLabel("Enter your details :");
		j.setFont(new Font("Arial", Font.PLAIN, 25));
		j.setBounds(100, 15, 240, 25);
		c.add(j);

		JLabel name = new JLabel("Name");
		name.setFont(new Font("Arial", Font.PLAIN, 20));
		name.setBounds(35, 70, 100, 25);
		c.add(name);

		tname = new JTextField();
		tname.setFont(new Font("Arial", Font.PLAIN, 15));
		tname.setBounds(210, 70, 190, 25);
		c.add(tname);

		JLabel mno = new JLabel("Mobile Number");
		mno.setFont(new Font("Arial", Font.PLAIN, 20));
		mno.setBounds(35, 110, 150, 25);
		c.add(mno);

		tmno = new JTextField();
		tmno.setFont(new Font("Arial", Font.PLAIN, 15));
		tmno.setBounds(210, 110, 190, 25);
		c.add(tmno);

		JLabel adrn = new JLabel("Aadhaar Number");
		adrn.setFont(new Font("Arial", Font.PLAIN, 20));
		adrn.setBounds(35, 150, 150, 25);
		c.add(adrn);

		tadr = new JTextField();
		tadr.setFont(new Font("Arial", Font.PLAIN, 15));
		tadr.setBounds(210, 150, 190, 25);
		c.add(tadr);

		JLabel a = new JLabel("Age");
		a.setFont(new Font("Arial", Font.PLAIN, 20));
		a.setBounds(35, 190, 100, 25);
		c.add(a);

		ta = new JTextField();
		ta.setFont(new Font("Arial", Font.PLAIN, 15));
		ta.setBounds(210, 190, 100, 25);
		c.add(ta);

		JLabel dv = new JLabel("1st Dose Vaccinated");
		dv.setFont(new Font("Arial", Font.PLAIN, 18));
		dv.setBounds(35, 230, 180, 25);
		c.add(dv);

		y = new JCheckBox("Yes");
		n = new JCheckBox("No");
		y.setBounds(210, 230, 55, 25);
		n.setBounds(265, 230, 100, 25);
		y.addActionListener(this);
		n.addActionListener(this);
		c.add(y);
		c.add(n);

		r = new JLabel("");
		r.setEnabled(false);
		c.add(r);
		JLabel hint1 = new JLabel("If 1st vacination is done");
		hint1.setFont(new Font("Arial", Font.PLAIN, 10));
		c.add(hint1);
		
		dov = new JLabel("Date of 1st Vaccination");
		dov.setFont(new Font("Arial", Font.BOLD, 16));
		dov.setBounds(35, 270, 185, 25);
		c.add(dov);
		
		fdov = new JTextField();
		fdov.setFont(new Font("Arial", Font.PLAIN, 15));
		fdov.setBounds(210, 270, 190, 25);
		c.add(fdov);

		JLabel hint2 = new JLabel("Input format is 'yyyy-mm-dd'");
		hint2.setFont(new Font("Arial", Font.PLAIN, 10));
		hint2.setBounds(210, 290, 185, 25);
		c.add(hint2);

		/*
		 * d = new JComboBox (dates); m = new JComboBox (months); ye = new JComboBox
		 * (years); d.setBounds (215, 270, 60, 25); m.setBounds (280, 270, 60, 25);
		 * ye.setBounds (345, 270, 60, 25); d.addActionListener(new ActionListener() {
		 * public void actionPerformed(ActionEvent a) { fda=Integer.parseInt((String)
		 * d.getSelectedItem()); } }); m.addActionListener(new ActionListener() { public
		 * void actionPerformed(ActionEvent a) { fm=Integer.parseInt((String)
		 * m.getSelectedItem()); } }); ye.addActionListener(new ActionListener() {
		 * public void actionPerformed(ActionEvent a) { fy=Integer.parseInt((String)
		 * ye.getSelectedItem()); } }); c.add(d); c.add(m); c.add(ye);
		 */
		if (y.isSelected()) {
			n.setEnabled(false);
		}
		if (n.isSelected()) {
			y.setEnabled(false);
		}

		sub = new JButton("Submit");
		sub.setFont(new Font("Arial", Font.PLAIN, 15));
		sub.setBounds(155, 330, 130, 50);
		sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tname.getText();
				String dofv = fdov.getText();
				String num = tmno.getText();
				int len = num.length();
				String adrno=tadr.getText();
				int age = Integer.parseInt(ta.getText());
				if (len != 10) {
					JOptionPane.showMessageDialog(sub, "Enter a valid mobile number");
				}
				if (age < 18) {
					JOptionPane.showMessageDialog(sub, "You are not eligible for vaccination");
					System.exit(0);
				}
				if (adrno.length() < 12) {
					JOptionPane.showMessageDialog(sub, "Enter a valid aadhaar number");
				}
				if (y.isSelected()) {
					Date dof = Date.valueOf(dofv);
					fd = "YES";
					sd = "YES";
					Date dos = new Date(Calendar.getInstance().getTime().getTime());
					DateFormat df = new SimpleDateFormat("dd MM yyyy");
					String s1 = df.format(dof);
					String s2 = df.format(dos);
					long nod = 0;
					try {
						java.util.Date date1 = df.parse(s1);
						java.util.Date date2 = df.parse(s2);
						long nood;
						nood = Math.abs(date2.getTime() - date1.getTime());
						nod = TimeUnit.DAYS.convert(nood, TimeUnit.MILLISECONDS);
					} catch (ParseException u) {
						u.printStackTrace();
					}

					if (nod >= 28) {
						try {
							
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vds",
									"root", pass);

							String query = "INSERT INTO cvdata values('" + name + "','" + num + "','" + adrno + "','"
									+ age + "','" + fd + "','" + dof + "','" + sd + "','" + dos + "')";

							Statement sta = connection.createStatement();
							sta.executeUpdate(query);
							JOptionPane.showMessageDialog(sub, "You are eligible for vaccination");
							connection.close();
						} catch (Exception exception) {
							exception.printStackTrace();
						}
					} else {
						long l = 28 - nod;
						JOptionPane.showMessageDialog(sub,
								"You are not eligibile for vaccination" + "\nCome again after" + l + "days");
						System.exit(0);
					}
				}
				if (n.isSelected()) {
					fd = "YES";
					sd = "NO";
					Date dof = new Date(Calendar.getInstance().getTime().getTime());
					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vds",
								"root",pass);

						String query = "INSERT INTO cvdata values('" + name + "','" + num + "','" + adrno + "','" + age
								+ "','" + fd + "','" + dof + "','" + sd + "',NULL)";

						Statement sta = connection.createStatement();
						sta.executeUpdate(query);
						
							JOptionPane.showMessageDialog(sub, "You are eligible for vaccination");
						
						connection.close();
					} catch (Exception exception) {
						exception.printStackTrace();
					}
				}
				new FinalUI();
			}
		});
		c.add(sub);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

	}

}