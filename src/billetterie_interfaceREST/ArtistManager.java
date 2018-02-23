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

import billetterie_console.Artist;
import billetterie_console.Band;
import billetterie_console.PersonArtist;

import org.hibernate.*;




// Base URL : http://localhost:8080/Devoir_PWA/REST/Artist/artistmanager/
@Path("/artistmanager/")
@Consumes({"application/JSON", "application/xml"})
@Produces({"application/JSON", "application/xml"})
public class ArtistManager
{
  //public long currentId = 0;
//  public Map<Long, Artist> artists = new HashMap<Long, Artist>();

  public ArtistManager()
  {
    init();
  }

  @GET
  @Path("/artist/{id}/")
  public Artist getArtist(@PathParam("id") String id) {
    System.out.println("----invoking getArtist, Artist id is: " + id);
    long idNumber = Long.parseLong(id);
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    Artist a = session.get(Artist.class, idNumber);
    tx.commit();
    
    return a;
  }

  @GET
  @Path("/artists/")
  public Artist[] getAllArtist() {
    System.out.println("----invoking getAllArtist");
    
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    
    
    List<Artist> lArtistes = (List<Artist>)session.createCriteria(Artist.class).list();
    tx.commit();

    
    return lArtistes.toArray(new Artist[] {});
  }

  @PUT
  @Path("/artists/")
  @Consumes({"application/JSON", "application/xml"})
  public Response updateArtist(Artist artist) {
    System.out.println("----invoking updateArtist, Artist name is: " + artist.getName());
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    Artist a = session.get(Artist.class, artist.getId());
    
    Response r;
    if (a != null) {
      session.save(artist);
      r = Response.ok().build();
    } else {
      r = Response.notModified().build();
    }

    tx.commit();
    
    return r;
  }

  @POST
  @Path("/artists/")
  public Response addArtist(Artist artist) {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    System.out.println("----invoking addArtist, Artist name is: " + artist.getName());
    
    if(artist instanceof Band)
    {
      for (PersonArtist member : ((Band)artist).getMembers())
      {
        session.save(member);
      }
    }
    
    session.save(artist);
    tx.commit();
    
    return Response.ok(artist).build();
  }

  @DELETE
  @Path("/artist/{id}/")
  public Response deleteArtist(@PathParam("id") String id) {
    System.out.println("----invoking deleteArtist, Artist id is: " + id);
    long idNumber = Long.parseLong(id);
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    Artist a = session.get(Artist.class, idNumber);

    Response r;
    if (a != null) {
      r = Response.ok().build();
      session.delete(a);
    } else {
      r = Response.notModified().build();
    }
    
    tx.commit();
    

    return r;
  }

  final void init()
  {
//    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//    Transaction tx = session.beginTransaction();
//
//    Artist test = new Artist("Pouet", "BiduleLand", "TrucCore");
//    session.save(test);
//
//
//    //this.artists.put(test.getId(), test);
//    //this.currentId++;
//
//
//    Band aal = new Band("Animals as Leader", "USA", "Métal Progressif");
//    PersonArtist jr = new PersonArtist("Javier Reyes", "USA", "Metal Progressif, Jazz fusion",
//        "Javier", "Reyes", "M", "Guitarist");
//    PersonArtist ta = new PersonArtist("Tosin Abasi", "USA", "Metal Progressif, Jazz fusion",
//        "Tosin", "Abasi", "M", "Guitarist");
//    PersonArtist mg = new PersonArtist("Matt Gartska", "USA", "Metal Progressif",
//        "Matt", "Gartska", "M", "Drummer");
//
//    aal.addMember(ta);
//    aal.addMember(jr);
//    aal.addMember(mg);
//
//
//    session.save(ta);
//    session.save(jr);
//    session.save(mg);
//    session.save(aal);
//    tx.commit();
//   
////    System.out.println(aal.getId());
//    this.artists.put(aal.getId(), aal);
//    this.artists.put(jr.getId(), jr);
//    this.artists.put(ta.getId(), ta);
//    this.artists.put(mg.getId(), mg);
//
//    //    System.out.println(this.artists);
//    //    for (Object o : this.artists.values().toArray())
//    //    {
//    //      System.out.println(o);
//    //    }
//    //    System.out.println(this.artists.values().toArray()[0]);
//
//
//
//    //session.close();
  }
}
