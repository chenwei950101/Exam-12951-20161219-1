package com.hand.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.dao1.ICustomerDao;
import com.hand.entity.Customer;
import com.hand.util.IProResultSet;
import com.hand.util.SqlCommand;
import com.hand.util.SqlStatement;

public class CustomerDao implements ICustomerDao{

	public Customer selCus(Customer customer) throws SQLException {
		final Customer customer_=new Customer();
		Object args[] = null;
		String sql = SqlStatement.CustomerSql.select;
		if(customer!=null){
			sql+=" and first_name="+ "'"+customer.getFirst_name()+"'";
		}
		new SqlCommand(sql, args).executeQuery(new IProResultSet() {
			
			@Override
			public void resultSetToObj(ResultSet rs) throws SQLException {
			while(rs.next()){
				wrap(rs, customer_);
			}
			}
		});
		return customer_.getFirst_name()!=null?customer_:null;
	}
	
	//封装customer
	private void wrap(ResultSet rs, Customer cus) throws SQLException {
		cus.setCustomer_id(rs.getInt("customer_id"));
		cus.setFirst_name(rs.getString("first_name"));
	}

}
