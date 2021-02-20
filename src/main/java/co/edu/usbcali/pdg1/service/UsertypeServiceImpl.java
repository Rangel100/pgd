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
public class UsertypeServiceImpl implements UsertypeService{

	@Autowired
	private UsertypeRepository usertypeRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(Usertype usertype)throws ConstraintViolationException{		
		
		Set<ConstraintViolation<Usertype>> constraintViolations =validator.validate(usertype);
		 if (!constraintViolations.isEmpty()) {			
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return usertypeRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Usertype> findAll(){
		log.debug("finding all Usertype instances");
       	return usertypeRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)			
    public Usertype save(Usertype entity) throws Exception {
		log.debug("saving Usertype instance");
	   
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("Usertype");
		}
		
		validate(entity);	
	
		if(usertypeRepository.existsById(entity.getUstyid())){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return usertypeRepository.save(entity);
	   
    }
			
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void delete(Usertype entity) throws Exception {
            	log.debug("deleting Usertype instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("Usertype");
	    		}
    	
                                if(entity.getUstyid()==null){
                    throw new ZMessManager().new EmptyFieldException("ustyid");
                    }
                        
            if(usertypeRepository.existsById(entity.getUstyid())==false){
           		throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        	} 
            
            	            findById(entity.getUstyid()).ifPresent(entidad->{	            	
	                													List<User> users = entidad.getUsers();
							                    if(Utilities.validationsList(users)==true){
                       	 	throw new ZMessManager().new DeletingException("users");
                        }
	                	            });
                       

           
            
            usertypeRepository.deleteById(entity.getUstyid());
            log.debug("delete Usertype successful");
            
           
            	
            }
            
            @Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting Usertype instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("ustyid");
            	}
            	if(usertypeRepository.existsById(id)){
           			delete(usertypeRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public Usertype update(Usertype entity) throws Exception {

				log.debug("updating Usertype instance");
				
	           
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("Usertype");
		    		}
		    		
	            validate(entity);
	            
	            
	            if(usertypeRepository.existsById(entity.getUstyid())==false){
           			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        		}	            
	
	            return usertypeRepository.save(entity);
	        
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<Usertype> findById(Integer ustyid) {            
            	log.debug("getting Usertype instance");
            	return usertypeRepository.findById(ustyid);
            }
			
}
