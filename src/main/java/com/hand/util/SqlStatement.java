package com.hand.util;

public class SqlStatement {

	public static class CustomerSql {

		public static final String insert = "insert into fs_product(pname,pdescription,category1,category2,pfilepath,pcolor,pstatus) values(?,?,?,?,?,?,?)";
		public static final String update = "update fs_product set pname=?,pdescription=?,category1=?,category2=?,pfilepath=?,pcolor=?,pstatus=? where pno=?";
		public static final String select = "select customer_id,first_name from customer where 1=1";
		public static final String delete = "delete fs_product where pno = ?";
		public static final String selectActPro="select a.ano, a.pno,b.pname,b.pdescription,b.category1,b.category2,b.pfilepath,b.pcreatetime,b.pcolor,b.pstatus from fs_productactivity a inner join fs_product b on a.pno=b.pno where 1=1";
	}
	
	public static class FilmSql {

		public static final String insert = "insert into film(title,description,language_id) values(?,?,?)";
		public static final String update = "update film set title=?,description=?,language_id=? where film_id=?";
		public static final String select = "select film_id,title,description,f.language_id language_id,name from film f,language l where l.language_id=f.language_id";
		public static final String delete = "delete film where film_id = ?";
	
	}
	
	public static class  LanguageSql{

		public static final String insert = "insert into language(language_id,name) values(?,?)";
		public static final String update = "update film set name=? where language_id=?";
		public static final String select = "select language_id,name from language where 1=1";
		public static final String delete = "delete film where language_id = ?";

	}
	
	}
