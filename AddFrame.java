import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class AddFrame extends JFrame {
Container c;
JLabel labRno, labName, labGraduation, labSkill; 
JTextField txtRno, txtName;
JRadioButton rbCompleted, rbPursuing;
JCheckBox cbPython, cbJava, cbJavaScript, cbML;
JButton btnBack, btnSave;



AddFrame() {
c = getContentPane();
c.setLayout(null);


JLabel labBG = new JLabel(); 					//JLabel Creation
labBG.setIcon(new ImageIcon("AddFrameBG.jpg")); 	//Sets the image to be displayed as an icon
Dimension size = labBG.getPreferredSize(); 		//Gets the size of the image
labBG.setBounds(0, 0, 1500, 800); 				//Sets the location of the image



labRno = new JLabel("Student Roll No  - ");
txtRno = new JTextField(10);
labName = new JLabel("Student Name    - ");
txtName = new JTextField(20);
labGraduation = new JLabel(" Graduation Status   - ");
rbCompleted = new JRadioButton(" Completed ",true);
rbPursuing = new JRadioButton(" Pursuing ");
labSkill = new JLabel(" Skills Known   - ");
cbPython = new JCheckBox("Python",true);
cbJava = new JCheckBox(" Java");
cbJavaScript = new JCheckBox(" JavaScript");
cbML = new JCheckBox(" ML");

btnBack = new JButton(" BACK ");
btnSave = new JButton(" SAVE ");

        


Font f = new Font("Bell MT", Font.BOLD, 25);
labRno.setFont(f);
txtRno.setFont(f);
labName.setFont(f);
txtName.setFont(f);
labGraduation.setFont(f);
rbCompleted.setFont(f);
rbPursuing.setFont(f);
labSkill.setFont(f);
cbPython.setFont(f);
cbJava.setFont(f);
cbJavaScript.setFont(f);
cbML.setFont(f);
btnBack.setFont(f);
btnSave.setFont(f);


labRno.setBounds(490, 60, 300, 30);
txtRno.setBounds(750, 60, 250, 30);
labName.setBounds(490, 130, 300, 30);
txtName.setBounds(750, 130, 250, 30);

labGraduation.setBounds(490, 210, 300, 35);
rbCompleted.setBounds(520, 270, 180, 40);
rbPursuing.setBounds(880, 270, 150, 40);

labSkill.setBounds(490, 350, 300, 35);
cbPython.setBounds(520, 400, 150, 30);
cbJava.setBounds(880, 400, 80, 30);
cbJavaScript.setBounds(520, 450, 180, 30);
cbML.setBounds(880, 450, 70, 30);

btnBack.setBounds(550, 620, 150, 40);
btnSave.setBounds(800, 622, 150, 40);



labRno.setForeground(Color.WHITE);
labName.setForeground(Color.WHITE);
labGraduation.setForeground(Color.WHITE);
labSkill.setForeground(Color.WHITE);


btnSave.setForeground(Color.WHITE);
btnSave.setBackground(Color.ORANGE);
btnBack.setForeground(Color.WHITE);
btnBack.setBackground(Color.ORANGE);

rbCompleted.setForeground(Color.WHITE);
rbCompleted.setOpaque(false);				// to make the background of button Transparent
rbPursuing.setForeground(Color.WHITE);
rbPursuing.setOpaque(false);

cbPython.setForeground(Color.WHITE);
cbPython.setOpaque(false);
cbJava.setForeground(Color.WHITE);
cbJava.setOpaque(false);
cbJavaScript.setForeground(Color.WHITE);
cbJavaScript.setOpaque(false);
cbML.setForeground(Color.WHITE);
cbML.setOpaque(false);



ButtonGroup bg = new ButtonGroup();
bg.add(rbCompleted);
bg.add(rbPursuing);


c.add(labRno);
c.add(txtRno);
c.add(labName);
c.add(txtName);
c.add(labGraduation);
c.add(rbCompleted);
c.add(rbPursuing);
c.add(labSkill);
c.add(cbPython);
c.add(cbJava);
c.add(cbJavaScript);
c.add(cbML);
c.add(btnSave);
c.add(btnBack);

c.add(labBG);

ActionListener a1 = (ae) -> {
MainFrame mf = new MainFrame();
dispose();
};
btnBack.addActionListener(a1);


ActionListener a2 = (ae) -> {

	  int rno = 0; String name = "";

	try {
	rno = Integer.parseInt(txtRno.getText());	
		if ((rno <= 0) | (rno >= 100))
			throw new Exception(" Please enter valid Roll Number ! ");
		} catch (NumberFormatException e) {
	  	  JOptionPane.showMessageDialog(c, " Only integers are allowed in Roll Number ! ");
	  	  txtRno.setText("");
		  txtRno.requestFocus();
		  return;
	  	} catch (Exception e1) {
	  	  JOptionPane.showMessageDialog(c, e1.getMessage());
		  txtRno.setText("");
		  txtRno.requestFocus();
	  	  return;
	  	}		
	

	try {
	name = txtName.getText();
		if (! (name.matches("[a-zA-Z ]+")))
			throw new Exception(" Please enter a valid Name ! ");
		} catch (Exception e) {
		  JOptionPane.showMessageDialog(c, e.getMessage());
		  txtName.setText("");
		  txtName.requestFocus();
		  return;
		}
	

		String graduation = "";
	if (bg.getSelection() == null) 
		{
		JOptionPane.showMessageDialog(c, " Please Select Graduation Status ! " );
		return; 
		}
	else 	
		{
		if (rbCompleted.isSelected())
			graduation = "COMPLETED";
		else 
			graduation = "PURSUING";
		}
		 

		String skill = "";
		if (cbPython.isSelected())		skill = skill + "Python ";
		if (cbJava.isSelected())		skill = skill + "Java ";
		if (cbJavaScript.isSelected())	skill = skill + "JavaScript ";
		if (cbML.isSelected()) 			skill = skill + "ML ";
		if (skill == "")				skill = skill + " NOT MENTIONED ";
		
	

try {
	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	
	String url = "jdbc:mysql://localhost:3306/project";
	String un = "root";
	String pass = "pratham@5255";
	Connection con = DriverManager.getConnection(url, un, pass);
	 

	String sql = "insert into student values(?, ?, ?, ?)";
	PreparedStatement pst = con.prepareStatement(sql);
	pst.setInt(1, rno);
	pst.setString(2, name);
	pst.setString(3, graduation);
	pst.setString(4, skill);
	pst.executeUpdate();
	JOptionPane.showMessageDialog(c, " Details Saved Successfully ! ");
	txtRno.setText("");
	txtName.setText("");
	txtRno.requestFocus();
		
	con.close();
	} catch (SQLIntegrityConstraintViolationException e) {
		JOptionPane.showMessageDialog(c, " Roll Number already exists ! ");
		txtRno.setText("");
		txtRno.requestFocus();
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(c, "issue = " + e);
	}

};
btnSave.addActionListener(a2);


setTitle(" Add Detail ");
setSize(1500, 800);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}

