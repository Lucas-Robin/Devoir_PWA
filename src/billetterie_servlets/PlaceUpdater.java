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
 * Servlet implementation class PlaceUpdater
 */
@WebServlet("/PlaceUpdater")
public class PlaceUpdater extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceUpdater() {
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

    long placeID = Long.parseLong(request.getParameter("placeID"));
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    
    Place place = session.get(Place.class, placeID);
    
    
    System.out.println("updating place : " + place);
    place.setCapacity(Integer.parseInt(request.getParameter("capacity")));
    place.setCommentary(request.getParameter("commentary"));
    place.setInfosPMR(request.getParameter("infosPMR"));
    place.setMail(request.getParameter("mail"));
    place.setName(request.getParameter("name"));
    place.setPhonenumber(request.getParameter("phonenumber"));
    place.setType(request.getParameter("type"));

    session.evict(place);
    session.update(place);
    
    tx.commit();
    
    response.sendRedirect("/Devoir_PWA/ListPlaces");
    
	}

}
