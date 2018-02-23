package billetterie_interfaceREST;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.Transaction;

import billetterie_console.Artist;
import billetterie_console.Ticket;

@Path("/ticketValidator/")
@Consumes({"application/JSON", "application/xml"})
@Produces({"application/JSON", "application/xml"})
public class ValidateTicket
{
  public ValidateTicket()
  {

  }
  
  @PUT
  @Path("/{id}/")
  public Response validateTicket(@PathParam("id") String id) {
    System.out.println("----invoking validateTicket, Ticket id is: " + id);
    long idNumber = Long.parseLong(id);
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    
    Ticket t = session.get(Ticket.class, idNumber);
    
    
    if(!t.getState().equals("Validated"))
    {
      t.setState("Validated");
    
      session.save(t);
      tx.commit();
      
      return Response.ok(t).build();
    }
    else
    {
      return Response.status(Response.Status.NOT_FOUND).entity("Ticket already validated: " + t).build();
    }
    
    
  }
  
  
  
  final void init()
  {
    
  }

}
