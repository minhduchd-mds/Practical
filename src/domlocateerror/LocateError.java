/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domlocateerror;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;


import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author tuann
 */
public class LocateError {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println("Enter file name: ");
            Scanner scanner = new Scanner(System.in);
            String path = scanner.nextLine();
            System.out.println(path);
            DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = parser.parse(new File("src/domlocateerror/"+ path));
            
            Schema schema = SchemaFactory.
                    newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).
                    newSchema(new StreamSource(new File("src/domlocateerror/Employee-Detail.xsd")));
            Validator validator = schema.newValidator();
            validator.validate(new DOMSource(doc));
            System.out.println("valid");

        } catch (ParserConfigurationException ex) {
            System.out.println("abc");
        } catch (SAXException ex) {
            System.out.println("The end-tag for element type \"Employye\" ");
        } catch (IOException ex) {
            System.out.println("File not found");
        }

    }

}
