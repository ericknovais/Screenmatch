package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.execao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmbd;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        String busca = "";
        Scanner leitura = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        while (!busca.equalsIgnoreCase("sair")) {
            try {

                System.out.println("Digite um filme para busca: ");
                busca = leitura.nextLine();

                if(busca.equalsIgnoreCase("sair"))
                    break;

                String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=aa01283d";

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);


                TituloOmbd tituloOmbd = gson.fromJson(json, TituloOmbd.class);

                Titulo titulo = new Titulo(tituloOmbd);
                System.out.println(titulo);
                titulos.add(titulo);

//                FileWriter file = new FileWriter("filmes.txt");
//                file.write(titulo.toString());
//                file.close();
            }
            catch(NumberFormatException e){
                System.out.printf("Aconteceu um erro: %n%s%n", e.getMessage());
            }
            catch(IllegalArgumentException e){
                System.out.printf("Aconteceu no argumento na busca: %n%s%n", e.getMessage());
            }
            catch(ErroDeConversaoDeAnoException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titulos);
        FileWriter fileWriter = new FileWriter("filmes.json");
        fileWriter.write(gson.toJson(titulos));
        fileWriter.close();
        System.out.println("Programa finalizado!");
    }
}
