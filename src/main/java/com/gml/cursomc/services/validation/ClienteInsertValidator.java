package com.gml.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.gml.cursomc.domain.Cliente;
import com.gml.cursomc.domain.enums.TipoCliente;
import com.gml.cursomc.dto.ClienteNewDTO;
import com.gml.cursomc.repositories.ClienteRepository;
import com.gml.cursomc.resources.exception.FieldMessage;
import com.gml.cursomc.services.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void initialize(ClienteInsert ann) {
    }

    @Override
    public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        Cliente auxCpfouCnpj = clienteRepository.findByCpfOuCnpj(objDto.getCpfOuCnpj());

        Cliente aux = clienteRepository.findByEmail(objDto.getEmail());

        if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
            list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
        }

        else if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
            list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
        }

        else if (auxCpfouCnpj != null && objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod())) {
            list.add(new FieldMessage("cpfOuCnpj", "CPF já existente"));
        }

        else if (auxCpfouCnpj != null && objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod())) {
            list.add(new FieldMessage("cpfOuCnpj", "CNPJ já existente"));
        }

        else if (aux != null) {
            list.add(new FieldMessage("email", "Email já existente"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}