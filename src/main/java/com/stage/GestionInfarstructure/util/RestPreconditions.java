package com.stage.GestionInfarstructure.util;


import org.springframework.http.HttpStatus;

import com.stage.GestionInfarstructure.errors.MyResourceNotFoundException;

 

/**
 * Simple static methods to be called at the start of your own methods to verify correct arguments and state. If the Precondition fails, an {@link HttpStatus} code is thrown
 */
public final class RestPreconditions {

    private RestPreconditions() {
        throw new AssertionError();
    }

    // API

    /**
     * Check if some value was found, otherwise throw exception.
     * 
     * @param expression
     *            has value true if found, otherwise false
     * @throws MyResourceNotFoundException
     *             if expression is false, means value not found.
     */
    public static void checkFound(final boolean expression,String message) {
        if (!expression) {
            throw new MyResourceNotFoundException("message");
        }
    }

    /**
     * Check if some value was found, otherwise throw exception.
     * 
     * @param resource
     *            has value true if found, otherwise false
     * @throws MyResourceNotFoundException
     *             if expression is false, means value not found.
     */
    public static <T> T checkFound(final T resource) {
        if (resource == null) {
            throw new MyResourceNotFoundException();
        }

        return resource;
    }
    
    public static <T> T checkFound(final T resource,String message) {
        if (resource == null) {
            throw new MyResourceNotFoundException(message);
        }

        return resource;
    }

}
