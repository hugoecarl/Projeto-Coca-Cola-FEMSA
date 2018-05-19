package com.example.josefernando.comunicaococa;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.josefernando.comunicaococa.DAO.ConfiguracaoFirebase;
import com.example.josefernando.comunicaococa.Entidades.Usuarios;
import com.example.josefernando.comunicaococa.Helper.Base64Custom;
import com.example.josefernando.comunicaococa.Helper.Preferencias;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

public class CadastrosActivity extends AppCompatActivity {

    private EditText edtCadEmail;
    private EditText edtCadNome;
    private EditText edtCadSobrenome;
    private EditText edtCadSenha;
    private EditText edtCadConfirmaSenha;
    private EditText edtCadNascimento;
    private RadioButton rbMasculino;
    private RadioButton rbFeminino;
    private Button btnGravar;
    private Usuarios usuarios;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastros);

        edtCadEmail = (EditText) findViewById(R.id.edtCadEmail);
        edtCadNome = (EditText) findViewById(R.id.edtCadNome);
        edtCadSobrenome = (EditText) findViewById(R.id.edtCadSobrenome);
        edtCadSenha = (EditText) findViewById(R.id.edtCadSenha);
        edtCadConfirmaSenha = (EditText) findViewById(R.id.edtCadConfirmaSenha);
        edtCadNascimento = (EditText) findViewById(R.id.edtCadNascimento);
        rbFeminino = (RadioButton) findViewById(R.id.rbFeminino);
        rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);
        btnGravar = (Button) findViewById(R.id.btnGravar);

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtCadSenha.getText().toString().equals(edtCadConfirmaSenha.getText().toString())){
                    usuarios = new Usuarios();
                    usuarios.setNome(edtCadNome.getText().toString());
                    usuarios.setEmail(edtCadEmail.getText().toString());
                    usuarios.setSenha(edtCadSenha.getText().toString());
                    usuarios.setNascimento(edtCadNascimento.getText().toString());
                    usuarios.setSobrenome(edtCadSobrenome.getText().toString());

                    if (rbFeminino.isChecked()){
                        usuarios.setSexo("Feminino");
                    } else {
                        usuarios.setSexo("Masculino");
                    }
                    cadastrarUsuario();
                }else {
                    Toast.makeText(CadastrosActivity.this,"As senhas não são correspondentes", Toast.LENGTH_LONG).show();
                }
            }
        });

        }

    private void cadastrarUsuario(){

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                usuarios.getEmail(),
                usuarios.getSenha()
        ).addOnCompleteListener(CadastrosActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(CadastrosActivity.this,"Usuario cadastrado com sucesso", Toast.LENGTH_LONG).show();

                    String identificadorUsuario = Base64Custom.codificarBase64(usuarios.getEmail());

                    FirebaseUser usuarioFirebase = task.getResult().getUser();
                    usuarios.setId(identificadorUsuario);
                    usuarios.salvar();

                    Preferencias preferenciasAndroid = new Preferencias(CadastrosActivity.this);
                    preferenciasAndroid.salvarUsuarioPreferencias(identificadorUsuario, usuarios.getNome());
                    abrirLoginUsuario();
                }else {
                    String erroExcecao = "";

                    try {
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){
                        erroExcecao = "Digite uma senha mais forte, contendo no mínimo 8 caracteres de letras e números";
                    }catch (FirebaseAuthInvalidCredentialsException e) {
                        erroExcecao = "O e-mail digitado é inalido, digite um novo e-mail";
                    }
                    catch (FirebaseAuthUserCollisionException e) {
                        erroExcecao = "O ID digitado já está cadastrado no sistema";
                    }
                    catch (Exception e) {
                        erroExcecao = "Erro ao efetuar o cadastro";
                    }
                    Toast.makeText(CadastrosActivity.this,"Erro: " + erroExcecao, Toast.LENGTH_LONG).show();
                }

            }
        });

        }
    public void abrirLoginUsuario(){
        Intent intent = new Intent(CadastrosActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}