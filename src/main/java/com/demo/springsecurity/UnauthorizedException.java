package com.demo.springsecurity;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UnauthorizedException extends RuntimeException {

    protected static MessageSourceAccessor messageSourceAccessor = SpringSecurityMessageSource.getAccessor();

    public UnauthorizedException() {
        super(messageSourceAccessor.getMessage("AbstractAccessDecisionManager.accessDenied", "Access is denied"));
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
