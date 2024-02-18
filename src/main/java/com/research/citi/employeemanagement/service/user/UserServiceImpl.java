package com.research.citi.employeemanagement.service.user;

import com.research.citi.employeemanagement.config.ModelMapperConfig;
import com.research.citi.employeemanagement.dto.UserDTO;
import com.research.citi.employeemanagement.entity.User;
import com.research.citi.employeemanagement.exception.UserExistException;
import com.research.citi.employeemanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ModelMapperConfig modelMapperConfig;

    @Override
    public UserDTO createUser(UserDTO userDTO) throws UserExistException {

        Optional<User> existUser = userRepository.findByUserId(userDTO.getUserId());
        if(!existUser.isPresent()) {
            User user = modelMapperConfig.modelMapper().map(userDTO, User.class);
            User savedUser = userRepository.save(user);
            return modelMapperConfig.modelMapper().map(savedUser, UserDTO.class);
        } else {
            throw new UserExistException("User Already Exist");
        }
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return modelMapperConfig.modelMapper().map(users, List.class);
    }

    @Override
    public UserDTO getUser(String id) {
        Optional<User> user = userRepository.findByUserId(id);
        return modelMapperConfig.modelMapper().map(user, UserDTO.class);
    }
}
