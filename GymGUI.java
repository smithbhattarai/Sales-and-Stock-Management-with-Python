//importing required package
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

public class GymGUI{
    //instance variable
    private ArrayList<GymMember>member=new ArrayList<GymMember>();
    private JLabel id,name,location,phone,email,gender,dob,membershipStartDate,referralSource,paidAmount,removalReason,trainersName,regularPlan,premiumPlan,discountAmount,plan,instruction;
    private JTextField idTxt,nameTxt,locationTxt,phoneTxt,emailTxt,referralSourceTxt,paidAmountTxt,trainersNameTxt,regularPlanTxt,premiumPlanTxt,discountAmountTxt;
    private JComboBox dobYear,dobMonth,dobDay,membershipYear,membershipMonth,membershipDate,planBox;
    private JRadioButton maleRadio,femaleRadio;
    private JButton addRegularMember,addPremiumMember,activateMembership,deactivateMembership,markAttendance,upgradePlan,calculateDiscount,revertReMember,revertPreMember,payDueAmount,display,clear,saveToFile,readFromFile;
    private JTextArea regularTxt,premiumTxt,removalReasonTxt,rInstruction,pInstruction;
    private JScrollPane regularScroll,premiumScroll;
    private JFrame frame;
    private JPanel displayMember;
    //constructor
    public GymGUI(){
        //implementation
        frame=new JFrame("24046510 Smith Bhattarai");
        frame.setSize(910,720);
        frame.setResizable(false);
        frame.setLayout(null);

        displayMember=new JPanel();
        displayMember.setBounds(10,400,910,300);
        displayMember.setLayout(null);
        regularTxt=new JTextArea();
        regularTxt.setBounds(15,20,400,240);
        regularTxt.setEditable(false);
        regularTxt.setLineWrap(true);
        regularTxt.setWrapStyleWord(true);
        regularScroll=new JScrollPane(regularTxt);
        regularScroll.setBounds(15, 20, 400, 240);
        regularScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        premiumTxt=new JTextArea();
        premiumTxt.setBounds(445,20,400,240);
        premiumTxt.setEditable(false);
        premiumTxt.setLineWrap(true);
        premiumTxt.setWrapStyleWord(true);
        premiumScroll=new JScrollPane(premiumTxt);
        premiumScroll.setBounds(445, 20, 400, 240);
        premiumScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        id=new JLabel("ID");
        id.setBounds(15,15,100,20);
        idTxt=new JTextField(20);
        idTxt.setBounds(125,15,180,20);
        name=new JLabel("Name");
        name.setBounds(15,40,100,20);
        nameTxt=new JTextField(50);
        nameTxt.setBounds(125,40,180,20);
        //for gender
        gender=new JLabel("Gender");
        gender.setBounds(15,65,100,20);
        maleRadio=new JRadioButton("Male");
        maleRadio.setBounds(125,65,60,20);
        femaleRadio=new JRadioButton("Female");
        femaleRadio.setBounds(185,65,80,20);
        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        //for dob
        dob=new JLabel("DOB");
        dob.setBounds(15,90,100,20);
        //for year
        Integer[] years = new Integer[76];
        for (int i = 0; i < 76; i++) {
            years[i] = 1950 + i;
        }
        JComboBox<Integer> dobYear = new JComboBox<>(years);
        dobYear.setBounds(125,90,55,20);
        //for month
        String[] months = {"January", "February", "March", "April", "May", "June", "July","August", "September", "October", "November", "December"};
        JComboBox<String> dobMonth = new JComboBox<>(months);
        dobMonth.setBounds(180,90,85,20);
        //for date
        Integer[] dates = new Integer[31];
        for (int i = 0; i < 31; i++) {
            dates[i] = i + 1;
        }
        JComboBox<Integer> dobDay = new JComboBox<>(dates);
        dobDay.setBounds(265,90,40,20);
        //
        location=new JLabel("Location");
        location.setBounds(15,115,100,20);
        locationTxt=new JTextField(80);
        locationTxt.setBounds(125,115,180,20);
        phone=new JLabel("Phone");
        phone.setBounds(15,140,100,20);
        phoneTxt=new JTextField(80);
        phoneTxt.setBounds(125,140,180,20);
        email=new JLabel("Email");
        email.setBounds(15,165,100,20);
        emailTxt=new JTextField(80);
        emailTxt.setBounds(125,165,180,20);
        referralSource=new JLabel("Referral Source");
        referralSource.setBounds(15,190,100,20);
        referralSourceTxt=new JTextField(80);
        referralSourceTxt.setBounds(125,190,180,20);
        membershipStartDate=new JLabel("Membership Start Date");
        membershipStartDate.setBounds(350,15,130,20);
        //for year
        Integer[] sYears = new Integer[11];
        for (int i = 0; i < 11; i++) {
            sYears[i] = 2015 + i;
        }
        JComboBox<Integer> membershipYear = new JComboBox<>(sYears);
        membershipYear.setBounds(500,15,55,20);
        //for month
        String[] sMonths = {"January", "February", "March", "April", "May", "June", "July","August", "September", "October", "November", "December"};
        JComboBox<String> membershipMonth= new JComboBox<>(sMonths);
        membershipMonth.setBounds(555,15,85,20);
        //for date
        Integer[] sDates = new Integer[31];
        for (int i = 0; i < 31; i++) {
            sDates[i] = i + 1;
        }
        JComboBox<Integer> membershipDate = new JComboBox<>(sDates);
        membershipDate.setBounds(640,15,40,20);
        //
        trainersName=new JLabel("Trainer's Name");
        trainersName.setBounds(350,40,100,20);
        trainersNameTxt=new JTextField(100);
        trainersNameTxt.setBounds(500,40,180,20);
        //
        regularPlan=new JLabel("Regular Plan Price");
        regularPlan.setBounds(350,65,120,20);
        regularPlanTxt=new JTextField("6500");
        regularPlanTxt.setBounds(500,65,180,20);
        regularPlanTxt.setEditable(false);
        premiumPlan=new JLabel("Premium Plan Price");
        premiumPlan.setBounds(350,90,120,20);
        premiumPlanTxt=new JTextField("50000");
        premiumPlanTxt.setBounds(500,90,180,20);
        premiumPlanTxt.setEditable(false);
        discountAmount=new JLabel("Discount Amount");
        discountAmount.setBounds(350,115,120,20);
        discountAmountTxt=new JTextField("0");
        discountAmountTxt.setBounds(500,115,180,20);
        plan=new JLabel("Plan");
        plan.setBounds(350,140,120,20);
        String[]plans={"Basic","Standard","Deluxe"};
        planBox=new JComboBox(plans);
        planBox.setBounds(500,140,80,20);
        discountAmountTxt.setEditable(false);
        paidAmount=new JLabel("Paid Amount");
        paidAmount.setBounds(350,165,120,20);
        paidAmountTxt=new JTextField(1000);
        paidAmountTxt.setBounds(500,165,180,20);
        removalReason=new JLabel("Removal Reason");
        removalReason.setBounds(350,190,120,20);
        removalReasonTxt=new JTextArea();
        removalReasonTxt.setBounds(500,190,180,70);
        removalReasonTxt.setLineWrap(true);
        //for buttons
        addRegularMember=new JButton("Add Regular Member");
        addRegularMember.setBounds(50,240,180,20);
        //action listener for add regular member button
        addRegularMember.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    try{
                        int id=Integer.parseInt(idTxt.getText());
                        String name=nameTxt.getText();
                        String location=locationTxt.getText();
                        String phone=phoneTxt.getText();
                        String email=emailTxt.getText();
                        String gender=maleRadio.isSelected() ? "Male":(femaleRadio.isSelected()?"Female":"");
                        String dob=dobYear.getSelectedItem()+"-"+dobMonth.getSelectedItem()+"-"+dobDay.getSelectedItem();
                        String mStart=membershipYear.getSelectedItem()+"-"+membershipMonth.getSelectedItem()+"-"+membershipDate.getSelectedItem();
                        String referralSource=referralSourceTxt.getText();

                        if (idTxt.getText().isEmpty()||name.isEmpty()||location.isEmpty()||phone.isEmpty()||email.isEmpty()||gender.isEmpty()||referralSource.isEmpty()){
                            JOptionPane.showMessageDialog(frame,"Please fill all the fields required as given in the instructions","Incomplete Data",JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        for(GymMember members:member){
                            if(members.getId()==id){
                                JOptionPane.showMessageDialog(frame, "ID already exists. Please enter a unique ID.", "Duplicate ID", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        }
                        RegularMember members=new RegularMember(id,name,location,phone,email,gender,dob,mStart,referralSource);
                        member.add(members);
                        String message="Regular Member Added Sucessfully!\n\n"+"ID:"+id+"\n"+"Name:"+name+"\n"+"Location:"+location+"\n"+"Phone:"+phone+"\n"+"Email:"+email+"\n"+"Gender:"+gender+"\n"+"Date of Birth:"+dob+"\n"+"Membership Start Date:"+mStart+"\n"+"Referral Source:"+referralSource;
                        JOptionPane.showMessageDialog(frame,message,"Sucessful",JOptionPane.INFORMATION_MESSAGE);

                    }
                    catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(frame,"Please enter a numeric ID","Invalid ID",JOptionPane.WARNING_MESSAGE);
                    }

                }
            });
        addPremiumMember=new JButton("Add Premium Member");
        addPremiumMember.setBounds(270,240,180,20);
        addPremiumMember.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    try{
                        int id=Integer.parseInt(idTxt.getText());
                        String name=nameTxt.getText();
                        String location=locationTxt.getText();
                        String phone=phoneTxt.getText();
                        String email=emailTxt.getText();
                        String gender=maleRadio.isSelected() ? "Male":(femaleRadio.isSelected()?"Female":"");
                        String dob=dobYear.getSelectedItem()+"-"+dobMonth.getSelectedItem()+"-"+dobDay.getSelectedItem();
                        String mStart=membershipYear.getSelectedItem()+"-"+membershipMonth.getSelectedItem()+"-"+membershipDate.getSelectedItem();
                        String trainersName=trainersNameTxt.getText();
                        if (idTxt.getText().isEmpty()||name.isEmpty()||location.isEmpty()||phone.isEmpty()||email.isEmpty()||gender.isEmpty()||trainersName.isEmpty()){
                            JOptionPane.showMessageDialog(frame,"Please fill all the fields required as given in the instructions","Incomplete Data",JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        for(GymMember members:member){
                            if(members.getId()==id){
                                JOptionPane.showMessageDialog(frame, "ID already exists. Please enter a unique ID.", "Duplicate ID", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        }
                        PremiumMember members=new PremiumMember(id,name,location,phone,email,gender,dob,mStart,trainersName);
                        member.add(members);
                        String message="Premium Member Added Sucessfully!\n\n"+"ID:"+id+"\n"+"Name:"+name+"\n"+"Location:"+location+"\n"+"Phone:"+phone+"\n"+"Email:"+email+"\n"+"Gender:"+gender+"\n"+"Date of Birth:"+dob+"\n"+"Membership Start Date:"+mStart+"\n"+"Trainer's Name:"+trainersName;
                        JOptionPane.showMessageDialog(frame,message,"Sucessful",JOptionPane.INFORMATION_MESSAGE);

                    }
                    catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(frame,"Please enter a numeric ID","Invalid ID",JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
        activateMembership=new JButton("Activate Membership");
        activateMembership.setBounds(50,270,180,20);
        activateMembership.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try{
                        int id = Integer.parseInt(idTxt.getText());
                        boolean found=false;
                        for(GymMember members:member){
                            if(members.getId()==id){
                                members.activeMembership();
                                JOptionPane.showMessageDialog(frame,"Membership activated for ID:"+id+"\n");
                                found=true;
                                break;
                            }
                        }
                        if(!found){
                            JOptionPane.showMessageDialog(frame,"Member not found","Error",JOptionPane.ERROR_MESSAGE);

                        }
                    }
                    catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(frame,"Please enter a valid numeric ID.","Invalid ID",JOptionPane.ERROR_MESSAGE);
                    }
                }

            });
        deactivateMembership=new JButton("Deactivate Membership");
        deactivateMembership.setBounds(270,270,180,20);
        deactivateMembership.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try{
                        int id=Integer.parseInt(idTxt.getText());
                        boolean found=false;
                        for(GymMember members:member){
                            if(members.getId()==id){
                                members.deactivateMembership();
                                JOptionPane.showMessageDialog(frame, "Membership deactivated for ID: " + id, "Success", JOptionPane.INFORMATION_MESSAGE);
                                found=true;
                                break;
                            }
                        }
                        if (!found){
                            JOptionPane.showMessageDialog(frame, "Member not found.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(frame, "Please enter a valid numeric ID.", "Invalid ID", JOptionPane.ERROR_MESSAGE);
                    }
                }

            });

        markAttendance=new JButton("Mark Attendance");
        markAttendance.setBounds(490,270,180,20);
        markAttendance.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try{
                        int id=Integer.parseInt(idTxt.getText());
                        boolean found=false;
                        for(GymMember members:member){
                            if(members.getId()==id){
                                if(!members.activeStatus()){
                                    JOptionPane.showMessageDialog(frame,"Membership is not active","Error",JOptionPane.ERROR_MESSAGE);
                                    return;
                                }
                                members.markAttendance();
                                JOptionPane.showMessageDialog(frame,
                                    "Attendance marked for ID:"+id+"\nAttendance:"+members.getAttendance()+"\nCurrent Loyalty Points:"+ members.getLoyaltyPoints(),
                                    "Sucess",
                                    JOptionPane.INFORMATION_MESSAGE);
                                found=true;
                                break;
                            }
                        }
                        if(!found){
                            JOptionPane.showMessageDialog(frame,"Member not found.","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(frame,"Please enter a valid numeric ID.","Input Error",JOptionPane.ERROR_MESSAGE);
                    }
                }

            });
        upgradePlan=new JButton("Upgrade Plan");
        upgradePlan.setBounds(50,300,180,20);
        upgradePlan.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (idTxt.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame,
                                "Please enter Member ID to upgrade plan.", "Input Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        int memberId = Integer.parseInt(idTxt.getText());
                        String newPlan = planBox.getSelectedItem().toString();
                        boolean found = false;
                        for (GymMember members : member) {
                            if (members.getId() == memberId && members instanceof RegularMember) {
                                RegularMember regular = (RegularMember) members;
                                String msg = regular.upgradePlan(newPlan);
                                double price = 6500;
                                if (newPlan.equalsIgnoreCase("standard")) {
                                    price = 12500;
                                } else if (newPlan.equalsIgnoreCase("deluxe")) {
                                    price = 18500;
                                }
                                regularPlanTxt.setText(String.valueOf(price));
                                JOptionPane.showMessageDialog(frame,msg, "Upgrade Plan", JOptionPane.INFORMATION_MESSAGE);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            JOptionPane.showMessageDialog(frame,
                                "Regular member not found.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame,
                            "Please enter a valid numeric ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        calculateDiscount=new JButton("Calculate Discount");
        calculateDiscount.setBounds(270,300,180,20);
        calculateDiscount.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (idTxt.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame,
                                "Please enter Member ID to calculate discount.", "Input Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        int memberId = Integer.parseInt(idTxt.getText());
                        boolean found = false;
                        for (GymMember members : member) {
                            if (members.getId() == memberId && members instanceof PremiumMember) {
                                PremiumMember premium = (PremiumMember) members;
                                String msg = premium.calculateDiscount();
                                discountAmountTxt.setText(String.valueOf(premium.getDiscountAmount()));
                                JOptionPane.showMessageDialog(frame,
                                    msg, "Calculate Discount", JOptionPane.INFORMATION_MESSAGE);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            JOptionPane.showMessageDialog(frame,
                                "Premium member not found.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame,
                            "Please enter a valid numeric ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        display=new JButton("Display Member");
        display.setBounds(490,300,180,20);
        display.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    regularTxt.setText("Regular Member:\n----------------------------\n");
                    premiumTxt.setText("Premium Member:\n----------------------------\n");  // Clear previous display

                    for (GymMember gm : member) {
                        if (gm instanceof RegularMember) {
                            RegularMember rm = (RegularMember) gm;
                            regularTxt.append("ID: " + rm.getId() + "\n");
                            regularTxt.append("Name: " + rm.getName() + "\n");
                            regularTxt.append("Location: " + rm.getLocation() + "\n");
                            regularTxt.append("Phone: " + rm.getPhone() + "\n");
                            regularTxt.append("Email: " + rm.getEmail() + "\n");
                            regularTxt.append("Gender: " + rm.getGender() + "\n");
                            regularTxt.append("DOB: " + rm.getDOB() + "\n");
                            regularTxt.append("Membership Start Date: " + rm.getMembershipStartDate() + "\n");
                            regularTxt.append("Referral Source: " + rm.getReferralSource() + "\n");
                            regularTxt.append("Attendance: " +rm.getAttendance() + "\n");
                            regularTxt.append("Loyalty Points: " + rm.getLoyaltyPoints() + "\n");
                            regularTxt.append("Active Status: " + rm.activeStatus() + "\n");
                            regularTxt.append("----------------------------------------\n");
                        } 
                        else if (gm instanceof PremiumMember) {
                            PremiumMember pm = (PremiumMember) gm;
                            premiumTxt.append("ID: " + pm.getId() + "\n");
                            premiumTxt.append("Name: " + pm.getName() + "\n");
                            premiumTxt.append("Location: " + pm.getLocation() + "\n");
                            premiumTxt.append("Phone: " + pm.getPhone() + "\n");
                            premiumTxt.append("Email: " + pm.getEmail() + "\n");
                            premiumTxt.append("Gender: " + pm.getGender() + "\n");
                            premiumTxt.append("DOB: " + pm.getDOB() + "\n");
                            premiumTxt.append("Membership Start Date: " + pm.getMembershipStartDate() + "\n");
                            premiumTxt.append("Personal Trainer: " + pm.getPersonalTrainer() + "\n");
                            premiumTxt.append("Attendance: " + pm.getAttendance() + "\n");
                            premiumTxt.append("Loyalty Points: " + pm.getLoyaltyPoints() + "\n");
                            premiumTxt.append("Active Status: " + pm.activeStatus() + "\n");
                            premiumTxt.append("----------------------------------------\n");
                        }
                    }
                    regularTxt.setCaretPosition(0);
                    premiumTxt.setCaretPosition(0);

                }
            });

        revertReMember=new JButton("Revert Regular Member");
        revertReMember.setBounds(50,330,180,20);
        revertReMember.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try{
                        int memberId=Integer.parseInt(idTxt.getText());
                        String removalReason=removalReasonTxt.getText();
                        boolean memberFound=false;
                        if(idTxt.getText().isEmpty()||removalReason.isEmpty()){
                            JOptionPane.showMessageDialog(frame,"Please enter Member ID and Removal Reason to revert Regular Member","Incomplete Input",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        for(GymMember members:member){
                            if(members.getId()== memberId && members instanceof RegularMember){
                                RegularMember regular=(RegularMember)members;
                                String reason=removalReasonTxt.getText();
                                regular.revertRegularMember(reason);
                                JOptionPane.showMessageDialog(frame,"Regular member reverted for ID:"+memberId,"Revert Member",JOptionPane.INFORMATION_MESSAGE);
                                memberFound=true;
                                break;
                            }
                        }
                        if(!memberFound){
                            JOptionPane.showMessageDialog(frame,"Regular Member not found.","Input Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(frame,"Please enter a valid numeric ID.","Input Error",JOptionPane.ERROR_MESSAGE);
                    }
                }

            });
        revertPreMember=new JButton("Revert Premium Member");
        revertPreMember.setBounds(270,330,180,20);
        revertPreMember.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try{
                        int memberId=Integer.parseInt(idTxt.getText());
                        boolean memberFound=false;
                        if(idTxt.getText().isEmpty()){
                            JOptionPane.showMessageDialog(frame,"Please enter Member ID to revert Regular Member","Invalid Input",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        for(GymMember members:member){
                            if(members.getId()== memberId && members instanceof PremiumMember){
                                PremiumMember premium=(PremiumMember)members;
                                premium.revertPremiumMember();
                                JOptionPane.showMessageDialog(frame,"Regular member reverted for ID:"+memberId,"Revert Member",JOptionPane.INFORMATION_MESSAGE);
                                memberFound=true;
                                break;
                            }
                        }
                        if(!memberFound){
                            JOptionPane.showMessageDialog(frame,"Regular Member not found.","Input Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(frame,"Please enter a valid numeric ID.","Input Error",JOptionPane.ERROR_MESSAGE);
                    }
                }

            });

        payDueAmount=new JButton("Pay Due Amount");
        payDueAmount.setBounds(490,330,180,20);
        payDueAmount.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try{
                        if(idTxt.getText().isEmpty()||paidAmountTxt.getText().isEmpty()){
                            JOptionPane.showMessageDialog(frame,"Please enter Member ID and Paid Amount to pay due amount.","Invalid Input",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        int memberId=Integer.parseInt(idTxt.getText());
                        double amount=Double.parseDouble(paidAmountTxt.getText());
                        boolean found=false;

                        for (GymMember members : member) {
                            if (members.getId() == memberId && members instanceof PremiumMember) {
                                PremiumMember premium = (PremiumMember) members;
                                String msg = premium.payDueAmount(amount);
                                JOptionPane.showMessageDialog(frame,
                                    msg, "Payment done", JOptionPane.INFORMATION_MESSAGE);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            JOptionPane.showMessageDialog(frame,
                                "Premium member not found.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(frame,"Please enter valid numeric value .", "Input Error", JOptionPane.ERROR_MESSAGE);
                    }

                }

            });
        clear=new JButton("Clear");
        clear.setBounds(50,360,180,20);
        clear.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    idTxt.setText("");
                    nameTxt.setText("");
                    maleRadio.setSelected(false);
                    femaleRadio.setSelected(false);
                    genderGroup.clearSelection();
                    locationTxt.setText("");
                    phoneTxt.setText("");
                    emailTxt.setText("");
                    referralSourceTxt.setText("");
                    trainersNameTxt.setText("");
                    paidAmountTxt.setText("");
                    removalReasonTxt.setText("");

                }
            });
        saveToFile=new JButton("Save To File");
        saveToFile.setBounds(270,360,180,20);
        saveToFile.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        // Check if there is at least one member
                        if (member.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "No members to save!", "Warning", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        // Create a file writer
                        FileWriter fileWriter = new FileWriter("MemberDetails.txt");
                        PrintWriter printWriter = new PrintWriter(fileWriter);

                        // Write header
                        printWriter.printf("%-5s %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10s %-15s %-10s %-15s %-15s %-15s\n", 
                            "ID", "Name", "Location", "Phone", "Email", "Membership Start Date", "Plan", 
                            "Price", "Attendance", "Loyalty Points", "Active Status", "Full Payment", 
                            "Discount Amount", "Net Amount Paid");

                        // Write member details
                        for (GymMember members : member) {
                            if (members instanceof RegularMember) {
                                RegularMember regularMember = (RegularMember) members;
                                printWriter.printf("%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10.2f %-10d %-15.2f %-10b %-15s %-15s %-15s\n", 
                                    regularMember.getId(), regularMember.getName(), regularMember.getLocation(), 
                                    regularMember.getPhone(), regularMember.getEmail(), regularMember.getMembershipStartDate(), 
                                    regularMember.getPlan(), regularMember.getPrice(), regularMember.getAttendance(), 
                                    regularMember.getLoyaltyPoints(), regularMember.activeStatus(), "-", "-", "-");
                            } else if (members instanceof PremiumMember) {
                                PremiumMember premiumMember = (PremiumMember) members;
                                printWriter.printf("%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10d %-15.2f %-10b %-15b %-15.2f %-15.2f\n",
                                    premiumMember.getId(), premiumMember.getName(), premiumMember.getLocation(), 
                                    premiumMember.getPhone(), premiumMember.getEmail(), premiumMember.getMembershipStartDate(), 
                                    "Premium", "50000.0", premiumMember.getAttendance(), 
                                    premiumMember.getLoyaltyPoints(), premiumMember.activeStatus(), 
                                    premiumMember.isFullPayment(), premiumMember.getDiscountAmount(), premiumMember.getPaidAmount());
                            }
                        }

                        // Close writers
                        printWriter.close();
                        fileWriter.close();

                        // Show success message
                        JOptionPane.showMessageDialog(frame, "Member details saved to file successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Error saving to file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        readFromFile=new JButton("Read From File");
        readFromFile.setBounds(490,360,180,20);
        readFromFile.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try {
                        // Create a file reader
                        FileReader fileReader = new FileReader("MemberDetails.txt");
                        BufferedReader bufferedReader = new BufferedReader(fileReader);

                        // Create a new frame for display
                        JFrame displayFrame = new JFrame("Member Details from File");
                        displayFrame.setSize(800, 400);
                        displayFrame.setLayout(new BorderLayout());

                        // Create a text area for display
                        JTextArea textArea = new JTextArea();
                        textArea.setEditable(false);

                        // Add scroll pane
                        JScrollPane scrollPane = new JScrollPane(textArea);
                        displayFrame.add(scrollPane, BorderLayout.CENTER);

                        // Read and display file contents
                        StringBuilder sb = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            sb.append(line).append("\n");
                        }

                        // Set the text
                        textArea.setText(sb.toString());

                        // Close reader
                        bufferedReader.close();
                        fileReader.close();

                        // Display the frame
                        displayFrame.setVisible(true);
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(frame, "File not found: MemberDetails.txt", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Error reading from file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            });

        instruction=new JLabel("Instructions");
        instruction.setFont(new Font("Arial",Font.BOLD,20));
        instruction.setBounds(750,15,130,20);
        rInstruction=new JTextArea();
        rInstruction.setEditable(false);
        rInstruction.setLineWrap(true);
        rInstruction.setWrapStyleWord(true);
        rInstruction.setBackground(frame.getBackground());
        rInstruction.setBounds(690,35,210,185);
        rInstruction.setText("1.Instruction for Regular Member:\n"+
            "Please fill the fiels as instructed below;\n"+"a).ID\n"+"b).Name\n"+"c).Gender\n"+"d).DOB\n"+"e).Location\n"
            +"f).Phone\n"+"g).Email\n"+"h).Membership Start Date\n"+"i).Referral Source");
        pInstruction=new JTextArea();
        pInstruction.setEditable(false);
        pInstruction.setLineWrap(true);
        pInstruction.setWrapStyleWord(true);
        pInstruction.setBackground(frame.getBackground());
        pInstruction.setBounds(690,220,210,220);
        pInstruction.setText("2.Instruction for Premium Member:\n"+
            "Please fill the fiels as instructed below;\n"+"a).ID\n"+"b).Name\n"+"c).Gender\n"+"d).DOB\n"+"e).Location\n"
            +"f).Phone\n"+"g).Email\n"+"h).Membership Start Date\n"+"i).Trainer's Name");

        frame.add(displayMember);
        displayMember.add(regularScroll);
        displayMember.add(premiumScroll);
        frame.add(id);
        frame.add(idTxt);
        frame.add(name);
        frame.add(nameTxt);
        frame.add(gender);
        frame.add(maleRadio);
        frame.add(femaleRadio);
        frame.add(dob);
        frame.add(dobYear);
        frame.add(dobMonth);
        frame.add(dobDay);
        frame.add(location);
        frame.add(locationTxt);
        frame.add(phone);
        frame.add(phoneTxt);
        frame.add(email);
        frame.add(emailTxt);
        frame.add(referralSource);
        frame.add(referralSourceTxt);
        frame.add(membershipStartDate);
        frame.add(membershipYear);
        frame.add(membershipMonth);
        frame.add(membershipDate);
        frame.add(trainersName);
        frame.add(trainersNameTxt);
        frame.add(regularPlan);
        frame.add(regularPlanTxt);
        frame.add(premiumPlan);
        frame.add(premiumPlanTxt);
        frame.add(discountAmount);
        frame.add(discountAmountTxt);
        frame.add(plan);
        frame.add(planBox);
        frame.add(paidAmount);
        frame.add(paidAmountTxt);
        frame.add(removalReason);
        frame.add(removalReasonTxt);
        frame.add(addRegularMember);
        frame.add(addPremiumMember);
        frame.add(activateMembership);
        frame.add(deactivateMembership);
        frame.add(markAttendance);
        frame.add(upgradePlan);
        frame.add(calculateDiscount);
        frame.add(display);
        frame.add(revertReMember);
        frame.add(revertPreMember);
        frame.add(payDueAmount);
        frame.add(clear);
        frame.add(saveToFile);
        frame.add(readFromFile);
        frame.add(instruction);
        frame.add(rInstruction);
        frame.add(pInstruction);

        frame.setVisible(true);
    }
    //main method
    public static void main(String[]args){
        GymGUI gym=new GymGUI();
    }
}