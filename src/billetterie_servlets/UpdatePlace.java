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
import billetterie_console.Place;
import billetterie_interfaceREST.HibernateUtil;

/**
 * Servlet implementation class UpdatePlace
 */
@WebServlet("/UpdatePlace")
public class UpdatePlace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePlace() {
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

    long placeID = Long.parseLong(request.getParameter("placeID"));
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    
    Place place = session.get(Place.class, placeID);
    tx.commit();
    
    System.out.println("Generating place " + place + " update page");
    
    context.setAttribute("place", place);
    RequestDispatcher dispatcher = context.getRequestDispatcher("/UpdatePlace.jsp");
    dispatcher.forward(request, response);
	}

}
