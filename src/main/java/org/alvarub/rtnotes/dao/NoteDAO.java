package org.alvarub.rtnotes.dao;

import org.alvarub.rtnotes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDAO extends JpaRepository<Note, Integer> {
}
