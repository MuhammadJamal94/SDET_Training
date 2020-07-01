package resources;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;

public class ResponseInterceptor {
	
	public static void main(String args[]) throws Exception{
	      
	      //Creating an HttpRequestInterceptor
	      HttpResponseInterceptor responseInterceptor = new HttpResponseInterceptor() {
	         @Override
	         public void process(HttpResponse response, HttpContext context) throws
	         HttpException, IOException {
	            //System.out.println("Adding header sample_header, demo-header, test_header to the response");
	            //response.setHeader("sample-header", "My first header");
	            //response.setHeader("demo-header", "My second header");
	            //response.setHeader("test-header", "My third header"); 
	         }
	      };

	      //Creating a CloseableHttpClient object
	      CloseableHttpClient httpclient = HttpClients.custom().addInterceptorFirst(responseInterceptor).build();

	      //Creating a request object
	      //HttpGet httpget1 = new HttpGet("https://www.tutorialspoint.com/");
	      HttpGet httpget1 = new HttpGet("https://www.phptravels.net/account/");

	      //Executing the request
	      HttpResponse httpresponse = httpclient.execute(httpget1); 

	      //Printing remaining list of headers
	      Header[] headers = httpresponse.getAllHeaders();
	 
	      for (int i = 0; i<headers.length;i++) {
	         System.out.println(headers[i].getName());
	      }
	   }
	}
