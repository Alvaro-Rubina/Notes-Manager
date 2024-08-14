package org.alvarub.notesmanager.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Note {

    //
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_gen")
    @SequenceGenerator(name = "note_gen", sequenceName = "note_seq", allocationSize = 1)
    private Long noteID;

    @Column(nullable = false)
    private String title;

    @Column(length = 500, nullable = false)
    private String content;

    private LocalDate creationDate = LocalDate.now();

    private int characterCount;

    //
    @ManyToOne
    @JoinColumn(name = "user_user_id", nullable = false)
    private User user;

    //
    public Note(String title, String content, User user) {
        this.title = title;
        setContent(content);
        this.user = user;
    }

    public void setContent(String content) {
        this.content = content;
        this.characterCount = content.length();
    }

}