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

public class TelaLogin extends AppCompatActivity {

    private String email;
    private String senha;
    private EditText entradaEmail;
    private EditText entradaSenha;
    private Button entrar;
    private Button cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        entradaEmail = (EditText) findViewById(R.id.entEmail);
        entradaSenha = (EditText) findViewById(R.id.entSenha);
        entrar = (Button) findViewById(R.id.botEntrar);
        cadastrar = (Button) findViewById(R.id.botCadastrar);


        entrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    logar();
                } catch (NullPointerException e) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Sem conexão com o servidor", Toast.LENGTH_SHORT);
                    toast.show();
                } catch (JSONException | IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void checarCadastroBd() {
        Toast toast = Toast.makeText(getApplicationContext(), "Email e/ou senha incorreto(s)", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void chamarTelaCadastro(View view) {
        Intent trocaTela = new Intent(this, TelaCadastrar.class);
        startActivity(trocaTela);
    }

    public void logar() throws IOException, JSONException {
        Login login = new Login();

        email = entradaEmail.getText().toString();
        senha = entradaSenha.getText().toString();

        boolean b = login.acesso(email, senha);

        if (b) {
            Login.LoginPadrao.setEmail(email);
            Intent trocaTela = new Intent(this, TelaEscolha.class);
            startActivity(trocaTela);
            this.finish();
        } else {
            checarCadastroBd();
        }

    }


}
