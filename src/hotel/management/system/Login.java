package hotel.management.system;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    
    JTextField username;
    JPasswordField password;//JPasswordField is use to hide the password 
    JButton login,cancel;
    
    Login(){
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        //label
        JLabel user=new JLabel("Username");
        user.setBounds(40,20,100,30);
        add(user);
        
        //box 
        username=new JTextField();
        username.setBounds(150,20,150,30);
        add(username);
         
        JLabel pass=new JLabel("PassWord");
        pass.setBounds(40,70,100,30);
        add(pass);
        
        password=new JPasswordField();
        password.setBounds(150,70,150,30);
        add(password);
        
        login=new JButton("Next");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(180,150,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        //for image 
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);
        
        
        setBounds(500,200,600,300); 
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            String user = username.getText();
            String pass = password.getText();
            try{
            Conn c = new Conn();
            
            String query = "select * from login where username= '"+user+"' and password= '"+pass+"'";//ddl commond 
            //query ko execute karna ke liye 
            ResultSet rs = c.s.executeQuery(query); 
            if(rs.next()){ //next function check karega ki data set aaya kya hai 
                new Dashboard().setVisible(true);
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");//pop for invalid 
                setVisible(false);
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==cancel){
            System.exit(0);
        }
    }
    public static void main (String[] args){
        new Login();
    }
}
