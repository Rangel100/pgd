package co.edu.usbcali.pdg1.controller;

import co.edu.usbcali.pdg1.domain.*;
import co.edu.usbcali.pdg1.dto.DeviceDTO;
import co.edu.usbcali.pdg1.mapper.DeviceMapper;
import co.edu.usbcali.pdg1.service.DeviceService;

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
@RequestMapping("/api/v1/device")
@CrossOrigin(origins = "*")
@Slf4j
public class DeviceRestController {
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private DeviceMapper deviceMapper;

    @GetMapping(value = "/{deviid}")
    public ResponseEntity<?> findById(@PathVariable("deviid")
    Integer deviid) throws Exception {
        log.debug("Request to findById() Device");

        Device device = (deviceService.findById(deviid).isPresent() == true)
            ? deviceService.findById(deviid).get() : null;

        return ResponseEntity.ok().body(deviceMapper.deviceToDeviceDTO(device));
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() Device");

        return ResponseEntity.ok()
                             .body(deviceMapper.listDeviceToListDeviceDTO(
                deviceService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid
    @RequestBody
    DeviceDTO deviceDTO) throws Exception {
        log.debug("Request to save Device: {}", deviceDTO);

        Device device = deviceMapper.deviceDTOToDevice(deviceDTO);
        device = deviceService.save(device);

        return ResponseEntity.ok().body(deviceMapper.deviceToDeviceDTO(device));
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid
    @RequestBody
    DeviceDTO deviceDTO) throws Exception {
        log.debug("Request to update Device: {}", deviceDTO);

        Device device = deviceMapper.deviceDTOToDevice(deviceDTO);
        device = deviceService.update(device);

        return ResponseEntity.ok().body(deviceMapper.deviceToDeviceDTO(device));
    }

    @DeleteMapping(value = "/{deviid}")
    public ResponseEntity<?> delete(@PathVariable("deviid")
    Integer deviid) throws Exception {
        log.debug("Request to delete Device");

        deviceService.deleteById(deviid);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(deviceService.count());
    }
}
