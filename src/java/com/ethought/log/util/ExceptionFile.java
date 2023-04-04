/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ethought.log.util;

import com.ethought.constants.Constants;
import com.ethought.log.Logger;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

/**
 *
 * @author Akshay
 */
public class ExceptionFile {

    private final String LOGS_DIRECTORY = Constants.LOGS_DIRECTORY.getConstantName();

    public void logExceptionToFile(Exception ex) {
        try {
            final String logFileName = LOGS_DIRECTORY + LocalDate.now().toString() + "-Error.log";
            File file = new File(logFileName);
            Logger logger = new Logger(logFileName);

            if (file.createNewFile()) {
                logger.logError(ex);
            } else {
                logger.logError(ex);
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void logDataToFile(String data) {
        try {
            final String logFileName = LOGS_DIRECTORY + LocalDate.now().toString() + "-Data.log";
            File file = new File(logFileName);
            Logger logger = new Logger(logFileName);

            if (file.createNewFile()) {
                logger.logData(data);
            } else {
                logger.logData(data);
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
