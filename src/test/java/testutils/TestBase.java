package testutils;

import app.Application;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll()
    public static void ignite() {
        String [] args = {};
        Application.main(args);
    }

    @AfterAll()
    public static void end() {
        Application.end();
    }
}
