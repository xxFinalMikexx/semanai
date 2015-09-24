package com.example.miguel.semanai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.HashMap;
import java.util.Map;

public class ActividadNuevosDatos extends AppCompatActivity {

    private double pi= 3.141592;
    Map<String, Float> diametroPVC= new HashMap<String, Float>();
    //HashMap de diametros Acero
    Map<String, Float> diametroAcero= new HashMap<String, Float>();
    //HashMap de diametros PE
    Map<String, Float> diametroPE= new HashMap<String, Float>();
    //HashMap de diametros PE
    Map<String, Float> diametroHierro= new HashMap<String, Float>();
    //HashMap de diametros PE
    Map<String, Map<String, Float>> diametros= new HashMap<String, Map<String, Float>>();

    public void setHashMaps(Map diametroPVC, Map diametroAcero, Map diametroPE, Map diametroHierro, Map diametros) {
        diametroPVC.put("1/2", 1910/14.23);
        diametroPVC.put("3/4", 1540/14.23);
        diametroPVC.put("1", 1440/14.23);
        diametroPVC.put("5/4", 1180/14.23);
        diametroPVC.put("3/2", 1060/14.23);
        diametroPVC.put("2", 890/14.23);
        diametroPVC.put("5/2", 870/14.23);
        diametroPVC.put("3", 840/14.23);
        diametroPVC.put("4", 710/14.23);
        diametroPVC.put("5", 620/14.23);
        diametroPVC.put("6", 560/14.23);
        diametroPVC.put("8", 500/14.23);
        diametroPVC.put("10", 450/14.23);
        diametroPVC.put("12", 420/14.23);

        diametroAcero.put("1/8", 3500/14.23);
        diametroAcero.put("1/4", 2100/14.23);
        diametroAcero.put("3/8", 1700/14.23);
        diametroAcero.put("1/2", 2300/14.23);
        diametroAcero.put("3/4", 2000/14.23);
        diametroAcero.put("1", 2100/14.23);
        diametroAcero.put("5/4", 1800/14.23);
        diametroAcero.put("3/2", 1700/14.23);
        diametroAcero.put("2", 1500/14.23);
        diametroAcero.put("5/2", 1900/14.23);
        diametroAcero.put("3", 1600/14.23);
        diametroAcero.put("7/2", 1500/14.23);
        diametroAcero.put("4", 1400/14.23);
        diametroAcero.put("5", 1300/14.23);
        diametroAcero.put("6", 1210/14.23);
        diametroAcero.put("8", 1100/14.23);
        diametroAcero.put("10", 1030/14.23);
        diametroAcero.put("12", 1000/14.23);

        diametroPE.put("1/2", 262/14.23);
        diametroPE.put("3/4", 220/14.23);
        diametroPE.put("1", 200/14.23);
        diametroPE.put("5/4", 162/14.23);
        diametroPE.put("3/2", 150/14.23);
        diametroPE.put("2", 125/14.23);
        diametroPE.put("5/2", 130/14.23);
        diametroPE.put("3", 122/14.23);
        diametroPE.put("7/2", 110/14.23);
        diametroPE.put("4", 100/14.23);
        diametroPE.put("5", 95/14.23);
        diametroPE.put("6", 90/14.23);

        diametroHierro.put("x", 24.61);

        diametros.put("PVC", diametroPVC);
        diametros.put("Acero", diametroAcero);
        diametros.put("Hierro", diametroHierro);
        diametros.put("PE", diametroPE);
    }

    //Qmo= flujo
    //Area que se saca con inputs del usuario
    public float area(float flujo, float vel){
        float area=flujo/vel;
        return area;
    }

    //Diametro propuesto
    public float diametro(float area){
        float diametro= (float) (2*(Math.sqrt(area / pi)));
        return diametro;
    }

    public void consigueDatos() {
        Intent intendReporte = getIntent();
        Bundle bundle = intendReporte.getExtras();

        String velocidad = bundle.getString("VelInicial");
        String flujo = bundle.getString("Flujo");
        String material = bundle.getString("Material");

        Map<String, Float> materialEscogido = this.diametros.get(material);


        float area = area(Float.parseFloat(flujo), (Float.parseFloat(velocidad)));
        float diametro = diametro(area);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_nuevos_datos);

        setHashMaps(diametroPVC, diametroAcero, diametroPE, diametroHierro, diametros);


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
