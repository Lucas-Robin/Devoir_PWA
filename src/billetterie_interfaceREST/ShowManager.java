package billetterie_interfaceREST;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


import billetterie_console.Show;

@Path("/showmanager/")
@Consumes({"application/JSON", "application/xml"})
@Produces({"application/JSON", "application/xml"})
public class ShowManager
{
  
  public ShowManager()
  {
    init();
  }
  
  @GET
  @Path("/show/{id}/")
  public Show getShow(@PathParam("id") String id) {
    System.out.println("----invoking getShow, Show id is: " + id);
    long idNumber = Long.parseLong(id);
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    Show s = session.get(Show.class, idNumber);
    tx.commit();
    
    return s;
  }

  @GET
  @Path("/shows/")
  public Show[] getAllShow() {
    System.out.println("----invoking getAllShow");
    
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    
    
    List<Show> lShows = (List<Show>)session.createCriteria(Show.class).list();
    tx.commit();

    
    return lShows.toArray(new Show[] {});
  }

  @PUT
  @Path("/shows/")
  @Consumes({"application/JSON", "application/xml"})
  public Response updateShow(Show show) {
    System.out.println("----invoking updateShow, Show name is: " + show.getName());
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    Show s = session.get(Show.class, show.getId());
    
    Response r;
    if (s != null) {
      session.save(show);
      r = Response.ok().build();
    } else {
      r = Response.notModified().build();
    }

    tx.commit();
    
    return r;
  }

  @POST
  @Path("/shows/")
  public Response addShow(Show show) {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    System.out.println("----invoking addShow, Show name is: " + show.getName());
        
    session.save(show);
    tx.commit();
    
    return Response.ok(show).build();
  }

  @DELETE
  @Path("/show/{id}/")
  public Response deleteShow(@PathParam("id") String id) {
    System.out.println("----invoking deleteShow, Show id is: " + id);
    long idNumber = Long.parseLong(id);
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    Show s = session.get(Show.class, idNumber);

    Response r;
    if (s != null) {
      r = Response.ok().build();
      session.delete(s);
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