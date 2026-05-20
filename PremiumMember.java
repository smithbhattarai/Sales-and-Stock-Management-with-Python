public class PremiumMember extends GymMember{
    private final double premiumCharge;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;
    //making constructor
    public PremiumMember(int id,String name,String location,String phone,String email,String gender,String DOB,String membershipStartDate,String personalTrainer){
        super(id,name,location,phone,email,gender,DOB,membershipStartDate);
        this.premiumCharge=50000;
        this.paidAmount=0;
        this.isFullPayment=false;
        this.discountAmount=0;
        this.personalTrainer=personalTrainer;
    }
    //accessor method
    public double getPremiumCharge() {
        return premiumCharge;
    }

    public String getPersonalTrainer() {
        return personalTrainer;
    }

    public boolean isFullPayment() {
        return isFullPayment;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }
    //implementing abstract method markAttendance
    @Override
    public void markAttendance(){
        if(activeStatus) {
            attendance++;
            loyaltyPoints += 10;
        } else {
            System.out.println("Membership is not active. Cannot mark attendance.");
        }
    }
    //creating method for due amount payment
    public String payDueAmount(double paidAmount){
        if(this.isFullPayment){
            return"Payment is already done.";
        }
        else if(this.paidAmount+paidAmount>premiumCharge){
            return"Payment exceeds the premium charge.";
        }
        this.paidAmount+=paidAmount;
        if(this.paidAmount==premiumCharge){
            this.isFullPayment=true;
            return"Full payment is successful.";
        }
        else{
            this.isFullPayment=false;
            return"Partial payment is successful and your remaining amount to be paid will be: "+(premiumCharge-this.paidAmount);
        }
    }
    //creating method to calculate discount
    public String calculateDiscount(){
        if(this.isFullPayment){
            this.discountAmount=premiumCharge*0.1;
            return"Discount amount calculated is: "+discountAmount;
        }
        else{
            return"No discount is available as the premium payment is not fully done.";
        }
    }
    //creating method which class superclass resetMember() method
    public void revertPremiumMember(){
        super.resetMember();
        this.personalTrainer="";
        this.isFullPayment=false;
        this.paidAmount=0;
        this.discountAmount=0;
    }
    //creating method to display details
    @Override
    public void display(){
        super.display();
        System.out.println("Personal Trainer: "+personalTrainer);
        System.out.println("Paid Amount: "+paidAmount);
        System.out.println("Full Payment: "+isFullPayment);
        System.out.println("Remaining Amount: "+(premiumCharge-paidAmount));
        if(isFullPayment){
            System.out.println("Discount Amount: "+discountAmount);
        }
    }
}