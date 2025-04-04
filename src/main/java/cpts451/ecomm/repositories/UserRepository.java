package cpts451.ecomm.repositories;

import cpts451.ecomm.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>
{
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.phoneNumber =:phoneNumber")
    User findByPhoneNumber(String phoneNumber);

    @Query("SELECT u FROM User u WHERE u.userId =:userId")
    User findById(int userId);
}
