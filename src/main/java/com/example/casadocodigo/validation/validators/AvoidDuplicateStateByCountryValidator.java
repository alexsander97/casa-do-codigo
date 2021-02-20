package com.example.casadocodigo.validation.validators;

import com.example.casadocodigo.dtos.requests.NewStateRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
public class AvoidDuplicateStateByCountryValidator implements Validator {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean supports(Class<?> clazz) {
        return NewStateRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        NewStateRequest request = (NewStateRequest) target;

        Query query = entityManager.createQuery("select s from State s where name =:name and s.country.id = :idCountry");
        query.setParameter("name", request.getName());
        query.setParameter("idCountry", request.getIdCountry());

        if(query.getResultList().size() > 0) {
            errors.rejectValue("name", null,
                    "Já existe um estado cadastrado com esse nome para esse país.");
        }
    }
}
