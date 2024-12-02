package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {
    
    JComboBox cbid;
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    JRadioButton rbmale,rbfemale;   
    Choice croom; 
    JLabel checkintime;
    JButton add, back;
    
    AddCustomer(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("NEW CUSTOMER FORM");
        text.setFont(new Font("Raleway",Font.BOLD,18));
        text.setBounds(100,20,300,30);
        add(text);
        
        JLabel lblid=new JLabel("ID");
        lblid.setFont(new Font("Raleway",Font.BOLD,18));
        lblid.setBounds(35,80,100,20);
        add(lblid);
        
        String idOption[] = {"Aadhar Card","Passport","Driving Licens","Voter-id Card","Ration Card"};
        cbid = new JComboBox(idOption);
        cbid.setBackground(Color.WHITE);
        cbid.setBounds(200,80,150,25);
        add(cbid);
        
        JLabel lblnumber=new JLabel("Number");
        lblnumber.setFont(new Font("Raleway",Font.BOLD,18));
        lblnumber.setBounds(35,120,100,20);
        add(lblnumber);
        
        tfnumber=new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);
        
        JLabel lblname=new JLabel("Name");
        lblname.setFont(new Font("Raleway",Font.BOLD,18));
        lblname.setBounds(35,160,100,20);
        add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        
        JLabel lblgender=new JLabel("Gender");
        lblgender.setFont(new Font("Raleway",Font.BOLD,18));
        lblgender.setBounds(35,200,100,20);
        add(lblgender);
        
        //JRadioButton -is use to create a radio button
        rbmale=new JRadioButton("Male");
        rbmale.setBounds(200,200,60,25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(270,200,100,25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        JLabel lblcountry=new JLabel("Country");
        lblcountry.setFont(new Font("Raleway",Font.BOLD,18));
        lblcountry.setBounds(35,240,100,20);
        add(lblcountry);
        
        tfcountry=new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);
        
        JLabel lblroom=new JLabel("Room Number");
        lblroom.setFont(new Font("Raleway",Font.BOLD,18));
        lblroom.setBounds(35,280,150,20);
        add(lblroom);
        
        croom=new Choice();
        try{
            Conn conn=new Conn();
            String query="select * from room where availability='Avilable'";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next()){//jo bhi executeQuery(query) data aaya ho usko loop kar sakte hai 
                croom.add(rs.getString("roomnumber"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        croom.setBounds(200,280,150,25);
        add(croom);
        
        
        //non editable field user cant edit 
        JLabel lbltime=new JLabel("CheckIn Time");
        lbltime.setFont(new Font("Raleway",Font.BOLD,18));
        lbltime.setBounds(35,320,150,20);
        add(lbltime);
          
        //date class object
        Date date=new Date();
       
        checkintime=new JLabel(""+date);
        checkintime.setFont(new Font("Raleway",Font.BOLD,16));
        checkintime.setBounds(200,320,150,25);
        add(checkintime);
        
        JLabel lbldeposit=new JLabel("Deposit");
        lbldeposit.setFont(new Font("Raleway",Font.BOLD,18));
        lbldeposit.setBounds(35,360,100,20);
        add(lbldeposit);
        
        tfdeposit=new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);
        
        add=new JButton("Add");
        add.setBounds(50,410,120,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        back=new JButton("Back");
        back.setBounds(200,410,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        //image
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);//scale
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,300,400);//crop bhi kar sakte hai
        add(image);
        
        setBounds(350,200,800,550);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
            String id=(String )cbid.getSelectedItem();
            String number=tfnumber.getText();
            String name=tfname.getText();
            String gender=null;
            
            if(rbmale.isSelected()){
                gender="Male";
            }else {
                gender="Female";
            }
            
            String country=tfcountry.getText();
            String room=croom.getSelectedItem();
            String time=checkintime.getText();
            String deposit=tfdeposit.getText();
            try{
                Conn conn=new Conn();
                String query="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String query2="update room set availability = 'Occupied' where roomnumber='"+room+"'";
                conn.s.executeUpdate(query);//data update kar rhe hai
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
                setVisible(false);
                new Reception();
                
                
            }catch (Exception e){
                e.printStackTrace();
            }
            
            
        }else if(ae.getSource()== back){
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        
        new AddCustomer();
    }
    
}
