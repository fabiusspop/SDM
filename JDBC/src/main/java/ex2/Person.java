package ex2;

import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private int address;

    public Person(String name) {
        this.name = name;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(int id, String name, int address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }
}
