package in.ac.iiitb.login.Service;

import in.ac.iiitb.login.Entity.User;
import in.ac.iiitb.login.Dto.UserDto;


public interface UserService {
    boolean checkCredentials(String username, String password);

    User addUser(UserDto newUser);
}
