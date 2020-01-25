package ru.startandroid.p1491_canvastext;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    /*class DrawView extends View {

        Paint fontPaint;
        Paint redPaint;
        String text = "Test width text";
        int fontSize = 100;
        float[] widths;
        float width;

        public DrawView(Context context) {
            super(context);
            redPaint = new Paint();
            redPaint.setColor(Color.RED);

            fontPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            fontPaint.setTextSize(fontSize);
            fontPaint.setStyle(Paint.Style.STROKE);

            // ширина текста
            width = fontPaint.measureText(text);

            // посимвольная ширина
            widths = new float[text.length()];
            fontPaint.getTextWidths(text, widths);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            canvas.translate(50, 250);

            // вывод текста
            canvas.drawText(text, 0, 0, fontPaint);

            // линия шириной в текст
            canvas.drawLine(0, 0, width, 0, fontPaint);

            // посимвольные красные точки
            canvas.drawCircle(0, 0, 3, redPaint);
            for (float w : widths) {
                canvas.translate(w, 0);
                canvas.drawCircle(0, 0, 3, redPaint);
            }
        }
    }*/
    /*class DrawView extends View {

        Paint p;
        String text = "Test width text";
        int fontSize = 80;
        int maxWidth = 350;
        float realWidth = 0;
        int cnt = 0;
        String info = "";

        public DrawView(Context context) {
            super(context);
            p = new Paint(Paint.ANTI_ALIAS_FLAG);
            p.setTextSize(fontSize);

            // кол-во символов и их ширина
            float[] measuredWidth = new float[1];
            cnt = p.breakText(text, true, maxWidth, measuredWidth);
            realWidth = measuredWidth[0];

            info = "cnt = " + cnt + ", realWidth = " + realWidth
                    + ", maxWidth = " + maxWidth;

        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            // данные о ширине
            p.setTextSize(24);
            canvas.drawText(info, 50, 50, p);

            // текст
            p.setTextSize(fontSize);
            canvas.drawText(text, 50, 250, p);

            p.setStrokeWidth(10);

            // полоса реальной ширины урезанного текста
            p.setColor(Color.BLUE);
            canvas.drawLine(50, 260, 50 + realWidth, 260, p);

            // полоса лимита
            p.setColor(Color.GREEN);
            canvas.drawLine(50, 270, 50 + maxWidth, 270, p);

        }
    }*/
    /*class DrawView extends View {

        Paint p;
        String text = "Test width text";
        int fontSize = 60;
        float y = 80;

        public DrawView(Context context) {
            super(context);
            p = new Paint(Paint.ANTI_ALIAS_FLAG);
            p.setTextSize(fontSize);
            p.setStyle(Paint.Style.STROKE);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            // обычный текст
            canvas.translate(50, y);
            canvas.drawText(text, 0, 0, p);

            // моноширинный
            canvas.translate(0, y);
            p.setTypeface(Typeface.create(Typeface.MONOSPACE, Typeface.NORMAL));
            canvas.drawText(text, 0, 0, p);

            // с засечками
            canvas.translate(0, y);
            p.setTypeface(Typeface.create(Typeface.SERIF, Typeface.NORMAL));
            canvas.drawText(text, 0, 0, p);

            // обычный жирный
            canvas.translate(0, y);
            p.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
            canvas.drawText(text, 0, 0, p);

            // обычный жирный курсивный
            canvas.translate(0, y);
            p.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD_ITALIC));
            canvas.drawText(text, 0, 0, p);

            // обычный курсивный
            canvas.translate(0, y);
            p.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
            canvas.drawText(text, 0, 0, p);

        }
    }*/
    /*class DrawView extends View {

        Paint p;
        String text = "Test width text";
        int fontSize = 60;
        float y = 80;

        public DrawView(Context context) {
            super(context);
            p = new Paint(Paint.ANTI_ALIAS_FLAG);
            p.setTextSize(fontSize);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            // обычный текст
            canvas.translate(50, y);
            canvas.drawText(text, 0, 0, p);

            // растянутый
            canvas.translate(0, y);
            p.setTextScaleX(1.5f);
            canvas.drawText(text, 0, 0, p);
            p.setTextScaleX(1);

            // наклоненный
            canvas.translate(0, y);
            p.setTextSkewX(0.5f);
            canvas.drawText(text, 0, 0, p);
            p.setTextSkewX(0);

            // подчеркнутый
            canvas.translate(0, y);
            p.setUnderlineText(true);
            canvas.drawText(text, 0, 0, p);
            p.setUnderlineText(false);

            // зачеркнутый
            canvas.translate(0, y);
            p.setStrikeThruText(true);
            canvas.drawText(text, 0, 0, p);
            p.setStrikeThruText(false);

        }
    }*/
    class DrawView extends View {

        Paint p;
        String text = "Test text";
        int fontSize = 100;
        float pos[];

        public DrawView(Context context) {
            super(context);
            p = new Paint(Paint.ANTI_ALIAS_FLAG);
            p.setTextSize(fontSize);

            pos = new float[] { 100, 300, 200, 150, 300, 500, 400, 300, 500,
                    250, 600, 350, 700, 400, 800, 200, 900, 500 };

        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            canvas.drawPosText(text, pos, p);

        }
    }

}