package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
    JButton newCustomer,rooms,department,allEmployee,managers,customers;
    JButton searchRoom,updateCheckStatus,updateRoomStatus,pickupService,
            checkOut,logOut;
    Reception(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10, 30, 200, 30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.addActionListener(this);
        add(newCustomer);
        
        rooms = new JButton("Rooms");
        rooms.setBounds(10, 70, 200, 30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);
        
        department = new JButton("Department");
        department.setBounds(10, 110, 200, 30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);
        
        allEmployee = new JButton("All Employese");
        allEmployee.setBounds(10, 150, 200, 30);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        allEmployee.addActionListener(this);
        add(allEmployee);
        
        customers = new JButton("Customer Info");
        customers.setBounds(10, 190, 200, 30);
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.WHITE);
        customers.addActionListener(this);
        add(customers);
        
        managers = new JButton("Manager Info");
        managers.setBounds(10, 230, 200, 30);
        managers.setBackground(Color.BLACK);
        managers.setForeground(Color.WHITE);
        managers.addActionListener(this);
        add(managers);
        
        checkOut = new JButton("Check Out");
        checkOut.setBounds(10, 270, 200, 30);
        checkOut.setBackground(Color.BLACK);
        checkOut.setForeground(Color.WHITE);
        checkOut.addActionListener(this);
        add(checkOut);
        
        updateCheckStatus= new JButton("Update Status");
        updateCheckStatus.setBounds(10, 310, 200, 30);
        updateCheckStatus.setBackground(Color.BLACK);
        updateCheckStatus.setForeground(Color.WHITE);
        updateCheckStatus.addActionListener(this);
        add(updateCheckStatus);
        
        updateRoomStatus = new JButton("Update Room Status");
        updateRoomStatus.setBounds(10, 350, 200, 30);
        updateRoomStatus.setBackground(Color.BLACK);
        updateRoomStatus.setForeground(Color.WHITE);
        updateRoomStatus.addActionListener(this);
        add(updateRoomStatus);
        
        pickupService = new JButton("Pickup Service");
        pickupService.setBounds(10, 390, 200, 30);
        pickupService.setBackground(Color.BLACK);
        pickupService.setForeground(Color.WHITE);
        pickupService.addActionListener(this);
        add(pickupService);
        
        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10, 430, 200, 30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.addActionListener(this);
        add(searchRoom);
        
        logOut = new JButton("Log Out");
        logOut.setBounds(10, 470, 200, 30);
        logOut.setBackground(Color.BLACK);
        logOut.setForeground(Color.WHITE);
        logOut.addActionListener(this);
        add(logOut);
        
        //image
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(250,30,500,470);//crop bhi kar sakte hai
        add(image);
        
        setBounds(350,200,800,570);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== newCustomer){
            setVisible(false);
            new AddCustomer();
        }else if(ae.getSource()== rooms){
            setVisible(false);
            new Room();
        }else if(ae.getSource()== department){
            setVisible(false);
            new Department();
        }else if(ae.getSource()== allEmployee){
            setVisible(false);
            new EmployeeInfo();
        }else if(ae.getSource()== managers){
            setVisible(false);
            new ManagerInfo();
        }else if(ae.getSource()== customers){
            setVisible(false);
            new CustomerInfo();
        }else if(ae.getSource()== searchRoom){
            setVisible(false);
            new SearchRoom();
        }else if(ae.getSource()== updateCheckStatus){
            setVisible(false);
            new UpdateCheck();
        }else if(ae.getSource()== updateRoomStatus){
            setVisible(false);
            new UpdateRoom();
        }else if(ae.getSource()== pickupService){
            setVisible(false);
            new Pickup();
        }else if(ae.getSource()== checkOut){
            setVisible(false);
            new Checkout();
        }else if(ae.getSource()==logOut ){
            setVisible(false);
            System.exit(0);
        }
    }
    public static void main(String[] args){
       new Reception(); 
    }
}
