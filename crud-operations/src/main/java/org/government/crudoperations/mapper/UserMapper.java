package org.government.crudoperations.mapper;

import org.government.crudoperations.dao.entity.User;
import org.government.crudoperations.model.request.UserRequest;
import org.government.crudoperations.model.response.UserResponse;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true))
@Component
public interface UserMapper {
    User fromDTO(UserRequest userRequest);
    UserResponse toDTO(User user);
    List<UserResponse> toDTOs(List<User> users);
}
