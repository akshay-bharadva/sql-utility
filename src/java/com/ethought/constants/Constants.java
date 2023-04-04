/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ethought.constants;

/**
 *
 * @author Akshay
 */
public enum Constants {

    LOGS_DIRECTORY("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\logical\\logs\\"),
    CONNECTION_CONFIG("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\logical\\config\\connection.json");

    private String name;

    // ! Constructor
    Constants(String value) {
        name = value;
    }

    // ! Constant Value Getter
    public String getConstantName() {
        return name;
    }

}
