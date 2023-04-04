/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ethought.trial.error.main;

import com.ethought.connection.SQLUtility;
import com.ethought.log.Logger;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Akshay
 */
public class Experiment {

    public static void main(String[] args) {
        SQLUtility sqlUtility = new SQLUtility("locaalhost");
        Logger logger = new Logger("C:\\Users\\Akshay\\Documents\\NetBeansProjects\\SQLUtility\\web\\logs\\logs.log");
        try {
            String sql = "SELECT * FROM abc;";
            List l = sqlUtility.getList(sql);
            for (Object o : l) {

                System.out.println(o);
            }
            logger.logData(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            logger.logError(ex);
        }
    }
}
