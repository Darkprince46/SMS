import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class ViewFrame extends JFrame {
Container c;
JLabel labData;
TextArea taData;
JButton btnBack, btnEdit;


ViewFrame() {
c = getContentPane();
c.setLayout(null);

JLabel labBG = new JLabel(); 					//JLabel Creation
labBG.setIcon(new ImageIcon("ViewFrameBG.png")); 	//Sets the image to be displayed as an icon
Dimension size = labBG.getPreferredSize(); 		//Gets the size of the image
labBG.setBounds(0, 0, 1500, 800); 				//Sets the location of the image



labData = new JLabel(" Saved Details    - ");
taData = new TextArea(20, 45);
btnBack = new JButton(" BACK ");
btnEdit = new JButton(" EDIT ");

Font f = new Font("Bell MT", Font.BOLD, 20);
labData.setFont(f);
btnBack.setFont(f);
btnEdit.setFont(f);
taData.setFont(new Font("Bell MT", Font.BOLD, 15));


labData.setForeground(Color.WHITE);
btnBack.setForeground(Color.WHITE);
btnBack.setBackground(Color.BLUE);
btnEdit.setForeground(Color.WHITE);
btnEdit.setBackground(Color.BLUE);

labData.setBounds(260, 50, 190, 30);
taData.setBounds(500, 40, 310, 500); 
btnBack.setBounds(490, 580, 130, 40);
btnEdit.setBounds(680, 580, 130, 40);

StringBuffer data = new StringBuffer();
try {
	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

	String url = "jdbc:mysql://localhost:3306/project";
	String un = "root";
	String pass = "pratham@5255";
	Connection con = DriverManager.getConnection(url, un, pass);

	String sql = "select * from student";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	while(rs.next()) {
		int rno = rs.getInt(1);
		String name = rs.getString(2);
		String graduation = rs.getString(3);
		String skill = rs.getString(4);
		data.append(" Roll No - " + rno + "\n" + " Name - " + name + "\n" + " Graduation Status - " + graduation + "\n" + " Skills - " + skill + "\n" + "\n");
		}
	taData.setText(data.toString());

	con.close();
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(c, " issue - " + e);
	}
		

c.add(labData);
c.add(taData);
c.add(btnBack);
c.add(btnEdit);

c.add(labBG);

ActionListener a1 = (ae) -> {
MainFrame mf = new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

ActionListener a2 = (ae) -> {
UpdateFrame uf = new UpdateFrame();
dispose();
};
btnEdit.addActionListener(a2);




setTitle(" Saved Details ");
setSize(1500, 800);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}