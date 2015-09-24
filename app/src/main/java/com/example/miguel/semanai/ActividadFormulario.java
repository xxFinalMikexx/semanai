package com.example.miguel.semanai;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.app.AlertDialog;

import java.lang.*;
import java.util.HashMap;
import java.util.Map;


public class ActividadFormulario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_formulario);
    }

    public void calcular(View view) {
        EditText longDescarga = (EditText) findViewById(R.id.longitudDescarga);
        EditText altInicial = (EditText) findViewById(R.id.alturaInicial);
        EditText altFinal = (EditText) findViewById(R.id.alturaFinal);
        EditText flujo = (EditText) findViewById(R.id.cantidadFlujo);
        EditText velInicial = (EditText) findViewById(R.id.velocidadInicial);
        EditText distPerdida = (EditText) findViewById(R.id.perdidaDistancia);
        Spinner materiales = (Spinner) findViewById(R.id.materialesLista);

        boolean campos = verificaCampos(longDescarga, altInicial, altFinal, flujo, velInicial, distPerdida);
        if(campos) {
            Bundle bundle = new Bundle();

            bundle.putString("LongDescarga", longDescarga.getText().toString());
            bundle.putString("AltInicial" , altInicial.getText().toString());
            bundle.putString("AltFinal" , altFinal.getText().toString());
            bundle.putString("Flujo" , flujo.getText().toString());
            bundle.putString("VelInicial" , velInicial.getText().toString());
            bundle.putString("DisPerdida" , distPerdida.getText().toString());
            bundle.putString("Material" , materiales.getSelectedItem().toString());

            Intent intent = new Intent(this, ActividadReporte.class);
            intent.putExtras( bundle );
            startActivity(intent);
        } else {
            mostrarAlerta();
        }
    }

    public void cargaReporte(EditText longDescarga, EditText altInicial, EditText altFinal, EditText flujo,
                             EditText velInicial, EditText distPerdida, Spinner materiales) {

    }


    public boolean verificaCampos(EditText longDescarga, EditText altInicial, EditText altFinal, EditText flujo,
                                  EditText velInicial, EditText distPerdida){
        boolean campos_completos = true;

        if(isNotEmpty(longDescarga)) {
            /*if(isNotEmpty(altInicial)) {
                if(isNotEmpty(altFinal)) {
                    if(isNotEmpty(flujo)) {
                        if(isNotEmpty(velInicial)) {
                            if(isNotEmpty(distPerdida)) {
                                campos_completos = true;
                            } else {
                                campos_completos = false;
                            }
                        } else {
                            campos_completos = false;
                        }
                    } else {
                        campos_completos = false;
                    }
                } else {
                    campos_completos = false;
                }
            } else {
                campos_completos = false;
            }*/
        } else {
            campos_completos = false;
        }

        return campos_completos;
    }
    public boolean isNotEmpty(EditText campo) {
        if(campo.getText().toString().equalsIgnoreCase("")) {
            return false;
        } else {
            return true;
        }
    }

    public void mostrarAlerta() {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Campos vacíos");
        alertDialog.setMessage("Todos los campos deben ser llenados");
        alertDialog.setButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.hide();
            }
        });
        alertDialog.show();
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
