package ex2;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class JDBCPersonDaoImpl extends CoreJDBCDao implements PersonDAO{
    public Set<Person> findAll() {
        Set<Person> persons=new HashSet<>();
        String findAllPersonsSQL = "SELECT * FROM persons";
        try (
                PreparedStatement findAllPersons = connection.prepareStatement(findAllPersonsSQL);
        ) {
            ResultSet rs = findAllPersons.executeQuery();
            while (rs.next()){
                Person p =new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("address"));
                // int adid=rs.;
                persons.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public Set<Person> findByName(String name) {
        return null;
    }

    public Person insert(Person person) {
        String insertPersonSQL = "INSERT into persons(id,name) values(?,?)";
        try (
                PreparedStatement insertPerson = connection.prepareStatement(insertPersonSQL, Statement.RETURN_GENERATED_KEYS);
        ) {
            insertPerson.setInt(1,person.getId());
            insertPerson.setString(2,person.getName());
            insertPerson.setInt(3,person.getAddress());
            insertPerson.executeQuery();
            var generatedKeys = insertPerson.getGeneratedKeys();
            if (generatedKeys.next()) {
                person.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public void update(Person name) {

    }

    @Override
    public void delete(int personId) {

    }
}
