package com.example.casadocodigo.validation.validators;

import com.example.casadocodigo.dtos.requests.NewClientRequest;
import com.example.casadocodigo.entities.State;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
public class CountryWithoutStateValidator implements Validator {

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
        Query query = entityManager.createQuery("select distinct c.id from State s " +
                "inner join Country c ON s.country.id = :id");
        query.setParameter("id", request.getIdCountry());

        if(query.getResultList().size() > 0 && request.getIdState() == null) {
            errors.rejectValue("idState", null,
                    "Um estado precisa ser cadastrado porque este país tem estados.");
        }
    }
}
