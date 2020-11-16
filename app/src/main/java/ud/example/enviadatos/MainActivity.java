package ud.example.enviadatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.ErrorListener;

import Clases.Bebida;
import Clases.Hamburguesa;

public class MainActivity extends AppCompatActivity {
    private EditText cliente, cantham, cantbbeb;
    private Spinner lista01, lista02, lista03;
    private CheckBox hielo;
    private Button enviab;
    private List<String> tipoh, sino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cliente = findViewById(R.id.editText);
        cantham = findViewById(R.id.editText2);
        cantbbeb = findViewById(R.id.editText3);
        lista01 = findViewById(R.id.spinner);
        lista02 = findViewById(R.id.spinner3);
        lista03 = findViewById(R.id.spinner4);
        hielo = findViewById(R.id.checkBox);
        enviab = findViewById(R.id.button5);
        datosincio();

    }
    private  void datosincio(){
        List<String> tipoh = new ArrayList<String>();
      //  List<String> tipob = new ArrayList<String>();
        List<String> sino = new ArrayList<String>();
        tipoh.add("Carne");tipoh.add("Pollo");tipoh.add("Pescado");
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>
                (this,android.R.layout.simple_spinner_item,tipoh);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lista01.setAdapter(adaptador);
        sino.add("SI"); sino.add("NO");
        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>
                (this,android.R.layout.simple_spinner_item,sino);
        adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lista02.setAdapter(adaptador2);


    }
    public void llamaractividad (View v){
        boolean cebolla = false;
        if (lista02.getSelectedItem().toString().equals("SI")) cebolla = true;
        Hamburguesa miham = new Hamburguesa(lista01.getSelectedItem().toString(), cebolla);
        boolean hielo = this.hielo.isChecked();
        Bebida mibeb = new Bebida(lista03.getSelectedItem().toString(),hielo);

      //  if (cliente.getText().toString().isEmpty()==true);{
     //       cliente.setText("");
     //   }
      //  if (cliente.getText().toString().isEmpty()==false);

      //      cliente.setText("");


        Intent int01 = new Intent(v.getContext(),Actividad2.class);
        int01.putExtra("CLIENTE",cliente.getText().toString());
        int01.putExtra("CANTIDAD HAM",cantham.getText().toString());
        int01.putExtra("CANTIDAD BEB",cantbbeb.getText().toString());
        //if (cliente.equals(""))   enviab.setEnabled(false);


        int01.putExtra("HAMBURGUESA",miham);
        int01.putExtra("BEBIDA",mibeb);
        if (cliente.getText().toString().isEmpty()==false){ Toast.makeText(this,"Pedido Enviado Exitosamente",Toast.LENGTH_SHORT).show();
            startActivity(int01);
        }


    }

}