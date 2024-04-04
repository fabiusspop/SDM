package ex2;

import java.util.Set;

public interface PersonDAO {
    Set<Person> findAll();
    Set<Person> findByName(String name);
    Person insert(Person person);
    void update(Person person);
    void delete(int personId);
}
