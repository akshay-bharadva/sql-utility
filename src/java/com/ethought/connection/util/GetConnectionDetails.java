
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ethought.connection.util;

import com.ethought.constants.Constants;
import com.ethought.log.util.ExceptionFile;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Akshay
 */
public class GetConnectionDetails {

    public ConnectionEntity getConnectionValue(final String CONNECTION_NAME) {

        try {
            // ! READING JSON FILE FOR CONNECTIN ENTITY
            final String CONNECTION_FILE = Constants.CONNECTION_CONFIG.getConstantName();
            final FileReader JSON_FILE = new FileReader(CONNECTION_FILE);

            JSONParser parser = new JSONParser();
            Object object = parser.parse(JSON_FILE);
            JSONArray jsonArray = (JSONArray) object;

            // LOOP OVER JSON ARRAY TO FIND APPROPRIATE CONNECTION ENTITY
            for (Object country : jsonArray) {
                JSONObject jsonObject = (JSONObject) country;
                if (jsonObject.get("connection_name").equals(CONNECTION_NAME)) {
                    ConnectionEntity entity = new ConnectionEntity();
                    entity.setUsername((String) jsonObject.get("username"));
                    entity.setPassword((String) jsonObject.get("password"));
                    entity.setUrl((String) jsonObject.get("connection_string"));
                    entity.setDriver((String) jsonObject.get("driver"));
                    return entity;
                }
            }
        } catch (Exception ex) {
            new ExceptionFile().logExceptionToFile(ex);
        }
        new ExceptionFile().logDataToFile("No Such Connection Found (Named as : " + CONNECTION_NAME + ")");
        return null;
    }
}
