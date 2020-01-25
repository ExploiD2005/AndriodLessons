package ru.startandroid.p1341_camerafeatures;

import android.support.v7.app.AppCompatActivity;
import java.util.List;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    SurfaceView surfaceView;
    Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);

        SurfaceHolder holder = surfaceView.getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    camera.setPreviewDisplay(holder);
                    camera.startPreview();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format,
                                       int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        camera = Camera.open();
        initSpinners();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (camera != null)
            camera.release();
        camera = null;
    }

    void initSpinners() {
        // Цветовые эффекты
        // получаем список цветовых эффектов
        final List<String> colorEffects = camera.getParameters()
                .getSupportedColorEffects();
        Spinner spEffect = initSpinner(R.id.spEffect, colorEffects, camera
                .getParameters().getColorEffect());
        // обработчик выбора
        spEffect.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                Parameters params = camera.getParameters();
                params.setColorEffect(colorEffects.get(arg2));
                camera.setParameters(params);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        // Режимы вспышки
        // получаем список режимов вспышки
        final List<String> flashModes = camera.getParameters()
                .getSupportedFlashModes();
        // настройка спиннера
        Spinner spFlash = initSpinner(R.id.spFlash, flashModes, camera
                .getParameters().getFlashMode());
        // обработчик выбора
        spFlash.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                Parameters params = camera.getParameters();
                params.setFlashMode(flashModes.get(arg2));
                camera.setParameters(params);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    Spinner initSpinner(int spinnerId, List<String> data, String currentValue) {
        // настройка спиннера и адаптера для него
        Spinner spinner = (Spinner) findViewById(spinnerId);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // определеяем какое значение в списке является текущей настройкой
        for (int i = 0; i < data.size(); i++) {
            String item = data.get(i);
            if (item.equals(currentValue)) {
                spinner.setSelection(i);
            }
        }

        return spinner;
    }

}