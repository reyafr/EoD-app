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
public class EoDBefore implements Serializable{
    
    @CsvBindByName
    private long id;
    @CsvBindByName
    private String Nama;
    @CsvBindByName
    private String Age;
    @CsvBindByName
    private String Balanced;
    @CsvBindByName(column = "Previous Balanced")
    private String PreviousBalanced; 
    @CsvBindByName(column = "Average Balanced")
    private String AverageBalanced; 
    @CsvBindByName(column = "Free Transfer")
    private String FreeTransfer;  
    
    
}
