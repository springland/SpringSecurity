#Spring Seucirty MFA exercise


### Custom Authentication Provider




http.basic() places BasicAuthenticationFilter into the filter chain

http.form() places UsernamePasswordAuthenticationFilter into filter chain


To use a custom authentication token need to create an authentication filter.


## It covers below

1. Custom Authentication provider  (basic)
2. Email  ( MFA)
3. Google Authenticator (MFA)
4. SMS (MFA)



To implement Email MFA we can add an email authentication token 


https://github.com/samdjstevens/java-totp
