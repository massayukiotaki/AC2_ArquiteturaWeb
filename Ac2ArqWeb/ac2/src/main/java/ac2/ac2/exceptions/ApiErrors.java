package ac2.ac2.exceptions;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class ApiErrors {
    @Getter
    private List<String> errors;
    public ApiErrors(String mensagemError) {
        errors = Arrays.asList(mensagemError);
    }
}
