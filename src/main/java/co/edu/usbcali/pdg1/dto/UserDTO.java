package co.edu.usbcali.pdg1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String email;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String name;
    private String password;
    private String status;
    @NotNull
    private Integer useid;
    private Integer deviid_Device;
    private Integer ustyid_Usertype;
}
