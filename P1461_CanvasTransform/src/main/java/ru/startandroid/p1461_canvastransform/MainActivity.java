package ru.startandroid.p1461_canvastransform;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    class DrawView extends View {

        Paint p;
        RectF rectf1;
        RectF rectf2;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            p.setStrokeWidth(3);
            p.setStyle(Paint.Style.STROKE);
            rectf1 = new RectF(50,50,100,100);
            rectf2 = new RectF(50,150,100,200);
        }

        /*@Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            // зеленый квадрат
            p.setColor(Color.GREEN);
            canvas.drawRect(rectf1, p);

            // синий квадрат
            p.setColor(Color.BLUE);
            canvas.drawRect(rectf2, p);

        }*/
        /*protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            // зеленый квадрат
            p.setColor(Color.GREEN);
            canvas.drawRect(rectf1, p);

            // преобразования канвы
            // и рисование зеленых квадратов
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);

            // сброс канвы
            canvas.restore();

            // синий квадрат
            p.setColor(Color.BLUE);
            canvas.drawRect(rectf2, p);

        }*/
        /*protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            // зеленый квадрат
            p.setColor(Color.GREEN);
            canvas.drawRect(rectf1, p);

            // преобразования канвы
            // и рисование зеленых квадратов
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);

            // сохраняем настройки матрицы канвы
            canvas.save();

            // преобразования канвы
            // и рисование красных квадратов
            p.setColor(Color.RED);
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);

            // возврат канвы к предыдущему сохранению
            canvas.restore();

            // синий квадрат
            p.setColor(Color.BLUE);
            canvas.drawRect(rectf2, p);

        }*/
        /*protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            // зеленый квадрат
            p.setColor(Color.GREEN);
            canvas.drawRect(rectf1, p);

            // преобразования канвы
            // и рисование зеленых квадратов
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);

            // сохраняем настройки матрицы канвы
            canvas.save();

            // преобразования канвы
            // и рисование желтых квадратов
            p.setColor(Color.YELLOW);
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);

            // сохраняем настройки матрицы канвы
            canvas.save();

            // преобразования канвы
            // и рисование красных квадратов
            p.setColor(Color.RED);
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);

            // возврат канвы к предыдущему сохранению
            canvas.restore();

            // синий квадрат
            p.setColor(Color.BLUE);
            canvas.drawRect(rectf2, p);

            // возврат канвы к предыдущему сохранению
            canvas.restore();

            // черный квадрат
            p.setColor(Color.BLACK);
            canvas.drawRect(rectf2, p);

            // возврат канвы в изначальное состояние
            canvas.restore();

            // пурпурный квадрат
            p.setColor(Color.MAGENTA);
            canvas.drawRect(rectf2, p);
        }*/
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            // сохраняем настройки матрицы канвы
            // в initSave получаем значение для восстановления этого состояния
            int initSave = canvas.save();

            // зеленый квадрат
            p.setColor(Color.GREEN);
            canvas.drawRect(rectf1, p);

            // преобразования канвы
            // и рисование зеленых квадратов
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);

            // сохраняем настройки матрицы канвы
            canvas.save();

            // преобразования канвы
            // и рисование желтых квадратов
            p.setColor(Color.YELLOW);
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);

            // сохраняем настройки матрицы канвы
            // в needSave получаем значение для восстановления этого состояния
            int needSave = canvas.save();

            // преобразования канвы
            // и рисование красных квадратов
            p.setColor(Color.RED);
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);

            // сохраняем настройки матрицы канвы
            canvas.save();

            // преобразования канвы
            // и рисование синих квадратов
            p.setColor(Color.BLUE);
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);
            canvas.translate(100, 0);
            canvas.drawRect(rectf1, p);

            // возврат канвы к указанному сохранению
            canvas.restoreToCount(needSave);

            // черный квадрат
            p.setColor(Color.BLACK);
            canvas.drawRect(rectf2, p);

            // возврат канвы к указанному сохранению
            canvas.restoreToCount(initSave);

            // пурпурный квадрат
            p.setColor(Color.MAGENTA);
            canvas.drawRect(rectf2, p);

        }
    }/*class DrawView extends View {

        Paint p;
        Matrix matrix;
        RectF rectf;
        Path path;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            p.setStrokeWidth(3);
            p.setStyle(Paint.Style.STROKE);
            rectf = new RectF(100, 100, 200, 200);
            matrix = new Matrix();
            path = new Path();
        }

        /*@Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            // квадрат
            path.reset();
            path.addRect(rectf, Path.Direction.CW);
            p.setColor(Color.BLACK);
            canvas.drawPath(path, p);

            // преобразованный квадрат
            matrix.reset();
            matrix.preRotate(30);
            matrix.preTranslate(500, 0);
            path.transform(matrix);
            p.setColor(Color.BLUE);
            canvas.drawPath(path, p);
        }*/
        /*@Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            // квадрат
            p.setColor(Color.BLACK);
            canvas.drawRect(rectf, p);

            // квадрат на канве с преобразованиями
            canvas.rotate(30);
            canvas.translate(500, 000);
            p.setColor(Color.GREEN);
            canvas.drawRect(rectf, p);

        }*/

    }