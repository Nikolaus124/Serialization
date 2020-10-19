package serialize;

import model.DwellingIns;
import model.LifeIns;

import java.io.*;

public class DwellingInsTxt implements Serializer<DwellingIns> {
    private Class<DwellingIns> clazz;

    public DwellingInsTxt(Class<DwellingIns> type) {
        this.clazz = type;
    }

    public Class<DwellingIns> getClazz() {
        return clazz;
    }

    public void setClazz(Class<DwellingIns> clazz) {
        this.clazz = DwellingIns.class;
    }

    @Override
    public void toFile(DwellingIns obj, File file) throws IOException {
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
    public DwellingIns fromFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream istream = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            istream = new ObjectInputStream(fis);
            // десериализация
            return (DwellingIns) istream.readObject();

        } catch (FileNotFoundException e) {
            //TODO
        }
        return null;
    }

    @Override
    public String toString(DwellingIns obj) {
        return null;
    }

    @Override
    public DwellingIns fromString(String string) {
        return null;
    }
}
