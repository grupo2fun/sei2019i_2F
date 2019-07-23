package com.example.ahorcado1.Presentation;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahorcado1.BusinessLogic.controllers.Globals;
import com.example.ahorcado1.BusinessLogic.controllers.categoryController;
import com.example.ahorcado1.BusinessLogic.controllers.wordController;
import com.example.ahorcado1.DataAccess.models.Category;
import com.example.ahorcado1.DataAccess.models.Word;
import com.example.ahorcado1.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class wordsAdminActivity extends AppCompatActivity {

    private Button buttonWordAdd;
    private Button buttonWordRemove;
    private ListView lvWords;
    private List<Word> lista;
    private List<Word> lista1;
    private List<Word> lista2;
    private List<Word> lista3;
    private List<String> listaWords;
    List<Category> words;
    private List<String> levelsWords;
    private EditText etext;
    private TextView tituloCategoria;
    private Spinner seleecionDif;

    private ArrayAdapter<String> stringAdapter;
    private categoryController cc;
    private wordController wc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words_admin);

        //Edit Text
        tituloCategoria = (TextView) findViewById(R.id.textViewTitulo);
        tituloCategoria.setText(Globals.category.getName()); //Asignación de título de activity
        //Botones
        buttonWordAdd = (Button) findViewById(R.id.addButton);
        buttonWordRemove = (Button) findViewById(R.id.removeButton);

        //Edit text
        etext = (EditText) findViewById(R.id.editText1);

        //ListView
        lvWords = (ListView) findViewById(R.id.listViewObject);

        //Controller
        wc = new wordController();

        //Spinner
        seleecionDif = (Spinner) findViewById(R.id.spinnerAdmin);

        List<Integer> listaSpinner = new LinkedList<>();
        listaSpinner.add(1);
        listaSpinner.add(2);
        listaSpinner.add(3);

        ArrayAdapter<Integer> adp = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, listaSpinner
        );

        seleecionDif.setAdapter(adp);



        //Listas de palabras por nivel.
        lista1 = wc.getWordsByCatDif(Globals.category, 1);
        lista2 = wc.getWordsByCatDif(Globals.category, 2);
        lista3 = wc.getWordsByCatDif(Globals.category, 3);

        lista = wc.getAllWords();

        //Lista a string
        listaWords = getWordNames(lista);
        levelsWords = getLevels(lista);
        //adapter finally used
        final wordsAdminActivity.MyAdapter adapter1 = new wordsAdminActivity.MyAdapter(this, listaWords,levelsWords);
        lvWords.setAdapter(adapter1);
        //En Cada posición de la lista, se puede accionar.
        lvWords.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });

        /*ACCIONES*/
        //Acción Botón añadir
        buttonWordAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String palabra = etext.getText().toString();
                int dificultad = (int) seleecionDif.getSelectedItem();
                Word word = new Word(Globals.category, palabra, dificultad);
                Boolean added = wc.writeWord(Globals.category, word);
                if(added)
                {
                    lista = wc.getAllWords(); //Actualizar de la base de datos
                    listaWords = getWordNames(lista);
                    adapter1.notifyDataSetChanged();
                    Toast.makeText(wordsAdminActivity.this,"Se ha añadido la palabra exitosamente", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(wordsAdminActivity.this, wordsAdminActivity.class);
                    startActivity(i);
                }else
                {
                    Toast.makeText(wordsAdminActivity.this,"No se efectuó la operación", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //Acción Botón quitar
        buttonWordRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String palabra = etext.getText().toString();
                String[] words ={palabra};
                Boolean added = wc.deleteWords(words); //Optimazar
                if(added)
                {
                    lista = wc.getAllWords(); //Actualizar de la base de datos
                    listaWords = getWordNames(lista);
                    adapter1.notifyDataSetChanged();
                    Toast.makeText(wordsAdminActivity.this,"Se ha eliminado la palabra exitosamente", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(wordsAdminActivity.this, wordsAdminActivity.class);
                    startActivity(i);
                }else
                {
                    Toast.makeText(wordsAdminActivity.this,"No se efectuó la operación", Toast.LENGTH_SHORT).show();
                }
            }
        });









    }


    public static List<String> getWordNames(List<Word> wordList)
    {
        List<String> nombres = new ArrayList<>(); //Nombres de categorias
        for(int i = 0; i < wordList.size(); i++)
        {
            String nombre = wordList.get(i).getWord();
            nombres.add(nombre);
        }
        return nombres;

    }

    public static List<String> getLevels(List<Word> wordList)
    {
        List<String> levels = new ArrayList<>(); //Nombres de categorias
        for(int i = 0; i < wordList.size(); i++)
        {
            String level = String.valueOf( wordList.get(i).getDifficult() );
            levels.add(level);
        }
        return levels;

    }

    /**
     * Clase MyAdapter
     */
    class MyAdapter extends ArrayAdapter<String>
    {
        Context context;
        List<String> titles;
        List<String> levels;

        MyAdapter(Context c, List<String> title, List<String> levels)
        {
            super(c, R.layout.row_layout, R.id.textView1, title);
            this.context = c;
            this.titles = title;
            this.levels = levels;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater li = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = li.inflate(R.layout.row_layout,parent, false);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myLevel = row.findViewById(R.id.textView2);
            //Set resources
            myTitle.setText(titles.get(position));
            myLevel.setText(levels.get(position));


            return row;

        }
    }
}
