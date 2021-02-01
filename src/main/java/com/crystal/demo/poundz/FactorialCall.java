package com.crystal.demo.poundz;

import com.crystal.demo.poundz.exceptions.InvalidParamaterException;

import java.util.concurrent.Callable;

public class FactorialCall implements Callable<Integer> {
    int number = 0;
    public FactorialCall(int num) {
        this.number = num;
    }

    @Override
    public Integer call() {

        int fact=1;
        if(number < 0)
            try {
                throw new InvalidParamaterException("Number must be positive");
            } catch (InvalidParamaterException e) {
                e.printStackTrace();
            }

        for(int count=number;count>1;count--){
            fact=fact * count;
        }

        return fact;
    }


}
