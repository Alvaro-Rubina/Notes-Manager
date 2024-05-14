package org.alvarub.rtnotes.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Note {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_gen")
    @SequenceGenerator(name = "note_gen", sequenceName = "note_seq", allocationSize = 1)
    private Long noteID;
    private String title;
    private String content;
    private LocalDate date;

    // Associations
    @ManyToOne
    @JoinColumn(name = "user_user_id")
    private User user;

    // Constructors
    public Note() {

    }

    public Note(Long noteID, String title, String content, LocalDate date, User user) {
        this.noteID = noteID;
        this.title = title;
        this.content = content;
        this.date = date;
        this.user = user;
    }

    // Get set
    public Long getNoteID() {
        return noteID;
    }

    public void setNoteID(Long noteID) {
        this.noteID = noteID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}