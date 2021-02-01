package com.crystal.demo.poundz;

import org.junit.Test;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

public class FutureTest {
    @Test(expected = ExecutionException.class)
    public void whenException_ThenCallableThrowsIt() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        FactorialCall  task = new FactorialCall (-5);
        Future<Integer> future = executorService.submit(task);
        Integer result = future.get().intValue();
    }

    @Test
    public void whenException_ThenCallableDoesntThrowsItIfGetIsNotCalled()  {
        FactorialCall task = new FactorialCall(-5);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Integer> future = executorService.submit(task);
        //Integer result = future.get().intValue();
        assertEquals(false, future.isDone());
    }
}
