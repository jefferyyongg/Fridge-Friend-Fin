package util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Recept;
import model.ZoekObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class SuggestionService extends ApiService {

    @Override
    public HttpRequest handleRequest(String query) throws URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.spoonacular.com/recipes/findByIngredients?ingredients=" + query + "&apiKey=511f0eda5ee6487ea63b21e8660d8a88"))
                .GET()
                .build();
        return request;
    }

    @Override
    public ZoekObject handleResponse(HttpRequest request) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        Type recipeListType = new TypeToken<List<ZoekObject.ZoekResultaten>>(){}.getType();
        List<ZoekObject.ZoekResultaten> recepten = gson.fromJson(response.body(), recipeListType);
        ZoekObject zoekObject = new ZoekObject();
        zoekObject.setResults(recepten);
        return zoekObject;
    }
}
