package org.alvarub.notesmanager.mapper;

import org.alvarub.notesmanager.dto.NewUserDTO;
import org.alvarub.notesmanager.dto.UserDTO;
import org.alvarub.notesmanager.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = NoteMapper.class)
public interface UserMapper {

    // Mapeos
    User newUserDTOToUser(NewUserDTO newUserDTO);

    @Mapping(source = "notes", target = "notes")
    UserDTO userToUserDTO(User user);

    List<UserDTO> userListToUserDTOList(List<User> users);
}
