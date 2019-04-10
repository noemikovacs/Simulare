package Domain;

import Repository.InMemoryRepository;

public class MyClassValidator {

    /**
     *
     * @param mc
     * @throws MyClassValException
     */

    public void validate(MyClass mc) throws MyClassValException {

        if(mc.getName().isEmpty()) {
            throw new MyClassValException("Invalid!");
        }
    }
}
