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
public class TypedeviceServiceImpl implements TypedeviceService{

	@Autowired
	private TypedeviceRepository typedeviceRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(Typedevice typedevice)throws ConstraintViolationException{		
		
		Set<ConstraintViolation<Typedevice>> constraintViolations =validator.validate(typedevice);
		 if (!constraintViolations.isEmpty()) {			
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return typedeviceRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Typedevice> findAll(){
		log.debug("finding all Typedevice instances");
       	return typedeviceRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)			
    public Typedevice save(Typedevice entity) throws Exception {
		log.debug("saving Typedevice instance");
	   
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("Typedevice");
		}
		
		validate(entity);	
	
		if(typedeviceRepository.existsById(entity.getTydeid())){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return typedeviceRepository.save(entity);
	   
    }
			
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void delete(Typedevice entity) throws Exception {
            	log.debug("deleting Typedevice instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("Typedevice");
	    		}
    	
                                if(entity.getTydeid()==null){
                    throw new ZMessManager().new EmptyFieldException("tydeid");
                    }
                        
            if(typedeviceRepository.existsById(entity.getTydeid())==false){
           		throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        	} 
            
            	            findById(entity.getTydeid()).ifPresent(entidad->{	            	
	                													List<Device> devices = entidad.getDevices();
							                    if(Utilities.validationsList(devices)==true){
                       	 	throw new ZMessManager().new DeletingException("devices");
                        }
	                	            });
                       

           
            
            typedeviceRepository.deleteById(entity.getTydeid());
            log.debug("delete Typedevice successful");
            
           
            	
            }
            
            @Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting Typedevice instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("tydeid");
            	}
            	if(typedeviceRepository.existsById(id)){
           			delete(typedeviceRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public Typedevice update(Typedevice entity) throws Exception {

				log.debug("updating Typedevice instance");
				
	           
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("Typedevice");
		    		}
		    		
	            validate(entity);
	            
	            
	            if(typedeviceRepository.existsById(entity.getTydeid())==false){
           			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        		}	            
	
	            return typedeviceRepository.save(entity);
	        
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<Typedevice> findById(Integer tydeid) {            
            	log.debug("getting Typedevice instance");
            	return typedeviceRepository.findById(tydeid);
            }
			
}
