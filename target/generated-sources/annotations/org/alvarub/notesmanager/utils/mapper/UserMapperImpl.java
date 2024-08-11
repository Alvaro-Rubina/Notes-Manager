package org.alvarub.notesmanager.utils.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.alvarub.notesmanager.model.dto.NewUserDTO;
import org.alvarub.notesmanager.model.dto.UserDTO;
import org.alvarub.notesmanager.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-11T01:08:15-0300",
    comments = "version: 1.6.0.RC1, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private NoteMapper noteMapper;

    @Override
    public User newUserDTOToUser(NewUserDTO newUserDTO) {
        if ( newUserDTO == null ) {
            return null;
        }

        User user = new User();

        user.setUserName( newUserDTO.userName() );
        user.setName( newUserDTO.name() );
        user.setLastName( newUserDTO.lastName() );

        return user;
    }

    @Override
    public UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.notes( noteMapper.noteListToNoteDTOList( user.getNotes() ) );
        userDTO.userID( user.getUserID() );
        userDTO.userName( user.getUserName() );
        userDTO.name( user.getName() );
        userDTO.lastName( user.getLastName() );

        return userDTO.build();
    }

    @Override
    public List<UserDTO> userListToUserDTOList(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( users.size() );
        for ( User user : users ) {
            list.add( userToUserDTO( user ) );
        }

        return list;
    }
}
