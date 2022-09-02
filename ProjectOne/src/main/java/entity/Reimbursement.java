package entity;

import java.sql.Blob;


public class Reimbursement  {
    private int id;
    private int amount;
    private String description;

    private int employee_id;

    String status;

    public Reimbursement(){}
    public Reimbursement(String status){
        this.status = status;
    }


    public Reimbursement(int id, int amount, String description, String status, int employee_id) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.status = status;
        this.employee_id = employee_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", employee_id=" + employee_id +
                ", status='" + status + '\'' +
                '}';
    }
}
