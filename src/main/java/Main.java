import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.*;
import serialize.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Customers cus = new Customers(1, "Peter", "Steven", "21-04-2001", 56464,"+38054123678",656454);
        Employees emp = new Employees(1, "John", "Inc", "2017-1-25", 55448749,"+38054123678");
        //Insurance ins = new Insurance(1, 23423, cus, emp, "FULL", "21-09-2020", 1, 15600);

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

        LifeIns lifeIns = new LifeIns.Builder()
                .idi(1)
                .sn(156024)
                .cust(cus)
                .emp(emp)
                .instype("Full")
                .crd("20-03-2013")
                .term(1.5)
                .amount(2300)
                .Decl(256478954)
                .build();

        DwellingIns dweIns = new DwellingIns.Builder()
                .idi(1)
                .sn(156024)
                .cust(cus)
                .emp(emp)
                .instype("Full")
                .crd("20-03-2013")
                .term(1.5)
                .amount(2300)
                .Typedw("Квартира")
                .Square(125.05)
                .build();


/*

        //СЕРІАЛІЗАЦІЯ/ДЕСЕРІАЛІЗАЦІЯ КЛАСУ Customers

        JsonSerializer serj = new JsonSerializer<>(Customers.class);
        serj.toFile(cus, new File("files/cust.json"));
        Customers ins1 = (Customers) serj.fromFile(new File("src/cust.json"));
        System.out.println(ins1);


        XmlSerializer serx = new XmlSerializer<>(Customers.class);
        serx.toFile(cus, new File("files/cust.xml"));
        System.out.println(serx.toString(cus));
        Customers ins = (Customers) serx.fromFile(new File("src/cust.xml"));
        System.out.println(ins);


        CustSerTxt serc = new CustSerTxt(Customers.class);
        serc.toFile(cus, new File("files/cust.txt"));
        Customers desCus = (Customers) serc.fromFile(new File("src/cust.txt"));
        System.out.println(desCus.getFn());
        System.out.println(desCus.getLn());




        //СЕРІАЛІЗАЦІЯ/ДЕСЕРІАЛІЗАЦІЯ КЛАСУ Employees

        JsonSerializer serj = new JsonSerializer<>(Employees.class);
        serj.toFile(emp, new File("files/emp.json"));
        Employees desEmpj = (Employees) serj.fromFile(new File("src/emp.json"));
        System.out.println(desEmpj);


        XmlSerializer serx = new XmlSerializer<>(Employees.class);
        serx.toFile(emp, new File("files/emp.xml"));
        Employees desEmpx = (Employees) serx.fromFile(new File("src/emp.xml"));
        System.out.println(desEmpx);


        EmSerTxt sert = new EmSerTxt(Employees.class);
        sert.toFile(emp, new File("files/emp.txt"));
        Employees desEmpt = (Employees) sert.fromFile(new File("src/emp.txt"));
        System.out.println(desEmpt);




        //СЕРІАЛІЗАЦІЯ/ДЕСЕРІАЛІЗАЦІЯ КЛАСУ TransportIns

        JsonSerializer serj = new JsonSerializer(TransportIns.class);
        serj.toFile(trIns, new File("files/trins.json"));
        TransportIns ins1 = (TransportIns) serj.fromFile(new File("src/trins.json"));
        System.out.println(ins1);


        XmlSerializer serx = new XmlSerializer<>(TransportIns.class);
        serx.toFile(trIns, new File("files/trins.xml"));
        TransportIns desEmpx = (TransportIns) serx.fromFile(new File("src/trins.xml"));
        System.out.println(desEmpx);


        TrInsSerTxt ser = new TrInsSerTxt(TransportIns.class);
        ser.toFile(trIns, new File("files/trins.txt"));
        TransportIns desIns = (TransportIns) ser.fromFile(new File("src/trins.txt"));
        System.out.println(desIns);



        //СЕРІАЛІЗАЦІЯ/ДЕСЕРІАЛІЗАЦІЯ КЛАСУ LifeIns

        JsonSerializer serj = new JsonSerializer(LifeIns.class);
        serj.toFile(lifeIns, new File("files/ls.json"));
        LifeIns ins1 = (LifeIns) serj.fromFile(new File("src/ls.json"));
        System.out.println(ins1);


        XmlSerializer serx = new XmlSerializer<>(LifeIns.class);
        serx.toFile(lifeIns, new File("files/ls.xml"));
        LifeIns desEmpx = (LifeIns) serx.fromFile(new File("src/ls.xml"));
        System.out.println(desEmpx);


        LifeInsTxt serLins = new LifeInsTxt(LifeIns.class);
        serLins.toFile(lifeIns, new File("files/ls.txt"));
        LifeIns desL = (LifeIns) serLins.fromFile(new File("src/ls.txt"));
        System.out.println(desL);



        //СЕРІАЛІЗАЦІЯ/ДЕСЕРІАЛІЗАЦІЯ КЛАСУ DwellingIns

        JsonSerializer serj = new JsonSerializer(DwellingIns.class);
        serj.toFile(dweIns, new File("files/ds.json"));
        DwellingIns ins1 = (DwellingIns) serj.fromFile(new File("src/ds.json"));
        System.out.println(ins1);


        XmlSerializer serx = new XmlSerializer<>(DwellingIns.class);
        serx.toFile(dweIns, new File("files/ds.xml"));
        DwellingIns desEmpx = (DwellingIns) serx.fromFile(new File("src/ds.xml"));
        System.out.println(desEmpx);


        DwellingInsTxt serDins = new DwellingInsTxt(DwellingIns.class);
        serDins.toFile(dweIns, new File("files/ds.txt"));
        DwellingIns desD = (DwellingIns) serDins.fromFile(new File("src/ds.txt"));
        System.out.println(desD);

        */



    }

}
