package serialize;


import model.TransportIns;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrInsSerTxt implements Serializer<TransportIns>{
    private Class<TransportIns> clazz;

    public TrInsSerTxt(Class<TransportIns> type) {
        this.clazz = type;
    }

    public Class<TransportIns> getClazz() {
        return clazz;
    }

    public void setClazz(Class<TransportIns> clazz) {
        this.clazz = TransportIns.class;
    }

    @Override
    public void toFile(TransportIns obj, File file) throws IOException {
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
    public TransportIns fromFile(File file) throws IOException, ClassNotFoundException{
        ObjectInputStream istream = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            istream = new ObjectInputStream(fis);
            // десериализация
            return (TransportIns) istream.readObject();

        } catch (FileNotFoundException e) {
            //TODO
        }
        return null;
    }

    @Override
    public String toString(TransportIns obj) {
        return null;
    }

    @Override
    public TransportIns fromString(String string) {
        return null;
    }
}
