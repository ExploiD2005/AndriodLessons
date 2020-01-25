package ru.startandroid.p1611_bitmapcache;

import android.support.v7.app.AppCompatActivity;
import java.io.File;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView mLvImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLvImages = (ListView) findViewById(R.id.lvImages);


        File dir = new File(Environment.getExternalStorageDirectory(), "Download");
        File[] filesArray = dir.listFiles();

        if (filesArray != null) {
            ImageAdapter adapter = new ImageAdapter(this, filesArray);
            mLvImages.setAdapter(adapter);
        }

    }


    /*static class ImageAdapter extends ArrayAdapter<File> {

        LayoutInflater mInflater;
        int mSize;

        public ImageAdapter(Context context, File[] objects) {
            super(context, R.layout.list_item, objects);
            mInflater = LayoutInflater.from(context);
            mSize = context.getResources().getDimensionPixelSize(R.dimen.image_size);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                view = mInflater.inflate(R.layout.list_item, parent, false);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            Bitmap bitmap = getBitmap(position);
            imageView.setImageBitmap(bitmap);
            return view;
        }

        private Bitmap getBitmap(int position) {
            String filePath = getItem(position).getAbsolutePath();
            return Utils.decodeSampledBitmapFromResource(filePath, mSize, mSize);

        }


    }*/
    static class ImageAdapter extends ArrayAdapter<File> {

        LayoutInflater mInflater;
        int mSize;
        LruCache<String, Bitmap> mMemoryCache;

        public ImageAdapter(Context context, File[] objects) {
            super(context, R.layout.list_item, objects);
            mInflater = LayoutInflater.from(context);
            mSize = context.getResources().getDimensionPixelSize(R.dimen.image_size);

            final int maxMemory = (int) (Runtime.getRuntime().maxMemory());
            final int cacheSize = maxMemory / 8;

            mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
                @Override
                protected int sizeOf(String key, Bitmap bitmap) {
                    return bitmap.getByteCount();
                }
            };
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                view = mInflater.inflate(R.layout.list_item, parent, false);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            Bitmap bitmap = getBitmap(position);
            imageView.setImageBitmap(bitmap);
            return view;
        }

        private Bitmap getBitmap(int position) {
            String filePath = getItem(position).getAbsolutePath();
            Bitmap bitmap = getBitmapFromMemCache(filePath);
            if (bitmap == null) {
                bitmap = Utils.decodeSampledBitmapFromResource(filePath, mSize, mSize);
                addBitmapToMemoryCache(filePath, bitmap);
            }
            return bitmap;

        }

        public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
            if (getBitmapFromMemCache(key) == null) {
                mMemoryCache.put(key, bitmap);
            }
        }

        public Bitmap getBitmapFromMemCache(String key) {
            return mMemoryCache.get(key);
        }


    }
    /*
    static class ImageAdapter extends ArrayAdapter<File> {

  LayoutInflater mInflater;
  Picasso mPicasso;

  public ImageAdapter(Context context, File[] objects) {
    super(context, R.layout.list_item, objects);
    mInflater = LayoutInflater.from(context);
    mPicasso = Picasso.with(context);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View view = convertView;
    if (view == null) {
      view = mInflater.inflate(R.layout.list_item, parent, false);
    }
    ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
    mPicasso.load(getItem(position)).resizeDimen(R.dimen.image_size, R.dimen.image_size). centerInside().into(imageView);
    return view;
  }

}
     */
}