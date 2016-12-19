package com.hand.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.hand.dao1.IFilmDao;
import com.hand.entity.Film;
import com.hand.util.IProResultSet;
import com.hand.util.SqlCommand;
import com.hand.util.SqlStatement;


public class FilmDao implements IFilmDao{

	@Override
	public List<Film> selAllFilm() throws SQLException {
		final List<Film> films=new Vector<Film>();
		Object args[]=null;
		String sql=SqlStatement.FilmSql.select;
		new SqlCommand(sql, args).executeQuery(new IProResultSet() {
			
			@Override
			public void resultSetToObj(ResultSet rs) throws SQLException {
				Film  film_ = null;
				while (rs.next()) {
					film_ = new Film();
					wrap(rs, film_);
					 films.add(film_);

				}
			}
		});
		return films;
	}
	
	@Override
	public Film selOneFilm(int  film_id) throws SQLException {
		final Film film_=new Film();
		Object args[] = null;
		String sql = SqlStatement.FilmSql.select;
		if(film_id!=0){
			sql+=" and film_id="+film_id;
		}
		new SqlCommand(sql, args).executeQuery(new IProResultSet() {
			
			@Override
			public void resultSetToObj(ResultSet rs) throws SQLException {
			while(rs.next()){
				wrap(rs, film_);
			}
			}
		});
		return film_!=null?film_:null;
	}
	

	 protected void wrap(ResultSet rs, Film film_) throws SQLException {
		film_.setFilm_id(rs.getInt("film_id"));
		film_.setTitle(rs.getString("title"));
		film_.setDescription(rs.getString("description"));
		film_.setLanguage_id(rs.getInt("language_id"));
		film_.setName(rs.getString("name"));
	}




	@Override
	public int addFilm(Film film) throws SQLException {
		String sql=SqlStatement.FilmSql.insert;
		Object[] film_={film.getTitle(),film.getDescription(),film.getLanguage_id()};
	return new SqlCommand(sql, film_).executeUpdate();}



	@Override
	public int delFilm(int film_id) throws SQLException {
		String sql=SqlStatement.FilmSql.delete;
		Object[] args = null;
		if(film_id!=0){
			args = new Object[] { film_id };
		}
		return new SqlCommand(sql, args).executeUpdate();
	}


	@Override
	public int updateFilm(Film film) throws SQLException {
		String sql=SqlStatement.FilmSql.update;
		Object[] film_={film.getTitle(),film.getDescription(),film.getLanguage_id()};
		return new SqlCommand(sql, film_).executeUpdate();}



}
