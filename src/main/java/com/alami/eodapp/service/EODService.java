/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alami.eodapp.service;

import com.alami.eodapp.object.EoDAfter;
import com.alami.eodapp.utils.UtilConvert;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;

/**
 *
 * @author rey
 */
@Service
public class EODService {

    private static Integer countPoolThread = 11;

    public List<EoDAfter> averageBalance(List<EoDAfter> request) {
        List<EoDAfter> EoDAfter = new ArrayList<>();
        EoDAfter.addAll(request);
        if (!EoDAfter.isEmpty()) {
            long startExec = System.currentTimeMillis();
            ExecutorService service = null;
            try {
                /*Threads pools with the Executor Framework*/
                service = Executors.newFixedThreadPool(countPoolThread);

                for (EoDAfter o : EoDAfter) {
                    service.submit(new Runnable() {
                        @Override
                        public void run() {
                            IntStream intStream = IntStream.of(Integer.parseInt(o.getBalanced()), Integer.parseInt(o.getPreviousBalanced()));
                            OptionalDouble res = intStream.average();
                            o.setAverageBalanced(String.valueOf(res.getAsDouble()));
                            o.setNo1ThreadNo(Thread.currentThread().getName());
                        }
                    });
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(EODService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } finally {
                service.shutdown();
            }

            long endExec = System.currentTimeMillis();
            System.out.println("Duration Exec Average Balance  " + (endExec - startExec));
        }

        return EoDAfter;
    }

    public List<EoDAfter> benefit(List<EoDAfter> request) {
        List<EoDAfter> EoDAfter = new ArrayList<>();
        EoDAfter.addAll(request);
        if (!EoDAfter.isEmpty()) {
            long startExec = System.currentTimeMillis();
            ExecutorService service = null;
            try {
                /*Threads pools with the Executor Framework*/
                service = Executors.newFixedThreadPool(countPoolThread);

                for (EoDAfter o : EoDAfter) {
                    service.submit(new Runnable() {
                        @Override
                        public void run() {
                            Integer balance = Integer.parseInt(o.getBalanced());
                            if (UtilConvert.between(balance, 100, 150)) {
                                o.setFreeTransfer("5");
                                o.setNo2aThreadNo(Thread.currentThread().getName());
                            } else if (balance > 150) {
                                o.setBalanced(String.valueOf(balance + 25));
                                o.setNo2bThreadNo(Thread.currentThread().getName());
                            }
                        }
                    });
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(EODService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } finally {
                service.shutdown();
            }

            long endExec = System.currentTimeMillis();
            System.out.println("Duration Exec Benefit  " + (endExec - startExec));
        }
        return EoDAfter;
    }

    public List<EoDAfter> additionalBalance(List<EoDAfter> request) {
        List<EoDAfter> EoDAfter = new ArrayList<>();
        EoDAfter.addAll(request);
        if (!EoDAfter.isEmpty()) {
            long startExec = System.currentTimeMillis();
            ExecutorService service = null;
            try {
                /*Threads pools with the Executor Framework*/
                service = Executors.newFixedThreadPool(countPoolThread);
                for (EoDAfter o : EoDAfter) {
                    service.submit(new Runnable() {
                        @Override
                        public void run() {
                            if(Integer.valueOf(o.getId())<=100){
                                o.setNo3ThreadNo(Thread.currentThread().getName());
                                o.setBalanced(String.valueOf(Integer.valueOf(o.getBalanced())+10));
                            }
                        }
                    });
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(EODService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } finally {
                service.shutdown();
            }

            long endExec = System.currentTimeMillis();
            System.out.println("Duration Exec Benefit  " + (endExec - startExec));
        }
        return EoDAfter;
    }

}
