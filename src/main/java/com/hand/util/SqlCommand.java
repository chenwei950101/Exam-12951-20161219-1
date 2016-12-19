package com.hand.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlCommand extends JDBCcon {

	private String sql;
	private Object[] args;
	
	public SqlCommand(String sql,Object[] args) {
		this.sql = sql;
		this.args = args;
	}
	
	public void executeQuery(IProResultSet proResultSet) throws SQLException{
		Connection con = this.getConnection();
		PreparedStatement ps = con.prepareStatement(this.sql);
		this.setArgs(ps);
		ResultSet rs = ps.executeQuery();
		proResultSet.resultSetToObj(rs);
		this.close(con, ps, rs);
	}
	
	public int executeUpdate() throws SQLException{
		int result = -1;
		Connection con = this.getConnection();
		PreparedStatement ps = con.prepareStatement(this.sql);
		this.setArgs(ps);
		result = ps.executeUpdate();
		this.close(con, ps, null);
		return result;
	}
	
	private void setArgs(PreparedStatement ps) throws SQLException {

		if(this.args==null){
			return;
		}
		for(int i=0;i<args.length;i++){
			ps.setObject(i+1, args[i]);
		}
		
	}
	
}
