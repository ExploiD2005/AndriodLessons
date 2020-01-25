package ru.startandroid.p1541_porterduff;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    class DrawView extends View {

        Paint paintSrc;
        Paint paintDst;
        Paint paintBorder;

        Path pathSrc;
        Path pathDst;

        Bitmap bitmapSrc;
        Bitmap bitmapDst;

        // PorterDuff режим
        PorterDuff.Mode mode = PorterDuff.Mode.ADD;

        int colorDst = Color.RED;
        int colorSrc = Color.GREEN;

        public DrawView(Context context) {
            super(context);

            // необходимо для корректной работы
            if (android.os.Build.VERSION.SDK_INT >= 11) {
                setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            }

            // DST фигура
            pathDst = new Path();
            pathDst.moveTo(0, 0);
            pathDst.lineTo(500, 0);
            pathDst.lineTo(500, 500);
            pathDst.close();

            // создание DST bitmap
            bitmapDst = createBitmap(pathDst, colorDst);

            // кисть для вывода DST bitmap
            paintDst = new Paint();

            // SRC фигура
            pathSrc = new Path();
            pathSrc.moveTo(0, 0);
            pathSrc.lineTo(500, 0);
            pathSrc.lineTo(0, 500);
            pathSrc.close();

            // создание SRC bitmap
            bitmapSrc = createBitmap(pathSrc, colorSrc);

            // кисть для вывода SRC bitmap
            paintSrc = new Paint();
            paintSrc.setXfermode(new PorterDuffXfermode(mode));

            // кисть для рамки
            paintBorder = new Paint();
            paintBorder.setStyle(Paint.Style.STROKE);
            paintBorder.setStrokeWidth(3);
            paintBorder.setColor(Color.BLACK);
        }

        private Bitmap createBitmap(Path path, int color) {
            // создание bitmap и канвы для него
            Bitmap bitmap = Bitmap.createBitmap(500, 500,
                    Bitmap.Config.ARGB_8888);
            Canvas bitmapCanvas = new Canvas(bitmap);

            // создание кисти нужного цвета
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setColor(color);

            // рисование фигуры на канве bitmap
            bitmapCanvas.drawPath(path, paint);

            return bitmap;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.translate(390, 80);

            // DST bitmap
            canvas.drawBitmap(bitmapDst, 0, 0, paintDst);

            // SRC bitmap
            canvas.drawBitmap(bitmapSrc, 0, 0, paintSrc);

            // рамка
            canvas.drawRect(0, 0, 500, 500, paintBorder);

        }
    }
}