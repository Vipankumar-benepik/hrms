package com.vipan.hrms.RestController;

import com.vipan.hrms.Entity.UserInfo;
import com.vipan.hrms.Repository.UserRepository;
//import com.vipan.hrms.security.JwtUtils;
import com.vipan.hrms.Request.AuthRequest;
import com.vipan.hrms.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;
//    @Autowired
//    private JwtUtils jwtUtils;

//    @Autowired
//    private UserService userService;
//
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

//        String jwt = jwtUtils.generateToken(user.getUsername());
        return ResponseEntity.ok(jwtService.generateToken(authRequest.getUsername()));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserInfo user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserInfo savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/getAPI")
    public ResponseEntity<?> registerData() {
        return ResponseEntity.ok("Hello This is spring security");
    }
}
