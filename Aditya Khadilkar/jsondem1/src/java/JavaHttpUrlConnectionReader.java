
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.out;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.json.JsonObject;
import org.json.JSONArray;

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

    
    public JavaHttpUrlConnectionReader()
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
    
    


    private void doHttpUrlConnectionAction(String myUrl) throws Exception {
       
        
    BufferedReader reader = null;
    StringBuilder stringBuilder;
 
    try
    {
      // create the HttpURLConnection
      URL url = new URL(myUrl);
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
     
      String json = reader.readLine();
      
      JSONArray arr = new JSONArray(json);
      
      List<String> list = new ArrayList<String>();
        for(int i = 0; i < arr.length(); i++){
            list.add(arr.getJSONObject(i).getString("signUp"));
}
     /* String line=null;
    String message = org.apache.commons.io.IOUtils.toString(reader);
    final StringBuffer buffer = new StringBuffer(2048);
    while ((line = reader.readLine()) != null) 
    {
        //buffer.append(line);
        message += line;
    }
    System.out.println(message);
    */
    
    
    //JsonObject json;
   // json = new JsonObject(message);
    
        
    /* reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      stringBuilder = new StringBuilder();
 
      String line = null;
      while ((line = reader.readLine()) != null)
      {
        stringBuilder.append(line + "\n");
        System.out.println(stringBuilder.toString());
      }*/
      //return stringBuilder.toString();
    }
    
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
    }

    private void alert(String myUrl) {
        out.println(myUrl); //To change body of generated methods, choose Tools | Templates.
    }
}

   
    

