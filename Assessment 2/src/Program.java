import java.util.Scanner;

class Insurance{
    private String insuranceNo;
    private String insuranceName;
    private double amountcovered;
    public String getInsuranceNo() {
        return insuranceNo;
    }
    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo;
    }
    public String getInsuranceName() {
        return insuranceName;
    }
    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }
    public double getAmountcovered() {
        return amountcovered;
    }
    public void setAmountcovered(double amountcovered) {
        this.amountcovered = amountcovered;
    }
}
class MotorInsurance extends Insurance{
        private Float depPercent;
        public Double Idv;
        public Double getIdv(){
            return Idv;
    }
    public void setIdv(Double idv) {
            this.Idv = idv;
    }
    public Float getDepPercent() {
            return depPercent;
    }
    public void setDepPercent(Float depPercent) {
            this.depPercent = depPercent;
    }
    public double calculatePremium(){
            Idv = getAmountcovered() - ((getAmountcovered()*depPercent)/100);
            return 0.03 * Idv;
    }
}
class LifeInsurance extends Insurance {
    private int policyTerm;
    private float benefitpercent;

    public int getPolicyTerm() {
        return policyTerm;
    }
    public void setPolicyTerm(int policyTerm) {
        this.policyTerm = policyTerm;
    }

    public float getBenefitpercent() {
        return benefitpercent;
    }

    public void setBenefitpercent(Float benefitpercent) {
        this.benefitpercent = benefitpercent;
    }

    public double calculatePremium() {
        return (getAmountcovered() - ((getAmountcovered() * benefitpercent) / 100)) / policyTerm;
    }
}
public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insurance Number : ");
        String insuranceNo = sc.nextLine();
        System.out.println("Insurance Name : ");
        String insuranceName = sc.nextLine();
        System.out.println("Amount Covered: ");
        double amountcovered = sc.nextDouble();
        System.out.println("Selct insurance options: /n 1. Life Insurance /n 2. Motor Insurance");
        int option = sc.nextInt();
        Insurance insurance = null;
        if (option == 1) {
            LifeInsurance lifeInsurance = new LifeInsurance();
            lifeInsurance.setInsuranceNo(insuranceNo);
            lifeInsurance.setInsuranceName(insuranceName);
            lifeInsurance.setAmountcovered(amountcovered);

            System.out.println("Policy term:");
            lifeInsurance.setPolicyTerm(sc.nextInt());

            System.out.println("Benefit percent:");
            lifeInsurance.setBenefitpercent(sc.nextFloat());

            //addPolicy(lifeInsurance);
            double premium = addPolicy(lifeInsurance);
            System.out.printf("Calculated Premium:%.2f\n", premium);
        } else if (option == 2) {
            MotorInsurance motorInsurance = new MotorInsurance();
            motorInsurance.setInsuranceNo(insuranceNo);
            motorInsurance.setInsuranceName(insuranceName);
            motorInsurance.setAmountcovered(amountcovered);

            System.out.println("Depreciation percent:");
            float deppercent = sc.nextFloat();
            motorInsurance.setDepPercent(deppercent);
            double premium = addPolicy(motorInsurance);
            System.out.printf("Calculated Premium:%.2f\n", premium);
        } else {
            System.out.println("Invalid option");
        }
        sc.close();
    }

    public static double addPolicy(Insurance ins) {
        if (ins instanceof LifeInsurance) {
            return ((LifeInsurance) ins).calculatePremium();
        } else if (ins instanceof MotorInsurance) {
            return ((MotorInsurance) ins).calculatePremium();
        }
        return 0.0;
    }
}

