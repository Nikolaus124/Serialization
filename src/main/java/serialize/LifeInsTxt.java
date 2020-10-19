package serialize;

import model.LifeIns;
import model.TransportIns;

import java.io.*;

public class LifeInsTxt implements Serializer<LifeIns> {
    private Class<LifeIns> clazz;

    public LifeInsTxt(Class<LifeIns> type) {
        this.clazz = type;
    }

    public Class<LifeIns> getClazz() {
        return clazz;
    }

    public void setClazz(Class<LifeIns> clazz) {
        this.clazz = LifeIns.class;
    }

    @Override
    public void toFile(LifeIns obj, File file) throws IOException {
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
    public LifeIns fromFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream istream = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            istream = new ObjectInputStream(fis);
            // десериализация
            return (LifeIns) istream.readObject();

        } catch (FileNotFoundException e) {
            //TODO
        }
        return null;
    }

    @Override
    public String toString(LifeIns obj) {
        return null;
    }

    @Override
    public LifeIns fromString(String string) {
        return null;
    }
}
