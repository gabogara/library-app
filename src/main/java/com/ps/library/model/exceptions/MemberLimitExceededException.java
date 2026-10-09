package com.ps.library.model.exceptions;

public class MemberLimitExceededException extends DomainException {
    public MemberLimitExceededException(String message) { super(message); }
}
