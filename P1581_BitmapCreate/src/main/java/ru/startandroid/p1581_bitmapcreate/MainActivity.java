package ru.startandroid.p1581_bitmapcreate;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    /*class DrawView extends View {

        Paint paint;
        Bitmap bitmapSource;
        Bitmap bitmap;
        Matrix matrix;

        public DrawView(Context context) {
            super(context);
            paint = new Paint(Paint.ANTI_ALIAS_FLAG);

            bitmapSource = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

            matrix = new Matrix();
            matrix.postScale(10, 15);
            matrix.postRotate(45);

            bitmap = Bitmap.createBitmap(bitmapSource, 0, 0, bitmapSource.getWidth()/2, bitmapSource.getHeight()/2, matrix, true);

        }


        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);
            canvas.drawBitmap(bitmap, 0, 0, paint);
        }

    }*/
    /*
    class DrawView extends View {

  Paint paint;
  Bitmap bitmap;
  Bitmap bitmapAlpha;

  public DrawView(Context context) {
    super(context);
    paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    int[] colors = new int[300*300];
    Arrays.fill(colors, 0, 300*100, Color.argb(85, 255, 0, 0));
    Arrays.fill(colors, 300*100, 300*200, Color.GREEN);
    Arrays.fill(colors, 300*200, 300*300, Color.BLUE);

    bitmap = Bitmap.createBitmap(colors, 300, 300, Bitmap.Config.RGB_565);
    bitmapAlpha = Bitmap.createBitmap(colors, 300, 300, Bitmap.Config.ARGB_8888);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    canvas.drawBitmap(bitmap, 50, 50, paint);
    canvas.drawBitmap(bitmapAlpha, 550, 50, paint);
  }

}
     */
    /*class DrawView extends View {

        Paint paint;
        Bitmap bitmap;

        public DrawView(Context context) {
            super(context);
            paint = new Paint(Paint.ANTI_ALIAS_FLAG);

            bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.RGB_565);

            bitmap.setPixel(20, 20, Color.RED);
            bitmap.setPixel(70, 50, Color.RED);
            bitmap.setPixel(30, 80, Color.RED);

            int[] colors = new int[10*15];
            Arrays.fill(colors, 0, 10*15, Color.GREEN);
            bitmap.setPixels(colors, 0, 10, 40, 40, 10, 15);

            Canvas canvas = new Canvas(bitmap);
            Paint p = new Paint();
            p.setColor(Color.BLUE);
            canvas.drawCircle(80, 80, 10, p);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);
            canvas.drawBitmap(bitmap, 50, 50, paint);
        }

    }*/
    class DrawView extends View {

        Paint paint;
        Bitmap bitmap1;
        Bitmap bitmap2;
        Bitmap bitmap3;

        public DrawView(Context context) {
            super(context);
            paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setStyle(Paint.Style.STROKE);

            bitmap1 = Bitmap.createBitmap(100, 100, Bitmap.Config.RGB_565);
            bitmap2 = Bitmap.createBitmap(100, 100, Bitmap.Config.RGB_565);
            bitmap3 = Bitmap.createBitmap(100, 100, Bitmap.Config.RGB_565);

            Bitmap bitmapIcon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

            Canvas canvas = new Canvas(bitmap1);
            canvas.drawBitmap(bitmapIcon, 0, 0, paint);

            canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmapIcon, 0, 0, paint);
            bitmap2.setDensity(DisplayMetrics.DENSITY_XHIGH);

            bitmap3.setDensity(DisplayMetrics.DENSITY_XHIGH);
            canvas = new Canvas(bitmap3);
            canvas.drawBitmap(bitmapIcon, 0, 0, paint);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            canvas.translate(100, 100);
            canvas.drawRect(0,0,100,100,paint);
            canvas.drawBitmap(bitmap1, 0, 0, paint);

            canvas.translate(150, 0);
            canvas.drawRect(0,0,100,100,paint);
            canvas.drawBitmap(bitmap2, 0, 0, paint);

            canvas.translate(150, 0);
            canvas.drawRect(0,0,100,100,paint);
            canvas.drawBitmap(bitmap3, 0, 0, paint);
        }

    }
}