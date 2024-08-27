package employeeDepartmentMap;

import java.util.*;

class Employee {
    private String name, department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}

class EmployeeGrouper{
    public Map<String,List<Employee>> groupByDepartment(List<Employee> employees){
        Map<String,List<Employee>> departmentMap = new HashMap<>();

        for (Employee empl : employees){
            String department = empl.getDepartment();

            List<Employee> empList = departmentMap.getOrDefault(department,new ArrayList<>());
            empList.add(empl);
            departmentMap.put(department,empList);
        }
        return departmentMap;
        //return employees.stream().collect(Collectors.groupingBy(employeeDepartmentMap.Employee::getDepartment));
    }
}

class ControllerDemo{
    public void getAccess(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();
        List<Employee> employeeList = new ArrayList<>();
        for(int i =0; i<n; i++){
            System.out.println("enter name: ");
            String name = sc.nextLine();

            System.out.println("enter department");
            String department = sc.nextLine();


            employeeList.add(new Employee(name,department));

        }
        EmployeeGrouper grouper = new EmployeeGrouper();
        Map<String,List<Employee>> groupedEmployee = grouper.groupByDepartment(employeeList);
  //      System.out.println(groupedEmployee);

        for (String department : groupedEmployee.keySet()){
            System.out.println(department + ":");
            List<Employee> empList = groupedEmployee.get(department);
            for(int i = 0; i<empList.size();i++){
                System.out.println("-" + empList.get(i).getName());
            }
        }

//        groupedEmployee.forEach((department,empList)->{
//            System.out.println(department+ ":");
//            empList.forEach(emp -> System.out.println("-"+emp.getName()));
//        });

    }
}
public class EmployeeNameWithDepartmentMain {
    public static void main(String[] args) {
        new ControllerDemo().getAccess();
    }
}
