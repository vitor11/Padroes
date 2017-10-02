package telalogin.telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;

import fatec.telalogin.R;
import telalogin.Model.Login;

public class TelaCadastrar extends AppCompatActivity {
    private String email;
    private String senha;
    private String nome;
    private long telefone;
    private Button validarCadastro;
    private EditText cadEmail;
    private EditText cadSenha;
    private EditText cadNome;
    private EditText cadTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrar);

        cadEmail = (EditText) findViewById(R.id.cademail);
        cadSenha = (EditText) findViewById(R.id.cadsenha);
        cadNome = (EditText) findViewById(R.id.cadnome);
        cadTelefone = (EditText) findViewById(R.id.cadtelefone);


        validarCadastro = (Button) findViewById(R.id.btncadastrar);

        validarCadastro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try{
                    cadastro();
                }catch (NullPointerException e){
                    Toast toast = Toast.makeText(getApplicationContext(), "catch", Toast.LENGTH_SHORT);
                    toast.show();
                }catch (JSONException | IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /*public void tryCadastar()throws IOException, JSONException {
        Login login = new Login();

        email = cadEmail.getText().toString();
        senha = cadSenha.getText().toString();
        nome = cadNome.getText().toString();
        telefone = Long.parseLong(String.valueOf(cadTelefone));

        boolean b = login.cadastrar(email, senha, nome, telefone);

        if (b) {
            Intent trocaTela = new Intent(this, TelaEscolha.class);
            startActivity(trocaTela);
            this.finish();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Sem conexão com o servidor", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
*/
    public void cadastro() throws IOException, JSONException {
        Login login = new Login();

        email = cadEmail.getText().toString();
        senha = cadSenha.getText().toString();
        nome = cadNome.getText().toString();
        telefone = Long.parseLong(cadTelefone.getText().toString());


        boolean b = login.cadastrar(email, senha, nome, telefone);

        if(b){
            Intent trocaTela = new Intent(this, TelaEscolha.class);
            startActivity(trocaTela);
            this.finish();
        }else{
            // System.out.println("TESTE "+b);
            Toast toast = Toast.makeText(getApplicationContext(), "Sem conexão com o servidor", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}
