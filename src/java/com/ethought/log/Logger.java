/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ethought.log;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Akshay
 */
public class Logger {

    String FILE_NAME;
    String seperator;

    public Logger(String FILE_NAME) {
        this.FILE_NAME = FILE_NAME;
        this.seperator = "===========================================================\n\n";
    }

    public void logData(String data) {
        try ( FileWriter fw = new FileWriter(FILE_NAME, true)) {
            PrintWriter pw = new PrintWriter(fw);
            pw.println(data);
            pw.println(seperator);
            pw.close();
            fw.close();
        } catch (Exception ex) {
            System.out.println("Error in Logger.logData " + ex.getMessage());
        }
    }

    public void logError(Exception e) {
        try ( FileWriter fw = new FileWriter(FILE_NAME, true)) {
            PrintWriter pw = new PrintWriter(fw);
            e.printStackTrace(pw);
            pw.println(seperator);
            pw.close();
        } catch (Exception ex) {
            System.out.println("Error in Logger.logError " + ex.getMessage());
        }
    }
}
