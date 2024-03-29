package com.joaodurante.springproject.services.validations;

import com.joaodurante.springproject.DTO.CustomerInsertDTO;
import com.joaodurante.springproject.domain.enums.CustomerType;
import com.joaodurante.springproject.repositories.CustomerRepository;
import com.joaodurante.springproject.resources.exceptions.FieldMessage;
import com.joaodurante.springproject.services.validations.utils.DocumentUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomerInsertValidator implements ConstraintValidator<CustomerInsert, CustomerInsertDTO> {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void initialize(CustomerInsert ann) {
    }

    @Override
    public boolean isValid(CustomerInsertDTO obj, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if(obj.getType().equals(CustomerType.PHYSICALPERSON.getCode()) && !DocumentUtil.isValidSsn(obj.getDocument()))
            list.add(new FieldMessage("Document", "Invalid CPF"));

        else if(obj.getType().equals(CustomerType.LEGALENTITY.getCode()) && !DocumentUtil.isValidTin(obj.getDocument()))
            list.add(new FieldMessage("Document", "Invalid CNPJ"));

        if(customerRepository.findByEmail(obj.getEmail()) != null)
            list.add(new FieldMessage("Email", "This email is already in use."));

        for (FieldMessage x : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(x.getMessage())
                    .addPropertyNode(x.getField()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
