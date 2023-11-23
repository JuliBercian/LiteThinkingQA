package rapidapi.googletranslate;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import java.net.http.HttpResponse;

import org.apache.http.HttpStatus;

import utils.JsonSchemaValidator;

public class TranslateService {

    private final String ENDPOINT = "https://google-translate1.p.rapidapi.com/language/translate/v2";
    private final String RAPIDAPIKEY = "5358e328a9msh7f5fdad53869971p164a1cjsn2c33f57930e9";
    private final String RAPIDAPIHOST = "google-translate1.p.rapidapi.com";

    public HttpRequest requestTranslate(String testToTranslate, String source, String target){

        String body = "q=" + testToTranslate + "&target=" + target + "&source=" + source;

        return HttpRequest.newBuilder()
                .uri(URI.create(ENDPOINT))
                .header("content-type", "application/x-www-form-urlencoded")
                .header("Accept-Encoding", "application/gzip")
                .header("X-RapidAPI-Key", RAPIDAPIKEY)
                .header("X-RapidAPI-Host", RAPIDAPIHOST)
                .method("POST", HttpRequest.BodyPublishers.ofString(body))
                .build();
    }

    public String sendRequest(HttpClient client, HttpRequest request){

        HttpResponse<String> response;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            String resultsJsonSchema = JsonSchemaValidator.validateJsonAgainstSchema(
                response.body(), 
                "postTranslateGoogle.json"
            ); 

            assertEquals("Status Code", response.statusCode(), HttpStatus.SC_OK);
            assertEquals("Result Json Schema Validatior", "", resultsJsonSchema);

            return response.body();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "{}";
        }
    }
}
