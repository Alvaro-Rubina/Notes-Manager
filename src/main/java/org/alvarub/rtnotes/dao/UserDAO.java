package org.alvarub.rtnotes.dao;

import org.alvarub.rtnotes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
}
