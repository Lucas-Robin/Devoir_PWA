package billetterie_interfaceREST;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.Transaction;

import billetterie_console.Ticket;

// http://localhost:8080/Devoir_PWA/REST/Ticket/ticketmanager/
@Path("/ticketmanager/")
@Consumes({"application/JSON", "application/xml"})
@Produces({"application/JSON", "application/xml"})
public class TicketManager
{
  public TicketManager()
  {
    init();
  }

  @GET
  @Path("/ticket/{id}/")
  public Ticket getTicket(@PathParam("id") String id) {
    System.out.println("----invoking getTicket, Ticket id is: " + id);
    long idNumber = Long.parseLong(id);
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    Ticket t = session.get(Ticket.class, idNumber);
    tx.commit();
    
    return t;
  }

  @GET
  @Path("/tickets/")
  public Ticket[] getAllTicket() {
    System.out.println("----invoking getAllTicket");
    
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    
    
    List<Ticket> lTickets = (List<Ticket>)session.createCriteria(Ticket.class).list();
    tx.commit();

    
    return lTickets.toArray(new Ticket[] {});
  }

  @PUT
  @Path("/tickets/")
  @Consumes({"application/JSON", "application/xml"})
  public Response updateTicket(Ticket ticket) {
    System.out.println("----invoking updateTicket, Ticket id is: " + ticket.getId());
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    Ticket t = session.get(Ticket.class, ticket.getId());
    
    Response r;
    if (t != null) {
      session.save(ticket);
      r = Response.ok().build();
    } else {
      r = Response.notModified().build();
    }

    tx.commit();
    
    return r;
  }

  @POST
  @Path("/tickets/")
  public Response addTicket(Ticket ticket) {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    System.out.println("----invoking addTicket, Ticket id is: " + ticket.getId());
        
    session.save(ticket);
    tx.commit();
    
    return Response.ok(ticket).build();
  }

  @DELETE
  @Path("/ticket/{id}/")
  public Response deleteTicket(@PathParam("id") String id) {
    System.out.println("----invoking deleteTicket, Ticket id is: " + id);
    long idNumber = Long.parseLong(id);
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    Ticket t = session.get(Ticket.class, idNumber);

    Response r;
    if (t != null) {
      r = Response.ok().build();
      session.delete(t);
    } else {
      r = Response.notModified().build();
    }
    
    tx.commit();
    

    return r;
  }
  
  
  final void init()
  {
    

  }
  
  
}
