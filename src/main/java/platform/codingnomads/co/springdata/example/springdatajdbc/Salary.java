package platform.codingnomads.co.springdata.example.springdatajdbc;

import lombok.Data;

@Data
public class Salary {

    private long id;
    private double basePay;
    private double bonus;
    private double businessExpenses;

    public Salary(long id, double basePay, double bonus, double businessExpenses) {
        this.id = id;
        this.basePay = basePay;
        this.bonus = bonus;
        this.businessExpenses = businessExpenses;
    }

}
