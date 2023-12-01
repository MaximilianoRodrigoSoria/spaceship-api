package ar.com.laboratory.openapirestexample.util.exceptions;

import java.util.Map;


public class CannotParseObjectException extends BaseException {
    private static final String DESCRIPTION = "Can not parse Object ";


    public CannotParseObjectException(String detail) {
        super(DESCRIPTION +" . " +detail);
    }

    public CannotParseObjectException(String detail, Map<String, Object> variables) {
        super(DESCRIPTION +" . " +detail, variables);    }

    public CannotParseObjectException(String detail, Map<String, Object> variables, String path) {
        super(DESCRIPTION +" . " +detail, variables, path);
    }

    public CannotParseObjectException(String detail, String path) {
        super(DESCRIPTION +" . " +detail, path);
    }
}
