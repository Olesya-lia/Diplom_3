package data;

import com.github.javafaker.Faker;

public class TestData {

    static Faker user = new Faker();
    public static final String EMAIL = user.name().lastName()+user.number().digits(4)+"@yandex.ru";
    public static final String PASSWORD = user.regexify("[0-9]{6,12}");
    public static final String NAME = user.name().firstName();
}
