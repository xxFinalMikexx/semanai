package com.example.miguel.semanai;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v4.util.LogWriter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class ActividadReporte extends AppCompatActivity {

    private double pi= 3.141592;
    private double elasticidadAgua= 20670;
    //HashMap de Rugosidad
    Map<String, Float> rugosidad= new HashMap<String, Float>();
    //HashMap de elasticidad
    Map<String, Float> elasticidad= new HashMap<String, Float>();
    //HashMap de diametros PVC
    Map<String, Float> diametroPVC= new HashMap<String, Float>();
    //HashMap de diametros Acero
    Map<String, Float> diametroAcero= new HashMap<String, Float>();
    //HashMap de diametros PE
    Map<String, Float> diametroPE= new HashMap<String, Float>();
    //HashMap de diametros PE
    Map<String, Float> diametroHierro= new HashMap<String, Float>();
    //HashMap de diametros PE
    Map<String, Map<String, Float>> diametros= new HashMap<String, Map<String, Float>>();
    //Hashmap de los diametros en Float
    Map<String, Float> diametrosTotales = new HashMap<String, Float>();


    public void setHashMaps() {
        this.diametrosTotales.put("1/2", (float)0.5);
        this.diametrosTotales.put("3/4", (float)0.75);
        this.diametrosTotales.put("1", (float)1);
        this.diametrosTotales.put("5/4", (float)1.25);
        this.diametrosTotales.put("3/2", (float)1.5);
        this.diametrosTotales.put("2", (float)2);
        this.diametrosTotales.put("5/2", (float)2.5);
        this.diametrosTotales.put("3", (float)3);
        this.diametrosTotales.put("4", (float)4);
        this.diametrosTotales.put("5", (float)5);
        this.diametrosTotales.put("6", (float)6);
        this.diametrosTotales.put("8", (float)8);
        this.diametrosTotales.put("10", (float)10);
        this.diametrosTotales.put("12", (float)12);
        this.diametrosTotales.put("1/8", (float)0.125);
        this.diametrosTotales.put("1/4", (float)0.25);
        this.diametrosTotales.put("3/8", (float)0.375);
        this.diametrosTotales.put("7/2", (float)3.5);

        this.rugosidad.put("Acero", (float)0.0010);
        this.rugosidad.put("PVC", (float)0.009);
        this.rugosidad.put("PE", (float)0.008);

        this.elasticidad.put("Acero",(float)2100000 );
        this.elasticidad.put("PVC", (float)28100);
        this.elasticidad.put("PE",(float)5200);

        this.diametroPVC.put("1/2", (float)(1910/14.23));
        this.diametroPVC.put("3/4", (float)(1540/14.23));
        this.diametroPVC.put("1", (float)(1440/14.23));
        this.diametroPVC.put("5/4", (float)(1180/14.23));
        this.diametroPVC.put("3/2", (float)(1060/14.23));
        this.diametroPVC.put("2", (float)(890/14.23));
        this.diametroPVC.put("5/2", (float)(870/14.23));
        this.diametroPVC.put("3", (float)(840/14.23));
        this.diametroPVC.put("4", (float)(710/14.23));
        this.diametroPVC.put("5", (float)(620/14.23));
        this.diametroPVC.put("6", (float)(560/14.23));
        this.diametroPVC.put("8", (float)(500/14.23));
        this.diametroPVC.put("10", (float)(450/14.23));
        this.diametroPVC.put("12", (float)(420/14.23));

        this.diametroAcero.put("1/8", (float)(3500/14.23));
        this.diametroAcero.put("1/4", (float)(2100/14.23));
        this.diametroAcero.put("3/8", (float)(1700/14.23));
        this.diametroAcero.put("1/2", (float)(2300/14.23));
        this.diametroAcero.put("3/4", (float)(2000/14.23));
        this.diametroAcero.put("1", (float)(2100/14.23));
        this.diametroAcero.put("5/4", (float)(1800/14.23));
        this.diametroAcero.put("3/2", (float)(1700/14.23));
        this.diametroAcero.put("2", (float)(1500/14.23));
        this.diametroAcero.put("5/2", (float)(1900/14.23));
        this.diametroAcero.put("3", (float)(1600/14.23));
        this.diametroAcero.put("7/2", (float)(1500/14.23));
        this.diametroAcero.put("4", (float)(1400/14.23));
        this.diametroAcero.put("5", (float)(1300/14.23));
        this.diametroAcero.put("6", (float)(1210/14.23));
        this.diametroAcero.put("8", (float)(1100/14.23));
        this.diametroAcero.put("10", (float)(1030/14.23));
        this.diametroAcero.put("12", (float)(1000/14.23));

        diametroPE.put("1/2", (float)(262/14.23));
        diametroPE.put("3/4", (float)(220/14.23));
        diametroPE.put("1", (float)(200/14.23));
        diametroPE.put("5/4", (float)(162/14.23));
        diametroPE.put("3/2", (float)(150/14.23));
        diametroPE.put("2", (float)(125/14.23));
        diametroPE.put("5/2", (float)(130/14.23));
        diametroPE.put("3", (float)(122/14.23));
        diametroPE.put("7/2", (float)(110/14.23));
        diametroPE.put("4", (float)(100/14.23));
        diametroPE.put("5", (float)(95/14.23));
        diametroPE.put("6", (float)(90/14.23));

        diametros.put("PVC", diametroPVC);
        diametros.put("Acero", diametroAcero);
        diametros.put("PE", diametroPE);
    }
    ///////////////////////Formulas///////////////////////
    //Altura, H
    public float cargaEstatica(float altInicial, float altFinal, float colchon){
        float cargaE= (altFinal-altInicial)+colchon;
        return cargaE;
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
    public void presionesTubo(float pt, float pn, float golpeA, float presionTubo) {
        float pva = 0;
        if (pt >= presionTubo) {
            pva = (float) (pn + (golpeA * 0.20));
        }
        if(pva>= presionTubo){
            //Escoger otro material u otro diametro
        }

    }

    public void consigueDatos() {
        Intent intendReporte = getIntent();
        Bundle bundle = intendReporte.getExtras();

        String longDescarga =  bundle.getString("LongDescarga");
        String altInicial = bundle.getString("AltInicial");
        String altFinal = bundle.getString("AltFinal");
        String flujo = bundle.getString("Flujo");
        String velInicial = bundle.getString("VelInicial");
        String disPerdida = bundle.getString("DisPerdida");
        String material = bundle.getString("Material");
        String colchon = bundle.getString("Colchon");
        String espesor = bundle.getString("Espesor");
        String nuevoDiametro = bundle.getString("NuevoDiametro");

        hacerCalculos(longDescarga, altInicial, altFinal, flujo, velInicial, disPerdida, material, colchon, espesor, nuevoDiametro);

    }

    public void alertaTest(String text) {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Información adicional");
        alertDialog.setMessage(text);
        alertDialog.setButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.hide();
            }
        });
        alertDialog.show();
    }

    public void hacerCalculos(String longitudDescarga, String altInicial, String altFinal, String flujoInicial,
                              String velocidad, String disPerdida, String material, String colchon, String espesor, String diametroComercial) {
        //**Seleccionar el diámetro comercial deseado en base al material
        float flujo = ((Float.parseFloat(flujoInicial))/1000);

        float nuevoDiametro = this.diametrosTotales.get(diametroComercial);

        float nuevaArea = areaC(nuevoDiametro);

        //Obtiene rugosidad en base al material
        float rugosidadElegida = this.rugosidad.get(material);

        float nuevaVelocidad = correccionV(flujo, nuevaArea);
        float k = k(rugosidadElegida, nuevoDiametro);

        float h = cargaEstatica(Float.parseFloat(altFinal), Float.parseFloat(altInicial), Float.parseFloat(colchon));
        float perdidaFriccion = perdidaFriccion(k, (Float.parseFloat(longitudDescarga)), flujo);

        //**Seleccionar elasticidad del material
        float elasticidadMaterial = this.elasticidad.get(material);

        float golpeAriete = golpeMetros(nuevaVelocidad, nuevoDiametro, elasticidadMaterial, Float.parseFloat(espesor));
        float presionGolpeAriete = golpeA(golpeAriete);
        float pn = pnMetros(h, (Float.parseFloat(disPerdida)), perdidaFriccion);
        float presionPn = pn(pn);
        float pt = ptMetros(golpeAriete, pn);
        float ptFinal = pt(pt);

        //**Diametros es un hashmap con el material y dentro un hashmap con el mapeo de el diámetro -> presión
        Map<String, Float> presionEsogida = diametros.get(material);
        float presionTubo = presionEsogida.get(diametroComercial);

        //Text Views para todos los campos
        TextView velocidadText = (TextView) findViewById(R.id.velocidad);
        velocidadText.setText(velocidad);
        TextView flujoText = (TextView) findViewById(R.id.flujo);
        flujoText.setText(flujoInicial);
        TextView cargaEstaticaText = (TextView) findViewById(R.id.cargaEstatica);
        cargaEstaticaText.setText(h + "");
        TextView materialText = (TextView) findViewById(R.id.material);
        materialText.setText(material);
        TextView elasticidadText = (TextView) findViewById(R.id.elasticidad);
        elasticidadText.setText(elasticidadMaterial + "");
        TextView rugosidadText = (TextView) findViewById(R.id.rugosidad);
        rugosidadText.setText(rugosidadElegida + "");
        TextView presionTuboText = (TextView) findViewById(R.id.presionTubo);
        presionTuboText.setText(presionTubo + "");
        TextView areaCorregidaText = (TextView) findViewById(R.id.areaC);
        areaCorregidaText.setText(nuevaArea + "");
        TextView correccionVText = (TextView) findViewById(R.id.correccionV);
        correccionVText.setText(nuevaVelocidad + "");
        TextView perdidaFriccionText = (TextView) findViewById(R.id.perdidaFriccion);
        perdidaFriccionText.setText(perdidaFriccion + "");
        TextView golpeArieteText = (TextView) findViewById(R.id.golpeMetros);
        golpeArieteText.setText(golpeAriete + "");
        TextView pniText = (TextView) findViewById(R.id.pnMetros);
        pniText.setText(pn + "");
        TextView ptiText = (TextView) findViewById(R.id.ptMetros);
        ptiText.setText(pt + "");
        TextView golpeA2Text = (TextView) findViewById(R.id.golpeA);
        golpeA2Text.setText(presionGolpeAriete + "");
        TextView pnText = (TextView) findViewById(R.id.pn);
        pnText.setText(presionPn + "");
        TextView ptText = (TextView) findViewById(R.id.pt);
        ptText.setText(ptFinal + "");


        if(ptFinal >= presionTubo) {
            float pva = (float)(presionPn + (presionGolpeAriete * 0.2));
            alertaTest("La presión supera a la presión del tubo. Se usará una válvula de alivio");
            if(pva >= presionTubo) {
                alertaTest("La presión continua superando la presión del tubo. Por favor, regresa y selecciona otro tubo\nPresión obtenida: "+pva+" - Presión del tubo: "+presionTubo);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_reporte);

        setHashMaps();
        consigueDatos();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad_reporte, menu);
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
