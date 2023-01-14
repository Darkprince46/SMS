import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class DeleteFrame extends JFrame {
Container c;
JLabel labRno;
JTextField txtRno;
JButton btnBack, btnDelete;

DeleteFrame() {
c = getContentPane();
c.setLayout(null);

JLabel labBG = new JLabel(); 					
labBG.setIcon(new ImageIcon("DelFrameBG.jpg")); 	
Dimension size = labBG.getPreferredSize(); 		
labBG.setBounds(0, 0, 1500, 800); 	

labRno = new JLabel(" Delete Roll Number  - ");
txtRno = new JTextField(10);
btnBack = new JButton("BACK");
btnDelete = new JButton("DELETE");


Font f = new Font("Bell MT", Font.BOLD, 20);
labRno.setFont(f);
txtRno.setFont(f);
btnBack.setFont(f);
btnDelete.setFont(f);


labRno.setForeground(Color.WHITE);
btnBack.setForeground(Color.WHITE);
btnBack.setBackground(Color.ORANGE);
btnDelete.setForeground(Color.WHITE);
btnDelete.setBackground(Color.ORANGE);


labRno.setBounds(400, 340, 220, 30);
txtRno.setBounds(670, 340, 200, 30);
btnBack.setBounds(520, 500, 130, 30);
btnDelete.setBounds(710, 500, 130, 30);


c.add(labRno);
c.add(txtRno);
c.add(btnBack);
c.add(btnDelete);

c.add(labBG);

ActionListener a1 = (ae) -> {
MainFrame mf = new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

ActionListener a2 = (ae) -> {

	int rno = 0;
	try {
	rno = Integer.parseInt(txtRno.getText());
		} catch (NumberFormatException e) {
		  JOptionPane.showMessageDialog(c, " Only integers are allowed ! ");
		  txtRno.setText("");
		  txtRno.requestFocus();
		  return;
		}
		if (rno <= 0) {
			JOptionPane.showMessageDialog(c, " Please enter a valid Roll Number ! ");
			txtRno.setText("");
			txtRno.requestFocus();
		} else 

try {
	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

	String url = "jdbc:mysql://localhost:3306/Project";
	String un = "root";
	String pass = "pratham@5255";
	Connection con = DriverManager.getConnection(url, un, pass);

	String sql = "Delete from student where rno = ?";
	PreparedStatement pst = con.prepareStatement(sql);
	pst.setInt(1, rno);
	int r = pst.executeUpdate();

int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete ?", "Delete?",  JOptionPane.YES_NO_OPTION);
if (reply == JOptionPane.YES_OPTION)
{
		if (r == 1) {
		    JOptionPane.showMessageDialog(c, " Deleted Successfully ! ");
			txtRno.setText("");
			txtRno.requestFocus();
		} else {
		    JOptionPane.showMessageDialog(c, " Roll Number doesn't exist ! ");
			txtRno.requestFocus();
		}
}


	con.close();
	} catch (SQLException e) {
	   JOptionPane.showMessageDialog(c, " issue = " + e);
	}
};
btnDelete.addActionListener(a2);


setTitle(" Delete detail ");
setSize(1500, 800);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);


}
}

