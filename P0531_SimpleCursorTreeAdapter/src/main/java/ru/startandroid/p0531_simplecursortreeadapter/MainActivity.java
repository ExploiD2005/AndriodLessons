package ru.startandroid.p0531_simplecursortreeadapter;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleCursorTreeAdapter;

import ru.startandroid.develop.p0531simplecursortreeadapter.DB;

public class MainActivity extends AppCompatActivity {

    ExpandableListView elvMain;
    DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // подключаемся к БД
        db = new DB(this);
        db.open();

        // готовим данные по группам для адаптера
        Cursor cursor = db.getCompanyData();
        startManagingCursor(cursor);
        // сопоставление данных и View для групп
        String[] groupFrom = { DB.COMPANY_COLUMN_NAME };
        int[] groupTo = { android.R.id.text1 };
        // сопоставление данных и View для элементов
        String[] childFrom = { DB.PHONE_COLUMN_NAME };
        int[] childTo = { android.R.id.text1 };

        // создаем адаптер и настраиваем список
        SimpleCursorTreeAdapter sctAdapter = new MyAdapter(this, cursor,
                android.R.layout.simple_expandable_list_item_1, groupFrom,
                groupTo, android.R.layout.simple_list_item_1, childFrom,
                childTo);
        elvMain = (ExpandableListView) findViewById(R.id.elvMain);
        elvMain.setAdapter(sctAdapter);
    }

    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }

    class MyAdapter extends SimpleCursorTreeAdapter {

        public MyAdapter(Context context, Cursor cursor, int groupLayout,
                         String[] groupFrom, int[] groupTo, int childLayout,
                         String[] childFrom, int[] childTo) {
            super(context, cursor, groupLayout, groupFrom, groupTo,
                    childLayout, childFrom, childTo);
        }

        protected Cursor getChildrenCursor(Cursor groupCursor) {
            // получаем курсор по элементам для конкретной группы
            int idColumn = groupCursor.getColumnIndex(DB.COMPANY_COLUMN_ID);
            return db.getPhoneData(groupCursor.getInt(idColumn));
        }
    }
}