package Tests;

import Domain.MyClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyClassTest {

    @org.junit.jupiter.api.Test
    void gettersShouldReturnCorrectly(){
        MyClass mc = new MyClass("1","test","12.03.2001","2h","12");

        assertEquals("1", mc.getId());
        assertEquals("test",mc.getName());
        assertEquals("12.03.2001",mc.getDate());
        assertEquals("2h",mc.getDuration());
        assertEquals("12",mc.getStartDate());

    }
    @Test
    void settersShouldSetFieldsCorrectly(){
        MyClass mc = new MyClass("1","test","12.03.2001","2h","12");

        mc.setId("2");
        mc.setName("test1");
        mc.setDate("12.03.2001");
        mc.setDuration("5h");
        mc.setStartDate("15");

        assertEquals("2",mc.getId());
        assertEquals("test1",mc.getName());
        assertEquals("12.03.2001",mc.getDate());
        assertEquals("5h",mc.getDuration());
        assertEquals("15",mc.getStartDate());
    }

    @Test
    void toStringShouldReturnALongEnoughString() {
        MyClass mc = new MyClass("1","test","12.03.2001","2h","12");

        assertTrue(mc.toString().length() > 10);
    }
}