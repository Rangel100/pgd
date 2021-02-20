package co.edu.usbcali.pdg1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "user", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "useid", unique = true, nullable = false)
    @NotNull
    private Integer useid;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deviid")
    @NotNull
    private Device device;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ustyid")
    @NotNull
    private Usertype usertype;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    @Column(name = "email", nullable = false)
    private String email;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "status")
    private String status;
}
