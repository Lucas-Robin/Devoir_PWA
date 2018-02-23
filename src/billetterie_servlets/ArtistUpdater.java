package billetterie_servlets;

import java.io.IOException;

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
 * Servlet implementation class ArtistUpdater
 */
@WebServlet("/ArtistUpdater")
public class ArtistUpdater extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtistUpdater() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
    long artistID = Long.parseLong(request.getParameter("artistID"));
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    
    Artist artist = session.get(Artist.class, artistID);
    
    
    System.out.println("updating artist : " + artist);
    if(artist instanceof PersonArtist)
    {
      PersonArtist pArtist = (PersonArtist) artist;
      pArtist.setCountry(request.getParameter("country"));
      pArtist.setGenre(request.getParameter("genre"));
      pArtist.setSex(request.getParameter("sex"));
      pArtist.setRole(request.getParameter("role"));
      pArtist.setLastname(request.getParameter("lastname"));
      pArtist.setFirstname(request.getParameter("firstname"));
      pArtist.setName(request.getParameter("name"));
      session.evict(pArtist);
      session.update(pArtist);
    }
    else
    {
      Band band = (Band) artist;
      band.setCountry(request.getParameter("country"));
      band.setGenre(request.getParameter("genre"));
      band.setName(request.getParameter("name"));
      //TODO: add members op
      session.evict(band);
      session.update(band);
    }
    
    
    tx.commit();
    
//    RequestDispatcher dispatcher = context.getRequestDispatcher("/ListArtists");
//    dispatcher.forward(request, response);
    response.sendRedirect("/Devoir_PWA/ListArtists");
    
    
	}

}
