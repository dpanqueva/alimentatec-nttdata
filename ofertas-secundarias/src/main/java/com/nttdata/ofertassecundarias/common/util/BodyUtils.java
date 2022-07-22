package com.nttdata.ofertassecundarias.common.util;

import com.nttdata.ofertassecundarias.common.exception.BadRequestException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class BodyUtils {
    public void validate(BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder strErrorBuilder = new StringBuilder();
            strErrorBuilder.append("Parameters error, field(s): ");
            List<String> errors = result.getFieldErrors().stream().map(err -> err.getField().concat(Objects.requireNonNull(err.getDefaultMessage()))).collect(Collectors.toList());
            errors.forEach(strErrorBuilder::append);

            throw new BadRequestException(strErrorBuilder.toString());
        }
    }
}
