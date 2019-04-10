package Tests;

import Domain.MyClass;
import Domain.MyClassValidator;
import Repository.InMemoryRepository;
import Service.MyClassService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyClassServiceTest {


    @Test
    void addServiceShouldAddMyClass() {

        MyClassValidator validator =new MyClassValidator();
        InMemoryRepository inMemoryRepository = new InMemoryRepository(validator);
        MyClassService myClassService = new MyClassService(inMemoryRepository);

        MyClass mc = new MyClass("1","test","12.03.2001","2h","12");
        inMemoryRepository.add(mc);

        assertEquals(mc,myClassService.getAll().get(0));
        assertEquals(1, myClassService.getAll().size());

    }

    /*@Test
    void getAllServieShouldGetAllMyClass() {

        MyClassValidator validator =new MyClassValidator();
        InMemoryRepository inMemoryRepository = new InMemoryRepository(validator);
        MyClassService myClassService = new MyClassService(inMemoryRepository);

        MyClass mc = new MyClass("1","test","12.03.2001","2h","12");
        MyClass mc1 = new MyClass("2","test","12.03.2001","2h","12");

        myClassService.add("1","test","12.03.2001","2h","12");
        myClassService.add("2","test","12.03.2001","2h","12");



        assertEquals(mc, myClassService.getAll().get(0));
        assertEquals(mc1, myClassService.getAll().get(1));
        assertFalse(myClassService.getAll().size() != 2);
    }*/
}