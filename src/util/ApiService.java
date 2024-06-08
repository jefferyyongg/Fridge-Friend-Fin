package util;

import com.google.gson.Gson;
import model.Recept;
import model.ZoekObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public abstract class ApiService {

    public final Recept getRecept(ZoekObject.ZoekResultaten zoekResultaten) throws URISyntaxException, IOException, InterruptedException {
        return fetchRecept(zoekResultaten);
    }

    public abstract HttpRequest handleRequest(String query) throws URISyntaxException;
    public abstract ZoekObject handleResponse(HttpRequest request) throws IOException, InterruptedException;

    private Recept fetchRecept(ZoekObject.ZoekResultaten zoekResultaten) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.spoonacular.com/recipes/" + zoekResultaten.getId() + "/information?apiKey=511f0eda5ee6487ea63b21e8660d8a88"))
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        Recept recept = gson.fromJson(response.body(), Recept.class);

        return recept;
    }
}


