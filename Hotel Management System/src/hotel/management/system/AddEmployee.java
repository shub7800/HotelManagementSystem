package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField tfname,tfphone,tfage,tfsalary,tfemail,tfaadhar;
    JRadioButton rbmale,rbfemale;
    JButton submit;
    JComboBox cbjob;
    AddEmployee(){
        setLayout(null);
        
        JLabel heading=new JLabel("Add Emplyee");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(350,7,200,20);
        add(heading);
        //name
        JLabel lblname=new JLabel("NAME");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);
        
        //age
        JLabel lblage=new JLabel("AGE");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblage);
        
        tfage=new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);
        
        //gender
        JLabel lblgender=new JLabel("GENDER");
        lblgender.setBounds(60,130,120,30);//set the posion 
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblgender);
        
        //JRadioButton -is use to create a radio button
        rbmale=new JRadioButton("Male");
        rbmale.setBounds(200,130,100,30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(280,130,80,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        //group karte dono button ko using ButtonGroup
        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        
        JLabel lbljob=new JLabel("JOB");
        lbljob.setBounds(60,180,120,30);//set the posion 
        lbljob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbljob);
        
        //JCombo box is use for dropdown
        String str[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
        cbjob = new JComboBox(str);
        cbjob.setBackground(Color.WHITE);
        cbjob.setBounds(200,180,150,30);
        add(cbjob);

        JLabel lblsalary= new JLabel("SALARY");
        lblsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblsalary.setBounds(60, 230, 120, 30);
        add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230, 150, 30);
        add(tfsalary);

        JLabel lblphone = new JLabel("PHONE");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblphone.setBounds(60, 280, 120, 30);
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200, 280, 150, 30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("EMAIL");
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblemail.setBounds(60, 330, 120, 30);
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);
        
        JLabel lblaadhar = new JLabel("AADHAR");
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblaadhar.setBounds(60, 380, 120, 30);
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(200, 380, 150, 30);
        add(tfaadhar);
	
        submit=new JButton("SUBMIT");
        submit.setBounds(200,430,150,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        //image
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(450, 450,Image.SCALE_DEFAULT);//scale
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,60,450,370);//crop bhi kar sakte hai
        add(image);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,540);
        setVisible(true); 
    }
    
    public void actionPerformed(ActionEvent ae){
        String name=tfname.getText();
        String age=tfage.getText();
        String salary=tfsalary.getText();
        String phone=tfphone.getText();
        String email=tfemail.getText();
        String aadhar=tfaadhar.getText();
        String gender=null;
        
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Name should not be empty");
            return;
        }
        if(age.equals("")){
            JOptionPane.showMessageDialog(null, "Age should not be empty");
            return;
        }
        if(phone.equals("")){
            JOptionPane.showMessageDialog(null, "phone should not be empty");
            return;
        }
        if (email.equals("")) {
            JOptionPane.showMessageDialog(null, "Email should not be empty");
            return;
        } else if (!email.contains("@") || !email.endsWith(".com")) {
            JOptionPane.showMessageDialog(null, "Invalid email format. Email must contain '@' and end with '.com'");
            return;
        }
        if(aadhar.equals("")){
            JOptionPane.showMessageDialog(null, "aadhar should not be empty");
            return;
        }
        if(rbmale.isSelected()){
            gender="Male";
        }else if(rbfemale.isSelected()){
            gender="Female";
        }
        //note  login main ddl commond ka use kiya tha quary main se data ko nikala tha 
        String job=(String)cbjob.getSelectedItem();//yaha se pta chlega konsa item select hua hai 
        try{
            //1step jb koi databasse ka kaam ho toh conn class object bna lo
            //2step quary
            Conn conn=new Conn();
            String query="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
            conn.s.executeUpdate(query);//data update kar rhe hai
            
            JOptionPane.showMessageDialog(null, "Employee added successfully");
            setVisible(false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    } 
    public static void main(String []args){
        new AddEmployee();
    }
           
    
}
