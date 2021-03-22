package com.gnolivos.zoo.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * 
 * @author gnolivos
 *
 */
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AnimalNotFoundException extends RuntimeException {

}
