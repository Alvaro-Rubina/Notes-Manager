package org.alvarub.notesmanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    //
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", allocationSize = 1)
    private Long userID;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastName;

    //
    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Note> notes = new ArrayList<>();
}
