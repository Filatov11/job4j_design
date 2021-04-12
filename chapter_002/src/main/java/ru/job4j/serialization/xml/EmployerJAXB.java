package ru.job4j.serialization.xml;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;

@XmlRootElement(name = "employee")

@XmlAccessorType(XmlAccessType.FIELD)
public class EmployerJAXB {
    private EmployeeJAXB employee;

    private boolean hired;
    private int age;
    @XmlElementWrapper(name = "skills")

    private String[] skill;

    public EmployerJAXB(EmployeeJAXB employee, String[] skill, boolean hired, int age) {
        this.employee = employee;
        this.skill = skill;
        this.hired = hired;
        this.age = age;
    }

    public EmployerJAXB() {
    }

    public static void main(String[] args) throws JAXBException {

        EmployerJAXB employerJAXB = new EmployerJAXB(new EmployeeJAXB(123, "Nik"),
                new String[]{"Java", "Ruby", "PostgreSQL"}, true, 37);

        JAXBContext context = JAXBContext.newInstance(EmployerJAXB.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(employerJAXB, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {

        }

    }
}


@XmlElement(value = "employee")
class EmployeeJAXB {
    @XmlAttribute
    private int emplNbr;
    @XmlAttribute
    private String name;

    public EmployeeJAXB() {

    }

    public EmployeeJAXB(int emplNbr, String name) {
        this.name = name;
        this.emplNbr = emplNbr;
    }

    @Override
    public String toString() {
        return "employee{"
                + "name='" + name + '\''
                + "number='" + emplNbr + '\''
                + '}';
    }
}