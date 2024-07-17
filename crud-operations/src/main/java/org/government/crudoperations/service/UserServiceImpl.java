package org.government.crudoperations.service;

import lombok.RequiredArgsConstructor;
import org.government.crudoperations.dao.repository.UserRepository;
import org.government.crudoperations.mapper.UserMapper;
import org.government.crudoperations.model.request.UserRequest;
import org.government.crudoperations.model.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    private final UserMapper userMapper;
    @Override
    public List<UserResponse> getUsers() {
        var users = userRepository.findAll();
        return userMapper.toDTOs(users);
    }

    @Override
    public UserResponse getUserById(Long id) {
        var user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        return userMapper.toDTO(user);
    }

    @Override
    public void createUser(UserRequest userRequest) {
        var user = userMapper.fromDTO(userRequest);
        userRepository.save(user);
    }

    @Override
    public void updateUserName(Long id, String name) {
        var user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        user.setName(name);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
