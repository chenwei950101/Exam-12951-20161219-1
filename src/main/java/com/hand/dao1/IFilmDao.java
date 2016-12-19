package com.hand.dao1;

import java.sql.SQLException;
import java.util.List;

import com.hand.entity.Film;

public interface IFilmDao {
	public List<Film> selAllFilm() throws SQLException;
	public Film selOneFilm(int film_id) throws SQLException;
	public int addFilm(Film film) throws SQLException;
	public int delFilm(int film_id) throws SQLException;
	public int updateFilm(Film film) throws SQLException;

}
