package com.crystal.demo.poundz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestA {
    @Mock
    B b;

    @InjectMocks
    A a = new A();

    @Test
    public void testAdd(){
        int i = 2, j=3;
        Mockito.when(b.bAdd(i,j)).thenReturn(5);
        Assert.assertEquals(5, a.aAdd(i,j));
        Mockito.verify(b, Mockito.times(1)).bAdd(i, j);
    }
}
