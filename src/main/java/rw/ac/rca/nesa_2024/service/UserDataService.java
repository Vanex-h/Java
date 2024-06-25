package rw.ac.rca.nesa_2024.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rw.ac.rca.nesa_2024.entity.UserData;
import rw.ac.rca.nesa_2024.error.CustomException;
import rw.ac.rca.nesa_2024.repository.UserDataRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserDataService implements UserDetailsService {
    @Autowired
    private UserDataRepository repository;
    @Autowired
    private PasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserData> userData = repository.findByEmail(username);
        //Convert userData to UserDetails
        return userData.map(UserDataDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }
    public UserData loadCurrentUser(String username) throws UsernameNotFoundException {
        Optional<UserData> userDetail = repository.findByEmail(username);
        return userDetail
                .orElseThrow(() -> new UsernameNotFoundException("User not found " +
                        username));
    }

    public String addUser(UserData userData) {
        String password = userData.getPassword();
        String email = userData.getEmail();
        String roles=userData.getRoles();

        if (email == null || !email.contains("@") || !email.endsWith(".com")) {
            throw new CustomException("Email must be a valid email address");
        }

        if (repository.findByEmail(email).isPresent()) {
            throw new CustomException("Email already in use");
        }

        String[] roleArray = roles.split(",");
        for (String role : roleArray) {
            role = role.trim(); // remove leading and trailing spaces
            if (!role.equals("ROLE_USER") && !role.equals("ROLE_ADMIN") && !role.equals("ROLE_MANAGER")) {
                throw new CustomException("Invalid role: " + role + ". Roles must be either ROLE_USER, ROLE_ADMIN or ROLE_MANAGER");
            }
        }
        if (password == null || password.length() < 8) {
            throw new CustomException("Password must be at least 8 characters long");
        }


        if (!password.matches(".*\\d.*")) {
            throw new CustomException("Password must contain at least one number");
        }

        if (!password.matches(".*\\W.*")) {
            throw new CustomException("Password must contain at least one special character");
        }

        userData.setPassword(encoder.encode(password));
        repository.save(userData);
        return "User Added Successfully";
    }
    public List<UserData> listAll() {
        return repository.findAll();
    }
    public UserData getUserById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new CustomException("User not found with id: " + id));
    }

}


