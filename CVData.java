package mainUI;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class CVData extends JFrame {
	Connection con;
	static JTable table;
	String[] columnNames = { "Name", "Phone", "Aadhaar no", "Age", "First Dose", "First dose date", "Second Dose", "Second dose date" };
	public String pass="Koushik@808";
	CVData() {
		super("Covaccine Data");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table = new JTable();
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		table.setFillsViewportHeight(true);

		JScrollPane scroll = new JScrollPane(table);

		scroll.setHorizontalScrollBarPolicy(

				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scroll.setVerticalScrollBarPolicy(

				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vds", "root", pass);
			String sql = "select * from cvdata";
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while(rs.next()) {

				int age = rs.getInt(4);
				String name = rs.getString(1);
				String phone = rs.getString(2);
				String adrno = rs.getString(3);
				String fd = rs.getString(5);
				String sd = rs.getString(7);
				Date dof = rs.getDate(6);
				Date dos = rs.getDate(8);
				model.addRow(new Object[] { name, phone, adrno, age, fd, dof, sd, dos });
			}			

		} catch (Exception ex) {

			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}

		add(scroll);

		setVisible(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    super.setSize(screenSize.width, screenSize.height);
		
}
}
