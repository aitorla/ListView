package com.example.aitor.spinner2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public ListView listView;
    public TextView lblEtiqueta;

    private Titular[] datos = new Titular[]{
            new Titular("Título 1", "Subtítulo largo 1"),
            new Titular("Título 2", "Subtítulo largo 2"),
            new Titular("Título 3", "Subtítulo largo 3"),
            new Titular("Título 4", "Subtítulo largo 4"),
            //...
            new Titular("Título 15", "Subtítulo largo 15")};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // final String[] datos = new String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};

        //  ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);

        // listView = (ListView)findViewById(R.id.listView);

        //listView.setAdapter(adaptador);

        listView = (ListView)findViewById(R.id.listView);
        View header = getLayoutInflater().inflate(R.layout.list_header, null);

        listView.addHeaderView(header);
        AdaptadorTitulares adaptador = new AdaptadorTitulares(this, datos);

        listView = (ListView)findViewById(R.id.listView);

        listView.setAdapter(adaptador);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                //Alternativa 1:
                //String opcionSeleccionada =
                //                ((Titular)a.getItemAtPosition(position)).getTitulo();

                //Alternativa 2:
                String opcionSeleccionada =
                      ((TextView)v.findViewById(R.id.LblTitulo))
                          .getText().toString();

                lblEtiqueta=(TextView) findViewById(R.id.lblEtiqueta);
                lblEtiqueta.setText("Opción seleccionada: " + opcionSeleccionada);
            }
        });

    }

    class AdaptadorTitulares extends ArrayAdapter<Titular> {

        public AdaptadorTitulares(Context context, Titular[] datos) {
            super(context, R.layout.listitem_titular, datos);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_titular, null);

            TextView lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
            lblTitulo.setText(datos[position].getTitulo());

            TextView lblSubtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
            lblSubtitulo.setText(datos[position].getSubtitulo());

            return(item);
        }
    }


}
