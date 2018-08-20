package com.github.ricardobaumann.loanservice.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public Authentication getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

}
