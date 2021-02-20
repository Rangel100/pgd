package co.edu.usbcali.pdg1.controller;

import co.edu.usbcali.pdg1.domain.*;
import co.edu.usbcali.pdg1.dto.UserDTO;
import co.edu.usbcali.pdg1.mapper.UserMapper;
import co.edu.usbcali.pdg1.service.UserService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*")
@Slf4j
public class UserRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/{useid}")
    public ResponseEntity<?> findById(@PathVariable("useid")
    Integer useid) throws Exception {
        log.debug("Request to findById() User");

        User user = (userService.findById(useid).isPresent() == true)
            ? userService.findById(useid).get() : null;

        return ResponseEntity.ok().body(userMapper.userToUserDTO(user));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() User");

        return ResponseEntity.ok()
                             .body(userMapper.listUserToListUserDTO(
                userService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid
    @RequestBody
    UserDTO userDTO) throws Exception {
        log.debug("Request to save User: {}", userDTO);

        User user = userMapper.userDTOToUser(userDTO);
        user = userService.save(user);

        return ResponseEntity.ok().body(userMapper.userToUserDTO(user));
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid
    @RequestBody
    UserDTO userDTO) throws Exception {
        log.debug("Request to update User: {}", userDTO);

        User user = userMapper.userDTOToUser(userDTO);
        user = userService.update(user);

        return ResponseEntity.ok().body(userMapper.userToUserDTO(user));
    }

    @DeleteMapping(value = "/{useid}")
    public ResponseEntity<?> delete(@PathVariable("useid")
    Integer useid) throws Exception {
        log.debug("Request to delete User");

        userService.deleteById(useid);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(userService.count());
    }
}
