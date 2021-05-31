package com.javaconcurrencyinaction;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 *对大size的List<Integer>进行求和
 * 提示 多线程处理(超大的一个List，里面为数字，对这个列表的所有的数据求和,用多线程实现)
 */
public class BigSizeListSumTest {

    private ExecutorService executorService = Executors.newFixedThreadPool(3);

    @Test
    public void splitListTest() {
        List<Integer> bigList = new ArrayList<>();
        int size = 10000000;
        for (int i = 0; i < size; i++) {
            bigList.add(1);
        }
        int nThread = 3;
        Integer avg = size / nThread;
        int begin = 0;
        int end = avg;
        List<Future<Integer>> futureList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<Integer> list = bigList.subList(begin, end);
            Future future = executorService.submit(new Task(list));
            futureList.add(future);
            if (i != 2) {
                begin = begin + avg;
                end = end + avg;
            }
        }
        Integer sum = 0;
        if (end != size) {
            List<Integer> remain = bigList.subList(end, size);
            for (Integer r : remain) {
                sum = sum + r;
            }
        }
        for (Future<Integer> f : futureList) {
            try {
                Integer result = f.get();
                sum = sum + result;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("sum:" + sum);


    }


    class Task implements Callable<Integer> {

        private List<Integer> list;

        public Task(List<Integer> list) {
            this.list = list;
        }

        public Integer call() {
            int sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }
            return sum;
        }
    }

    @Test
    public void splitListTest2() {
        List<Integer> bigList = new ArrayList<>();
        int size = 10000000;
        for (int i = 0; i < size; i++) {
            bigList.add(1);
        }
        long sum = bigList.parallelStream().mapToInt((x) -> x.intValue()).sum();
        System.out.println(sum);
    }

}
