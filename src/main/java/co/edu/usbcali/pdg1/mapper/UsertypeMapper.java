package co.edu.usbcali.pdg1.mapper;

import co.edu.usbcali.pdg1.domain.Usertype;
import co.edu.usbcali.pdg1.dto.UsertypeDTO;

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
public interface UsertypeMapper {
    public UsertypeDTO usertypeToUsertypeDTO(Usertype usertype);

    public Usertype usertypeDTOToUsertype(UsertypeDTO usertypeDTO);

    public List<UsertypeDTO> listUsertypeToListUsertypeDTO(
        List<Usertype> usertypes);

    public List<Usertype> listUsertypeDTOToListUsertype(
        List<UsertypeDTO> usertypeDTOs);
}
