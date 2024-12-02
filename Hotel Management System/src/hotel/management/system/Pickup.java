package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener{
    JTable table;//it is use to crate for table 
    JButton back,submit;
    Choice typeofcar;
    JCheckBox available; 
    
    Pickup(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("PickUp Service");
        text.setBounds(400,30,200,30);
        text.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(text);
        
        JLabel lblbed=new JLabel("Type Of Car");
        lblbed.setBounds(50, 100, 100, 20);
        add(lblbed);
        
        typeofcar=new Choice();
        typeofcar.setBounds(150,100,200,25);
        add(typeofcar);
        
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from driver");
            while(rs.next()){
                typeofcar.add(rs.getString("brand"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
       
                
        JLabel l1=new JLabel("Name");
        l1.setBounds(30,160,100,20);
        add(l1);
        
        JLabel l2=new JLabel("Age");
        l2.setBounds(200,160,100,20);
        add(l2);
        
        JLabel l3=new JLabel("Gender");
        l3.setBounds(330,160,100,20);
        add(l3);
        
        JLabel l4=new JLabel("Company");
        l4.setBounds(460,160,100,20);
        add(l4);
        
        JLabel l5=new JLabel("brand");
        l5.setBounds(630,160,100,20);
        add(l5);
        
        JLabel l6=new JLabel("Available");
        l6.setBounds(740,160,100,20);
        add(l6);
        
        JLabel l7=new JLabel("Location");
        l7.setBounds(890,160,100,20);
        add(l7);
        
        table=new JTable();//table jo hota hai wo argument lete hai 1st is data and 2nd is header
        table.setBounds(0,200,1000,300);
        add(table); 
        
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        submit=new JButton("Submit");
        submit.setBounds(300,520,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        back=new JButton("Back");
        back.setBounds(500,520,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setBounds(300,200,1000,600);
        setVisible(true);
       
       
    } 
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            try{
                String query="select * from driver where brand='"+typeofcar.getSelectedItem()+"'";
                Conn conn=new Conn();
                ResultSet rs;
               
                rs=conn.s.executeQuery(query);
                
                table.setModel(DbUtils.resultSetToTableModel(rs));//jo room hoga wo search kar sakte hai 
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Reception();
        }
        
    }
    
    public static void main(String[] args){
        new Pickup();
    }
}
