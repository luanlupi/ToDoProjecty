package br.grupointegrado.luanbarboza.todoproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.grupointegrado.luanbarboza.todoproject.DB.DataBase;
import br.grupointegrado.luanbarboza.todoproject.model.Categoria;
import br.grupointegrado.luanbarboza.todoproject.model.ToDo;

public class RegisterToDoActivity extends AppCompatActivity {
    private EditText edtDescricao;
    private EditText edtDataEntrega;
    private RatingBar rbPrioridade;
        private Spinner spnCategoria;

  //  private ArrayList<ToDo> todoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_to_do);


        edtDescricao = (EditText) findViewById(R.id.edtDescricao);
                edtDataEntrega = (EditText) findViewById(R.id.edtDataEntrega);
                rbPrioridade = (RatingBar) findViewById(R.id.rbPrioridade);

                       List<Categoria> categoria = Arrays.asList(Categoria.values());

                   spnCategoria = (Spinner) findViewById(R.id.spnCategoria);


                 ArrayAdapter<Categoria> aaCategoria = new ArrayAdapter<Categoria>(this,
                         android.R.layout.simple_list_item_1, categoria);

                         spnCategoria.setAdapter(aaCategoria);

                }

    public ToDo getToDo () {
                ToDo todo = new ToDo();

                 todo.setDescricao(edtDescricao.getText().toString());
                 todo.setEntrega(edtDataEntrega.getText().toString());
                 todo.setPrioridade(rbPrioridade.getNumStars());

                 todo.setCategoria((Categoria) spnCategoria.getSelectedItem());

                  return todo;
            }


    public void LimpaActivity(){
        edtDescricao.setText("");
        edtDataEntrega.setText("");
        rbPrioridade.setRating(0);

        spnCategoria.setSelection(0);
        edtDataEntrega.requestFocus();


    }
            @Override
    public boolean onCreateOptionsMenu(Menu menu) {

                getMenuInflater().inflate(R.menu.menu_main, menu);

                return super.onCreateOptionsMenu(menu);
           }

            @Override
    public boolean onOptionsItemSelected(MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.action_salvar:
                        //Usando o método
                        ToDo todo = this.getToDo();


                        DataBase db = new DataBase(this);
                                        db.insert(todo);

                        this.LimpaActivity();
                        this.onBackPressed();


                        Toast.makeText(this, "Salvar", Toast.LENGTH_SHORT).show();

                        break;

                    case R.id.action_cancelar:
              //          Intent back = new Intent(this, MainActivity.class);
                //                        back.putExtra("lista", todoList);

//                                                startActivity(back);

                     //   Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show();
                        this.onBackPressed();
                        Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show();
                        break;
                }

                return super.onOptionsItemSelected(item);
            }
}
