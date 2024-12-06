package org.alvarub.notesmanager.dao;

import org.alvarub.notesmanager.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

    boolean existsByUserName(String userName);
}
