package br.com.spot.ecommerceintegration.component.model;

import lombok.*;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestModel implements Serializable {

    private static final long serialVersionUID = 6610149257516277078L;

    private String url;

    private Map<String, String> headersMap;

    private String accessToken;

    private Map<String, String> queryParamsMap;

    private Object object;

    private Class<?> returnClass;

}
