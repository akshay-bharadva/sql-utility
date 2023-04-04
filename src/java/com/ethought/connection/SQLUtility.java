
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ethought.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author Akshay
 */
public class SQLUtility {

    private String CONNECTION_ALIAS;
    ConnectionFactory connectionFactory = new ConnectionFactory();

    public SQLUtility(String CONNECTION_ALIAS) {
        this.CONNECTION_ALIAS = CONNECTION_ALIAS;
    }

    public List getList(final String sqlQuery) throws ClassNotFoundException, SQLException {
        try ( Connection connection = initConnection()) {
            DataSource dataSource = new SingleConnectionDataSource(connection, true);
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            List list = jdbcTemplate.queryForList(sqlQuery);
            return list;
        }
    }

    public List getList(final String sqlQuery, final SqlParameterSource paramSource) throws ClassNotFoundException, SQLException {
        try ( Connection connection = initConnection()) {
            DataSource dataSource = new SingleConnectionDataSource(connection, true);
            NamedParameterJdbcTemplate npJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
            List list = npJdbcTemplate.queryForList(sqlQuery, paramSource);
            return list;
        }
    }

    public int persist(final String sqlQuery) throws ClassNotFoundException, SQLException {
        try ( Connection connection = initConnection()) {
            DataSource dataSource = new SingleConnectionDataSource(connection, true);
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            return jdbcTemplate.update(sqlQuery);
        }
    }

    public int persist(final String sqlQuery, final SqlParameterSource paramSource) throws ClassNotFoundException, SQLException {
        try ( Connection connection = initConnection()) {
            DataSource dataSource = new SingleConnectionDataSource(connection, true);
            NamedParameterJdbcTemplate npJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
            return npJdbcTemplate.update(sqlQuery, paramSource);
        }
    }

    public SqlRowSet getRowSet(final String sqlQuery) throws ClassNotFoundException, SQLException {
        try ( Connection connection = initConnection()) {
            DataSource dataSource = new SingleConnectionDataSource(connection, true);
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sqlQuery);
            return sqlRowSet;
        }

    }

    public SqlRowSet getRowSet(final String sqlQuery, final SqlParameterSource paramSource) throws ClassNotFoundException, SQLException {
        try ( Connection connection = initConnection()) {
            DataSource ds = new SingleConnectionDataSource(connection, true);
            NamedParameterJdbcTemplate npJdbcTemplate = new NamedParameterJdbcTemplate(ds);
            SqlRowSet sqlRowSet = npJdbcTemplate.queryForRowSet(sqlQuery, paramSource);
            return sqlRowSet;
        }
    }

    private Connection initConnection() throws ClassNotFoundException, SQLException {
        return connectionFactory.getSQLConnection(CONNECTION_ALIAS);
    }
}
