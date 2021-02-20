package co.edu.usbcali.pdg1.controller;

import co.edu.usbcali.pdg1.domain.*;
import co.edu.usbcali.pdg1.dto.TypedeviceDTO;
import co.edu.usbcali.pdg1.mapper.TypedeviceMapper;
import co.edu.usbcali.pdg1.service.TypedeviceService;

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
@RequestMapping("/api/v1/typedevice")
@CrossOrigin(origins = "*")
@Slf4j
public class TypedeviceRestController {
    @Autowired
    private TypedeviceService typedeviceService;
    @Autowired
    private TypedeviceMapper typedeviceMapper;

    @GetMapping(value = "/{tydeid}")
    public ResponseEntity<?> findById(@PathVariable("tydeid")
    Integer tydeid) throws Exception {
        log.debug("Request to findById() Typedevice");

        Typedevice typedevice = (typedeviceService.findById(tydeid).isPresent() == true)
            ? typedeviceService.findById(tydeid).get() : null;

        return ResponseEntity.ok()
                             .body(typedeviceMapper.typedeviceToTypedeviceDTO(
                typedevice));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() Typedevice");

        return ResponseEntity.ok()
                             .body(typedeviceMapper.listTypedeviceToListTypedeviceDTO(
                typedeviceService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid
    @RequestBody
    TypedeviceDTO typedeviceDTO) throws Exception {
        log.debug("Request to save Typedevice: {}", typedeviceDTO);

        Typedevice typedevice = typedeviceMapper.typedeviceDTOToTypedevice(typedeviceDTO);
        typedevice = typedeviceService.save(typedevice);

        return ResponseEntity.ok()
                             .body(typedeviceMapper.typedeviceToTypedeviceDTO(
                typedevice));
    }

    @PutMapping()
    public ResponseEntity<?> update(
        @Valid
    @RequestBody
    TypedeviceDTO typedeviceDTO) throws Exception {
        log.debug("Request to update Typedevice: {}", typedeviceDTO);

        Typedevice typedevice = typedeviceMapper.typedeviceDTOToTypedevice(typedeviceDTO);
        typedevice = typedeviceService.update(typedevice);

        return ResponseEntity.ok()
                             .body(typedeviceMapper.typedeviceToTypedeviceDTO(
                typedevice));
    }

    @DeleteMapping(value = "/{tydeid}")
    public ResponseEntity<?> delete(@PathVariable("tydeid")
    Integer tydeid) throws Exception {
        log.debug("Request to delete Typedevice");

        typedeviceService.deleteById(tydeid);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(typedeviceService.count());
    }
}
