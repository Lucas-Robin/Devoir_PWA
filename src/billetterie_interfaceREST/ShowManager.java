package billetterie_interfaceREST;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


import billetterie_console.Show;

@Path("/showmanager/")
@Consumes({"application/JSON", "application/xml"})
@Produces({"application/JSON", "application/xml"})
public class ShowManager
{
  public Map<Long, Show> artists = new HashMap<Long, Show>();
  
  public ShowManager()
  {
    init();
  }
  
  
  final void init()
  {
    

  }
  

}
