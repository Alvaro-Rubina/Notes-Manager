package org.alvarub.rtnotes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", allocationSize = 1)
    private Long userID;
    private String userName;
    private String name;
    private String lastName;

    // TODO: Estos atributos se agregarán cuando se implemente la autenticación.
    /*private String email;
    private String password;*/


    // Associations
    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Note> notes = new ArrayList<>();
}
