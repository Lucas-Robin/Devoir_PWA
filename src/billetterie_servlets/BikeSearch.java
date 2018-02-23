package billetterie_servlets;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * Servlet implementation class BikeSearch
 */
@WebServlet("/BikeSearch")
public class BikeSearch extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public BikeSearch() {
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
    double lat = Double.parseDouble(request.getParameter("lat"));
    double lon = Double.parseDouble(request.getParameter("lon"));
    String apiKey = "ffc32a362ac656225068c53a375bcd776c15483a";
    List<JSONObject> nearestBikeStation = new ArrayList<JSONObject>();
    ServletContext context = getServletContext();
      
    URL bikeURL = new URL("https://api.jcdecaux.com/vls/v1/stations" + "?" + "apiKey=" + apiKey);
    URLConnection bikeURLConn = bikeURL.openConnection();
    JSONArray bikeData = new JSONArray(new JSONTokener(bikeURLConn.getInputStream()));
    
    
    for (int i = 0; i < bikeData.length(); i++)
    {
      JSONObject bikeStation = bikeData.getJSONObject(i);
      JSONObject position = bikeStation.getJSONObject("position");
      
      if((Math.abs(position.getDouble("lat") - lat) <= 0.01) &&
         (Math.abs(position.getDouble("lng") - lon) <= 0.01))
      {
        nearestBikeStation.add(bikeStation);
      }
    }
    
    
    if(nearestBikeStation.isEmpty())
    {
      context.setAttribute("listBikeStation", "No station found in this area");

      
      RequestDispatcher dispatcher = context.getRequestDispatcher("/NearestBikeStation.jsp");
      dispatcher.forward(request, response);
    }
    else
    {
      context.setAttribute("listBikeStation", nearestBikeStation);
      
      RequestDispatcher dispatcher = context.getRequestDispatcher("/NearestBikeStation.jsp");
      dispatcher.forward(request, response);
    }
    
  }

}
