
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ethought.connection;

import com.ethought.connection.util.ConnectionEntity;
import com.ethought.connection.util.GetConnectionDetails;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Akshay
 */
public class ConnectionFactory {

    public Connection getSQLConnection(final String CONNECTION_ALIAS) throws ClassNotFoundException, SQLException {

        GetConnectionDetails connectionDetails = new GetConnectionDetails();
        ConnectionEntity entity = connectionDetails.getConnectionValue(CONNECTION_ALIAS);
        if (entity != null) {

            Class.forName(entity.getDriver());
            Connection connection = DriverManager.getConnection(entity.getUrl(), entity.getUsername(), entity.getPassword());
            return connection;
        }
        return null;
    }
}
