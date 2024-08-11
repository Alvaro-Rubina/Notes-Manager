package org.alvarub.notesmanager.utils.exception;

public class NoteNotFoundException extends RuntimeException{

    public NoteNotFoundException(String message) {
        super(message);
    }
}
