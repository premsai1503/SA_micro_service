package in.ac.iiitb.login.Service;

import in.ac.iiitb.login.Entity.User;
import in.ac.iiitb.login.Repository.UserRepository;
import in.ac.iiitb.login.Dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepo;


    @Override
    public boolean checkCredentials(String username, String password) {
        Optional<User> user= Optional.ofNullable(userRepo.findByUsername(username));
        if(user.isPresent()){
            return Objects.equals(user.get().getPassword(), password);
        }
        user= Optional.ofNullable(userRepo.findByEmail(username));
        if(user.isPresent()){
            return Objects.equals(user.get().getPassword(), password);
        }
        return false;
    }

    @Override
    public User addUser(UserDto newUser) {
        boolean exists = userRepo.existsByUserid(newUser.getUserid());
        if (!exists) {
            User user = new User();
            user.setEmail(newUser.getEmail());
            user.setPassword(newUser.getPassword());
            user.setUsername(newUser.getUsername());
            user.setUserid(newUser.getUserid());
            userRepo.save(user);
            return user;
        }
        return null;
    }
}
