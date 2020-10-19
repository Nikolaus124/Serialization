package serialize;

import java.io.File;
import java.io.IOException;

public interface Serializer<T> {

    void toFile(T obj, File file) throws IOException;

    T fromFile(File file) throws IOException, ClassNotFoundException;

    String toString(T obj);

    T fromString(String string);

}
