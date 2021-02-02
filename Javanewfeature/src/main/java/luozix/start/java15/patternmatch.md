if (person instanceof Employee) {
    Employee employee = (Employee) person;
    Date hireDate = employee.getHireDate();
    //...
}

if (person instanceof Employee employee) {
    Date hireDate = employee.getHireDate();
    //...
}



if (person instanceof Employee employee && employee.getYearsOfService() > 5) {
    //...
}
