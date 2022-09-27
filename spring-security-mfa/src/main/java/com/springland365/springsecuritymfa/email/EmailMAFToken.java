package com.springland365.springsecuritymfa.email;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

public class EmailMAFToken extends AbstractAuthenticationToken {

    String username ;

    String password ;


    String token ;

    public EmailMAFToken(String username , String password , String token)
    {
        super(Collections.EMPTY_LIST);
        this.username = username ;
        this.password = password ;
        this.token = token ;

    }

    /**
     * Creates a token with the supplied array of authorities.
     *
     * @param authorities the collection of <tt>GrantedAuthority</tt>s for the principal
     *                    represented by this authentication object.
     */
    public EmailMAFToken(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }


    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {

        return new EmailMFAUserDetails(username , password , null ,  Collections.EMPTY_LIST);

    }
}
