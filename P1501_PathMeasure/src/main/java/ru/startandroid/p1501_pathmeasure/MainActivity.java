package ru.startandroid.p1501_pathmeasure;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(new DrawView(this));
    }

    /*class DrawView extends View {

        Paint paint;
        Paint paintText;
        Path path;
        PathMeasure pMeasure;
        float length;

        public DrawView(Context context) {
            super(context);
            paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(3);

            paintText = new Paint(Paint.ANTI_ALIAS_FLAG);
            paintText.setTextSize(30);

            path = new Path();
            path.moveTo(100, 300);
            path.rLineTo(150, 100);
            path.rLineTo(150, -100);
            path.rQuadTo(150, 200, 300, 0);
            path.rLineTo(150, 100);
            path.rLineTo(150, -100);

            pMeasure = new PathMeasure(path, false);
            length = pMeasure.getLength();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            canvas.drawPath(path, paint);
            canvas.drawText(String.format("Length: %s", length), 100, 100,
                    paintText);
        }
    }*/
    /*class DrawView extends View {

        Paint paint;
        Paint paintText;
        Path path;
        PathMeasure pMeasure;
        Matrix matrix;
        Rect rect;

        float[] pos;
        float[] tan;

        float length;
        float distance;

        public DrawView(Context context) {
            super(context);
            paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(3);

            paintText = new Paint(Paint.ANTI_ALIAS_FLAG);
            paintText.setTextSize(30);

            path = new Path();
            path.moveTo(100, 300);
            path.rLineTo(150, 100);
            path.rLineTo(150, -100);
            path.rQuadTo(150, 200, 300, 0);
            path.rLineTo(150, 100);
            path.rLineTo(150, -100);

            pMeasure = new PathMeasure(path, false);

            length = pMeasure.getLength();
            distance = length / 4;

            matrix = new Matrix();
            pMeasure.getMatrix(distance, matrix,
                    PathMeasure.POSITION_MATRIX_FLAG
                            + PathMeasure.TANGENT_MATRIX_FLAG);

            pos = new float[2];
            tan = new float[2];
            pMeasure.getPosTan(distance, pos, tan);

            rect = new Rect(-20, -10, 20, 10);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            canvas.drawPath(path, paint);
            canvas.drawText(
                    String.format("Distance: %s of %s", distance, length), 100,
                    100, paintText);
            canvas.drawText(
                    String.format("Position: %s. Tangent (cos,sin): %s",
                            Arrays.toString(pos), Arrays.toString(tan)), 100,
                    150, paintText);

            canvas.setMatrix(matrix);
            canvas.drawRect(rect, paint);
        }
    }*/
    /*class DrawView extends View {

        Paint paint;
        Path path;
        PathMeasure pMeasure;

        public DrawView(Context context) {
            super(context);
            paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(3);

            path = new Path();
            path.moveTo(100, 300);
            path.rLineTo(150, 150);
            path.rLineTo(150, -100);

            path.rMoveTo(0, 0);
            path.rQuadTo(150, 200, 300, 0);
            path.close();

            path.rMoveTo(0, 0);
            path.rLineTo(150, 100);
            path.rLineTo(150, -150);
            path.close();

            pMeasure = new PathMeasure(path, false);
            do {
                Log.d(TAG,
                        String.format("Length: %s, isClosed: %s",
                                pMeasure.getLength(), pMeasure.isClosed()));
            } while (pMeasure.nextContour());

        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);
            canvas.drawPath(path, paint);
        }
    }*/
    class DrawView extends View {

        Paint paint;
        Path path;
        Path path1;
        PathMeasure pMeasure;

        public DrawView(Context context) {
            super(context);
            paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(3);

            path = new Path();
            path.moveTo(100, 300);
            path.rLineTo(150, 150);
            path.rLineTo(150, -100);
            path.rQuadTo(150, 200, 300, 0);
            path.rLineTo(150, 100);
            path.rLineTo(150, -150);

            pMeasure = new PathMeasure(path, false);

            path1 = new Path();
            pMeasure.getSegment(150, 850, path1, true);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);
            canvas.drawPath(path1, paint);
        }
    }

}