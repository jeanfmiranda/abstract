package entities;

public class PhysicalPerson extends Person{
    private Double healthCosts;

    public PhysicalPerson() {

    }

    public PhysicalPerson(String name, Double annualIncome, Double healthCosts) {
        super(name, annualIncome);
        this.healthCosts = healthCosts;
    }

    public Double getHealthCosts() {
        return healthCosts;
    }

    public void setHealthCosts(Double healthCosts) {
        this.healthCosts = healthCosts;
    }

    @Override
    public Double taxAmount() {
        double tax;
        if (super.getAnnualIncome() < 20000) {
            tax = super.getAnnualIncome()*0.15;
        }
        else {
            tax = super.getAnnualIncome()*0.25;
        }

        if (healthCosts != null) {
            tax -= healthCosts*0.5;
        }

        if (tax < 0.0) {
            tax = 0.0;
        }
        return tax;
    }
}
