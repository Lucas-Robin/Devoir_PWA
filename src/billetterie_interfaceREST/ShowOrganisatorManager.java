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

import billetterie_console.ShowOrganisator;


// http://localhost:8080/Devoir_PWA/REST/ShowOrganisator/showorganisatormanager/
@Path("/showorganisatormanager/")
@Consumes({"application/JSON", "application/xml"})
@Produces({"application/JSON", "application/xml"})
public class ShowOrganisatorManager
{
  public ShowOrganisatorManager()
  {
    init();
  }

  @GET
  @Path("/showorganisator/{id}/")
  public ShowOrganisator getShowOrganisator(@PathParam("id") String id) {
    System.out.println("----invoking getShowOrganisator, ShowOrganisator id is: " + id);
    long idNumber = Long.parseLong(id);
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    ShowOrganisator so = session.get(ShowOrganisator.class, idNumber);
    tx.commit();
    
    return so;
  }

  @GET
  @Path("/showorganisators/")
  public ShowOrganisator[] getAllShowOrganisator() {
    System.out.println("----invoking getAllShowOrganisator");
    
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    
    
    List<ShowOrganisator> lShowOrganisators = (List<ShowOrganisator>)session.createCriteria(ShowOrganisator.class).list();
    tx.commit();

    
    return lShowOrganisators.toArray(new ShowOrganisator[] {});
  }

  @PUT
  @Path("/showorganisators/")
  @Consumes({"application/JSON", "application/xml"})
  public Response updateShowOrganisator(ShowOrganisator showOrganisator) {
    System.out.println("----invoking updateShowOrganisator, ShowOrganisator name is: " + showOrganisator.getName());
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    ShowOrganisator so = session.get(ShowOrganisator.class, showOrganisator.getId());
    
    Response r;
    if (so != null) {
      session.save(showOrganisator);
      r = Response.ok().build();
    } else {
      r = Response.notModified().build();
    }

    tx.commit();
    
    return r;
  }

  @POST
  @Path("/showorganisators/")
  public Response addShowOrganisator(ShowOrganisator showOrganisator) {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    System.out.println("----invoking addShowOrganisator, ShowOrganisator name is: " + showOrganisator.getName());
        
    session.save(showOrganisator);
    tx.commit();
    
    return Response.ok(showOrganisator).build();
  }

  @DELETE
  @Path("/showorganisator/{id}/")
  public Response deleteShowOrganisator(@PathParam("id") String id) {
    System.out.println("----invoking deleteShowOrganisator, ShowOrganisator id is: " + id);
    long idNumber = Long.parseLong(id);
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    ShowOrganisator so = session.get(ShowOrganisator.class, idNumber);

    Response r;
    if (so != null) {
      r = Response.ok().build();
      session.delete(so);
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
