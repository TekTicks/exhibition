
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.out;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
class JavaHttpUrlConnectionReader {

    
     
    
    
   /* public JavaHttpUrlConnectionReader()
  {
    try
    {
      String myUrl = "http://localhost:8080/jsondem/pass";
      // if your url can contain weird characters you will want to 
      // encode it here, something like this:
      myUrl = URLEncoder.encode(myUrl, "UTF-8");
 
     doHttpUrlConnectionAction(myUrl);
      //String results = 
      //System.out.println(results);
    }
    catch (Exception e)
    {
      // deal with the exception in your "controller"
    }
  }
    */
    


   /* private void doHttpUrlConnectionAction(String myUrl) throws Exception {
       
        URL url = null;
    BufferedReader reader = null;
    StringBuilder stringBuilder;
 JSONParser jsonParser = new JSONParser();

    try
    {
      // create the HttpURLConnection
      url = new URL(myUrl);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
       
      // just want to do an HTTP GET here
      connection.setRequestMethod("GET");
       
      // uncomment this if you want to write output to this url
      //connection.setDoOutput(true);
       
      // give it 15 seconds to respond
      connection.setReadTimeout(15*1000);
      connection.connect();
 
      // read the output from the server
     
      reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      
       String name = request.getParameter("name");
    String password = request.getParameter("password");
    String mobileNumber = request.getParameter("mobileNo");
      
      
     // Logic 1
      /*reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      
      JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
      
      String name = (String) jsonObject.get("name");
      System.out.println("Name: " + name);

      long mobileNo = (long) jsonObject.get("mobileNo");

            System.out.println("Mobile Number: " + mobileNo);
            
      String emailId = (String) jsonObject.get("emailId");
      System.out.println("Email Id: " + emailId);
      
      
      String password = (String) jsonObject.get("password");
      System.out.println("password: " + password);
      */
      
      
      
      //Logic 2
     /* stringBuilder = new StringBuilder();
 
      String line = null;
      while ((line = reader.readLine()) != null)
      {
        stringBuilder.append(line + "\n");
        System.out.println(stringBuilder.toString());
      }*/
      //return stringBuilder.toString();*/
    /*}
    catch (Exception e)
    {
      e.printStackTrace();
      throw e;
    }
    
    finally
    {
      // close the reader; this can throw an exception too, so
      // wrap it in another try/catch block.
      if (reader != null)
      {
        try
        {
          reader.close();
        }
        catch (IOException ioe)
        {
          ioe.printStackTrace();
        }
      }
    }
    }*/
}

   
    

