package data;
;
import java.util.List;
import entity.Employee;

public interface EmployeeDao {
    public Employee insert (Employee employee);

    public Employee getById(int employeeid);

    public List<Employee> getAllEmployees();

    public Employee update(Employee employee);







}
