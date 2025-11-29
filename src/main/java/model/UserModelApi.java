package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModelApi {

    private String email;
    private String password;
    private String name;

    public UserModelApi(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public UserModelApi(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
