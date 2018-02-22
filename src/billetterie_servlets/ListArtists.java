package billetterie_servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import billetterie_console.Artist;
import billetterie_console.Band;
import billetterie_console.PersonArtist;
import billetterie_interfaceREST.HibernateUtil;

/**
 * Servlet implementation class ListArtists
 */
@WebServlet("/ListArtists")
public class ListArtists extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListArtists() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  List<Band> lband = new ArrayList<Band>();
	  List<PersonArtist> lpersonartist = new ArrayList<PersonArtist>();
	  
	  ServletContext context = getServletContext();
	  
	  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    
    
    List<Artist> lArtistes = (List<Artist>)session.createCriteria(Artist.class).list();
    for (Artist artist : lArtistes)
    { 
      if(artist instanceof Band)
      {
        lband.add((Band)artist);
      }
      else if (artist instanceof PersonArtist) 
      {
        lpersonartist.add((PersonArtist)artist);
      }
    }
    
    tx.commit();
    
    context.setAttribute("lband", lband);
    context.setAttribute("lpersonartist", lpersonartist);

	  
	  RequestDispatcher dispatcher = context.getRequestDispatcher("/ListArtists.jsp");
    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
