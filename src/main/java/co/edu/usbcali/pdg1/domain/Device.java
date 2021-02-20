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
@Table ( name="device", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


			@Id
	    @Column(name="deviid", unique=true, nullable=false)
		@NotNull
		private Integer deviid;
		
	
			@ManyToOne(fetch=FetchType.LAZY)
   		@JoinColumn(name="tydeid"  	 )
		@NotNull
		private Typedevice typedevice;	
        
						@NotNull
						@NotEmpty
			@Size(max=100)
							@Column(name="ip"  , nullable=false  )
		private String ip;	
    					@NotNull
						@NotEmpty
			@Size(max=100)
							@Column(name="name"  , nullable=false  )
		private String name;	
    					@NotNull
						@NotEmpty
			@Size(max=2)
							@Column(name="state"  , nullable=false  )
		private String state;	
    					@NotNull
						@NotEmpty
			@Size(max=1)
							@Column(name="status"  , nullable=false  )
		private String status;	
        
		@OneToMany(fetch=FetchType.LAZY, mappedBy="device")
		private List<User> users = new ArrayList<>();	
        
}	