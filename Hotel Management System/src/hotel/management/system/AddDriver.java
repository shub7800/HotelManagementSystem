package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {
    JTextField tfname,tfage,tfcompany,tfmodel,tflocation;
    JComboBox cbgender,cbavailable;
    JButton add,cancel;
    
    AddDriver(){
        
        setLayout(null);
        
        JLabel heading=new JLabel("ADD DRIVERS");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(194,20,150,22);
        add(heading);
        
        JLabel lblroomno=new JLabel("Name");
        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblroomno.setBounds(64,70,102,22);
        add(lblroomno);
        
        tfname=new JTextField();
        tfname.setBounds(174,70,156,20);
        add(tfname);
        
        JLabel lblage=new JLabel("Age");
        lblage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblage.setBounds(64,110,102,22);
        add(lblage);
        
        tfage=new JTextField();
        tfage.setBounds(174, 110, 156, 20);
        add(tfage);
        
        JLabel lblclean=new JLabel("Gender");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblclean.setBounds(64, 150, 102, 22);
        add(lblclean);
        
        String cleanOption[] = {"Male","Female"};
        cbgender = new JComboBox(cleanOption);
        cbgender.setBackground(Color.WHITE);
        cbgender.setBounds(176, 150, 154, 20);
        add(cbgender);
        
        JLabel lblprice=new JLabel("Car Company");
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblprice.setBounds(64, 190, 102, 22);
        add(lblprice);
        
        tfcompany=new JTextField();
        tfcompany.setBounds(174, 190, 156, 20);
        add(tfcompany);
        
        JLabel lbltype=new JLabel("Car Model");
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltype.setBounds(64, 230, 102, 22);
        add(lbltype);
        
        tfmodel=new JTextField();
        tfmodel.setBounds(174, 230, 156, 20);
        add(tfmodel);
        
        JLabel lblavilable=new JLabel("Avilable");
        lblavilable.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblavilable.setBounds(64, 270, 102, 22);
        add(lblavilable);
        
        String driverOption[] = {"Avilable","Busy"};
        cbavailable = new JComboBox(driverOption);
        cbavailable.setBackground(Color.WHITE);
        cbavailable.setBounds(176, 270, 154, 20);
        add(cbavailable);
        
        JLabel lbllocation=new JLabel("Location");
        lbllocation.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbllocation.setBounds(64, 310, 102, 22);
        add(lbllocation);
        
        tflocation=new JTextField();
        tflocation.setBounds(174, 310, 156, 20);
        add(tflocation);
        
        add=new JButton("Add");
        add.setBounds(64, 380, 111, 33);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(198, 380, 111, 33);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        //image
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);//scale
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,30,500,300);//crop bhi kar sakte hai
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(300,200,980,470);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
            String name=tfname.getText();
            String age=tfage.getText();
            String gender=(String)cbgender.getSelectedItem();
            String company=tfcompany.getText();
            String brand=tfmodel.getText();
            String available=(String)cbavailable.getSelectedItem();
            String location=tflocation.getText();
            try{
                //1step jb koi databasse ka kaam ho toh conn class object bna lo
                //2step quary
                Conn conn=new Conn();
                String str="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
                conn.s.executeUpdate(str);//data update kar rhe hai

                JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
        
    } 
    
    public static void main(String[]args){
        new AddDriver();
        
    }
    
}
