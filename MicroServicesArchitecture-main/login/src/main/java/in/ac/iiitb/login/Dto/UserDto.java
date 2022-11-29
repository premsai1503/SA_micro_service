package in.ac.iiitb.login.Dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link in.ac.iiitb.login.Entity.User} entity
 */
@Data
public class UserDto implements Serializable {
    private final String username;
    private final String userid;
    private final String email;
    private final String password;
}