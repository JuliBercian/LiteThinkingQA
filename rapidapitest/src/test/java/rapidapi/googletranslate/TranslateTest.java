package rapidapi.googletranslate;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TranslateTest {

    HttpClient clientHttp;

    @Before
    public void setup() {
        System.out.println("-------------------");
        System.out.println(" START TEST");
        clientHttp = HttpClient.newHttpClient();
    }

    @Test
    public void translateGoogleENtoES(){

        TranslateService translateService =  new TranslateService();
        HttpRequest request = translateService.requestTranslate("Horse", "en", "es");
        translateService.sendRequest(clientHttp, request); 
    }

    @Test
    public void translateGoogleEStoEN(){
        TranslateService translateService =  new TranslateService();
        HttpRequest request = translateService.requestTranslate("Apartamento", "es", "en");
        translateService.sendRequest(clientHttp, request); 
    }

    @Test
    public void translateGoogleEStoJA(){
        TranslateService translateService =  new TranslateService();
        HttpRequest request = translateService.requestTranslate("Apartamento", "es", "ja");
        translateService.sendRequest(clientHttp, request); 
    }

    @After
    public void TearDown() {
        System.out.println(" END TEST");
        System.out.println("-------------------");
    }
}
