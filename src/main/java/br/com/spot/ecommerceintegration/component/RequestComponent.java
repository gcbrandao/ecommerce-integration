package br.com.spot.ecommerceintegration.component;

import br.com.spot.ecommerceintegration.component.model.RequestModel;
import org.springframework.web.client.HttpClientErrorException;

public interface RequestComponent {

    <T> T post(RequestModel requestModel) throws HttpClientErrorException;

    <T> T get(RequestModel requestModel) throws HttpClientErrorException;

}
