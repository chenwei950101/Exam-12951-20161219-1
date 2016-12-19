package com.hand.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.hand.util.ConnectionFactory;

public class ConnectonFactoryTest {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory cf=ConnectionFactory.getInstance();
		Connection conn=cf.makeConnection();
		System.out.println(conn.getAutoCommit());

	}

}
