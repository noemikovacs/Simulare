package Repository;

import Domain.MyClass;
import Domain.MyClassValException;
import Domain.MyClassValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository {

    private Map<String, MyClass> storage = new HashMap<>();
    private MyClassValidator validator;

    /**
     * validate an element
     * @param validator
     */

    public InMemoryRepository(MyClassValidator validator){
        this.validator = validator;
    }

    /**
     * add a new element
     * @param myClass
     * @throws MyClassValException
     */
    public void add(MyClass myClass) throws MyClassValException {
        if(storage.containsKey(myClass.getId())){
            throw new RepositoryException("An element with this ID is already exists");
        }
        validator.validate(myClass);
        storage.put(myClass.getId(),myClass);
    }

    /**
     * remove an element
     * @param id
     * @throws MyClassValException
     */
    public void remove (String  id) throws MyClassValException {
        if (!storage.containsKey(id)) {
            throw new RepositoryException("There is no element with the given id to remove");
        }
        storage.remove(id);
    }

    /**
     *
     * @param id
     * @return the element by id
     */

    public MyClass findById(String id) {
        return storage.get(id);
    }


    /**
     *
     * @return list with all element
     */

    public List<MyClass> getAll() {
        return new ArrayList<>(storage.values());
    }


}
