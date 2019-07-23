package com.example.ahorcado1.Presentation;

import android.content.Context;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahorcado1.BusinessLogic.controllers.categoryController;
import com.example.ahorcado1.DataAccess.models.Category;
import com.example.ahorcado1.R;

import java.util.ArrayList;
import java.util.List;

public class adminActivity extends AppCompatActivity {


    private Button buttonAdd;
    private ListView list;
    private List<String> listaString;
    private List<String> listaCategorias;
    private EditText etext;
    private TextView textView;
    private ArrayAdapter<String> stringAdapter;
    private categoryController cc;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        //Botón
        buttonAdd = (Button) findViewById(R.id.addButton);

        //textView
        textView = (TextView) findViewById(R.id.textViewAdmin);

        //CODIGO PARA AÑADIR
        //Instancia de botones
        buttonAdd = (Button) findViewById(R.id.addButton);
        list = (ListView) findViewById(R.id.listViewObject);
        etext = (EditText) findViewById(R.id.editText1);

        //Lista de categorias
        //listaString = new ArrayList<>();
        //listaString.add("Deportes"); //Ejemplos
        //listaString.add("Juegos");

        //Controller
        cc = new categoryController();
        List<Category> categories = cc.getAllCategories(); //Objetos de tipo categoria
        //Obtener los nombres de las categorias
        listaCategorias = new ArrayList<>(); //Nombres de categorias
        for(int i = 0; i < categories.size(); i++)
        {
            String nombre = categories.get(i).getName();
            listaCategorias.add(nombre);
        }



        //stringAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1, listaString);
        //list.setAdapter(stringAdapter);

        //adapter finally used
        final MyAdapter adapter1 = new MyAdapter(this, listaCategorias);
        list.setAdapter(adapter1);
        //En Cada posición de la lista, se puede accionar.
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0)
                {
                    Toast.makeText(adminActivity.this,"SELECCIONÓ LA POSICIÓN 0 de la lista!", Toast.LENGTH_SHORT).show();
                }
            }
        });




        //Botón añadir
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaCategorias.add(etext.getText().toString());
                adapter1.notifyDataSetChanged();
            }
        });



    }

    class MyAdapter extends ArrayAdapter<String>
    {
        Context context;
        List<String> titles;

        MyAdapter(Context c, List<String> title)
        {
            super(c, R.layout.row_layout, R.id.textView1, title);
            this.context = c;
            this.titles = title;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater li = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = li.inflate(R.layout.row_layout,parent, false);
            TextView myTitle = row.findViewById(R.id.textView1);

            //Set resources
            myTitle.setText(titles.get(position));


            return row;

        }
    }


}

