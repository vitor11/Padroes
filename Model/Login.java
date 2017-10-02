package telalogin.Model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import telalogin.rest.RestConnection;

/**
 * Created by vitor on 19/09/2017.
 */
public class Login {

    public boolean acesso(String email, String senha) throws NullPointerException, JSONException, IOException {

        String url = "http://br192.teste.website/~siste183/api/api_login.php";

        JSONObject json = new JSONObject();


            json.put("senha", senha);
            json.put("email", email);
            JSONObject resposta = RestConnection.sendPostObject(url, json);

            boolean b = resposta.getBoolean("status");
            return b;
    }


    public Boolean cadastrar(String email, String senha, String nome, long telefone) throws NullPointerException, JSONException, IOException{

       String url = "http://br192.teste.website/~siste183/api/api_cadastro.php";

        JSONObject json = new JSONObject();

            json.put("email", email);
            json.put("nome", nome);
            json.put("senha", senha);
            json.put("telefone", telefone);

            JSONObject resposta = RestConnection.sendPostObject(url, json);

            // return resposta.toString();
            boolean b =  resposta.getBoolean("status");
            return b;

        //String teste = nome+" - "+email+" - "+telefone+" - "+senha;
        //return teste;
    }

    public static class LoginPadrao {

        private static String email;

        public static void setEmail(String emailB) {
            email = emailB;
        }

        public static String getEmail() {
            return email;
        }
    }
}
