package com.example.bedirhan.sayitahminoyunu;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Object;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int sure=0;
    public int sayi;
    public Random random=new Random();
    CountDownTimer sayac;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tw_skor=(TextView)findViewById(R.id.tw_skor);
        final TextView tw_oyun_bitti=(TextView)findViewById(R.id.tw_oyun_bitti);

        SharedPreferences sharedPreferences=getSharedPreferences("Skorlar",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        int eskiskor=sharedPreferences.getInt("yuksek_skor",0);

        tw_skor.setText(getString(R.string.tw_skor)+eskiskor);

        tw_oyun_bitti.setVisibility(View.INVISIBLE);

    }



    //menü eklemek için metod
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    //Menüdeki elemanlara tıklanınca yapılması gerekenler


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_info:
                for (int i=0;i<4;i++)
                {
                    Toast.makeText(this,getString(R.string.info),Toast.LENGTH_LONG).show();
                }

                return true;
            case R.id.otuz_saniye:
                sure=30000;
                item.setChecked(true);
                return true;
            case  R.id.altmis_saniye:sure=60000;
                item.setChecked(true);
                return true;
            case R.id.doksan_saniye:sure=90000;
                item.setChecked(true);
                return true;

            default:return super.onOptionsItemSelected(item);


        }
    }

    //Oyuna başlandığında yapılması gerekenler.
    public void oyuna_basla_click(View v){

        if(sure==0)
        {
            Toast.makeText(this,"Lütfen oyuna başlamadan önce süreyi seçiniz",Toast.LENGTH_SHORT).show();
        }
        else {
            sayi=random.nextInt(900)+100; //100 ile 999 arasında 3 haneli bir sayi üretir.

            final Button btn_basla = (Button) findViewById(R.id.btn_basla);
            final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.liner_layout);
            final TextView tw_sure=(TextView)findViewById(R.id.tw_sure);
            final EditText et_tahmin=(EditText) findViewById(R.id.et_tahmin);
            final TextView tw_oyun_bitti=(TextView)findViewById(R.id.tw_oyun_bitti);

            btn_basla.setVisibility(View.INVISIBLE);
            linearLayout.setVisibility(View.VISIBLE);
            tw_oyun_bitti.setVisibility(View.INVISIBLE);

            sayac= new CountDownTimer(sure, 1000) {
                @Override
                public void onTick(long l) {

                    tw_sure.setText(""+l/1000);
                }

                @Override
                public void onFinish() {


                    btn_basla.setVisibility(View.VISIBLE);
                    linearLayout.setVisibility(View.INVISIBLE);
                    tw_oyun_bitti.setVisibility(View.VISIBLE);
                    tw_oyun_bitti.setText(getString(R.string.oyun_bitti)+sayi);
                    et_tahmin.setText("");

                }
            }.start();
        }

    }


    //*--------------klavye kontrolleri-------- başlangıç--------------*
    public void bir_click(View v){
        final EditText et_tahmin=(EditText) findViewById(R.id.et_tahmin);
        String deger=et_tahmin.getText().toString();
        if(deger.length()<3)
        et_tahmin.setText(et_tahmin.getText()+"1");
    }
    public void iki_click(View v){

        final EditText et_tahmin=(EditText) findViewById(R.id.et_tahmin);
        String deger=et_tahmin.getText().toString();
        if(deger.length()<3)
        et_tahmin.setText(et_tahmin.getText()+"2");

    }
    public void uc_click(View v){

        final EditText et_tahmin=(EditText) findViewById(R.id.et_tahmin);
        String deger=et_tahmin.getText().toString();
        if(deger.length()<3)
        et_tahmin.setText(et_tahmin.getText()+"3");

    }
    public void dort_click(View v){

        final EditText et_tahmin=(EditText) findViewById(R.id.et_tahmin);
        String deger=et_tahmin.getText().toString();
        if(deger.length()<3)
        {
        et_tahmin.setText(et_tahmin.getText()+"4");}

    }
    public void bes_click(View v){

        final EditText et_tahmin=(EditText) findViewById(R.id.et_tahmin);
        String deger=et_tahmin.getText().toString();
        if(deger.length()<3)
        {
        et_tahmin.setText(et_tahmin.getText()+"5");}

    }
    public void alti_click(View v){

        final EditText et_tahmin=(EditText) findViewById(R.id.et_tahmin);
        String deger=et_tahmin.getText().toString();
        if(deger.length()<3)
        {
        et_tahmin.setText(et_tahmin.getText()+"6");}

    }
    public void yedi_click(View v){

        final EditText et_tahmin=(EditText) findViewById(R.id.et_tahmin);
        String deger=et_tahmin.getText().toString();
        if(deger.length()<3)
        {
        et_tahmin.setText(et_tahmin.getText()+"7");}

    }
    public void sekiz_click(View v){

        final EditText et_tahmin=(EditText) findViewById(R.id.et_tahmin);
        String deger=et_tahmin.getText().toString();
        if(deger.length()<3)
        {
        et_tahmin.setText(et_tahmin.getText()+"8");}

    }
    public void dokuz_click(View v){

        final EditText et_tahmin=(EditText) findViewById(R.id.et_tahmin);

        String deger=et_tahmin.getText().toString();
        if(deger.length()<3)
        {
            et_tahmin.setText(et_tahmin.getText()+"9");
        }
    }
    public void sifir_click(View v){

        final EditText et_tahmin=(EditText) findViewById(R.id.et_tahmin);
        String deger=et_tahmin.getText().toString();
        if(deger.length()<3)
        {
            et_tahmin.setText(et_tahmin.getText()+"0");
        }

    }
    public void sil_click(View v){

        final EditText et_tahmin=(EditText) findViewById(R.id.et_tahmin);
        String deger=et_tahmin.getText().toString();

        if(deger.length()>0) //silenecek birşey varsa sil yoksa birşey yapma
        {
        StringBuffer sb=new StringBuffer();
        sb.append(deger);
        sb.deleteCharAt(deger.length()-1);
        deger=sb.toString();
        et_tahmin.setText(deger);}
        else{
            Toast.makeText(this,"Silinecek başka birşey kalmadı",Toast.LENGTH_SHORT).show();
        }

    }

    public void gonder_click(View v)
    {
        final EditText et_tahmin=(EditText) findViewById(R.id.et_tahmin);
        final TextView tw_sonuc=(TextView)findViewById(R.id.tw_tahminsonucu);
        int edittextdegeri=Integer.parseInt(et_tahmin.getText().toString());
        final TextView tw_sure=(TextView)findViewById(R.id.tw_sure);
        final Button btn_basla = (Button) findViewById(R.id.btn_basla);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.liner_layout);
        final TextView tw_skor=(TextView)findViewById(R.id.tw_skor);

        if(edittextdegeri>sayi)
        {
            tw_sonuc.setText("AŞAĞI");
            MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.asagi);
            mediaPlayer.start();
        }
        else if(edittextdegeri<sayi)
        {
            tw_sonuc.setText("YUKARI");
            MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.yukari);
            mediaPlayer.start();
        }
        else{
            tw_sonuc.setText("DOĞRU TAHMİN");
            int yuksekskor=Integer.parseInt(tw_sure.getText().toString());
            MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.tebrikler);
            mediaPlayer.start();

            SharedPreferences sharedPreferences=getSharedPreferences("Skorlar",MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();

            int eskiskor=sharedPreferences.getInt("yuksek_skor",0);

            if(yuksekskor>eskiskor)
            {
            editor.putInt("yuksek_skor",yuksekskor);
            editor.commit();
                tw_skor.setText(getString(R.string.tw_skor)+yuksekskor);
            Toast.makeText(this,"Tebrikler Yeni Yüksek Skor:"+yuksekskor,Toast.LENGTH_LONG).show();
            }

            btn_basla.setVisibility(View.VISIBLE);
            linearLayout.setVisibility(View.INVISIBLE);
            et_tahmin.setText("");
            sayac.cancel();

        }
        et_tahmin.setText("");
    }

    //*--------------klavye kontrolleri-------- son--------------*


}
