package hw8.Task1.SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SAXParsing {

    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XMLHandler handler = new XMLHandler();
        parser.parse(new File("src/main/java/hw8/Task1/hospitalEmployees.xml"), handler);

        for (Employee employee : employees) {
            System.out.println(String.format("Name: %s, Position: %s, Department: %s, Experience: %d.",
                    employee.getName(), employee.getPosition(), employee.getDepartment(), employee.getTerm()));
        }
    }


    private static class XMLHandler extends DefaultHandler {

        private String name, position, department, lastElementName;
        private int term;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElementName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String data = new String(ch, start, length);
            data = data.replace("\n", "").trim();

            if (!data.isEmpty()) {
                if (lastElementName.equalsIgnoreCase("name")) {
                    name = data;
                }
                if (lastElementName.equalsIgnoreCase("position")) {
                    position = data;
                }
                if (lastElementName.equalsIgnoreCase("department")) {
                    department = data;
                }
                if (lastElementName.equalsIgnoreCase("term")) {
                    term = Integer.valueOf(data);
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (((name != null && !name.isEmpty()) && (position != null && !position.isEmpty()) &&
                    (department != null && !department.isEmpty()) && (term != 0))) {
                employees.add(new Employee(name, position, department, term));
                name = null;
                position = null;
                department = null;
                term = 0;
            }
        }


    }
}