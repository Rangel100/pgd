package co.edu.usbcali.pdg1.service;

import co.edu.usbcali.pdg1.domain.*;
import co.edu.usbcali.pdg1.exception.*;
import co.edu.usbcali.pdg1.repository.*;
import co.edu.usbcali.pdg1.utility.Utilities;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.*;

import java.util.*;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Validator validator;

    @Override
    public void validate(User user) throws ConstraintViolationException {
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return userRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        log.debug("finding all User instances");

        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public User save(User entity) throws Exception {
        log.debug("saving User instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("User");
        }

        validate(entity);

        if (userRepository.existsById(entity.getUseid())) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        return userRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(User entity) throws Exception {
        log.debug("deleting User instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("User");
        }

        if (entity.getUseid() == null) {
            throw new ZMessManager().new EmptyFieldException("useid");
        }

        if (userRepository.existsById(entity.getUseid()) == false) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        userRepository.deleteById(entity.getUseid());
        log.debug("delete User successful");
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteById(Integer id) throws Exception {
        log.debug("deleting User instance");

        if (id == null) {
            throw new ZMessManager().new EmptyFieldException("useid");
        }

        if (userRepository.existsById(id)) {
            delete(userRepository.findById(id).get());
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public User update(User entity) throws Exception {
        log.debug("updating User instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("User");
        }

        validate(entity);

        if (userRepository.existsById(entity.getUseid()) == false) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        return userRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Integer useid) {
        log.debug("getting User instance");

        return userRepository.findById(useid);
    }
}
