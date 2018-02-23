package billetterie_servlets;

import java.io.IOException;
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
import billetterie_console.Place;
import billetterie_interfaceREST.HibernateUtil;

/**
 * Servlet implementation class AddPlace
 */
@WebServlet("/AddPlace")
public class AddPlace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlace() {
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
		Place place;
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    
   
    place = new Place(request.getParameter("type"), request.getParameter("name"), 
        Integer.parseInt(request.getParameter("capacity")), request.getParameter("phonenumeber"), 
        request.getParameter("mail"), request.getParameter("infosPMR"), request.getParameter("commentary"));
    
    session.save(place);
    
    tx.commit();
    
    System.out.println("Creating new place : " + place);
    

    response.sendRedirect("/Devoir_PWA/ListPlaces");
	}

}
