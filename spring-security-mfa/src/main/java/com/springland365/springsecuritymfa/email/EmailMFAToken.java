package com.springland365.springsecuritymfa.email;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter


public class EmailMFAToken extends AbstractAuthenticationToken {

    String username ;

    String password ;

    String token ;

    Object  principal ;

    public EmailMFAToken(String username , String password , String token)
    {
        super(Collections.EMPTY_LIST);
        this.username = username ;
        this.password = password ;
        this.token = token ;

    }

    public EmailMFAToken(Object princial , String credentials , Collection<? extends GrantedAuthority> authorities)
    {
        super( authorities);
        this.principal = princial;
        this.password = credentials;
    }
    /**
     * Creates a token with the supplied array of authorities.
     *
     * @param authorities the collection of <tt>GrantedAuthority</tt>s for the principal
     *                    represented by this authentication object.
     */
    public EmailMFAToken(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }


    public String getToken()
    {
        return this.token ;
    }

    @Override
    public Object getCredentials() {
        return this.password;
    }

    @Override
    public Object getPrincipal() {

        return this.principal;

    }
}
