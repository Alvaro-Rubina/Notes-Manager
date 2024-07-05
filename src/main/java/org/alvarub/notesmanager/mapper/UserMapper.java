package org.alvarub.notesmanager.mapper;

import org.alvarub.notesmanager.dto.UserDTO;
import org.alvarub.notesmanager.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = NoteMapper.class)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // Mapeos
    @Mapping(source = "notes", target = "notes")
    UserDTO userToUserDTO(User user);

    List<UserDTO> userListToUserDTOList(List<User> users);
}
