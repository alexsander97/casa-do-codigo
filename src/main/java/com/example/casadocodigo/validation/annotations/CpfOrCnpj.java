package com.example.casadocodigo.validation.annotations;

import org.hibernate.validator.constraints.br.CPF;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@CPF
@CNPJ
@ConstraintComposition(CompositionType.OR)
@ReportAsSingleViolation
@Documented
@Constraint(validatedBy = { })
@Target({FIELD})
@Retention(RUNTIME)
public @interface CpfOrCnpj {

    String message() default "Este CPF ou CNPJ não é válido.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}