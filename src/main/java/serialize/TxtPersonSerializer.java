package serialize;

import model.Person;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtPersonSerializer implements Serializer<Person> {
    private static final String PATTERN_FOR_PERSON = "(Name )([^|]*)(\\|\\| BirthDay )([^.]*)(\\.)";
    private Class<Person> clazz;

    public TxtPersonSerializer(Class<Person> type) {
        this.clazz = type;
    }

    public Class<Person> getClazz() {
        return clazz;
    }

    public void setClazz(Class<Person> clazz) {
        this.clazz = Person.class;
    }

    @Override
    public void toFile(Person student, File file) {

    }

    @Override
    public Person fromFile(File file) throws IOException {
        return null;
    }

    @Override
    public String toString(Person student) {
        return String.format("Name %s || BirthDay %s.", student.getName(), student.getDateOfBirth());
    }

    @Override
    public Person fromString(String string) {
        Pattern pattern = Pattern.compile(PATTERN_FOR_PERSON);
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            Person result = new Person(matcher.group(2).substring(0, matcher.group(2).length() - 1));
            result.setDateOfBirth(LocalDate.parse(matcher.group(4)));
            return result;
        }

        throw new RuntimeException(string + "is not applicable for create Student");
    }

}
