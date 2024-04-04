package ex2;

import java.sql.Connection;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // JDBCAddressDaoImpl addressDao=new JDBCAddressDaoImpl();
        // Set<Address> addresses=addressDao.findAll();
        // addresses.stream().forEach(System.out::println);

        // Address newAddress = new Address("Iasi","Principala");
        // addressDao.insert(newAddress);
        // System.out.println("==============================");
        // addresses=addressDao.findAll();
        // addresses.stream().forEach(System.out::println);
        // addressDao.closeConnection();

        JDBCPersonDaoImpl personDao = new JDBCPersonDaoImpl();
        Set<Person> persons = personDao.findAll();
        persons.stream().forEach(System.out::println);

        Person newPerson = new Person(17, "Fabiussss", 11);
        personDao.insert(newPerson);
        Person newPerson1 = new Person(18, "Seveerrrrr", 22);
        personDao.insert(newPerson1);
        Person newPerson2 = new Person(19, "Johnnnnnn", 33);
        personDao.insert(newPerson2);
        System.out.println("==============================");
        persons=personDao.findAll();
        persons.stream().forEach(System.out::println);
        personDao.closeConnection();
    }
}
