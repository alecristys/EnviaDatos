package ud.example.enviadatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import Clases.Bebida;
import Clases.Hamburguesa;

public class Actividad2 extends AppCompatActivity {

    private TextView logTextView;
    private ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
        logTextView = findViewById(R.id.textView10);
        scrollView = findViewById(R.id.scrollView);
        Bundle bundle = this.getIntent().getExtras();
        log("CLIENTE: " +bundle.getString("CLIENTE"));
        log("");
        Hamburguesa mipedham = (Hamburguesa) bundle.get("HAMBURGUESA");
        Bebida mipedbeb = (Bebida) bundle.get("BEBIDA");
        log("HAMBURGUESA");
        log("CANTIDAD HAM: " +bundle.getString("CANTIDAD HAM"));
        log("");
        log("Tipo: "+mipedham.getTipo());
        if (mipedham.getCebolla()) log("Con Cebolla");
        else log("Sin Cebolla");
        log("");
        log("Bebida");
        log("CANTIDAD BEB: " +bundle.getString("CANTIDAD BEB"));
        log("");
        log("Tipo "+mipedbeb.getTipo());
        if (mipedbeb.getHielo()) log("Con Hielo");
        else log("Sin Hielo");



    }
    private void log(String s){
        logTextView.append("\n"+s);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }
}