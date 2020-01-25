package ru.startandroid.p1441_matrixtransform;

import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    /*class DrawView extends View {

        Paint p;
        Path path;
        Matrix matrix;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            p.setStrokeWidth(3);
            p.setStyle(Paint.Style.STROKE);

            path = new Path();
            matrix = new Matrix();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            // создаем крест в path
            path.reset();
            path.addRect(300, 150, 450, 200, Path.Direction.CW);
            path.addRect(350, 100, 400, 250, Path.Direction.CW);

            // рисуем path зеленым
            p.setColor(Color.GREEN);
            canvas.drawPath(path, p);

            // настраиваем матрицу на перемещение на 300 вправо и 200 вниз
            matrix.reset();
            matrix.setTranslate(300, 200);

            // применяем матрицу к path
            path.transform(matrix);

            // рисуем path синим
            p.setColor(Color.BLUE);
            canvas.drawPath(path, p);

        }

    }*/
    /*class DrawView extends View {

        Paint p;
        Path path;
        Matrix matrix;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            p.setStrokeWidth(3);
            p.setStyle(Paint.Style.STROKE);

            path = new Path();
            matrix = new Matrix();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            // создаем крест в path
            path.reset();
            path.addRect(300,150,450,200, Path.Direction.CW);
            path.addRect(350,100,400,250, Path.Direction.CW);

            // рисуем path зеленым
            p.setColor(Color.GREEN);
            canvas.drawPath(path, p);

            // настраиваем матрицу на изменение размера:
            // в 2 раза по горизонтали
            // в 2,5 по вертикали
            // относительно точки (375, 100)
            matrix.reset();
            matrix.setScale(2f, 2.5f, 375, 100);

            // применяем матрицу к path
            path.transform(matrix);

            // рисуем path синим
            p.setColor(Color.BLUE);
            canvas.drawPath(path, p);

            // рисуем точку относительно которой было выполнено преобразование
            p.setColor(Color.BLACK);
            canvas.drawCircle(375, 100, 5, p);

        }

    }*/
    /*class DrawView extends View {

        Paint p;
        Path path;
        Matrix matrix;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            p.setStrokeWidth(3);
            p.setStyle(Paint.Style.STROKE);

            path = new Path();
            matrix = new Matrix();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            // создаем крест в path
            path.reset();
            path.addRect(300,150,450,200, Path.Direction.CW);
            path.addRect(350,100,400,250, Path.Direction.CW);
            path.addCircle(375, 125, 5, Path.Direction.CW);

            // рисуем path зеленым
            p.setColor(Color.GREEN);
            canvas.drawPath(path, p);

            // настраиваем матрицу на поворот на 120 градусов
            // относительно точки (600,400)
            matrix.reset();
            matrix.setRotate(120, 600, 400);

            // применяем матрицу к path
            path.transform(matrix);

            // рисуем path синим
            p.setColor(Color.BLUE);
            canvas.drawPath(path, p);

            // рисуем точку, относительно которой был выполнен поворот
            p.setColor(Color.BLACK);
            canvas.drawCircle(600, 400, 5, p);
        }

    }*/
    /*class DrawView extends View {

        Paint p;
        Path path;
        Path pathDst;
        Matrix matrix;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            p.setStrokeWidth(3);
            p.setStyle(Paint.Style.STROKE);

            path = new Path();
            pathDst = new Path();
            matrix = new Matrix();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            p.setColor(Color.BLACK);
            canvas.drawCircle(400, 200, 10, p);

            // прямоугольник
            path.reset();
            path.addRect(300,100,500,300, Path.Direction.CW);
            canvas.drawPath(path, p);

            // перемещение после поворота
            matrix.reset();
            matrix.setRotate(45, 400, 200);
            matrix.postTranslate(500, 0);
            path.transform(matrix, pathDst);
            p.setColor(Color.GREEN);
            canvas.drawPath(pathDst, p);

            // перемещение до поворота
            matrix.reset();
            matrix.setRotate(45, 400, 200);
            matrix.preTranslate(500, 0);
            path.transform(matrix, pathDst);
            p.setColor(Color.RED);
            canvas.drawPath(pathDst, p);
        }
    }*/
    /*class DrawView extends View {

        Paint p;
        Path path;
        Path pathDst;
        Matrix matrix;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            p.setStrokeWidth(3);
            p.setStyle(Paint.Style.STROKE);

            path = new Path();
            pathDst = new Path();
            path.addRect(100, 100, 200, 200, Path.Direction.CW);

            matrix = new Matrix();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            p.setColor(Color.BLACK);
            canvas.drawPath(path, p);

            p.setColor(Color.GREEN);

            // перемещение на 200 вправо
            // и наклон по вертикали на 0.5
            // точка наклона - слева
            matrix.reset();
            matrix.setTranslate(200, 0);
            matrix.postSkew(0.0f, 0.5f, 300, 100);
            path.transform(matrix, pathDst);
            canvas.drawPath(pathDst, p);
            canvas.drawCircle(300, 100, 5, p);

            // перемещение на 400 вправо
            // и наклон по вертикали на 0.5
            // точка наклона - справа
            matrix.reset();
            matrix.setTranslate(400, 0);
            matrix.postSkew(0.0f, 0.5f, 600, 100);
            path.transform(matrix, pathDst);
            canvas.drawPath(pathDst, p);
            canvas.drawCircle(600, 100, 5, p);

            p.setColor(Color.BLUE);

            // перемещение на 150 вниз
            // и наклон по горизонтали на 0.5
            // точка наклона - сверху
            matrix.reset();
            matrix.setTranslate(0, 150);
            matrix.postSkew(0.5f, 0.0f, 100, 250);
            path.transform(matrix, pathDst);
            canvas.drawPath(pathDst, p);
            canvas.drawCircle(100, 250, 5, p);

            // перемещение на 300 вниз
            // и наклон по горизонтали на 0.5
            // точка наклона - снизу
            matrix.reset();
            matrix.setTranslate(0, 300);
            matrix.postSkew(0.5f, 0.0f, 100, 500);
            path.transform(matrix, pathDst);
            canvas.drawPath(pathDst, p);
            canvas.drawCircle(100, 500, 5, p);
        }
    }*/
    class DrawView extends View {

        Paint p;
        Matrix matrix;
        RectF rectf;
        RectF rectfDst;
        Path path;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            p.setStrokeWidth(3);
            p.setStyle(Paint.Style.STROKE);
            rectf = new RectF(100, 100, 200, 200);
            rectfDst = new RectF();
            matrix = new Matrix();
            path = new Path();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            // прямоугольник
            path.reset();
            path.addRect(rectf, Path.Direction.CW);
            p.setColor(Color.BLACK);
            canvas.drawPath(path, p);

            // поворот, размер, пермещение
            matrix.setRotate(45, 150, 150);
            matrix.postScale(1.2f, 0.8f, 150, 150);
            matrix.postTranslate(200, 0);
            path.transform(matrix);

            // итоговая фигура зеленым цветом
            p.setColor(Color.GREEN);
            canvas.drawPath(path, p);

            // границы, полученные от изначального прямоугольника
            matrix.mapRect(rectfDst, rectf);
            p.setColor(Color.BLUE);
            canvas.drawRect(rectfDst, p);

        }
    }

}