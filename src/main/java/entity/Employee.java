package entity;

public class Employee {
    private String name;
    private int employeeid;

    private String password;

    private String address;
    private int phonenumber;

    private String role;
    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhonenumber() {return phonenumber;}

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Employee(){

    }




    public Employee(int employeeid, String username, String name, String address, int phonenumber, String password, String role) {
        this.name = name;
        this.username = username;
        this.employeeid = employeeid;
        this.address = address;
        this.phonenumber = phonenumber;
        this.role = role;
        this.password = password;
    }

    public Employee(int employeeid, String username,String name, String address, int phonenumber, String role) {
        this.employeeid = employeeid;
        this.name = name;
        this.username = username;
        this.address = address;
        this.phonenumber = phonenumber;
        this.role = role;
    }


    public String getName() {

        return name;
    }

    public int getEmployeeid() {

        return employeeid;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", employeeid=" + employeeid +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phonenumber=" + phonenumber +
                '}';
    }
}





