import controller.EmployeeController;
import model.Employee;
import model.Gender;
import repository.EmployeeRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.time.Year;
import java.util.List;
import java.util.Locale;


public class InterfaceScreen {
    public static void main(String[] args) throws Exception {
        EmployeeController controller = new EmployeeController();
        JFrame frame = new JFrame("My Interface Screen");
        frame.setSize(500, 700);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 0, 30));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel idLabel = new JLabel("ID:");
        JTextField idField = new JTextField(10);
        idField.setBorder(BorderFactory.createCompoundBorder(idField.getBorder(),
                BorderFactory.createEmptyBorder(0, 10, 0, 10)));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(10);
        nameField.setBorder(BorderFactory.createCompoundBorder(nameField.getBorder(),
                BorderFactory.createEmptyBorder(0, 10, 0, 10)));

        JLabel departmentLabel = new JLabel("Department:");
        JTextField departmentField = new JTextField(10);
        departmentField.setBorder(BorderFactory.createCompoundBorder(departmentField.getBorder(),
                BorderFactory.createEmptyBorder(0, 10, 0, 10)));

        JLabel genderLabel = new JLabel("Gender:");
        JTextField genderField = new JTextField(10);
        genderField.setBorder(BorderFactory.createCompoundBorder(genderField.getBorder(),
                BorderFactory.createEmptyBorder(0, 10, 0, 10)));

        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField(10);
        ageField.setBorder(BorderFactory.createCompoundBorder(ageField.getBorder(),
                BorderFactory.createEmptyBorder(0, 10, 0, 10)));

        JLabel yearLabel = new JLabel("Year:");
        JTextField yearField = new JTextField(10);
        yearField.setBorder(BorderFactory.createCompoundBorder(yearField.getBorder(),
                BorderFactory.createEmptyBorder(0, 10, 0, 10)));

        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(departmentLabel);
        inputPanel.add(departmentField);
        inputPanel.add(genderLabel);
        inputPanel.add(genderField);
        inputPanel.add(ageLabel);
        inputPanel.add(ageField);
        inputPanel.add(yearLabel);
        inputPanel.add(yearField);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 30, 30));

        JButton insertButton = new JButton("Insert");
        insertButton.setBorder(BorderFactory.createCompoundBorder(insertButton.getBorder(),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBorder(BorderFactory.createCompoundBorder(deleteButton.getBorder(),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        JButton updateButton = new JButton("Update");
        updateButton.setBorder(BorderFactory.createCompoundBorder(updateButton.getBorder(),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        JButton searchButton = new JButton("Search");
        searchButton.setBorder(BorderFactory.createCompoundBorder(searchButton.getBorder(),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        buttonPanel.add(insertButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(searchButton);

        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);


        insertButton.addActionListener(e -> {
            Long id = Long.parseLong(idField.getText());
            String name = nameField.getText();
            String department = departmentField.getText();
            String gender = genderField.getText();
            gender = gender.toLowerCase();
            Gender g;
            if (gender.equals("male")) {
                g = Gender.MALE;
            } else {
                g = Gender.FEMALE;
            }
            Integer age = Integer.parseInt(ageField.getText());
            Year year = Year.parse(yearField.getText());
            Employee employee = new Employee(id, name, department, g, age, year);
            try {
                controller.create(employee);
                System.out.println(employee);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        deleteButton.addActionListener(e -> {
            try {
                String id = idField.getText();
                Long longId = Long.parseLong(id);
                controller.deleteById(longId);
                System.out.println("Deleted ID: " + longId);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(idField.getText());
                String name = nameField.getText();
                String department = departmentField.getText();
                String gender = genderField.getText();
                gender = gender.toLowerCase();
                Gender g;
                if (gender.equals("male")) {
                    g = Gender.MALE;
                } else {
                    g = Gender.FEMALE;
                }
                Integer age = Integer.parseInt(ageField.getText());
                Year year = Year.parse(yearField.getText());
                Employee employee = new Employee(id, name, department, g, age, year);
                try {
                    controller.update(employee);
                    System.out.println(employee);
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
        });

        searchButton.addActionListener(e -> {
            try {
                List<Employee> employees = controller.findAll();
                JOptionPane.showMessageDialog(frame, employees.toString());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
