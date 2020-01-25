package ru.startandroid.p1471_region;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
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
        Rect rect1;
        Rect rect2;
        Region region;
        RegionIterator iterator;
        Path path;

        //Region.Op op = Region.Op.UNION;
        //Region.Op op = Region.Op.XOR;
        //Region.Op op = Region.Op.DIFFERENCE;
        //Region.Op op = Region.Op.REVERSE_DIFFERENCE;
        //Region.Op op = Region.Op.INTERSECT;
        Region.Op op = Region.Op.REPLACE;


        public DrawView(Context context) {
            super(context);
            p = new Paint();
            p.setStrokeWidth(3);

            // прямоугольники
            rect1 = new Rect(200,200,400,400);
            rect2 = new Rect(300,300,500,500);

            // создание региона
            region = new Region();
            region.set(rect1);
            region.op(rect2, op);

            // создание path из региона
            path = region.getBoundaryPath();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            // контуры прямоугольников
            p.setStyle(Paint.Style.STROKE);
            p.setColor(Color.BLACK);
            canvas.drawRect(rect1, p);
            canvas.drawRect(rect2, p);

            // path
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.BLUE);
            canvas.drawPath(path, p);

        }
    }*/
    class DrawView extends View {

        Paint p;
        Region region;
        Region clipRegion;
        Path path;
        Path pathDst;
        Rect rect;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            p.setStrokeWidth(3);
            p.setStyle(Paint.Style.STROKE);

            // path, треугольник
            path = new Path();
            path.moveTo(100, 100);
            path.lineTo(150, 150);
            path.lineTo(100, 200);
            path.close();

            // регион из прямоугольника обрезки
            rect = new Rect(100, 100, 150, 150);
            clipRegion = new Region(rect);

            // итоговый регион
            region = new Region();
            // отсекаем от path область clipRegion
            region.setPath(path, clipRegion);
            // получаем path из региона
            pathDst = region.getBoundaryPath();

        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            // треугольник
            p.setColor(Color.GREEN);
            canvas.drawPath(path, p);

            canvas.translate(200, 0);

            // верхняя часть треугольника
            p.setColor(Color.BLUE);
            canvas.drawPath(pathDst, p);

        }
    }
}
/*
RegionIterator
Итоговая область региона может быть разбита на набор непересекающихся прямоугольников. Для этого используется RegionIterator – итератор региона. При создании указываете ему регион и методом next перебираете прямоугольники, из которых состоит регион.

Ради интереса повесьте лог в цикл итератора и выведите (Rect.toShortString) координаты областей, из которых состоит регион в примерах выше. Вы увидите, как итератор разбивает регион на непересекающиеся прямоугольники.

В случае с UNION, например, лог будет следующим:

rect = [200,200][400,300]
rect = [200,300][500,400]
rect = [300,400][500,500]



Прочие методы
Рассмотрим еще несколько полезных методов региона.

contains – позволяет определить, содержится ли указанная точка в регионе

getBounds – вернет нам прямоугольник, который является общими границами региона

isComplex – вернет true, если регион состоит из более, чем одного прямоугольников. Причем имеется ввиду вовсе не количество добавленных к региону прямоугольников. Здесь речь о том, сколько прямоугольников содержит итератор региона.

isRect – вернет true, если итоговая область региона является единым прямоугольником

quickContains – вернет true если регион является единым прямоугольником и содержит в себе переданный ему прямоугольник. При этом false вовсе не означает, что переданный прямоугольник обязательно НЕ содержится в этом регионе.

quickReject – вернет true, если регион пуст или не пересекается с переданным прямоугольником/регионом. При этом false вовсе не означает, что переданный прямоугольник/регион обязательно НЕ пересекаются с текущим.



setPath – позволяет нам отсекать от переданного Path кусок, ограниченный переданным регионом. Отсеченный кусок будет итоговой областью текущего региона.
 */