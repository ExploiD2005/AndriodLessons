package ru.startandroid.p1431_drawingpath;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
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

    /*class DrawView extends View {

        Paint p;
        RectF rectf;
        Path path;
        Path path1;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            p.setStrokeWidth(3);
            p.setStyle(Paint.Style.STROKE);

            rectf = new RectF(350,100,400,150);
            path = new Path();
            path1 = new Path();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            // очистка path
            path.reset();

            // угол
            path.moveTo(100, 100);
            path.lineTo(150, 200);
            path.lineTo(50, 200);

            // треугольник
            path.moveTo(250, 100);
            path.lineTo(300, 200);
            path.lineTo(200, 200);
            path.close();

            // квадрат и круг
            path.addRect(rectf, Path.Direction.CW);
            path.addCircle(450, 150, 25, Path.Direction.CW);

            // рисование path
            p.setColor(Color.BLACK);
            canvas.drawPath(path, p);


            // очистка path1
            path1.reset();

            // две пересекающиеся линии
            path1.moveTo(50,50);
            path1.lineTo(500,250);
            path1.moveTo(500,50);
            path1.lineTo(50,250);

            // рисование path1
            p.setColor(Color.GREEN);
            canvas.drawPath(path1, p);


            // добавление path1 к path
            path.addPath(path1);

            // смещение
            path.offset(500,100);

            // рисование path
            p.setColor(Color.BLUE);
            canvas.drawPath(path, p);
        }

    }*/
    /*class DrawView extends View {

        Paint p;
        Path path;
        Point point1;
        Point point21;
        Point point22;

        public DrawView(Context context) {
            super(context);
            p = new Paint(Paint.ANTI_ALIAS_FLAG);
            p.setStrokeWidth(3);
            path = new Path();

            point1 = new Point(200,300);
            point21 = new Point(500,600);
            point22 = new Point(900,200);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);


            // первая линия
            p.setColor(Color.BLACK);
            canvas.drawLine(100, 100, 600, 100, p);

            // точка отклонения для первой линии
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.GREEN);
            canvas.drawCircle(point1.x, point1.y, 10, p);

            // квадратичная кривая
            path.reset();
            path.moveTo(100, 100);
            path.quadTo(point1.x, point1.y, 600, 100);
            p.setStyle(Paint.Style.STROKE);
            canvas.drawPath(path, p);


            // вторая линия
            p.setColor(Color.BLACK);
            canvas.drawLine(400, 400, 1100, 400, p);

            // точки отклонения для второй линии
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.BLUE);
            canvas.drawCircle(point21.x, point21.y, 10, p);
            canvas.drawCircle(point22.x, point22.y, 10, p);

            // кубическая кривая
            path.reset();
            path.moveTo(400, 400);
            path.cubicTo(point21.x, point21.y, point22.x, point22.y, 1100, 400);
            p.setStyle(Paint.Style.STROKE);
            canvas.drawPath(path, p);
        }
    }*/
    class DrawView extends View {

        Paint p;
        Path path;
        String text;

        public DrawView(Context context) {
            super(context);
            p = new Paint(Paint.ANTI_ALIAS_FLAG);
            p.setStrokeWidth(1);
            p.setTextSize(20);
            path = new Path();
            text = "Draw the text, with origin at (x,y), using the specified paint";
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            // черный
            path.reset();
            path.addCircle(200, 200, 100, Path.Direction.CW);
            p.setColor(Color.BLACK);
            canvas.drawTextOnPath(text, path, 0, 0, p);

            path.reset();
            path.addCircle(500, 200, 100, Path.Direction.CCW);

            // синий
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.BLUE);
            canvas.drawTextOnPath(text, path, 0, 0, p);
            p.setStyle(Paint.Style.STROKE);
            canvas.drawPath(path, p);

            // зеленый
            path.offset(-300, 250);
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.GREEN);
            canvas.drawTextOnPath(text, path, 100, 0, p);
            p.setStyle(Paint.Style.STROKE);
            canvas.drawPath(path, p);

            // красный
            path.offset(300, 0);
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.RED);
            canvas.drawTextOnPath(text, path, 0, 30, p);
            p.setStyle(Paint.Style.STROKE);
            canvas.drawPath(path, p);

        }

    }

}