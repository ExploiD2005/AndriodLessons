package ru.startandroid.p1551_porterduffcolorfilter;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    class DrawView extends View {

        Paint[] paints;
        Paint paintBorder;

        Bitmap bitmap;

        int size = 200;

        PorterDuff.Mode mode = PorterDuff.Mode.MULTIPLY;
        //int[] colorSrc = new int[] { Color.WHITE, Color.LTGRAY, Color.GRAY,
        //        Color.DKGRAY, Color.BLACK };
        int[] colorSrc = new int[] { Color.rgb(50, 0, 0), Color.rgb(100, 0, 0),
                Color.rgb(150, 0, 0), Color.rgb(200, 0, 0),
                Color.rgb(250, 0, 0) };

        public DrawView(Context context) {
            super(context);

            // необходимо для корректной работы
            if (android.os.Build.VERSION.SDK_INT >= 11) {
                setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            }

            // создание bitmap картинки необходимого размера
            bitmap = BitmapFactory.decodeResource(getResources(),
                    R.mipmap.ic_launcher);
            bitmap = Bitmap.createScaledBitmap(bitmap, size, size, true);

            // создание массива кистей paints
            paints = new Paint[colorSrc.length];
            for (int i = 0; i < colorSrc.length; i++) {
                Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
                // для каждой кисти свой PorterDuffColorFilter
                // с цветом из массива colorSrc
                paint.setColorFilter(new PorterDuffColorFilter(colorSrc[i],
                        mode));
                paints[i] = paint;
            }

            // кисть для рамок
            paintBorder = new Paint();
            paintBorder.setStyle(Paint.Style.STROKE);
            paintBorder.setStrokeWidth(3);
            paintBorder.setColor(Color.BLACK);
        }

        @Override
        protected void onDraw(Canvas canvas) {

            canvas.translate(0, 200);
            int delta = (canvas.getWidth() - size * paints.length)
                    / (paints.length + 1);

            // рисование bitmap
            for (int i = 0; i < paints.length; i++) {
                canvas.translate(delta, 0);
                // используем кисти из массива paints
                canvas.drawBitmap(bitmap, 0, 0, paints[i]);
                canvas.drawRect(0, 0, size, size, paintBorder);
                canvas.translate(size, 0);
            }
        }
    }
}