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

import billetterie_console.Client;

@Path("/clientmanager/")
@Consumes({"application/JSON", "application/xml"})
@Produces({"application/JSON", "application/xml"})
public class ClientManager
{
  public ClientManager()
  {
    init();
  }

  @GET
  @Path("/client/{id}/")
  public Client getClient(@PathParam("id") String id) {
    System.out.println("----invoking getClient, Client id is: " + id);
    long idNumber = Long.parseLong(id);
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    Client t = session.get(Client.class, idNumber);
    tx.commit();
    
    return t;
  }

  @GET
  @Path("/clients/")
  public Client[] getAllClient() {
    System.out.println("----invoking getAllClient");
    
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    
    
    List<Client> lClients = (List<Client>)session.createCriteria(Client.class).list();
    tx.commit();

    
    return lClients.toArray(new Client[] {});
  }

  @PUT
  @Path("/clients/")
  @Consumes({"application/JSON", "application/xml"})
  public Response updateClient(Client client) {
    System.out.println("----invoking updateClient, Client name is: " + client.getLastname());
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    Client t = session.get(Client.class, client.getId());
    
    Response r;
    if (t != null) {
      session.save(client);
      r = Response.ok().build();
    } else {
      r = Response.notModified().build();
    }

    tx.commit();
    
    return r;
  }

  @POST
  @Path("/clients/")
  public Response addClient(Client client) {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    System.out.println("----invoking addClient, Client name is: " + client.getLastname());
        
    session.save(client);
    tx.commit();
    
    return Response.ok(client).build();
  }

  @DELETE
  @Path("/client/{id}/")
  public Response deleteClient(@PathParam("id") String id) {
    System.out.println("----invoking deleteClient, Client id is: " + id);
    long idNumber = Long.parseLong(id);
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = session.beginTransaction();
    Client t = session.get(Client.class, idNumber);

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
