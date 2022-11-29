package in.ac.iiitb.login.Controller;

import in.ac.iiitb.login.Entity.User;
import in.ac.iiitb.login.Service.UserService;
import in.ac.iiitb.login.Service.UserServiceImpl;
import in.ac.iiitb.login.Dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<String>("Hello", HttpStatus.OK);
    }

    @PostMapping("/checkCredentials")
    public ResponseEntity<Boolean> checkCredentials(@RequestBody UserDto userDetails) {
        boolean isTrue = userService.checkCredentials(userDetails.getUsername(), userDetails.getPassword());
        if(isTrue) return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        return new ResponseEntity<>(Boolean.FALSE, HttpStatus.OK);
    }

//    @GetMapping("/getUserDetails")
//    public ResponseEntity<User>  getUserDetails(@RequestBody UserDto newUser) {
//    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody UserDto newUser) {
        User user = userService.addUser(newUser);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
