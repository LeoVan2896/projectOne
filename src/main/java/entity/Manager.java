package entity;

public class Manager {
    private int id;

    private String name;
    private String password;

    public Manager(int id){
        this.id = id;

    }


    public Manager(){}

    public Manager(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Manager(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public Manager(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
