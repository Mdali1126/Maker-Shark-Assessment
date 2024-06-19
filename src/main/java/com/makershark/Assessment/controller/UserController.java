package com.makershark.Assessment.controller;

import com.makershark.Assessment.dto.UserDTO;
import com.makershark.Assessment.mapper.UserMapper;
import com.makershark.Assessment.model.User;
import com.makershark.Assessment.sevice.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/fetch/{username}")
    @Transactional
    public ResponseEntity<?> fetchUserByUsername(@PathVariable String username) {
        User user = userService.fetchUserByUsername(username);
        UserDTO userDTO = UserMapper.toDTO(user);
           if (user == null){
               return new ResponseEntity<>("user not found",HttpStatus.NOT_FOUND);
           }
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/update/{username}")
    public ResponseEntity<String> updateUser(@RequestBody UserDTO userDTO, @PathVariable String username) {
        User user = UserMapper.toUser(userDTO);
        User updatedUser = userService.updateUser(user, username);
        if (updatedUser == null){
            return new ResponseEntity<>("User Not Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("User Updated Successfully",HttpStatus.OK);
    }

    @DeleteMapping("/delete/{username}")
    @Transactional
    public ResponseEntity<String> deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
        return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
    }


}
