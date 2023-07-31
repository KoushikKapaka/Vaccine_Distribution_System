package mainUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FinalUI extends JFrame implements ActionListener{
	private JLabel j1,j2,j3,j4,j5;
	private JButton exit;
	FinalUI()
	{
		super("Vaccine Distribution System");
		setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 	
        setResizable(false);
		Container c = super.getContentPane();
		c.setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	   
		j1= new JLabel("Congratulation! you are successfully vaccinated");
		j1.setBounds (60, 45, 295, 35);
		c.add(j1);
		j2= new JLabel("There might few side effects due to vaccination ");
		j2.setBounds (60, 70, 295, 45);
		c.add(j2);
		j3= new JLabel("No worries.Everything will be fine");
		j3.setBounds (105, 100, 195, 45);
		c.add(j3);
		j4= new JLabel("Have a nice day!😊");
		j4.setBounds (140, 155, 295, 35);
		c.add(j4);
		j5= new JLabel("Stay Home, Stay Safe");
		j5.setBounds (130, 200, 195, 45);
		c.add(j5);
		exit = new JButton("EXIT");
		exit.setBounds(150,250,100,50);
		exit.setBackground(Color.lightGray);
		exit.addActionListener(this);
		c.add(exit);
		 setVisible(true);
		 c.setBackground(Color.white);
	}
	
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
