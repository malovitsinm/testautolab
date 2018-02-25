package entities.hw4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {

    final static public User PITER = new User("epam", "1234", "PITER CHAILOVSKII");

    String login;
    String password;
    String name;

}