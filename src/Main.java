public class Main {
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();
        Employee emp1 = new Employee("Иванов И.И.", 1, 100);
        Employee emp2 = new Employee("Петров П.П.", 2, 200);
        Employee emp3 = new Employee("Сидоров С.С.", 3, 300);
        Employee emp4 = new Employee("Петров П.П.", 2, 200);
        Employee emp5 = new Employee("Сидоров С.С.", 3, 300);
        Employee emp6 = new Employee("Иванов И.И.", 1, 100);
        Employee emp7 = new Employee("Петров П.П.", 2, 200);
        Employee emp8 = new Employee("Иванов И.И.", 1, 100);
        Employee emp9 = new Employee("Петров П.П.", 2, 200);
        Employee emp10 = new Employee("Сидоров С.С.", 2, 300);
        Employee emp11 = new Employee("Сидоров С.С.", 3, 300);



        System.out.println("=== Добавление сотрудников ===");
        boolean[] results = new boolean[11];
        results[0] = book.addEmployee(emp1);
        results[1] = book.addEmployee(emp2);
        results[2] = book.addEmployee(emp3);
        results[3] = book.addEmployee(emp4);
        results[4] = book.addEmployee(emp5);
        results[5] = book.addEmployee(emp6);
        results[6] = book.addEmployee(emp7);
        results[7] = book.addEmployee(emp8);
        results[8] = book.addEmployee(emp9);
        results[9] = book.addEmployee(emp10);
        results[10] = book.addEmployee(emp11); // 11-й вызов


        for (int i = 0; i < results.length; i++) {
            System.out.println("Добавление сотрудника №" + (i + 1) + ": " + (results[i] ? "успешно" : "не удалось (нет места)"));
        }


        System.out.println("\n--- Список всех сотрудников ---");
        book.printAllEmployees();

        System.out.println("\n--- Средняя зарплата ---");
        System.out.println("Средняя зарплата: " + book.calculateAverageSalary());

        System.out.println("\n--- Налоги (PROPORTIONAL) ---");
        book.printTaxes("PROPORTIONAL");

        System.out.println("\n--- Налоги (PROGRESSIVE) ---");
        book.printTaxes("PROGRESSIVE");

        System.out.println("\n--- Индексация зарплат в отделе 1 на 10% ---");
        book.indexSalariesInDepartment(1, 10);

        System.out.println("\n--- Поиск первого сотрудника в отделе 3 с зарплатой > 200 ---");
        book.findFirstEmployeeInDepartmentWithHigherSalary(3, 200);

        System.out.println("\n--- Первые 3 сотрудника с зарплатой < 250 ---");
        book.printFirstEmployeesWithLowerSalary(250, 3);

        System.out.println("\n--- Проверка наличия сотрудника по зарплате (бухгалтерское сравнение) ---");
        Employee testEmp = new Employee("Тест Т.Т.", 1, 132.0); // после индексации у Иванова стало 66, у Петрова 132
        boolean exists = book.containsEmployeeBySalary(testEmp);
        System.out.println("Есть ли сотрудник с такой зарплатой: " + exists);

        System.out.println("\n--- Получение сотрудника по ID ---");
        Employee empById = book.getEmployeeById(2);
        if (empById != null) {
            empById.printShortInfo();
        } else {
            System.out.println("Сотрудник с таким ID не найден.");
        }

    }
}





