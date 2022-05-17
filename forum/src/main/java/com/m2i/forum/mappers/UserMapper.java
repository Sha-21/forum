package com.m2i.forum.mappers;

import com.m2i.forum.dto.UserDto;
import com.m2i.forum.models.Role;
import com.m2i.forum.models.User;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserMapper {
	public UserDto toDto(User user){
		Long id = user.getId();
        String username = user.getUsername();
        String email = user.getEmail();
        Set<Role> roles = user.getRoles();

        return new UserDto(id, username, email, roles);
    }

}
