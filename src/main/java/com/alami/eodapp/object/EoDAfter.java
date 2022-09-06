/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alami.eodapp.object;

import com.opencsv.bean.CsvBindByName;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author rey
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EoDAfter implements Serializable {

    @CsvBindByName
    private String id;
    @CsvBindByName
    private String Nama;
    @CsvBindByName
    private String Age;
    @CsvBindByName
    private String Balanced;
    @CsvBindByName(column = "No 2b Thread-No")
    private String No2bThreadNo;
    @CsvBindByName(column = "No 3 Thread-No")
    private String No3ThreadNo;
    @CsvBindByName(column = "Previous Balanced")
    private String PreviousBalanced;
    @CsvBindByName(column = "Average Balanced")
    private String AverageBalanced;
    @CsvBindByName(column = "No 1 Thread-No")
    private String No1ThreadNo;
    @CsvBindByName(column = "Free Transfer")
    private String FreeTransfer;
    @CsvBindByName(column = "No 2a Thread-No")
    private String No2aThreadNo;

}
