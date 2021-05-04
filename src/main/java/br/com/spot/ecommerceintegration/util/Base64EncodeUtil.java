package br.com.spot.ecommerceintegration.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
public class Base64EncodeUtil {

    private Base64EncodeUtil() {
    }

    /*
     * encode file to string in base64
     */
    public static String encodeFile(String filePath) throws IOException {

        byte[] fileContent;
        String encodedString = "";

        try {
            fileContent = FileUtils.readFileToByteArray(new File(filePath));

            encodedString = Base64.getEncoder().encodeToString(fileContent);

        } catch (IOException e) {

            log.error(e.getMessage());
        }
        return encodedString;
    }

    /*
     * decode string in base64 to file
     */

    public static byte[] decodeStringToBytes(String encodedString) {
        return Base64.getDecoder().decode(encodedString);
    }

    /*
     * encode string to a encoded String
     */
    public static String encodeString(String encondeValue) {
        return Base64.getEncoder().encodeToString(encondeValue.getBytes(StandardCharsets.UTF_8));
    }
    
    public static String encodeBytes(byte[] bytes) {
		return Base64.getEncoder().encodeToString(bytes);
    }

}
