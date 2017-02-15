package View;
import java.io.*;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class URLConnection {
  
  private static String url = "http://52.36.156.222:3000/user/signin";
  
  public static void main(String[] args) throws Exception{
    HttpClient httpclient = new HttpClient();
    getRequest(httpclient);
    postRequest(httpclient);
  }
  
  public static void getRequest(HttpClient httpclient) {
    GetMethod method = new GetMethod(url);
    method.addRequestHeader(new Header("x-access-token", url));
    try {
      // Execute the method.
      int statusCode = httpclient.executeMethod(method);

      if (statusCode != HttpStatus.SC_OK) {
        System.err.println("Method failed: " + method.getStatusLine());
      }

      // Read the response body.
      byte[] responseBody = method.getResponseBody();

      // Deal with the response.
      // Use caution: ensure correct character encoding and is not binary data
      System.out.println(new String(responseBody));

    } catch (HttpException e) {
      System.err.println("Fatal protocol violation: " + e.getMessage());
      e.printStackTrace();
    } catch (IOException e) {
      System.err.println("Fatal transport error: " + e.getMessage());
      e.printStackTrace();
    } finally {
      // Release the connection.
      method.releaseConnection();
    }
  }
  public static void postRequest(HttpClient httpclient) throws IOException {
    PostMethod post = new PostMethod();
    NameValuePair[] data = {
        new NameValuePair("username", "admin@test.com"),
        new NameValuePair("password", "testpassword")
      };
      post.setRequestBody(data);
      // execute method and handle any error responses.
      InputStream in = post.getResponseBodyAsStream();
      post.releaseConnection();
  }
}


