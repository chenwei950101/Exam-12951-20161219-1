package com.hand.dao1;

import java.sql.SQLException;
import java.util.List;

import com.hand.entity.Language;

public interface ILanguageDao {
	public List<Language> selLanguage() throws SQLException;
	public Language selOneLan(String parameter) throws SQLException;


}
