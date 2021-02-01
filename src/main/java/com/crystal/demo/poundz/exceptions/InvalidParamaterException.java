package com.crystal.demo.poundz.exceptions;

public class InvalidParamaterException extends Throwable {
    public InvalidParamaterException(String number_should_be_positive) {
            super(number_should_be_positive);
    }
}
