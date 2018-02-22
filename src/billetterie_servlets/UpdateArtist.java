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
import billetterie_console.PersonArtist;
import billetterie_interfaceREST.HibernateUtil;

/**
 * Servlet implementation class UpdateArtist
 */
@WebServlet("/UpdateArtist")
public class UpdateArtist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateArtist() {
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
	  ServletContext context = getServletContext();

    long artistID = Long.parseLong(request.getParameter("artistID"));
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    
    Artist artist = session.get(Artist.class, artistID);
    tx.commit();
    
    System.out.println("Generating artist " + artist + " update page");
    
    context.setAttribute("artist", artist);
    context.setAttribute("isPerson", artist instanceof PersonArtist);
    RequestDispatcher dispatcher = context.getRequestDispatcher("/UpdateArtist.jsp");
    dispatcher.forward(request, response);
	}

}
