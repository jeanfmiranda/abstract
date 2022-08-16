package entities;

public class LegalPerson extends Person{
    private Integer nEmployees;

    public LegalPerson() {

    }

    public LegalPerson(String name, Double annualIncome, Integer nEmployees) {
        super(name, annualIncome);
        this.nEmployees = nEmployees;
    }

    public Integer getnEmployees() {
        return nEmployees;
    }

    public void setnEmployees(Integer nEmployees) {
        this.nEmployees = nEmployees;
    }

    @Override
    public Double taxAmount() {
        double tax;
        if (nEmployees>10) {
            tax = super.getAnnualIncome()*0.14;
        }
        else {
            tax = super.getAnnualIncome()*0.16;
        }
        return tax;
    }
}
