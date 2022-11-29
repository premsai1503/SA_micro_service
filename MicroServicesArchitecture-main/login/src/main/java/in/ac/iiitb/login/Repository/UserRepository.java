package in.ac.iiitb.login.Repository;

import in.ac.iiitb.login.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUserid(String userid);

    User findByUsername(String name);

    User findByEmail(String username);
}