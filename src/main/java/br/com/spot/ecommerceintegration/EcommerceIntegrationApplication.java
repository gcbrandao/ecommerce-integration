package br.com.spot.ecommerceintegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

@SpringBootApplication
public class EcommerceIntegrationApplication {
	@Autowired
	private Environment env;


	public static void main(String[] args) {
		SpringApplication.run(EcommerceIntegrationApplication.class, args);
	}



	@Bean
	public RestTemplate restTemplate() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		final String[] activeProfiles = env.getActiveProfiles();

//		if (activeProfiles.length <= 0) {
//			final Neo4jProperties.Security.TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
//
//			final SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
//					.loadTrustMaterial(null, acceptingTrustStrategy).build();
//
//			final SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
//
//			final CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
//
//			final HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
//
//			requestFactory.setHttpClient(httpClient);
//
//			return new RestTemplate(requestFactory);
//		}

		return new RestTemplate();
	}

}
