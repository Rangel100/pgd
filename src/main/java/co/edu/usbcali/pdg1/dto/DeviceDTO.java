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
public class DeviceDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    private Integer deviid;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String ip;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String name;
    @NotNull
    @NotEmpty
    @Size(max = 2)
    private String state;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String status;
    private Integer tydeid_Typedevice;
    private String uno;
    private String pruebita;
}
