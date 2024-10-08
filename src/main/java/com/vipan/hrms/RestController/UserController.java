//package com.vipan.hrms.RestController;
//
//import com.sun.jdi.request.DuplicateRequestException;
//import com.vipan.hrms.Entity.User;
//import com.vipan.hrms.Service.UserService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/user")
//public class UserController {
//    private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getById(@PathVariable Long id){
//        try {
//            User user = userService.findById(id);
//            return ResponseEntity.ok(user);
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }
//
//    @GetMapping("/getuser")
//    public ResponseEntity<List<User>> getAll(){
//        List<User> users = userService.findAll();
//        return ResponseEntity.ok(users);
//    }
//
//    @PostMapping("/setuser")
//    public ResponseEntity<User> createUser(@RequestBody User user){
//        User createdUser = userService.save(user);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User updatedUser){
//        try{
//            User updatedData = userService.update(id, updatedUser);
//            return ResponseEntity.ok(updatedData);
//        }
//        catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete(@PathVariable Long id){
//        try {
//            userService.delete(id);
//            return ResponseEntity.ok("Deleted Successfully");
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such User!");
//        }
//    }
//}
