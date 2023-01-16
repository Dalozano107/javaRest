package com.david.backendCursoJava.services.user;

import com.david.backendCursoJava.dtos.UserDTO;
import com.david.backendCursoJava.dtos.requests.UserDetailsRequestsModel;
import com.david.backendCursoJava.dtos.responses.UserRest;
import com.david.backendCursoJava.entities.User;
import com.david.backendCursoJava.exceptions.EmailExistsException;
import com.david.backendCursoJava.repositories.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.UUID;

@Service
public class UserService implements IUserService{
    private final ModelMapper modelMapper;
    private final IUserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(ModelMapper modelMapper, IUserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @ElementCollection(fetch = FetchType.LAZY)
    public UserRest createUser(UserDetailsRequestsModel userDetails){

        if (userRepository.existsByEmail(userDetails.getEmail()))
            throw new EmailExistsException("El usuario con el email ya existe");


        User user = modelMapper.map(userDetails, User.class);

        user.setUserId(UUID.randomUUID().toString());
        user.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));

        User newUser = userRepository.save(user);
        return modelMapper.map(newUser,UserRest.class);
    }

    @Override
    @ElementCollection(fetch = FetchType.LAZY)
    public UserDTO getUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EmailExistsException("El usuario con el email ya existe"));
        return modelMapper.map(user,UserDTO.class);
    }

    @Override
    @ElementCollection(fetch = FetchType.LAZY)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EmailExistsException(String.format("No existe usuarios con el email %s", email)));

        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getEncryptedPassword(),new ArrayList<>());
    }
}
