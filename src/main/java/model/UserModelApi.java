package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiUserModel {

    private String email;
    private String password;
    private String name;

    public ApiUserModel(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public ApiUserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
