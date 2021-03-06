package org.platformlayer.auth;

public class DirectAuthenticator implements Authenticator {

    final AuthenticationToken authenticationToken;

    public DirectAuthenticator(AuthenticationToken authenticationToken) {
        this.authenticationToken = authenticationToken;
    }

    @Override
    public AuthenticationToken getAuthenticationToken() throws OpenstackAuthenticationException {
        return authenticationToken;
    }

    @Override
    public void clearAuthenticationToken() {
        // We can't do anything useful here
    }

    @Override
    public String getHost() {
        throw new UnsupportedOperationException();
    }

}
