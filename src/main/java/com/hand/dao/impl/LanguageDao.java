package com.hand.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.hand.dao1.ILanguageDao;


import com.hand.entity.Film;
import com.hand.entity.Language;
import com.hand.util.IProResultSet;
import com.hand.util.SqlCommand;
import com.hand.util.SqlStatement;

public class LanguageDao implements ILanguageDao{

	@Override
	public List<Language> selLanguage() throws SQLException {
		final List<Language> languages=new Vector<Language>();
		Object args[]=null;
		String sql=SqlStatement.LanguageSql.select;
		new SqlCommand(sql, args).executeQuery(new IProResultSet() {
			
			@Override
			public void resultSetToObj(ResultSet rs) throws SQLException {
				Language  language_= null;
				while (rs.next()) {
					language_ = new Language();
					wrap(rs, language_);
					languages.add(language_);

				}
			}
		});
		return languages;
	}

	 protected void wrap(ResultSet rs, Language language_) throws SQLException {
		language_.setLanguage_id(rs.getInt("language_id"));
		language_.setName(rs.getString("name"));
	}

	@Override
	public Language selOneLan(String name) throws SQLException {
		final Language language_=new Language();
		Object args[] = null;
		String sql = SqlStatement.LanguageSql.select;
		if(name!=null){
			sql+=" and name="+"'"+name+"'";
		}
		new SqlCommand(sql, args).executeQuery(new IProResultSet() {
			
			@Override
			public void resultSetToObj(ResultSet rs) throws SQLException {
			while(rs.next()){
				wrap(rs, language_);
			}
			}
		});
		return language_!=null?language_:null;
}}
