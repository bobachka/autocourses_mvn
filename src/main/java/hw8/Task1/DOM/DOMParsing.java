package hw8.Task1.DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DOMParsing {
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("src/main/java/hw8/Task1/hospitalEmployees.xml"));

        NodeList employeeList = document.getElementsByTagName("employee");

        String name, position, department;
        int term;
        for (int i = 0; i < employeeList.getLength(); i++) {
            Node node = employeeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                name = element.getElementsByTagName("name").item(0).getTextContent();
                position = element.getElementsByTagName("position").item(0).getTextContent();
                department = element.getElementsByTagName("department").item(0).getTextContent();
                term = Integer.valueOf(element.getElementsByTagName("term").item(0).getTextContent());
                employees.add(new Employee(name, position, department, term));
            }
        }
        for (Employee employee : employees) {
            System.out.printf("Name: %s, Position: %s, Department: %s, Experience: %d years.\n",
                    employee.getName(), employee.getPosition(), employee.getDepartment(), employee.getTerm());
        }

        verifyEmployee("Janka Huba");
    }

    public static void verifyEmployee(String name) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("src/main/java/hw8/Task1/hospitalEmployees.xml"));
        NodeList employeeElements = document.getElementsByTagName("employee");

        boolean found = false;
        for (int i = 0; i < employeeElements.getLength(); i++) {
            Node node = employeeElements.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if (name.equalsIgnoreCase(element.getElementsByTagName("name").item(0).getTextContent())) {
                    found = true;
                    System.out.printf("\nThere is an employee with name " + name + " Please see details:\n"
                                    + "\nName: %s, position: %s, department: %s, experience: %d years.",
                            element.getElementsByTagName("name").item(0).getTextContent(),
                            element.getElementsByTagName("position").item(0).getTextContent(),
                            element.getElementsByTagName("department").item(0).getTextContent(),
                            Integer.valueOf(element.getElementsByTagName("term").item(0).getTextContent()));
                }
            }
        }
        if (!found) {
            System.err.println("\nSorry, there is no employee with the name of " + name);
        }
    }
}
