package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;


public class Checkout extends JFrame implements ActionListener  {
    
    Choice ccustomerid;
    JButton checkout,back;
    JLabel lblroomnumber,lblcheckouttime,lblcheckintime;
    Checkout(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Checkout");
        text.setBounds(100,20,100,30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(text);
        
        JLabel lblid=new JLabel("Customer Id");
        lblid.setBounds(30,80,100,30);
        add(lblid);
        
        ccustomerid=new Choice();
        ccustomerid.setBounds(200,80,150,25);
        add(ccustomerid);
        
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomerid.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkintime"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        //image
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);//scale
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(370,50,400,250);//crop bhi kar sakte hai
        add(image);
        
        JLabel lblroom=new JLabel("Room Number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);
        
        lblroomnumber=new JLabel();
        lblroomnumber.setBounds(150,130,100,30);
        add(lblroomnumber);
        
        JLabel lblcheckin=new JLabel("CheckIn Time");
        lblcheckin.setBounds(30,180,100,30);
        add(lblcheckin);
        
        lblcheckintime=new JLabel();
        lblcheckintime.setBounds(150,180,100,30);
        add(lblcheckintime);
        
        JLabel lblcheckout=new JLabel("CheckOut Time");
        lblcheckout.setBounds(30,230,100,30);
        add(lblcheckout);
        
        Date date=new Date();
        lblcheckouttime=new JLabel(""+date);
        lblcheckouttime.setBounds(150,230,150,30);
        add(lblcheckouttime);
        
        checkout=new JButton("CheckOut");
        checkout.setBounds(30,280,120,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);
        
        back=new JButton("Back");
        back.setBounds(170,280,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomerid.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkintime"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        setBounds(300,200,800,400);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkout){
            String query1="delete from customer where number='"+ccustomerid.getSelectedItem()+"'";
            String query2="update room set availability='Avilable' where roomnumber ='"+lblroomnumber.getText()+"'"; 
            try{
                
                Conn conn=new Conn();
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Checkout done");
                setVisible(false);
                new Reception();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
        }else{
            setVisible(false);
            new Reception();
        }
        
    }
    
    public static void main(String[] args){
        new Checkout();
    }
}
