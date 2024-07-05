package org.alvarub.notesmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Note {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_gen")
    @SequenceGenerator(name = "note_gen", sequenceName = "note_seq", allocationSize = 1)
    private Long noteID;
    private String title;
    private String content;
    private LocalDate creationDate;
    private int characterCount;

    // Associations
    @ManyToOne
    @JoinColumn(name = "user_user_id")
    private User user;

    // Constructor
    public Note(String title, String content, User user) {
        this.title = title;
        setContent(content);
        this.creationDate = LocalDate.now();
        this.user = user;
    }

    // Setter especificado para que se actualice el conteo de carácteres de la nota
    public void setContent(String content) {
        this.content = content;
        this.characterCount = content.length();
    }


}