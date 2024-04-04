package ex2;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class JDBCAddressDaoImpl extends CoreJDBCDao implements AddressDAO{

    @Override
    public Set<Address> findAll() {
        Set<Address> addresses=new HashSet<>();
        String findAllAddressSQL = "SELECT * FROM addresses";
        try (
                PreparedStatement findAllAddress = connection.prepareStatement(findAllAddressSQL);
        ) {
            ResultSet rs = findAllAddress.executeQuery();
            while (rs.next()){
                Address ad=new Address(rs.getInt("id"),rs.getString("city"),rs.getString("street"));
                addresses.add(ad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }

    @Override
    public Set<Address> findByCity(String city) {
        return null;
    }

    @Override
    public Address insert(Address address) {
        String insertAddressSQL = "INSERT into addresses(city,street) values(?,?)";
        try (
           PreparedStatement insertAddress = connection.prepareStatement(insertAddressSQL,Statement.RETURN_GENERATED_KEYS);
        ) {
            insertAddress.setString(1,address.getCity());
            insertAddress.setString(2,address.getStreet());
            insertAddress.executeQuery();
            var generatedKeys = insertAddress.getGeneratedKeys();
            if (generatedKeys.next()) {
                address.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public void update(Address address) {

    }

    @Override
    public void delete(int addressId) {

    }
}
