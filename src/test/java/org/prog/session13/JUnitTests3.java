package org.prog.session13;

import org.junit.jupiter.api.*;

public class JUnitTests3 {

    @BeforeAll
    public static void setUp() {
        System.out.println("Start BROWSER");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("Terminate BROWSER");
    }

    @BeforeEach
    public void beforeTest(){
        System.out.println("Load Home Page");
    }

    @AfterEach
    public void afterTest(){
        System.out.println("Clear Cookies");
        System.out.println("Load about:blank");
    }

    @Test
    public void cancelRegTest() {
        System.out.println("Click Reg button");
        System.out.println("Fill user credentials");
        System.out.println("Cancel reg by pressing 'cancel'");
    }

    @Test
    public void cancelRegTest2() {
        System.out.println("Click Reg button");
        System.out.println("Fill user credentials");
        System.out.println("Close reg form by pressing ESC");
    }
}
