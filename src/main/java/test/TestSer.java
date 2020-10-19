package test;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.Customers;
import model.Employees;
import model.TransportIns;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import org.testng.annotations.AfterTest;

import java.io.*;
import java.util.*;


import static org.testng.Assert.*;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;


public class TestSer {
    Customers cus = new Customers(1, "Peter", "Steven", "21-04-2001", 56464,"+38054123678",656454);
    Employees emp = new Employees(1, "John", "Inc", "2017-1-25", 55448749,"+38054123678");
    TransportIns trIns = new TransportIns.Builder()
            .idi(1)
            .sn(156024)
            .cust(cus)
            .emp(emp)
            .instype("Full")
            .crd("20-03-2013")
            .term(1.5)
            .amount(2300)
            .Type("Truck")
            .Fuel("Diesel")
            .Engcap(3.5)
            .Brand("KAMAZ")
            .Model("125")
            .VIN("WWAUZ354VAND")
            .build();

    @Test
    public void testTr() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();

        xmlMapper.writeValue(new File("simpleTr.xml"), trIns);
        File file = new File("simpleTr.xml");
        assertNotNull(file);
    }
    @Test
    public void testTrxt() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();

        xmlMapper.writeValue(new File("simpleTr.txt"), trIns);
        File file = new File("simpleTr.txt");
        assertNotNull(file);
    }

    @Test
    public void testTrs() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();

        xmlMapper.writeValue(new File("simpleTr.json"), trIns);
        File file = new File("simpleTr.json");
        assertNotNull(file);
    }

    public String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }



    @Test
    public void testTrFromXmlFile_thenCorrect() throws IOException {
        File file = new File("simpleTr.xml");
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(new FileInputStream(file));
        TransportIns value = xmlMapper.readValue(xml, TransportIns.class);
        assertTrue(value.getIdi() == 1 && value.getTerm() == 1.5);
    }


    @Test
    public void trFromTxtFile_thenCorrect() throws IOException {
        File file = new File("simpleTr.txt");
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(new FileInputStream(file));
        TransportIns value = xmlMapper.readValue(xml, TransportIns.class);
        assertTrue(value.getIdi() == 1 && value.getTerm() == 1.5);
    }

    @Test
    public void trFromJavaFile_thenCorrect() throws IOException {
        File file = new File("simpleTr.json");
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(new FileInputStream(file));
        TransportIns value = xmlMapper.readValue(xml, TransportIns.class);
        assertTrue(value.getIdi() == 1 && value.getTerm() == 1.5);
    }




    @Test
    public void testC() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();

        xmlMapper.writeValue(new File("simpleC.xml"), cus);
        File file = new File("simpleC.xml");
        assertNotNull(file);
    }

    @Test
    public void testCtxt() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();

        xmlMapper.writeValue(new File("simpleC.txt"), cus);
        File file = new File("simpleC.txt");
        assertNotNull(file);
    }

    @Test
    public void testCjs() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();

        xmlMapper.writeValue(new File("simpleC.json"), cus);
        File file = new File("simpleC.json");
        assertNotNull(file);
    }

    public String inputStreamToStr(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    @Test
    public void custFromXmlFile_thenCorrect() throws IOException {
        File file = new File("simpleC.xml");
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToStr(new FileInputStream(file));
        Customers value = xmlMapper.readValue(xml, Customers.class);
        assertTrue(value.getId() == 1 && value.getIdcode() == 56464);
    }

    @Test
    public void custFromTxtFile_thenCorrect() throws IOException {
        File file = new File("simpleC.txt");
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToStr(new FileInputStream(file));
        Customers value = xmlMapper.readValue(xml, Customers.class);
        assertTrue(value.getId() == 1 && value.getIdcode() == 56464);
    }

    @Test
    public void custFromJavaFile_thenCorrect() throws IOException {
        File file = new File("simpleC.json");
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToStr(new FileInputStream(file));
        Customers value = xmlMapper.readValue(xml, Customers.class);
        assertTrue(value.getId() == 1 && value.getIdcode() == 56464);
    }

}
