package serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

public class XmlSerializer<T> implements Serializer<T> {
    private static XmlMapper mapper;
    private Class<T> clazz;
    XmlMapper xmlMapper = new XmlMapper();

    public XmlSerializer(Class<T> type) {
        this.clazz = type;
        mapper = new XmlMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void toFile(T obj, File file) {

        try {
            xmlMapper.writeValue(file, obj);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T fromFile(File file) throws IOException{

        return xmlMapper.readValue(file, clazz);

        /*
        try {

            return xmlMapper.readValue(file, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }

         */
    }

    @Override
    public String toString(T obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public T fromString(String string) {
        try {
            return mapper.readValue(string, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
