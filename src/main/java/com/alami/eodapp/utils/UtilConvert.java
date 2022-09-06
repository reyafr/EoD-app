/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alami.eodapp.utils;

import com.alami.eodapp.object.EoDAfter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author rey
 */
@Component
public class UtilConvert {
    
    /*Bean TO String CSV*/
    public static List<String[]> toStringArray(List<EoDAfter> emps) {
        List<String[]> records = new ArrayList<String[]>();

        // adding header record
        records.add(new String[]{"id", "Nama", "Age", "Balanced", "No 2b Thread-No", "No 3 Thread-No", "Previous Balanced",
            "Average Balanced", "No 1 Thread-No", "Free Transfer", "No 2a Thread-No"});

        Iterator<EoDAfter> it = emps.iterator();
        while (it.hasNext()) {
            EoDAfter obj = it.next();
            records.add(new String[]{obj.getId(), obj.getNama(), obj.getAge(), obj.getBalanced(),
                obj.getNo2bThreadNo(), obj.getNo3ThreadNo(), obj.getPreviousBalanced(), obj.getAverageBalanced(),
                obj.getNo1ThreadNo(), obj.getFreeTransfer(), obj.getNo2aThreadNo()});
        }
        return records;
    }
    
    public static boolean between(int i, int minValueInclusive, int maxValueInclusive) {
    return (i >= minValueInclusive && i <= maxValueInclusive);
}
    
}
