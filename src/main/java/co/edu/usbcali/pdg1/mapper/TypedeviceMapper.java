package co.edu.usbcali.pdg1.mapper;

import co.edu.usbcali.pdg1.domain.Typedevice;
import co.edu.usbcali.pdg1.dto.TypedeviceDTO;

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
public interface TypedeviceMapper {
    public TypedeviceDTO typedeviceToTypedeviceDTO(Typedevice typedevice);

    public Typedevice typedeviceDTOToTypedevice(TypedeviceDTO typedeviceDTO);

    public List<TypedeviceDTO> listTypedeviceToListTypedeviceDTO(
        List<Typedevice> typedevices);

    public List<Typedevice> listTypedeviceDTOToListTypedevice(
        List<TypedeviceDTO> typedeviceDTOs);
}
