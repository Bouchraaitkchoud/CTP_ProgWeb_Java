import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialisation du service des employés
        EmployeeService employeeService = new EmployeeService();

        // Création de quelques employés
        Employee employee1 = new Employee("Alice", "Manager");
        Employee employee2 = new Employee("Bob", "Developer");
        Employee employee3 = new Employee("Charlie", "Designer");

        // Ajout des employés dans la base de données à l'aide de threads
        DatabaseTask task1 = new DatabaseTask(employeeService, employee1);
        DatabaseTask task2 = new DatabaseTask(employeeService, employee2);
        DatabaseTask task3 = new DatabaseTask(employeeService, employee3);

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Affichage des employés depuis la base de données
        List<Employee> employees = employeeService.getAllEmployees();
        System.out.println("Employees from database:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // Sauvegarde des employés dans un fichier
        SerializationUtil.serializeEmployees(employees, "employees.ser");

        // Lecture des employés depuis le fichier
        List<Employee> deserializedEmployees = SerializationUtil.deserializeEmployees("employees.ser");
        System.out.println("Deserialized employees:");
        for (Employee employee : deserializedEmployees) {
            System.out.println(employee);
        }
    }
}
