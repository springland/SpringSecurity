
This is a sample project to demonstrate  email and google authenticator

### Email MFA

package com.springland365.springsecuritymfa.email

Supports both basic and form authentication. Form authentication is used to demonstrate email MFA

The purpose to support both basic and form is to demonstrate authentication filter chain


### How does spring security redirect request to login page

#### Redirect to /login
UsernamePasswordAuthenticationFilter
DefaultLoginPageGeneratingFilter
BasicAuthenticationFilter
AnonymousAuthenticationFilter  ( Create Anonymouse User in security context , no Authenticaiton created before this one)
ExceptionTranslationFilter
FilterSecurityInterceptor.doFilter 
    -> FilterSecuirytInterceptor.invoke
        -> AbstractSecurityInterceptor.beforeInvocation 
            -> AbstractSecurityInterceptor.attemptAuthorization
                -> AccessDecisionManager.decide  ( throws AccessDeniedException  here)

                publishEvent(new AuthorizationFailureEvent(object, attributes, authenticated, ex)) AuthorizationFailureEvent

The AuthorizationFailureEvent is handled by ExceptionTranslationFilter.handleSpringSecurityException
    ExceptionTranslationFilter.handleAccessDeniedException
        found is anonymouse then ExceptionTranslationFilter.sendStartAuthentication
            this.requestCache.saveRequest(request, response);    HttpSessionRequestCache 
            this.authenticationEntryPoint.commence(request, response, reason);
                    LoginUrlAuthenticationEntryPoint   redirect to /login



#### Build Authentication



#### Redirect back to original url

After login successfully  
UsernamePasswordAuthenticationFilter.doFilter
    -> AbstractAuthenticationProcessingFilter.successfulAuthentication
        -> this.requestCache.getRequest(request, response)  to restore the url
            getRedirectStrategy().sendRedirect(request, response, targetUrl);