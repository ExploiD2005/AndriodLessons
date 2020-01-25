package ru.startandroid.p1421_drawingfigure;

import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
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
        Rect rect;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            rect = new Rect();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            // заливка канвы цветом
            canvas.drawARGB(80, 102, 204, 255);

            // настройка кисти
            // красный цвет
            p.setColor(Color.RED);
            // толщина линии = 10
            p.setStrokeWidth(10);

            // рисуем точку (50,50)
            canvas.drawPoint(50, 50, p);

            // рисуем линию от (100,100) до (500,50)
            canvas.drawLine(100,100,500,50,p);

            // рисуем круг с центром в (100,200), радиус = 50
            canvas.drawCircle(100, 200, 50, p);

            // рисуем прямоугольник
            // левая верхняя точка (200,150), нижняя правая (400,200)
            canvas.drawRect(200, 150, 400, 200, p);

            // настройка объекта Rect
            // левая верхняя точка (250,300), нижняя правая (350,500)
            rect.set(250, 300, 350, 500);
            // рисуем прямоугольник из объекта rect
            canvas.drawRect(rect, p);
        }

    }*/
    /*class DrawView extends View {

        Paint p;
        RectF rectf;
        float[] points;
        float[] points1;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            rectf = new RectF(700,100,800,150);
            points = new float[]{100,50,150,100,150,200,50,200,50,100};
            points1 = new float[]{300,200,600,200,300,300,600,300,400,100,400,400,500,100,500,400};
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            p.setColor(Color.RED);
            p.setStrokeWidth(10);

            // рисуем точки их массива points
            canvas.drawPoints(points,p);

            // рисуем линии по точкам из массива points1
            canvas.drawLines(points1,p);

            // перенастраиваем кисть на зеленый цвет
            p.setColor(Color.GREEN);

            // рисуем закругленный прямоугольник по координатам из rectf
            // радиусы закругления = 20
            canvas.drawRoundRect(rectf, 20, 20, p);

            // смещаем коорднаты rectf на 150 вниз
            rectf.offset(0, 150);
            // рисуем овал внутри прямоугольника rectf
            canvas.drawOval(rectf, p);

            // смещаем rectf в (900,100) (левая верхняя точка)
            rectf.offsetTo(900, 100);
            // увеличиваем rectf по вертикали на 25 вниз и вверх
            rectf.inset(0, -25);
            // рисуем дугу внутри прямоугольника rectf
            // с началом в 90, и длиной 270
            // соединение крайних точек через центр
            canvas.drawArc(rectf, 90, 270, true, p);

            // смещаем коорднаты rectf на 150 вниз
            rectf.offset(0, 150);
            // рисуем дугу внутри прямоугольника rectf
            // с началом в 90, и длиной 270
            // соединение крайних точек напрямую
            canvas.drawArc(rectf, 90, 270, false, p);

            // перенастраиваем кисть на толщину линии = 3
            p.setStrokeWidth(3);
            // рисуем линию (150,450) - (150,600)
            canvas.drawLine(150, 450, 150, 600, p);

            // перенастраиваем кисть на синий цвет
            p.setColor(Color.BLUE);

            // настраиваем размер текста = 30
            p.setTextSize(30);
            // рисуем текст в точке (150,500)
            canvas.drawText("text left", 150, 500, p);

            // настраиваем выравнивание текста на центр
            p.setTextAlign(Paint.Align.CENTER);
            // рисуем текст в точке (150,525)
            canvas.drawText("text center", 150, 525, p);

            // настраиваем выравнивание текста на левое
            p.setTextAlign(Paint.Align.RIGHT);
            // рисуем текст в точке (150,550)
            canvas.drawText("text right", 150, 550, p);
        }
    }*/
    class DrawView extends View {

        Paint p;
        Rect rect;
        StringBuilder sb;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            rect = new Rect(100,200,200,300);
            sb = new StringBuilder();

        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            p.setColor(Color.BLUE);
            p.setStrokeWidth(10);

            p.setTextSize(30);

            // создаем строку с значениями ширины и высоты канвы
            sb.setLength(0);
            sb.append("width = ").append(canvas.getWidth())
                    .append(", height = ").append(canvas.getHeight());
            canvas.drawText(sb.toString(), 100, 100, p);

            // перенастраивам кисть на заливку
            p.setStyle(Paint.Style.FILL);
            canvas.drawRect(rect, p);

            // перенастраивам кисть на контуры
            p.setStyle(Paint.Style.STROKE);
            rect.offset(150, 0);
            canvas.drawRect(rect, p);

            // перенастраивам кисть на заливку + контуры
            p.setStyle(Paint.Style.FILL_AND_STROKE);
            rect.offset(150, 0);
            canvas.drawRect(rect, p);
        }

    }

}