package org.alvarub.rtnotes.exception;

public class NoteNotFoundException extends RuntimeException{

    public NoteNotFoundException(String message) {
        super(message);
    }
}
