package com.hand.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author 陈伟
 *
 */
public interface IProResultSet {

	void resultSetToObj(ResultSet resultSet) throws SQLException;
	
}
