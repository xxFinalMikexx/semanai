package com.example.miguel.semanai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.lang.*;
import java.util.*;

public class ActividadFormulario extends AppCompatActivity {

    private double pi= 3.141592;
    private double elasticidadAgua= 20670;

    //HashMap de Rugosidad
    Map<String, Float> rugosidad= new HashMap<String, Float>();
    rugosidad.put("acero", 0.07);
    rugosidad.put("pvc", 0.020);
    rugosidad.put("polietireno", 0.002);
    rugosidad.put("hierro", 0.07);

    //HashMap de elasticidad
    Map<String, Float> elasticidad= new HashMap<String, Float>();
    elasticidad.put("acero",2100000 );
    elasticidad.put("pvc", 28100);
    elasticidad.put("polietireno",5200);
    elasticidad.put("hierro", 320000);

    //HashMap de diametros PVC
    Map<String, Float> diametroPVC= new HashMap<String, Float>();
    diametroPVC.put("1/2", 1910);
    diametroPVC.put("3/4", 1540);
    diametroPVC.put("1", 1440);
    diametroPVC.put("5/4", 1180);
    diametroPVC.put("3/2", 1060);
    diametroPVC.put("2", 890);
    diametroPVC.put("5/2", 870);
    diametroPVC.put("3", 840);
    diametroPVC.put("4", 710);
    diametroPVC.put("5", 620);
    diametroPVC.put("6", 560);
    diametroPVC.put("8", 500);
    diametroPVC.put("10", 450);
    diametroPVC.put("12", 420);

    /7PVC, hierro, acero, polietileno
    //HashMap de diametros Acero
    Map<String, Float> diametroAcero= new HashMap<String, Float>();
    diametroAcero.put("1/8", 3500/14.23);
    diametroAcero.put("1/4", 2100);
    diametroAcero.put("3/8", 1700);
    diametroAcero.put("1/2", 2300);
    diametroAcero.put("3/4", 2000);
    diametroAcero.put("1", 2100);
    diametroAcero.put("5/4", 1800);
    diametroAcero.put("3/2", 1700);
    diametroAcero.put("2", 1500);
    diametroAcero.put("5/2", 1900);
    diametroAcero.put("3", 1910);
    diametroAcero.put("7/2", 1910);
    diametroAcero.put("4", 1910);
    diametroAcero.put("5", 1910);
    diametroAcero.put("6", 1910);
    diametroAcero.put("8", 1910);
    diametroAcero.put("10", 1910);
    diametroAcero.put("12", 1910);

    //HashMap PE pipes




///////////////////////Formulas///////////////////////
    //Altura, H
    public float cargaEstatica(float altInicial, float altFinal, float colchon){
        float cargaE= (altFinal-altInicial)+colchon;
        return cargaE;
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

    //Nueva area que se saca con el diametro comercial
    public float areaC(float diametroC){
        float area= (float) ((diametroC/2)*(Math.pow(pi, 2)));
        return area;

    }

    //Nueva velocidad que se saca con el area nueva
    public float correccionV(float flujo, float areaC){
        float correccion= flujo/areaC;
        return correccion;
    }


    public float k(float n, float diametroC){
        float k= (float) (((10.3)*(Math.pow(n,2)))/(Math.pow(diametroC, (16 / 3))));
        return k;
    }

    //Longitud de Descarga, Qmo= flujo
    //Perdida por friccion
    public float perdidaFriccion(float k, float longitudD, float flujo){
        float hF= (float) (k*longitudD*(Math.pow(flujo, 2)));
        return hF;
    }


    //Presion por golpe de ariete
    // e= espesor de la pared en m
    // elasticidadAgua= modulo de elasticidad del agua, eF= modulo de elasticidad del material
   //Primer golpe calculado en metros
    public float golpeMetros(float correccionV, float diametroC, float ef, float e){
        float golpe= (float) ((145*correccionV)/(Math.sqrt(1+(elasticidadAgua/ef)*(diametroC/e))));
        return golpe;
    }

    //Segundo golpe calculado en kg/cm^2
    public float golpeA(float golpeMetros){
        float golpeB= golpeMetros/10;
        return golpeB;
    }

    //Primer calculado en metros
    public float pnMetros(float cargaEstatica, float perdidaConexion, float perdidaF ){
        float pnMetros=cargaEstatica+perdidaConexion+perdidaF;
        return pnMetros;
    }

    //Segundo calculado en kg/cm^2
    public float pn(float pnMetros){
        float pn= pnMetros/10;
        return pn;
    }
    
    //Calculado en metros
    public float ptMetros(float golpeMetros, float pnMetros){
        float ptMetros= golpeMetros+pnMetros;
        return ptMetros;
    }

    //Segundo calculado en kg/cm^2
    public float pt(float ptMetros){
        float pt= ptMetros/10;
        return pt;
    }

    //Metodo para regresar a la pantalla de escoger material/alerta
    public void presionesTubo(float pt, float pn, float golpeA, float presionTubo){
        float pva=0;
        if(pt >= presionTubo) {
            pva = (float) (pn + (golpeA * 0.20));
        }
        if(pva>= presionTubo){
            //Escoger otro material u otro diametro
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_formulario);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad_formulario, menu);
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
