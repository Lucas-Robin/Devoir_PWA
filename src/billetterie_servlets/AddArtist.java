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
 * Servlet implementation class AjouterArtiste
 */
@WebServlet("/AddArtist")
public class AddArtist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArtist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	  ServletContext context = getServletContext();

	  Artist artist;
	  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    
    if(request.getParameter("artistType").equals("Band"))
    {
      artist = new Band(request.getParameter("name"), request.getParameter("country"), request.getParameter("genre"));
    }
    else
    {
      artist = new PersonArtist(request.getParameter("name"), request.getParameter("country"), 
          request.getParameter("genre"), request.getParameter("lastname"), request.getParameter("firstname"),
          request.getParameter("sex"), request.getParameter("role"));
    }
    
    session.save(artist);
    
    tx.commit();
    
    System.out.println("Creating new artist : " + artist);
    

    response.sendRedirect("/Devoir_PWA/ListArtists");
	}

}
