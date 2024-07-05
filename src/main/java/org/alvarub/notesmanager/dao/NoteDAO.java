package org.alvarub.notesmanager.dao;

import org.alvarub.notesmanager.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDAO extends JpaRepository<Note, Integer> {
}
