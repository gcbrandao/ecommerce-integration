package br.com.spot.ecommerceintegration.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.commons.beanutils.ConversionException;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class ParserUtil {

    private ParserUtil() {
    }

    private static final String FHIR = "fhir";
    private static final String RESOURCE_URI = FHIR + "/%s";


    public static String getReference(String id) {
        int first = id.indexOf('/');

        String temp = id.substring(first + 1);

        int second = temp.indexOf('/');

        id = id.substring(0, first + second + 1);

        return id;
    }


    public static String capitalizeAll(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        str = str.toLowerCase();

        return Arrays.stream(str.split("\\s+")).map(t -> t.substring(0, 1).toUpperCase() + t.substring(1))
                .collect(Collectors.joining(" "));
    }

    public static String objectToJson(Object object) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return ow.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new ConversionException("Error to converter Objeto for json");
        }
    }
}
