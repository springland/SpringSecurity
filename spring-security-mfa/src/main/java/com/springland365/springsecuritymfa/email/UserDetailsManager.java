package com.springland365.springsecuritymfa.email;

public interface UserDetailsManager {

    void createUser(
            String userName ,
            String password ,
            String email
    );

}
