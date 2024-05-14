package org.alvarub.rtnotes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
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

}