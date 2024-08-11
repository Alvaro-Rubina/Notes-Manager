package org.alvarub.notesmanager.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
public record NoteDTO (Long noteID,
                       String title,
                       String content,
                       int characterCount,
                       LocalDate creationDate,
                       String creatorUserName) {
}


