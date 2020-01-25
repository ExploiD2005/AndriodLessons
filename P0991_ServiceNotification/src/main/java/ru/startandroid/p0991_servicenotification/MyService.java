package ru.startandroid.p0991_servicenotification;

import java.util.concurrent.TimeUnit;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

public class MyService extends Service {
    NotificationManager nm;

    @Override
    public void onCreate() {
        super.onCreate();
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sendNotif();
        return super.onStartCommand(intent, flags, startId);
    }

    //void sendNotif() {
        // 1-я часть
    //    Notification notif = new Notification(R.drawable.ic_launcher_foreground, "Text in status bar",
    //            System.currentTimeMillis());

        // 3-я часть
    //    Intent intent = new Intent(this, MainActivity.class);
    //    intent.putExtra(MainActivity.FILE_NAME, "somefile");
    //    PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        // 2-я часть
    //    notif.setLatestEventInfo(this, "Notification's title", "Notification's text", pIntent);

        // ставим флаг, чтобы уведомление пропало после нажатия
    //    notif.flags |= Notification.FLAG_AUTO_CANCEL;

        // отправляем
    //    nm.notify(1, notif);
    //}
        private void sendNotif() {

            NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(this)
                    .setContentTitle("Title of notification")
                    .setContentText("Some context text here")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_foreground));


            // 3-я часть  Click on notification
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(MainActivity.FILE_NAME, "somefile.txt");
            PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            nBuilder.setContentIntent(pIntent);


            Notification notif = nBuilder.build();
            // ставим флаг, чтобы уведомление пропало после нажатия
            notif.flags |= Notification.FLAG_AUTO_CANCEL;
            notif.defaults = Notification.DEFAULT_ALL;
            notif.number = 5;

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // отправляем
            notificationManager.notify(1, notif);
        }

    public IBinder onBind(Intent arg0) {
        return null;
    }
}