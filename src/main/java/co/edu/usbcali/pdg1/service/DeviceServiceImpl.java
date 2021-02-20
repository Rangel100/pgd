package  co.edu.usbcali.pdg1.service;


import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import co.edu.usbcali.pdg1.exception.*;
import co.edu.usbcali.pdg1.repository.*;
import co.edu.usbcali.pdg1.utility.Utilities;

import co.edu.usbcali.pdg1.domain.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import lombok.extern.slf4j.Slf4j;

/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org/
* www.zathuracode.org
* 
*/

@Scope("singleton")
@Service
@Slf4j
public class DeviceServiceImpl implements DeviceService{

	@Autowired
	private DeviceRepository deviceRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(Device device)throws ConstraintViolationException{		
		
		Set<ConstraintViolation<Device>> constraintViolations =validator.validate(device);
		 if (!constraintViolations.isEmpty()) {			
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return deviceRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Device> findAll(){
		log.debug("finding all Device instances");
       	return deviceRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)			
    public Device save(Device entity) throws Exception {
		log.debug("saving Device instance");
	   
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("Device");
		}
		
		validate(entity);	
	
		if(deviceRepository.existsById(entity.getDeviid())){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return deviceRepository.save(entity);
	   
    }
			
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void delete(Device entity) throws Exception {
            	log.debug("deleting Device instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("Device");
	    		}
    	
                                if(entity.getDeviid()==null){
                    throw new ZMessManager().new EmptyFieldException("deviid");
                    }
                        
            if(deviceRepository.existsById(entity.getDeviid())==false){
           		throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        	} 
            
            	            findById(entity.getDeviid()).ifPresent(entidad->{	            	
	                													List<User> users = entidad.getUsers();
							                    if(Utilities.validationsList(users)==true){
                       	 	throw new ZMessManager().new DeletingException("users");
                        }
	                	            });
                       

           
            
            deviceRepository.deleteById(entity.getDeviid());
            log.debug("delete Device successful");
            
           
            	
            }
            
            @Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting Device instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("deviid");
            	}
            	if(deviceRepository.existsById(id)){
           			delete(deviceRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public Device update(Device entity) throws Exception {

				log.debug("updating Device instance");
				
	           
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("Device");
		    		}
		    		
	            validate(entity);
	            
	            
	            if(deviceRepository.existsById(entity.getDeviid())==false){
           			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        		}	            
	
	            return deviceRepository.save(entity);
	        
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<Device> findById(Integer deviid) {            
            	log.debug("getting Device instance");
            	return deviceRepository.findById(deviid);
            }
			
}
