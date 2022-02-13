package com.bridgelabz;

public class EmployeeData {
    int id;
    String name;
    long salary;
    String start_date;
    String phone;
    String address;
    String department;
    int basic_pay;
    int deduction;
    int taxable_pay;
    int income_tax;
    int net_pay;

    public EmployeeData(int id, String name, long salary, String start_date, String phone, String address, String department, int basic_pay, int deduction, int taxable_pay, int income_tax, int net_pay) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.start_date = start_date;
        this.phone = phone;
        this.address = address;
        this.department = department;
        this.basic_pay = basic_pay;
        this.deduction = deduction;
        this.taxable_pay = taxable_pay;
        this.income_tax = income_tax;
        this.net_pay = net_pay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getBasic_pay() {
        return basic_pay;
    }

    public void setBasic_pay(int basic_pay) {
        this.basic_pay = basic_pay;
    }

    public int getDeduction() {
        return deduction;
    }

    public void setDeduction(int deduction) {
        this.deduction = deduction;
    }

    public int getTaxable_pay() {
        return taxable_pay;
    }

    public void setTaxable_pay(int taxable_pay) {
        this.taxable_pay = taxable_pay;
    }

    public int getIncome_tax() {
        return income_tax;
    }

    public void setIncome_tax(int income_tax) {
        this.income_tax = income_tax;
    }

    public int getNet_pay() {
        return net_pay;
    }

    public void setNet_pay(int net_pay) {
        this.net_pay = net_pay;
    }

    @Override
    public String toString() {
        return "EmployeeData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", start_date='" + start_date + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", department='" + department + '\'' +
                ", basic_pay=" + basic_pay +
                ", deduction=" + deduction +
                ", taxable_pay=" + taxable_pay +
                ", income_tax=" + income_tax +
                ", net_pay=" + net_pay +
                '}';
    }
}
