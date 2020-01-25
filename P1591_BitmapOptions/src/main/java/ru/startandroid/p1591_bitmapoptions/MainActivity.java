package ru.startandroid.p1591_bitmapoptions;

import android.graphics.Color;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    /*class DrawView extends View {

        Paint paint;
        Bitmap bitmap;

        public DrawView(Context context) {
            super(context);
            paint = new Paint(Paint.ANTI_ALIAS_FLAG);

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher, options);

            Log.d("log", String.format("bitmap = %s, width = %s, height = %s, mimetype = %s",
                    bitmap, options.outWidth, options.outHeight, options.outMimeType));

        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);
        }

    }*/
    /*class DrawView extends View {

        Paint paint;
        Bitmap bitmap;

        public DrawView(Context context) {
            super(context);
            paint = new Paint(Paint.ANTI_ALIAS_FLAG);

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher, options);

            Log.d("log", String.format("width = %s, height = %s", bitmap.getWidth(), bitmap.getHeight()));
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);
        }

    }*/
    /*
    class DrawView extends View {

  Paint paint;
  Bitmap bitmap;

  public DrawView(Context context) {
    super(context);
    paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    Bitmap tempBitmap = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888);
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inBitmap = tempBitmap;
    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher, options);

    Log.d("log", String.format("bitmap = %s (%s,%s), tempBitmap = %s",
        bitmap, bitmap.getWidth(), bitmap.getHeight(), tempBitmap));

  }

  @Override
  protected void onDraw(Canvas canvas) {
    canvas.drawARGB(80, 102, 204, 255);
  }

}
     */
    class DrawView extends View {

        Paint paint;
        Bitmap bitmap;

        public DrawView(Context context) {
            super(context);
            paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setTextSize(40);

            Bitmap bmpIcon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
            bmpIcon = Bitmap.createScaledBitmap(bmpIcon, 500, 500, true);

            bitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
            canvas.drawColor(Color.WHITE);
            canvas.drawBitmap(bmpIcon, 0,0, paint);
            canvas.drawText("Saved bitmap", 100, 50, paint);

            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "savedBitmap.png");

            try {
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                } finally {
                    if (fos != null) fos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);
            canvas.drawBitmap(bitmap, 100, 100, paint);
        }

    }
}
/*
inPreferredConfig
Указание желаемой конфигурации Bitmap.Config.





inDensity
Задает density-значение для Bitmap, аналогично методу setDensity. Для задания значения используйте константы DENSITY* класса DisplayMetrics.





inTargetDensity, inScaled
Если inTargetDensity отличен от inDensity, и inScaled = true (по умолчанию), то размер изображения будет скорректирован от inDensity к inTargetDensity.





inScreenDensity
К сожалению, мне не удалось понять, зачем он нужен. Если есть мысли, пишите на форуме.





inPurgeable
Позволяет системе временно удалить содержимое созданного Bitmap из памяти в случае нехватки таковой. Когда изображение снова понадобится (например при выводе на экран), оно будет восстановлено из источника. Т.е. жертвуем производительностью в пользу памяти.





inInputShareable
Если true, то Bitmap хранит ссылку на источник, иначе – данные источника. Но даже если true, то вполне может быть, что по усмотрению системы будут храниться данные, а не ссылка. Этот параметр актуален только при включенном inPurgeable.





inDither
Попытка сгладить цвета, если текущей цветовой палитры не достаточно для отображения оригинальных цветов изображения





inMutable
Если true, то мы получим mutable Bitmap





inPreferQualityOverSpeed
Включение более качественного декодирования в ущерб скорости





inPremultiplied
Доступен с API Level 19. Дает возможность выключить premultiplied-режим. Если режим включен (по умолчанию), то RGB компоненты в пикселах сразу рассчитаны с учетом альфа-компонента (для лучшей производительности). Канва принимает Bitmap только в таком режиме. В хелпе сказано, что выключение режима может понадобиться для специфических задач: RenderScript  и OpenGL.





inTempStorage
Здесь можем указать свой временный массив, который будет использован в процессе декодирования





mCancel
По этой метке можно определить был ли процесс декодирования отменен методом requestCancelDecode
 */