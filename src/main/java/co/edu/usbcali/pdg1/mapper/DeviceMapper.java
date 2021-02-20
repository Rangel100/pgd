package co.edu.usbcali.pdg1.mapper;

import co.edu.usbcali.pdg1.domain.Device;
import co.edu.usbcali.pdg1.dto.DeviceDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
* Mapper Build with MapStruct https://mapstruct.org
* MapStruct is a code generator that greatly simplifies the
* implementation of mappings between Java bean type
* based on a convention over configuration approach.
*/
@Mapper
public interface DeviceMapper {
    @Mapping(source = "typedevice.tydeid", target = "tydeid_Typedevice")
    public DeviceDTO deviceToDeviceDTO(Device device);

    @Mapping(source = "tydeid_Typedevice", target = "typedevice.tydeid")
    public Device deviceDTOToDevice(DeviceDTO deviceDTO);

    public List<DeviceDTO> listDeviceToListDeviceDTO(List<Device> devices);

    public List<Device> listDeviceDTOToListDevice(List<DeviceDTO> deviceDTOs);
}
