package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {
    JTextField tfroom,tfprice;
    JComboBox cbavilable,cbclean,cbbed;
    JButton add,cancel;
    
    AddRooms(){
        
        setLayout(null);
        
        JLabel heading=new JLabel("ADD ROOMS");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);
        
        JLabel lblroomno=new JLabel("Room Number");
        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblroomno.setBounds(60,80,120,30);
        add(lblroomno);
        
        tfroom=new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);
        
        JLabel lblavilable=new JLabel("Available");
        lblavilable.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblavilable.setBounds(60,130,120,30);
        add(lblavilable);
        
        String avilableOption[] = {"Avilable","Occupied"};
        cbavilable = new JComboBox(avilableOption);
        cbavilable.setBackground(Color.WHITE);
        cbavilable.setBounds(200,130,150,30);
        add(cbavilable);
        
        JLabel lblclean=new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblclean.setBounds(60,180,120,30);
        add(lblclean);
        
        String cleanOption[] = {"Cleaned","Dirty"};
        cbclean = new JComboBox(cleanOption);
        cbclean.setBackground(Color.WHITE);
        cbclean.setBounds(200,180,150,30);
        add(cbclean);
        
        JLabel lblprice=new JLabel("Price");
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblprice.setBounds(60,230,120,30);
        add(lblprice);
        
        tfprice=new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);
        
        JLabel lbltype=new JLabel("Bed Type");
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltype.setBounds(60,280,120,30);
        add(lbltype);
        
        String bedOption[] = {"Single Bed","Double bed"};
        cbbed = new JComboBox(bedOption);
        cbbed.setBackground(Color.WHITE);
        cbbed.setBounds(200,280,150,30);
        add(cbbed);
        
        add=new JButton("Add Room");
        add.setBounds(60,350,130,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(220,350,130,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        //image
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        //Image i2=i1.getImage().getScaledInstance(450, 450,Image.SCALE_DEFAULT);//scale
        //ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i1);
        image.setBounds(400,30,500,300);//crop bhi kar sakte hai
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(330,200,940,470);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
            String roomnumber=tfroom.getText();
            String price=tfprice.getText();
            String availability=(String)cbavilable.getSelectedItem();
            String cleaning_status=(String)cbclean.getSelectedItem();
            String bed_type=(String)cbbed.getSelectedItem();
            try{
                //1step jb koi databasse ka kaam ho toh conn class object bna lo
                //2step quary
                Conn conn=new Conn();
                String str="insert into room values('"+roomnumber+"','"+availability+"','"+cleaning_status+"','"+price+"','"+bed_type+"')";
                conn.s.executeUpdate(str);//data update kar rhe hai

                JOptionPane.showMessageDialog(null, "New Room Added Successfully");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
        
    } 
    
    public static void main(String[]args){
        new AddRooms();
        
    }
    
}
