package com.javaconcurrencyinaction;

/**
 * @author junlin_huang
 * @create 2021-06-04 12:38 AM
 **/

public class FooBar {
    private volatile int count = 0;

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {


        for (int i = 0; i < n; i++) {

            while(true) {
                synchronized (FooBar.class) {
                    if (count % 2 == 0) {
                        // printFoo.run() outputs "foo". Do not change or remove this line.
                        printFoo.run();
                        count++;
                        break;
                    }
                }

            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while(true) {
                synchronized (FooBar.class) {
                    if (count % 2 == 1) {
                        // printBar.run() outputs "bar". Do not change or remove this line.
                        printBar.run();
                        count++;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("foo");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("bar");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}