package org.prog.session13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class JUnitTests2 {
    // Limitations:
    // [8..16]
    // Must include upper case and lower case letters
    // Must include at least 1 number
    // A1aaaaa  - 7 symbols - reject
    // a1aaaaaa - no upper case letters - reject
    // A1AAAAAA - no lower case letters - reject
    // Aaaaaaaa - no numerics - reject
    // A1aaaaaaaaaaaaaaa  - 17 symbols - reject

    @ParameterizedTest
    @ValueSource(strings = {"A1aaaaa", "a1aaaaaa", "A1AAAAAA", "Aaaaaaaa", "A1aaaaaaaaaaaaaaa"})
    public void passwordTest(String pwd) {
        System.out.println("Open web site");
        System.out.println("Open registration");
        System.out.println("Set user name : test user");
        System.out.println("Set password : " + pwd);
        System.out.println("Click 'register'");
        Assertions.assertTrue(true);
    }

    @ParameterizedTest
    @EnumSource(ExclusiveCar.class)
    public void carTest(ExclusiveCar car) {
        System.out.println(car.name());
        Assertions.assertFalse(car.equals(ExclusiveCar.EXCLUSIVE_CAR_3));
    }

    @ParameterizedTest
    @MethodSource("valuesSourceMethod")
    public void methodSourceTest(String value) {
        System.out.println(value);
    }

    @ParameterizedTest
    @MethodSource("valuesSourceMethod2")
    public void methodSourceTest(String value1, String value2) {
        System.out.println(value1);
        System.out.println(value2);
        Assertions.assertEquals(value1, value2);
    }

    public static Stream<Arguments> valuesSourceMethod2() {
        return Stream.of(
                Arguments.of("value 1", "value 1"),
                Arguments.of("value 2", "value 2"),
                Arguments.of("value 3", "value 5"),
                Arguments.of("value 4", "value 4"),
                Arguments.of("value 5", "value 3")
        );
    }

    public static Stream<Arguments> valuesSourceMethod() {
        return Stream.of(
                Arguments.of("value 1"),
                Arguments.of("value 2"),
                Arguments.of("value 3"),
                Arguments.of("value 4"),
                Arguments.of("value 5")
        );
    }
}
