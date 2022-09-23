package com.springland365.springsecuritymfa.email;

public interface UserDetailsRepo {

    void createUser(
            String userName ,
            String password ,
            String email
    );

}
