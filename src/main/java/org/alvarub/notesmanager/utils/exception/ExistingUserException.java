package org.alvarub.notesmanager.utils.exception;

public class ExistingUserException extends RuntimeException {
    public ExistingUserException(String message) {
        super(message);
    }
}
