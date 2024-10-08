//package com.vipan.hrms.Service;
//
//import com.vipan.hrms.Advice.DuplicateEmailException;
//import com.vipan.hrms.Entity.User;
//import com.vipan.hrms.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    public User findById(Long id){
//        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
//    }
//
//    public Optional<User> findByUsername(String username){
//        return userRepository.findByUsername(username);
//    }
//
//    public List<User> findAll(){
//        return userRepository.findAll();
//    }
//
//    public User save(User user){
//        String username = user.getUsername();
//        Optional<User> existingUser = userRepository.findByUsername(username);
//        if(existingUser.isPresent()){
//            throw new DuplicateEmailException("Username is already Registered: " + user.getUsername());
//        }
//        return userRepository.save(user);
//    }
//
//    public User update(Long id, User updatedUser) {
//        User existingUser = findById(id);
//        existingUser.setUsername(updatedUser.getUsername());
//        existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
//        return userRepository.save(existingUser);
//    }
//
//    public void delete(Long id){
//        User user = findById(id);
//        userRepository.delete(user);
//    }
//
//}
