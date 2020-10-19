package serialize;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

@JsonIgnoreProperties(ignoreUnknown = true)

public class JsonSerializer<T> implements Serializer<T> {
        private static ObjectMapper mapper;
        private Class<T> clazz;

        public JsonSerializer(Class<T> type) {
            this.clazz=type;
            mapper = new ObjectMapper();
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

            // Convert object to JSON string and save into file directly
            try {
                mapper.writeValue(file, obj);

                // Convert object to JSON string
                String jsonInString = mapper.writeValueAsString(obj);
                //System.out.println(jsonInString);

                // Convert object to JSON string and pretty print
                jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
                System.out.println(jsonInString);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    @Override
        public T fromFile(File file) throws IOException {
            return (T) mapper.readValue(file, clazz);
        }

    @Override
    public String toString(T obj)  {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
         //Convert object to JSON string and pretty print
            //jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
        //    System.out.println(jsonInString);
    }

    @Override
    public T fromString(String string)  {
        try {
            return mapper.readValue(string, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
