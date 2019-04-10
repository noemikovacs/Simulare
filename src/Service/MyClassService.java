package Service;

import Domain.MyClass;
import Repository.InMemoryRepository;

import java.util.List;

public class MyClassService {

    private InMemoryRepository myClassRepository;

    public MyClassService(InMemoryRepository myClassRepository) {
        this.myClassRepository = myClassRepository;
    }

    /**
     * add a new element
     * @param id
     * @param name
     * @param date
     * @param duration
     * @param startDate
     */

    //String id, name, date, duration,startDate;
    public void add(String id, String name, String date, String duration, String startDate){
        MyClass mc = new MyClass(id,name,date, duration, startDate);
        myClassRepository.add(mc);
    }

    /**
     * delete an element
     * @param id
     */

    public void delete(String id){
        myClassRepository.remove(id);
    }

    /**
     *
     * @return a list with all element
     */
    public List<MyClass> getAll() {
        return myClassRepository.getAll();
    }

    public void uniqID (String id){
        MyClass mcExist = myClassRepository.findById(id);

        if (!id.equals(mcExist.getId())){
            //do nothing
        } else {
            throw new RuntimeException("This ID is still exist!");
        }
    }
}
