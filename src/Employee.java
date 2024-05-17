import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }
    public String getName(){
        return this.name;
    }
    public String getRole(){
        return this.role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

