package co.edu.usbcali.pdg1.controller;

import co.edu.usbcali.pdg1.domain.*;
import co.edu.usbcali.pdg1.dto.UsertypeDTO;
import co.edu.usbcali.pdg1.mapper.UsertypeMapper;
import co.edu.usbcali.pdg1.service.UsertypeService;

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
@RequestMapping("/api/v1/usertype")
@CrossOrigin(origins = "*")
@Slf4j
public class UsertypeRestController {
    @Autowired
    private UsertypeService usertypeService;
    @Autowired
    private UsertypeMapper usertypeMapper;

    @GetMapping(value = "/{ustyid}")
    public ResponseEntity<?> findById(@PathVariable("ustyid")
    Integer ustyid) throws Exception {
        log.debug("Request to findById() Usertype");

        Usertype usertype = (usertypeService.findById(ustyid).isPresent() == true)
            ? usertypeService.findById(ustyid).get() : null;

        return ResponseEntity.ok()
                             .body(usertypeMapper.usertypeToUsertypeDTO(
                usertype));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() Usertype");

        return ResponseEntity.ok()
                             .body(usertypeMapper.listUsertypeToListUsertypeDTO(
                usertypeService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid
    @RequestBody
    UsertypeDTO usertypeDTO) throws Exception {
        log.debug("Request to save Usertype: {}", usertypeDTO);

        Usertype usertype = usertypeMapper.usertypeDTOToUsertype(usertypeDTO);
        usertype = usertypeService.save(usertype);

        return ResponseEntity.ok()
                             .body(usertypeMapper.usertypeToUsertypeDTO(
                usertype));
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid
    @RequestBody
    UsertypeDTO usertypeDTO) throws Exception {
        log.debug("Request to update Usertype: {}", usertypeDTO);

        Usertype usertype = usertypeMapper.usertypeDTOToUsertype(usertypeDTO);
        usertype = usertypeService.update(usertype);

        return ResponseEntity.ok()
                             .body(usertypeMapper.usertypeToUsertypeDTO(
                usertype));
    }

    @DeleteMapping(value = "/{ustyid}")
    public ResponseEntity<?> delete(@PathVariable("ustyid")
    Integer ustyid) throws Exception {
        log.debug("Request to delete Usertype");

        usertypeService.deleteById(ustyid);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(usertypeService.count());
    }
}
