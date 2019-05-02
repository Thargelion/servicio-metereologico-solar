package app.clima;

import org.junit.jupiter.api.Test;
import spark.Request;
import spark.Response;
import spark.routematch.RouteMatch;
import testutils.TestBase;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ClimaControllerTest extends TestBase {

    private final String HOST = "http://localhost:4567";
    private final String CLIMA_PATH = "/clima";
    private final String CLIMA_PATH_ID = String.format("%s/1", CLIMA_PATH);
    private final String REQUEST = String.format("%s%s", HOST, CLIMA_PATH_ID);
    private HttpSession httpSession;
    private HttpServletRequest servletRequest = mock(HttpServletRequest.class);
    private Request request = mock(Request.class);
    private Response response = mock(Response.class);
    private RouteMatch baseFirst = new RouteMatch(
            null,
            String.format("%s/:id", CLIMA_PATH),
            CLIMA_PATH_ID,
            "application/json");

    @Test()
    void getWeatherByIdTest() throws Exception {
        // request = (HttpURLConnection)new URL("http", HOST, 4567, REQUEST).openConnection();
        URL url = new URL(REQUEST);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        Clima clima = new Clima(1, "lluvia");
        String expectedResponse = "{\"dia\":1,\"clima\":\"lluvia\"}";
        ClimaDao climaDao = mock(ClimaDao.class);
        when(climaDao.read(anyString())).thenReturn(clima);
        when(request.params(anyString())).thenReturn("1");
        String actualResponse = readRequest(con);
        assertEquals(expectedResponse, actualResponse);
    }

    private String readRequest(HttpURLConnection connection) throws IOException {
        InputStream inputStream = connection.getInputStream();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }
}
