package Tests;

import Domain.MyClass;
import Domain.MyClassValException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyClassValidatorTest {

    @Test
    void shouldValidate() {
        MyClass mc = new MyClass("1","","12.03.2001","25min","12");

        Throwable exception = assertThrows(MyClassValException.class, () -> {
            throw new MyClassValException("Invalid");
        });
        assertEquals("Invalid", exception.getMessage());
    }
}