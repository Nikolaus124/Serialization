package serialize;

import model.Employees;
import serialize.Serializer;

import java.io.*;

public class EmSerTxt implements Serializer<Employees> {
    private Class<Employees> clazz;

    public EmSerTxt(Class<Employees> type) {
        this.clazz = type;
    }

    public Class<Employees> getClazz() {
        return clazz;
    }

    public void setClazz(Class<Employees> clazz) {
        this.clazz = Employees.class;
    }

    @Override
    public void toFile(Employees obj, File file) throws IOException {
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
    public Employees fromFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream istream = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            istream = new ObjectInputStream(fis);
            // десериализация
            return (Employees) istream.readObject();

        } catch (FileNotFoundException e) {
            //TODO
        }
        return null;
    }

    @Override
    public String toString(Employees obj) {
        return null;
    }

    @Override
    public Employees fromString(String string) {
        return null;
    }
}
