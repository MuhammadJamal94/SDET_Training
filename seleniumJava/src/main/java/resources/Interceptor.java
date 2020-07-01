package resources;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HttpContext;
////////////////////////////////////////////

import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

public class Interceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(org.springframework.http.HttpRequest request, byte[] body,
			ClientHttpRequestExecution execution) throws IOException {
		// TODO Auto-generated method stub
		ClientHttpResponse response = execution.execute(request, body);
		return response;

		// return null;
	}

}
