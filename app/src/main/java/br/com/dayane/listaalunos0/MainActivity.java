package br.com.dayane.listaalunos0;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText nomeAluno;
    EditText curso;
    RecyclerView recyclerViewAluno;
    AdapterAluno adapterAluno;
    List<Aluno> listaAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirDialogAluno();
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        listaAluno = new ArrayList<Aluno>();
        listaAluno.add(new Aluno("dayane","sistemas"));
        listaAluno.add(new Aluno("teste","computação"));

        recyclerViewAluno = (RecyclerView) findViewById(R.id.recicletViewListaAluno);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this,1);
        recyclerViewAluno.setLayoutManager(layoutManager);
        iniciaLista();

    }

    public void iniciaLista(){
        adapterAluno = new AdapterAluno(MainActivity.this, listaAluno);
        recyclerViewAluno.setAdapter(adapterAluno);
    }

    public void abrirDialogAluno(){
        View view = getLayoutInflater().inflate(R.layout.dialog_cadastro_aluno,null);

        nomeAluno = (EditText) view.findViewById(R.id.nomeAluno);
        curso = (EditText) view.findViewById(R.id.curso);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Cadastro de Aluno");
        builder.setView(view);

        builder.setPositiveButton("Gravar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                gravarAluno();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create().show();
    }

    public void gravarAluno(){
        Aluno aluno = new Aluno();
        aluno.setNome(nomeAluno.getText().toString());
        aluno.setCurso(curso.getText().toString());

        //---------------------------------------

        adapterAluno.addItem(aluno);
        adapterAluno.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
