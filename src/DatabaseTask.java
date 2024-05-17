public class DatabaseTask implements Runnable {
    private EmployeeService employeeService;
    private Employee employee;

    public DatabaseTask(EmployeeService employeeService, Employee employee) {
        this.employeeService = employeeService;
        this.employee = employee;
    }

    @Override
    public void run() {
        employeeService.addEmployee(employee);
    }
}

