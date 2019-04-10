package Tests;

import Domain.MyClass;
import Domain.MyClassValidator;
import Domain.MyClassValException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyClassValExceptionTest {


    @Test
    void exceptionTesting() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("a message");
        });
        assertEquals("a message", exception.getMessage());
    }


    /*@org.junit.jupiter.api.Test
    void shouldThrowAnExc(){
        MyClass mc = new MyClass("1","test","12.03.2001","2h","12");
        MyClassValidator myClassValidator = new MyClassValidator();


        assertThrows(myClassValidator.class, () ->
                myClassValidator.validate(mc));
    }*/
}