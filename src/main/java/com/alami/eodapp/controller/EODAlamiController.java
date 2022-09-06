package com.alami.eodapp.controller;

import com.alami.eodapp.object.EoDAfter;
import com.alami.eodapp.service.EODService;
import com.alami.eodapp.utils.UtilConvert;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author rey
 */
@RestController
public class EODAlamiController {
    
    @Autowired
    private EODService service;

    @Autowired
    private UtilConvert utils; 

    @RequestMapping(value = "/v1/eodProcess", method = RequestMethod.POST, produces = "text/csv")
    public String uploadTemplateDocumentFile(@RequestParam("file") MultipartFile file) {
        List<String[]> response = new ArrayList<String[]>();
        StringWriter writer = new StringWriter();
        List<EoDAfter> EoDAfter = new ArrayList<>();
        try ( Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            /* create csv bean reader */
            CsvToBean<EoDAfter> csvToBean = new CsvToBeanBuilder(reader)
                    .withSeparator(';')
                    .withType(EoDAfter.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            EoDAfter = csvToBean.parse();

            if (!EoDAfter.isEmpty()) {
               EoDAfter =  service.averageBalance(EoDAfter);
               EoDAfter = service.benefit(EoDAfter);
               EoDAfter = service.additionalBalance(EoDAfter);
            }
            
            /*Bean to CSV*/
            CSVWriter csvWriter = new CSVWriter(writer); 
            response = utils.toStringArray(EoDAfter); 
            csvWriter.writeAll(response); 
            csvWriter.close();
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return writer.toString();
    } 

}
