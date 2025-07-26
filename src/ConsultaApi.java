import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    private static final String chave_API = "456751c0c9e009e96db0ac09";

    public void conversao(double valor, String origem, String destino) {
        URI moeda = URI.create("https://v6.exchangerate-api.com/v6/"
                + chave_API + "/pair/"
                + origem + "/" + destino);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(moeda)
                .build();
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            RespostaApi resposta = gson.fromJson(response.body(), RespostaApi.class);

            if ("success".equals(resposta.result)) {
                double taxa = resposta.conversion_rate;
                double valorConvertido = valor * taxa;
                System.out.println("Valor " + valor + " " + origem +
                        " corresponde ao valor final de  --> " + valorConvertido +
                        " " + destino);
            } else {
                System.out.println("Erro na conversão: " + resposta.error_type);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar taxa de câmbio: " +
                    e.getMessage());
        }
    }
}
