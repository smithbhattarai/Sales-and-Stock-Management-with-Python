public class RegularMember extends GymMember{
    private final int attendanceLimit;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;
    //making constructor
    public RegularMember(int id,String name,String location,String phone,String email,
    String gender,String DOB,String membershipStartDate,String referralSource){
        super(id,name,location,phone,email,gender,DOB,membershipStartDate);
        this.referralSource=referralSource;
        this.isEligibleForUpgrade=false;
        this.attendanceLimit=30;
        this.plan="basic";
        this.price= 6500;
        this.removalReason="";
    }
    //accessor method
    public int getAttendanceLimit(){
        return attendanceLimit;
    }

    public boolean getIsEligibleForUpgrade(){
        return isEligibleForUpgrade;
    }

    public String getRemovalReason(){
        return removalReason;
    } 

    public String getReferralSource(){
        return referralSource;
    } 

    public String getPlan(){
        return plan;
    } 

    public double getPrice(){
        return price;
    } 
    //implementing abstract method markAttendance
    @Override
    public void markAttendance(){
        if (activeStatus){
            attendance++;
            loyaltyPoints+=5;
            if(attendance>=attendanceLimit){
                isEligibleForUpgrade=true;
            }
        }
        else{
            System.out.println("Attendance limit reached. Cannot mark attendance further.");
        }
    }
    //creating method getPlanPrice
    public double getPlanPrice(String plan){
        switch(plan.toLowerCase()){
                case"basic":return 6500;
                case"standard":return 12500;
                case"deluxe":return 18500;
            default:return -1;
        }
    }
    //creating method to upgrade plan;
    public String upgradePlan(String newPlan) {
        if (!activeStatus){
            return "Membership must be active to upgrade.";
        }
        if (!isEligibleForUpgrade) {
            return "Member is not eligible for upgrade yet.";
        }
        if (this.plan.equalsIgnoreCase(newPlan)) {
            return "Member is already subscribed to the " + newPlan + " plan.";
        }
        double newPrice = getPlanPrice(newPlan);
        if (newPrice == -1){
            return "Invalid plan selected.";
        }
        this.plan = newPlan;
        this.price = newPrice;
        return "Plan upgraded to " + newPlan + " successfully.";
    }
    //creating method to revert to basic plan
    public void revertRegularMember(String removalReason){
        resetMember();
        this.isEligibleForUpgrade=false;
        this.plan="basic";
        this.price=6500;
        this.removalReason=removalReason;
    }
    //method to display details
    @Override
    public void display(){
        super.display();
        System.out.println("Plan: "+plan);
        System.out.println("Price:"+price);
        if(!removalReason.isEmpty()){
            System.out.println("Removal Reason: "+removalReason);
        }
    }
}