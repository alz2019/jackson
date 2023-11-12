package com.alz2019;

import com.alz2019.model.Address;
import com.alz2019.model.Person;
import org.junit.jupiter.api.Test;

import static com.alz2019.JsonConverter.convertAnyObjectToJson;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JacksonTest {
    @Test
    public void testPerson() throws IllegalAccessException {
        Person person = new Person(11L, "John", "Doe", new Address("Minsk", "Lenina", "23B"));
        String json = convertAnyObjectToJson(person);
        assertEquals(json, "{\n" +
                "\t\"id\": 11,\n" +
                "\t\"name\": \"John\",\n" +
                "\t\"surname\": \"Doe\",\n" +
                "\t\"address\": {\n" +
                "\t\t\"town\": \"Minsk\",\n" +
                "\t\t\"street\": \"Lenina\",\n" +
                "\t\t\"house\": \"23B\"\n" +
                "\t}\n" +
                "}");
    }
}
