package com.example.alcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private NumberFormat percentFormat = NumberFormat.getPercentInstance();

    private TextView precoDaGasolinaTextView;
    private SeekBar precoDaGasolinaSeekBar;
    private TextView precoDoEtanolTextView;
    private SeekBar precoDoEtanolSeekBar;
    private TextView melhorOpcaoTextView;
    private ImageView melhorOpcaoImageView;

    private double precoGasolina;
    private double precoEtanol;
    private double total;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        precoDaGasolinaTextView = findViewById(R.id.precoGasolinaTextview);
        precoDaGasolinaSeekBar = findViewById(R.id.precoGasolinaSeekbar);
        precoDoEtanolTextView = findViewById(R.id.precoEtanolTextview);
        precoDoEtanolSeekBar =findViewById(R.id.precoEtanolSeekbar);        ;
        melhorOpcaoTextView = findViewById(R.id.melhorOpcaoValor);
        melhorOpcaoImageView = findViewById(R.id.fotoMelhorOpcaoImageView);

        precoGasolina = precoEtanol = 3;
        calcularMelhorOpcao();
        precoDaGasolinaSeekBar.setOnSeekBarChangeListener(observer);
        precoDoEtanolSeekBar.setOnSeekBarChangeListener(observer);
    }



    private SeekBar.OnSeekBarChangeListener observer = new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                    if (seekBar.getId() == R.id.precoGasolinaSeekbar){
                        precoGasolina = progress / 100.;
                    }
                    else{
                        precoEtanol = progress / 100.;
                    }
                    calcularMelhorOpcao();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            };

    private void calcularMelhorOpcao (){
        total = precoEtanol / precoGasolina;
        precoDaGasolinaTextView.setText(currencyFormat.format(precoGasolina));
        precoDoEtanolTextView.setText(currencyFormat.format(precoEtanol));

        if (total >= 0.7){
            melhorOpcaoImageView.setImageResource(R.drawable.gasolina);
            melhorOpcaoTextView.setText(R.string.gasolina);
        }
        else{
            melhorOpcaoImageView.setImageResource(R.drawable.etanol);
            melhorOpcaoTextView.setText(R.string.etanol);
        }
    }
}
