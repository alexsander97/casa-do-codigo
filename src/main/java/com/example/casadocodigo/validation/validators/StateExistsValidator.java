package com.example.casadocodigo.validation.validators;

import com.example.casadocodigo.dtos.requests.NewClientRequest;
import com.example.casadocodigo.entities.State;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class StateExistsValidator implements Validator {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean supports(Class<?> clazz) {
        return NewClientRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        NewClientRequest request = (NewClientRequest) target;

//        verifica se o estado passado quando o país tem estados existe.
        if ( request.getIdState() != null) {
            State state = entityManager.find(State.class, request.getIdState());
            if(state == null) {
                errors.rejectValue("idState", null,
                        "Este estado não está cadastrado.");
            }
        }
    }
}
