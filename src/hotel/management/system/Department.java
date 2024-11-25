package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener{
    JTable table;//it is use to crate for table 
    JButton back;
    
    Department(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        
        JLabel l1=new JLabel("Department");
        l1.setBounds(180,10,100,20);
        add(l1);
        
        JLabel l2=new JLabel("Budget");
        l2.setBounds(420,10,100,20);
        add(l2);
        
        
        table=new JTable();//table jo hota hai wo argument lete hai 1st is data and 2nd is header
        table.setBounds(0,50,700,350);
        add(table); 
        
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        back=new JButton("Back");
        back.setBounds(280,400,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setBounds(400,200,700,480);
        setVisible(true);
       
       
    } 
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args){
        new Department();
    }
}
