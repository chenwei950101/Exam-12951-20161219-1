package com.hand.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hand.dao.impl.FilmDao;
import com.hand.dao.impl.LanguageDao;
import com.hand.dao1.IFilmDao;
import com.hand.dao1.ILanguageDao;
import com.hand.entity.Film;
import com.hand.entity.Language;

public class FilmAction extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IFilmDao filmDao;
	private ILanguageDao languageDao;
	public FilmAction(){
		this.filmDao=new FilmDao();
		this.languageDao=new LanguageDao();
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command=request.getParameter("command");
		if(command.endsWith("filmList")){
			filmList(request,response);
		}else if(command.equals("toUpdate")){
			toUpdate(request,response);
		}else if(command.equals("delete")){
			delete(request,response);
		}else if(command.equals("update")){
			update(request,response);
		}else if(command.equals("toAdd")){
			add(request,response);
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			Film film = wrap(request);
			int result=this.filmDao.updateFilm(film);
			if(result>0){
				request.getRequestDispatcher("filmAction?command=filmList").forward(request, response);
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		try {
			Film film=wrap(request);
			int result=this.filmDao.addFilm(film);
			if(result>0){
				response.sendRedirect("filmAction?command=filmList");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private Film wrap(HttpServletRequest req) throws SQLException {
		Film film=new Film();
		film.setTitle(req.getParameter("title"));
		film.setDescription(req.getParameter("description"));
		Language language=this.languageDao.selOneLan(req.getParameter("name"));
		film.setLanguage_id(language.getLanguage_id());
		return film;
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		int film_id=Integer.valueOf(request.getParameter("film_id"));
		try {
			int result=this.filmDao.delFilm(film_id);
			if(result>0){
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void toUpdate(HttpServletRequest request, HttpServletResponse response) {
		int film_id=Integer.valueOf(request.getParameter("film_id"));
		try {
			Film film=this.filmDao.selOneFilm(film_id);
			request.setAttribute("film", film);
			request.getRequestDispatcher("updateFilm.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void filmList(HttpServletRequest request,
			HttpServletResponse response){
		try {
			List<Film> films=filmDao.selAllFilm();
			HttpSession Session=request.getSession(true);
			List<Language> languages=this.languageDao.selLanguage();
			Session.setAttribute("languages", languages);
			Session.setAttribute("films", films);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
