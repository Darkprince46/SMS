import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainFrame extends JFrame {
Container c;
JLabel labWelcome;
JButton btnAdd, btnView, btnUpdate, btnDelete, btnExit;


MainFrame() {
c = getContentPane();
c.setLayout(null);

JLabel labBG = new JLabel(); 					
labBG.setIcon(new ImageIcon("MainFrameBG.jpg")); 	
Dimension size = labBG.getPreferredSize(); 		
labBG.setBounds(0, 0, 1500, 800); 				


labWelcome = new JLabel(" WELCOME ! ");
btnAdd = new JButton(" Add Details ");
btnView = new JButton(" View Details ");
btnUpdate = new JButton(" Update Details ");
btnDelete = new JButton(" Delete Details ");
btnExit = new JButton("EXIT");


labWelcome.setFont(new Font("Cambria", Font.BOLD, 32));
Font f = new Font("Arial", Font.BOLD, 22);
btnAdd.setFont(f);
btnView.setFont(f);
btnUpdate.setFont(f);
btnDelete.setFont(f);
btnExit.setFont(f);


btnAdd.setForeground(Color.WHITE);
btnAdd.setBackground(Color.BLUE);
btnView.setForeground(Color.WHITE);
btnView.setBackground(Color.BLUE);
btnUpdate.setForeground(Color.WHITE);
btnUpdate.setBackground(Color.BLUE);
btnDelete.setForeground(Color.WHITE);
btnDelete.setBackground(Color.BLUE);
btnExit.setForeground(Color.WHITE);
btnExit.setBackground(Color.RED);



labWelcome.setBounds(670, 80, 300, 30);
btnAdd.setBounds(640, 200, 220, 40);
btnView.setBounds(640, 280, 220, 40);
btnUpdate.setBounds(640, 360, 220, 40);
btnDelete.setBounds(640, 440, 220, 40);
btnExit.setBounds(690, 580, 120, 30);



c.add(labWelcome);


c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);
c.add(btnExit);

c.add(labBG);




ActionListener a1 = (ae) -> {
AddFrame af = new AddFrame();
dispose();
};
btnAdd.addActionListener(a1);


ActionListener a2 = (ae) -> {
ViewFrame vf = new ViewFrame();
dispose();
};
btnView.addActionListener(a2);

ActionListener a3 = (ae) -> {
DeleteFrame df = new DeleteFrame();
dispose();
};
btnDelete.addActionListener(a3);

ActionListener a4 = (ae) -> {
UpdateFrame uf = new UpdateFrame();
dispose();
};
btnUpdate.addActionListener(a4);

ActionListener a5 = (ae) -> {
int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to Exit?", " Exit ? ",  JOptionPane.YES_NO_OPTION);
if (reply == JOptionPane.YES_OPTION)
{
   System.exit(0);
}
};
btnExit.addActionListener(a5);




setTitle(" Student Management App ");
setSize(1500, 800);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}

