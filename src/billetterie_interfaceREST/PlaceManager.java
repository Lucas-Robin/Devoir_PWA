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

import billetterie_console.Place;


@Path("/placemanager/")
@Consumes({"application/JSON", "application/xml"})
@Produces({"application/JSON", "application/xml"})
public class PlaceManager
{
  public PlaceManager()
  {
    init();
  }

  @GET
  @Path("/place/{id}/")
  public Place getPlace(@PathParam("id") String id) {
    System.out.println("----invoking getPlace, Place id is: " + id);
    long idNumber = Long.parseLong(id);
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    Place p = session.get(Place.class, idNumber);
    tx.commit();
    
    return p;
  }

  @GET
  @Path("/places/")
  public Place[] getAllPlace() {
    System.out.println("----invoking getAllPlace");
    
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    
    
    List<Place> lPlaces = (List<Place>)session.createCriteria(Place.class).list();
    tx.commit();

    
    return lPlaces.toArray(new Place[] {});
  }

  @PUT
  @Path("/places/")
  @Consumes({"application/JSON", "application/xml"})
  public Response updatePlace(Place place) {
    System.out.println("----invoking updatePlace, Place name is: " + place.getName());
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    Place p = session.get(Place.class, place.getId());
    
    Response r;
    if (p != null) {
      session.save(place);
      r = Response.ok().build();
    } else {
      r = Response.notModified().build();
    }

    tx.commit();
    
    return r;
  }

  @POST
  @Path("/places/")
  public Response addPlace(Place place) {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    System.out.println("----invoking addPlace, Place name is: " + place.getName());
        
    session.save(place);
    tx.commit();
    
    return Response.ok(place).build();
  }

  @DELETE
  @Path("/place/{id}/")
  public Response deletePlace(@PathParam("id") String id) {
    System.out.println("----invoking deletePlace, Place id is: " + id);
    long idNumber = Long.parseLong(id);
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    Place p = session.get(Place.class, idNumber);

    Response r;
    if (p != null) {
      r = Response.ok().build();
      session.delete(p);
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
