package com.blanke.hanu.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import java.util.Collection;

@Setter
@Getter
public class JwtAuthenticationToken extends AbstractAuthenticationToken {
        private String username;
        private String password;

        public JwtAuthenticationToken(String username, String password) {
            super((Collection)null);
            this.password =  password;
            this.username = username;
            this.setAuthenticated(false);
        }

        @Override
        public Object getCredentials() {
            return username;
        }

        @Override
        public Object getPrincipal() {
            return username;
        }

}
