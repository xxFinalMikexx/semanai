package com.example.miguel.semanai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.lang.*;

public class ActividadFormulario extends AppCompatActivity {

    private double pi= 3.141592;
    private double elasticidadAgua= 20670;

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


    //Información
    public float rugosidad(){
        if(){

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
