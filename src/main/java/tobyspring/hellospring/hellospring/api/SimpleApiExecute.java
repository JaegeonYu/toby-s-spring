package tobyspring.hellospring.hellospring.api;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Collectors;

public class SimpleApiExecute implements ApiExecutor{
    @Override
    public String execute(URI uri) throws IOException {
        String response;
        HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();

        try(BufferedReader br= new BufferedReader(new InputStreamReader(connection.getInputStream()))){
            response = br.lines().collect(Collectors.joining());
        }
        return response;
    }
}
