package hotel.management.system;

import javax.swing.*;// java extended package ke andar hota hai swing 
import java.awt.*;  
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {//actionListener help to ction or drag when button on click
    //swing ke jitne bhi concept hote hai wo hote hai jFrame ke andear
    HotelManagementSystem(){
        //frame ka size 
        setSize(1366,565);          // setContentPane(300,300,1366,390);   frame size
        setLocation(100,100);// to set frame open coordnaion
        setLayout(null);
        // border and grid layout 
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        //jLabel class is use to past the img in the frame 
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,1366,565);//locationx, loctiony,length,breadth
        //it is to set the layout by the user
        add(image);
        
        JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,430,1000,90);
        text.setFont(new Font("serif",Font.PLAIN,50));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        //in java by defult use border layout property if you want dont use any layout you use null
        
        JButton next=new JButton("Next");
        next.setBounds(1150,450,150,50);
        next.setBackground(Color.WHITE);
        next.addActionListener(this);//ye btata hai ki kon se jaghe par action chahiye 
        next.setFont(new Font("serif",Font.PLAIN,24));
        next.setForeground(Color.BLACK);
        image.add(next);
        
        setVisible(true);//setVisible(true) are use to see the frame b/c it is unvisible bydefult
    
        while(true){
            text.setVisible(false); // lid =  j label
            try{
                Thread.sleep(500); //1000 = 1 second
            }catch(Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500); //1000 = 1 second
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
}
