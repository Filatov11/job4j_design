package ru.job4j.serialization.xml;

import java.io.*;
import java.util.Arrays;

public class EmployerXML {
    private Employee employee;
    private String[] skill;
    private boolean hired;
    private int age;

    public EmployerXML(Employee employee, String[] skill, boolean hired, int age) {
        this.employee = employee;
        this.skill = skill;
        this.hired = hired;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employer{"
                + " number=" + employee.getEmplNbr()
                + ", name=" + employee.getName()
                + ", age=" + age
                + ", hired=" + hired
                + ", skills=" + Arrays.toString(skill)
                + '}';
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String[] getSkill() {
        return skill;
    }

    public void setSkill(String[] skill) {
        this.skill = skill;
    }

    public boolean isHired() {
        return hired;
    }

    public void setHired(boolean hired) {
        this.hired = hired;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        EmployerXML employerXML = new EmployerXML(new Employee(123, "Nik"),
                new String[]{"Java", "Ruby", "PostgreSQL"}, true, 37);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("emp1.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("");
        writer.close();

        PrintWriter out;

        {
            try {
                out =
                        new PrintWriter(new BufferedWriter(new FileWriter("emp1.xml", true)));
                out.println("<?xml version=\"1.1\" encoding=\"UTF-8\" ?>");
                // out.println("<xml version=");
                System.out.println("written" + employerXML.toString());
                out.println("<employee number=" + employerXML.getEmployee().getEmplNbr() + " name=" + employerXML.getEmployee().getName() + "/>");
                // out.println("<name>"+employerXML.getEmployee().getName()+"</>");
                out.println("<age>" + employerXML.age + "</age>");
                out.println("<hired>" + employerXML.hired + "</hired>");
                out.println("<skills>");
                for (String item : employerXML.skill) {
                    out.println("<skill>" + item + "</skill>");
                }
                out.println("</skills>");
                out.println("</employee>");
                out.flush();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

}


class Employee {
    private int emplNbr;
    private String name;

    public Employee(int emplNbr, String name) {
        this.name = name;
        this.emplNbr = emplNbr;
    }

    public int getEmplNbr() {
        return emplNbr;
    }

    public void setEmplNbr(int emplNbr) {
        this.emplNbr = emplNbr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}