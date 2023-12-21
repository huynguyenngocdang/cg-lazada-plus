package com.codegym.cglazadaplusproject.validator;

public class NotNegativeDoubleValidator implements Validator{
    private double inputDouble;

    public NotNegativeDoubleValidator(double inputDouble) {
        this.inputDouble = inputDouble;
    }

    @Override
    public boolean isCheck() {
        return inputDouble >= 0;
    }

    @Override
    public boolean checkUser() {
        return false;
    }
}
