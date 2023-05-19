//import model.Employee;
//import model.Gender;
//import repository.EmployeeRepository;
//
//import java.rmi.Naming;
//import java.rmi.registry.LocateRegistry;
//import java.rmi.registry.Registry;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.Statement;
//import java.time.Year;
//
//public class Main {
//    public static void main(String[] args) {
//
////        Class.forName("com.mysql.cj.jdbc.Driver");
////        Connection connection = DriverManager.getConnection("jdbc:MySql://localhost:3306/" + "rmi" + "?" +
////                "serverTimeZone=Asia/Hebron", "rmi", "root");
////        Statement statement = connection.createStatement();
//
////        try {
////            EmployeeRepository repository = (EmployeeRepository) Naming.lookup("rmi://192.168.2.2:5000/repository");
////            Employee employee = new Employee(
////                    1L, "Ahmad Mohsen", "CSE", Gender.MALE, 25, Year.now()
////            );
////            repository.create(employee);
////        } catch (Exception exception) {
////            exception.printStackTrace();
////        }
//
//
//    }
//}