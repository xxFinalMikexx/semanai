package com.example.miguel.semanai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class ActividadNuevosDatos extends AppCompatActivity {

    private double pi= 3.141592;

    //Qmo= flujo
    //Area que se saca con inputs del usuario
    public float area(float flujo, float vel){
        float area=(flujo/1000)/vel;
        return area;
    }

    //Diametro propuesto
    public float diametro(float area){
        float diametro= (float) (2*(Math.sqrt(area / pi)));
        return diametro;
    }

    public void consigueNuevoDiametro() {
        Intent intendReporte = getIntent();
        Bundle bundle = intendReporte.getExtras();

        String velocidad = bundle.getString("VelInicial");
        String flujo = bundle.getString("Flujo");
        String material = bundle.getString("Material");

        float area = area(Float.parseFloat(flujo), (Float.parseFloat(velocidad)));
        float diametro = diametro(area);

        TextView diametroPropuesto = findViewById(R.id.diametroPropuesto);
        diametroPropuesto.setText(diametro + "");
    }

    public void enviaReporte(View view) {
        Intent intendReporte = getIntent();
        Bundle bundleReporte = intendReporte.getExtras();

        String longDescarga = bundleReporte.getString("VelInicial");
        String altInicial = bundleReporte.getString("VelInicial");
        String altFinal = bundleReporte.getString("VelInicial");
        String flujo = bundleReporte.getString("VelInicial");
        String velInicial = bundleReporte.getString("VelInicial");
        String distPerdida = bundleReporte.getString("VelInicial");
        String materiales = bundleReporte.getString("VelInicial");
        String colchon = bundleReporte.getString("Flujo");
        String espesor = bundleReporte.getString("Material");

        Spinner nuevoDiametro = (Spinner) findViewById(R.id.nuevoDiametro);

        Bundle bundle = new Bundle();

        bundle.putString("LongDescarga", longDescarga);
        bundle.putString("AltInicial" , altInicial);
        bundle.putString("AltFinal" , altFinal);
        bundle.putString("Flujo" , flujo);
        bundle.putString("VelInicial" , velInicial);
        bundle.putString("DisPerdida" , distPerdida);
        bundle.putString("Material" , materiales);
        bundle.putString("Colchon" , colchon);
        bundle.putString("Espesor" , espesor);
        bundle.putString("NuevoDiametro", nuevoDiametro.getSelectedItem().toString());

        Intent intent = new Intent(this, ActividadReporte.class);
        intent.putExtras( bundle );
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_nuevos_datos);

        consigueNuevoDiametro();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad_nuevos_datos, menu);
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
