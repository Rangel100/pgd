package co.edu.usbcali.pdg1.domain;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org/
* www.zathuracode.org
* 
*/
@Entity
@Table ( name="typedevice", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Typedevice implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


			@Id
	    @Column(name="tydeid", unique=true, nullable=false)
		@NotNull
		private Integer tydeid;
		
	
	    
						@NotNull
						@NotEmpty
			@Size(max=100)
							@Column(name="name"  , nullable=false  )
		private String name;	
    				@Column(name="status"   )
		private String status;	
        
		@OneToMany(fetch=FetchType.LAZY, mappedBy="typedevice")
		private List<Device> devices = new ArrayList<>();	
        
}	