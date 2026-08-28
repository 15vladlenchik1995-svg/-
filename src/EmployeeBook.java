public class EmployeeBook {
    private Employee[] employees = new Employee[10];
    public static final String PROPORTIONAL = "PROPORTIONAL";
    public static final String PROGRESSIVE = "PROGRESSIVE";

    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }

    public void printAllEmployees() {
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println(emp.toString());
            } else {
                System.out.println("[Пусто]");
            }
        }
    }

    public double calculateAverageSalary() {
        double sum = 0;
        byte count = 0;
        for (Employee emp : employees) {
            if (emp == null) {
                break;
            }
            sum += emp.getSalary();
            count++;
        }
        if (count == 0) {
            return 0;
        }
        return sum / count;
    }
    public void printTaxes(String taxSheme) {
        for (Employee emp : employees) {
            if (emp == null) {
                break;
            }
            double tax = 0;
            switch (taxSheme) {
                case PROPORTIONAL:
                    tax = emp.getSalary() * 0.13;
                    break;
                case PROGRESSIVE:
                    double salary = emp.getSalary();
                    if (salary <= 150) {
                        tax = salary * 0.13;
                    } else if (salary <= 350) {
                        tax = salary * 0.17;
                    } else {
                        tax = salary * 0.21;
                    }
                    break;
                default:

                    System.out.println("Неизвестная схема расчета налогов: " + taxSheme);
                    return;
            }
            System.out.println(emp.getFullName() + " (отдел " + emp.getDepartment() + " ) : зарплата = " + emp.getSalary() + ", налог = " + tax);

        }
    }

    public void indexSalariesInDepartment(int department, double percent) {
        for (Employee e : employees) {
            if (e == null) continue;
            if (e.getDepartment() != department) continue;

            double oldSalary = e.getSalary();
            double newSalary = oldSalary * (1 + percent / 100.0);


            if (Double.compare(oldSalary, newSalary) == 0) {
                continue;
            }

            e.setSalary(newSalary);
            System.out.println("Индексирована зарплата сотрудника: " + e.getFullName() +
                    " (отдел " + department + "), старая: " + oldSalary +
                    ", новая: " + newSalary);
        }
    }
    public void findFirstEmployeeInDepartmentWithHigherSalary(int department, double wage) {
        for (int i = 0; i < employees.length; i++) {
            Employee e = employees[i];
            if (e == null) break;

            if (e.getDepartment() == department && e.getSalary() > wage) {
                System.out.println("Найден сотрудник (порядковый номер в списке: " + (i + 1) + "):");
                e.printShortInfo();
                return;
            }
        }
        System.out.println("Сотрудник не найден.");
    }
    public void printFirstEmployeesWithLowerSalary(double wage, int employeeNumber) {
        int count = 0;
        int index = 0;

        while (index < employees.length) {
            Employee e = employees[index];
            if (e == null) break;

            if (e.getSalary() < wage) {
                e.printShortInfo();
                count++;
                if (count >= employeeNumber) break;
            }
            index++;
        }
    }
    public boolean containsEmployeeBySalary(Employee target) {
        for (Employee e : employees) {
            if (e == null) break;
            if (e.equals(target)) {
                return true;
            }
        }
        return false;
    }
    public Employee getEmployeeById(int id) {
        for (Employee e : employees) {
            if (e == null) break;
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}


