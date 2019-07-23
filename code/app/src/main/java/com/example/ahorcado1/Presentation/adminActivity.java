package com.example.ahorcado1.Presentation;

import android.content.Context;
import android.content.Intent;
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

import com.example.ahorcado1.BusinessLogic.controllers.Globals;
import com.example.ahorcado1.BusinessLogic.controllers.categoryController;
import com.example.ahorcado1.DataAccess.models.Category;
import com.example.ahorcado1.R;

import java.util.ArrayList;
import java.util.List;

public class adminActivity extends AppCompatActivity {


    private Button buttonAdd;
    private Button buttonRemove;
    private ListView list;
    //private List<String> listaString;
    private List<String> listaCategorias;
    List<Category> categories;
    private EditText etext;
    private TextView textView;
    private TextView textInstruccion;
    private ArrayAdapter<String> stringAdapter;
    private categoryController cc;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        //Botones
        buttonAdd = (Button) findViewById(R.id.addButton);
        buttonRemove = (Button) findViewById(R.id.removeButton);

        //textView
        textView = (TextView) findViewById(R.id.textViewAdmin);
        textInstruccion = (TextView) findViewById(R.id.textViewInstruccion);

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
        categories = cc.getAllCategories(); //Objetos de tipo categoria

        //Obtener los nombres de las categorias (Optimizar)
        listaCategorias = getCategoryNames(categories); //Nombres de categorias


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
                }
                Globals.category = cc.getCategoryByName(listaCategorias.get(position));
                Toast.makeText(adminActivity.this,"Seleccionó la categoría: " + Globals.category.getName() , Toast.LENGTH_SHORT).show();
                Intent i = new Intent(adminActivity.this, wordsAdminActivity.class);
                startActivity(i);
            }
        });


        /*ACCIONES*/
        //Acción Botón añadir
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreCategoria = etext.getText().toString();
                Boolean added = cc.createCategory(nombreCategoria);
                if(added)
                {
                    categories = cc.getAllCategories(); //Actualizar de la base de datos
                    listaCategorias = getCategoryNames(categories);
                    adapter1.notifyDataSetChanged();
                    Toast.makeText(adminActivity.this,"Se ha añadido la categoría exitosamente", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(adminActivity.this, adminActivity.class);
                    startActivity(i);
                }else
                {
                    Toast.makeText(adminActivity.this,"No se efectuó la operación", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //Acción Botón quitar
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreCategoria = etext.getText().toString();
                String[] categorias ={nombreCategoria};  //Optimizar con el controller para poder borrar de una sola categoría
                boolean removed = cc.deleteCategories(categorias);
                if(removed)
                {
                    categories = cc.getAllCategories(); //Actualizar de la base de datos
                    listaCategorias = getCategoryNames(categories);
                    adapter1.notifyDataSetChanged();
                    Toast.makeText(adminActivity.this,"Se ha elimininado la categoría exitosamente", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(adminActivity.this, adminActivity.class);
                    startActivity(i);
                }else
                {
                    Toast.makeText(adminActivity.this,"No se efectuó la operación.\nLa categoría no existe o está escrita incorrectamente", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public static List<String> getCategoryNames(List<Category> categoryList)
    {
        List<String> nombres = new ArrayList<>(); //Nombres de categorias
        for(int i = 0; i < categoryList.size(); i++)
        {
            String nombre = categoryList.get(i).getName();
            nombres.add(nombre);
        }
        return nombres;

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

