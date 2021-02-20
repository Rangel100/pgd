package co.edu.usbcali.pdg1.mapper;

import co.edu.usbcali.pdg1.domain.User;
import co.edu.usbcali.pdg1.dto.UserDTO;

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
public interface UserMapper {
    @Mapping(source = "device.deviid", target = "deviid_Device")
    @Mapping(source = "usertype.ustyid", target = "ustyid_Usertype")
    public UserDTO userToUserDTO(User user);

    @Mapping(source = "deviid_Device", target = "device.deviid")
    @Mapping(source = "ustyid_Usertype", target = "usertype.ustyid")
    public User userDTOToUser(UserDTO userDTO);

    public List<UserDTO> listUserToListUserDTO(List<User> users);

    public List<User> listUserDTOToListUser(List<UserDTO> userDTOs);
}
