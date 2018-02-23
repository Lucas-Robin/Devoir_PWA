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
import billetterie_console.Place;
import billetterie_console.Show;
import billetterie_interfaceREST.HibernateUtil;

/**
 * Servlet implementation class DeletePlace
 */
@WebServlet("/DeletePlace")
public class DeletePlace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePlace() {
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
    
    Place p = session.get(Place.class, placeID);
    for (Show show : p.getShowList())
    {
      session.delete(show);
    }

    tx.commit();
    session = HibernateUtil.getSessionFactory().getCurrentSession();
    tx = session.beginTransaction();
    
    session.delete(p);
    tx.commit();
    
    System.out.println("Deleting place : " + p);
    

    response.sendRedirect("/Devoir_PWA/ListPlaces");
	}

}
