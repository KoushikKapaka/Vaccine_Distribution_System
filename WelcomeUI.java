package mainUI;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class WelcomeUI extends JFrame implements ActionListener{

	private JLabel j1,j2;
	private JButton b1,b2;
	JMenu menu,dov;
	JMenuItem cv,cs; 
	WelcomeUI()
	{
		super("Vaccine Distribution System");
		Container c = super.getContentPane();
		
		b1 = new JButton ("Covaccine");
        b2 = new JButton ("Covishield");
        j1 = new JLabel ("Welcome to Vaccination Center");
        j2 = new JLabel ("Select your preffered Vaccine:");
        
          JMenuBar mb=new JMenuBar();  
          menu=new JMenu("Menu"); 
        dov=new JMenu("Data of vaccinations"); 
        cv=new JMenuItem("Covaccine Data");
        cs=new JMenuItem("Covishield Data");
        cv.addActionListener(this);
        cs.addActionListener(this);
        dov.add(cv);
        dov.add(cs);
        menu.add(dov);
        mb.add(menu);
        setJMenuBar(mb);
        setSize(400,398);
        setLayout (null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    	j1.setFont(new Font("Verdana", Font.BOLD, 16));
    	j2.setFont(new Font("Arial",Font.PLAIN,18));
    	b1.addActionListener(this);
    	b2.addActionListener(this);
        add (b1);
        add (b2);
        add (j1);
        add (j2);
        b1.setBounds (110, 150, 170, 50);
        b2.setBounds (110, 215, 170, 50);
        j1.setBounds (50, 15, 300, 30);
        j2.setBounds (40, 85, 295, 30);
        setVisible(true);
        c.setBackground(Color.white);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{
			new CVDetailsPanelUI();
		}
		if(e.getSource()==b2)
		{
			new CSDetailsUI();
		}
		if(e.getSource()==cv)
		{
			new CVData();
		}
		if(e.getSource()==cs)
		{
			new CSData();
		}
	}
}
