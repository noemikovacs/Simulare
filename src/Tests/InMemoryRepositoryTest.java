package Tests;

import Domain.MyClass;
import Domain.MyClassValidator;
import Repository.InMemoryRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryRepositoryTest {

    @Test
    void shouldAddMyClass() {
        MyClassValidator validator =new MyClassValidator();
        InMemoryRepository inMemoryRepository = new InMemoryRepository(validator);

        MyClass mc = new MyClass("1","test","12.03.2001","2h","12");
        inMemoryRepository.add(mc);
        //if medicament was added

        assertEquals("1", mc.getId());
        assertEquals("test",mc.getName());
        assertEquals("12.03.2001",mc.getDate());
        assertEquals("2h",mc.getDuration());
        assertEquals("12",mc.getStartDate());

    }

    @Test
    void remove() {
    }

    @Test
    void shouldReturnById() {

        MyClassValidator validator =new MyClassValidator();
        InMemoryRepository inMemoryRepository = new InMemoryRepository(validator);

        MyClass mc = new MyClass("1","test","12.03.2001","2h","12");
        MyClass mc1 = new MyClass("2","test1","12.13.2001","2h","15");

        inMemoryRepository.add(mc);
        inMemoryRepository.add(mc1);

        MyClass existMc = inMemoryRepository.findById("2");

        assertEquals("2",existMc.getId());

    }

    @Test
    void shouldReturnGetAll() {
        MyClassValidator validator =new MyClassValidator();
        InMemoryRepository inMemoryRepository = new InMemoryRepository(validator);

        MyClass mc = new MyClass("1","test","12.03.2001","2h","12");
        MyClass mc1 = new MyClass("2","test1","12.13.2001","2h","15");

        inMemoryRepository.add(mc);
        inMemoryRepository.add(mc1);

        List<MyClass> allMyClass = inMemoryRepository.getAll();

        assertEquals(mc, allMyClass.get(0));
        assertEquals(mc1, allMyClass.get(1));
        assertFalse(inMemoryRepository.getAll().size() != 2);

    }
}