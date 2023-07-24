package org.hinson.leetcode;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class Test {

    static class Data {
        volatile int number = 0;

        Integer template_id;

        public void add() {
            this.number = number + 1;
        }
    }

    private static void testAtomic() throws InterruptedException {
        Data myData = new Data();

        if (myData.template_id != null && myData.template_id == 1) {
            System.out.println("test");
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.add();
                }
            }, "addPlusThread:" + i).start();
        }
        //等待上边20个线程结束后(预计5秒肯定结束了)，在main线程中获取最后的number
        TimeUnit.SECONDS.sleep(10);
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println("final value：" + myData.number);
    }

    public static void main(String[] args) throws InterruptedException {
        BigDecimal bigDecimal = new BigDecimal(10);
        bigDecimal.multiply(bigDecimal);
    }
}