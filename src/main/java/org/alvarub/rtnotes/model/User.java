package org.alvarub.rtnotes.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", allocationSize = 1)
    private Long userID;
    private String username;
    private String password;
    private String email;

    // Associations
    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Note> notes = new ArrayList<>();

    // TODO: En un futuro agregar quizás niveles de visualizacion (colaborador, vizualizacion, etc).

    // Constructors
    public User() {
    }

    public User(Long userID, String username, String password, String email) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Get set
    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
