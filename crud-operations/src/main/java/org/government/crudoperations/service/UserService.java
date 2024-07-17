package org.government.crudoperations.service;

import org.government.crudoperations.model.request.UserRequest;
import org.government.crudoperations.model.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getUsers();
    UserResponse getUserById(Long id);
    void createUser(UserRequest userRequest);
    void updateUserName(Long id, String name);
    void deleteUser(Long id);



}
