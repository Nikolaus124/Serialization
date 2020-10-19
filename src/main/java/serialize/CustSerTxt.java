package serialize;

import model.Customers;
import model.TransportIns;

import java.io.*;

public class CustSerTxt implements Serializer<Customers>{
    private Class<Customers> clazz;

    public CustSerTxt(Class<Customers> type) {
        this.clazz = type;
    }

    public Class<Customers> getClazz() {
        return clazz;
    }

    public void setClazz(Class<Customers> clazz) {
        this.clazz = Customers.class;
    }

    @Override
    public void toFile(Customers obj, File file) throws IOException {
        ObjectOutputStream oos = null;

        try {
            FileOutputStream fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        } catch (FileNotFoundException e) {
            //TODO
        }
    }


    @Override
    public Customers fromFile(File file) throws IOException, ClassNotFoundException{
        ObjectInputStream istream = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            istream = new ObjectInputStream(fis);
            // десериализация
            return (Customers) istream.readObject();

        } catch (FileNotFoundException e) {
            //TODO
        }
        return null;
    }

    @Override
    public String toString(Customers obj) {
        return null;
    }

    @Override
    public Customers fromString(String string) {
        return null;
    }
}
