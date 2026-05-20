public abstract class GymMember{
    //declaring variable
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;
    //making constructor
    public GymMember(int id,String name,String location,String phone,String email,
    String gender,String DOB,String membershipStartDate){
        this.id=id;
        this.name=name;
        this.location=location;
        this.phone=phone;
        this.email=email;
        this.gender=gender;
        this.DOB=DOB;
        this.membershipStartDate=membershipStartDate;
        this.attendance=0;
        this.loyaltyPoints=0.0;
        this.activeStatus=false;
    }
    //making accessor method
    public int getId(){
        return id;
    }

    public String getName(){ 
        return name; 
    }

    public String getLocation(){
        return location;
    }

    public String getPhone(){ 
        return phone;
    }

    public String getEmail(){ 
        return email;
    }

    public String getGender(){
        return gender;
    }

    public String getDOB(){
        return DOB;
    }

    public String getMembershipStartDate(){
        return membershipStartDate;
    }

    public int getAttendance(){
        return attendance;
    }

    public double getLoyaltyPoints(){
        return loyaltyPoints;
    }

    public boolean activeStatus(){
        return activeStatus;
    }
    //creating abstract method
    public abstract void markAttendance();

    public void activeMembership(){
        activeStatus=true;
    }

    public void deactivateMembership(){
        if(activeStatus)
            activeStatus=false;
    }
    //creating method resetMember
    public void resetMember(){
        activeStatus=false;
        attendance=0;
        loyaltyPoints=0.0;
    }
    //creating display method to display member details
    public void display(){
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("DOB: " + DOB);
        System.out.println("Membership Start Date: " + membershipStartDate);
        System.out.println("Attendance: " + attendance);
        System.out.println("Loyalty Points: " + loyaltyPoints);
        System.out.println("Active Status: " + activeStatus);  
    }
}
