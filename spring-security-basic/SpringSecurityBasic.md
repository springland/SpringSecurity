SpringSecurityFilter was introduced from SpringSecurity 5.4 and WebSecurityConfigurationAdapter was depreciated

The below profiles are used for each

        - security-filter-chain
        - web-security-adapter


### Users
- user  (pbkdf2)
- admin  (bcrypt)
- manager (scrypt)

This app is using thymeleaf library to display user authentication information


The role and authority relationship is not modeled ideally in spring security. In theory a role can have multiple authorities

For example user role can have read , write authority ( permission) , admin role can have read , write , delete user , add user authority. 
Then we just manage roles to add/remove authorities. However spring security implementation treats role as an authrotiy.  This means we have to
implement the role/authority relationship by ourselves.

