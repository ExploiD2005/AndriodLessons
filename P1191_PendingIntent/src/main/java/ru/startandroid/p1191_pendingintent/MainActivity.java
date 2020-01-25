package ru.startandroid.p1191_pendingintent;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    NotificationManager nm;
    AlarmManager am;
    Intent intent1;
    Intent intent2;
    PendingIntent pIntent1;
    PendingIntent pIntent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        am = (AlarmManager) getSystemService(ALARM_SERVICE);
    }

    //public void onClick1(View view) {
    //
    //    intent1 = createIntent("action 1", "extra 1");
    //    pIntent1 = PendingIntent.getBroadcast(this, 0, intent1, 0);
    //
     //   intent2 = createIntent("action 2", "extra 2");
    //    pIntent2 = PendingIntent.getBroadcast(this, 0, intent2, 0);
    //
    //    compare();
    //}
    //public void onClick1(View view) {
    //intent1 = createIntent("action", "extra 1");
    //pIntent1 = PendingIntent.getBroadcast(this, 0, intent1, 0);

    //intent2 = createIntent("action", "extra 2");
    //pIntent2 = PendingIntent.getBroadcast(this, 0, intent2, 0);
    //pIntent2 = PendingIntent.getBroadcast(this, 0, intent2, PendingIntent.FLAG_CANCEL_CURRENT);
    //pIntent2 = PendingIntent.getBroadcast(this, 0, intent2, PendingIntent.FLAG_UPDATE_CURRENT);



    //compare();

    //    sendNotif(1, pIntent1);
    //    sendNotif(2, pIntent2);
    //}

    //public void onClick1(View view) {
    //    intent1 = createIntent("action", "extra 1");
    //    pIntent1 = PendingIntent.getBroadcast(this, 0, intent1, PendingIntent.FLAG_ONE_SHOT);

    //    sendNotif(1, pIntent1);
    //    sendNotif(2, pIntent1);
    //}

    //public void onClick1(View view) {
    //    intent1 = createIntent("action", "extra 1");
    //    pIntent1 = PendingIntent.getBroadcast(this, 0, intent1, 0);
    //    Log.d(LOG_TAG, "pIntent1 created");
    //}
    //public void onClick2(View view){
    //    intent2 = createIntent("action", "extra 2");
    //    pIntent2 = PendingIntent.getBroadcast(this, 0, intent2, PendingIntent.FLAG_NO_CREATE);
    //    if (pIntent2 == null) Log.d(LOG_TAG, "pIntent2 is null");
    //    else Log.d(LOG_TAG, "pIntent2 created");
   // }

    /*public void onClick1(View view) {
        intent1 = createIntent("action", "extra 1");
        pIntent1 = PendingIntent.getBroadcast(this, 0, intent1, 0);
        sendNotif(1, pIntent1);
    }
    public void onClick2(View view) {
        pIntent1.cancel();
        Log.d(LOG_TAG, "cancel pIntent1");
    }*/

    /*public void onClick1(View view) {
        intent1 = createIntent("action", "extra 1");
        Uri data1 = Uri.parse(intent1.toUri(Intent.URI_INTENT_SCHEME));
        intent1.setData(data1);
        pIntent1 = PendingIntent.getBroadcast(this, 0, intent1, 0);

        intent2 = createIntent("action", "extra 2");
        Uri data2 = Uri.parse(intent2.toUri(Intent.URI_INTENT_SCHEME));
        intent2.setData(data2);
        pIntent2 = PendingIntent.getBroadcast(this, 0, intent2, 0);

        compare();

        sendNotif(1, pIntent1);
        sendNotif(2, pIntent2);
    }*/

    /*public void onClick1(View view) {
        intent1 = createIntent("action 1", "extra 1");
        pIntent1 = PendingIntent.getBroadcast(this, 0, intent1, 0);

        intent2 = createIntent("action 2", "extra 2");
        pIntent2 = PendingIntent.getBroadcast(this, 0, intent2, 0);

        Log.d(LOG_TAG, "start");
        am.set(AlarmManager.RTC, System.currentTimeMillis() + 4000, pIntent1);
        am.setRepeating(AlarmManager.ELAPSED_REALTIME,
                SystemClock.elapsedRealtime() + 3000, 5000, pIntent2);
    }

    public void onClick2(View view) {
        am.cancel(pIntent2);
    }*/

    /*В onClick1 создадим два разных PendingIntent. Первый отправим методом set. На вход метод требует тип «будильника», время срабатывания (в милисекундах) и PendingIntent.



Типы будильника бывают следующие: ELAPSED_REALTIME, ELAPSED_REALTIME_WAKEUP, RTC и RTC_WAKEUP. В чем отличие между ними?

Те, название которых начинается с RTC, ориентируются на системное время. И время запуска таких будильников надо указывать относительно System.currentTimeMillis. Т.е. это RTC и RTC_WAKEUP.

Те, название которых начинается с ELAPSED_REALTIME, ориентируются на время от начала загрузки оси (включения устройства). Время запуска таких будильников надо указывать относительно SystemClock.elapsedRealtime(). Т.е. это ELAPSED_REALTIME и ELAPSED_REALTIME_WAKEUP.

Те, в названии которых есть WAKEUP, при срабатывании будут выводить устройство из спячки. Т.е. это ELAPSED_REALTIME_WAKEUP и RTC_WAKEUP.

Тут надо не путать спячку с выключенным экраном. Экран может быть выключен, но устройство вовсю будет работать. А когда задач нет устройство уходит в спячку, вырубая процессор для экономии энергии. Если будильники с типом не WAKEUP должны сработать, а устройство в это время спит, то их запуск откладывается до пробуждения. А WAKEUP-будильники разбудят устройство.



Вернемся к методу set. Используем здесь тип RTC, а, значит, время запуска (второй параметр метода) указываем относительно системного времени.  Укажем текущее время + 4 секунды. Т.е. будильник сработает через 4 секунды после текущего времени создания. А когда он сработает, он выполнит pIntent1 (третий параметр метода).

Второй будильник ставим методом setRepeating. Он похож на set, только позволяет задать еще период повтора срабатывания. Для примера используем здесь тип ELAPSED_REALTIME. С таким типом время запуска мы должны указать, через сколько милисекунд после старта системы сработает будильник. Мы берем время уже прошедшее со старта (SystemClock.elapsedRealtime()), тем самым получая текущее время, и прибавляем к нему 3 секунды. Период повтора (третий параметр метода) сделаем равным 5 секунд. При срабатывании будет выполнен pIntent2.

Т.е. после того, как мы нажмем кнопку у нас установятся два будильника.

Первый – однократный, через 4 секунды от текущего времени, pIntent1.

Второй – повторяющийся каждые 5 сек., с первым запуском через 3 секунды от текущего времени.

В onClick2 мы будем выключать второй будильник, чтобы он у нас не работал вечно. Для этого выполняем метод cancel с указанием PendingIntent, который используется в будильнике.

Все сохраняем, запускаем приложение. Жмем Button1. В логах наблюдаем, как начали срабатывать будильники. Секунд через 20 жмем кнопку Button2, движуха в логах прекратилась. Смотрим логи:

07:55:22.380: start
07:55:25.450: onReceive
07:55:25.450: action = action 2
07:55:25.459: extra = extra 2
07:55:26.430: onReceive
07:55:26.430: action = action 1
07:55:26.430: extra = extra 1
07:55:30.499: onReceive
07:55:30.499: action = action 2
07:55:30.499: extra = extra 2
07:55:35.429: onReceive
07:55:35.429: action = action 2
07:55:35.429: extra = extra 2
07:55:40.450: onReceive
07:55:40.450: action = action 2
07:55:40.450: extra = extra 2



Второй будильник сработал через 3 секунды после старта и далее срабатывал каждые 5 сек, пока мы его не выключили методом cancel. А первый сработал один раз, через 4 секунды. Все, как и задумывалось.

Есть еще метод setInexactRepeating. Он аналогичен методу setRepeating, но периодичность его срабатывания не всегда точно такая, какую вы указали. Он может подстраивать запуск вашего будильника под будильники, которые будут выполнены примерно в то же время. Сделано это для экономии энергии, чтобы не будить два раза устройство, если оно спит. Судя по хелпу погрешность запуска может быть значительной, так что используйте аккуратнее.



Расскажу еще несколько полезных фактов из жизни будильников.

Если вы запланируете будильник с просроченным временем запуска – он выполнится сразу же.

После перезагрузки устройства все будильники стираются.

Если вы попытаетесь создать два разных будильника на основе одного или похожих PendingIntent, то сработает только второй, а первый будет удален при создании второго.
*/

    public void onClick1(View view) {
        intent1 = createIntent("action", "extra 1");
        pIntent1 = PendingIntent.getBroadcast(this, 0, intent1, 0);

        intent2 = createIntent("action", "extra 2");
        pIntent2 = PendingIntent.getBroadcast(this, 0, intent2, 0);

        Log.d("qwe", "start");
        am.set(AlarmManager.RTC, System.currentTimeMillis() + 2000, pIntent1);
        am.set(AlarmManager.RTC, System.currentTimeMillis() + 4000, pIntent2);
    }



    Intent createIntent(String action, String extra) {
        Intent intent = new Intent(this, Receiver.class);
        intent.setAction(action);
        intent.putExtra("extra", extra);
        return intent;
    }

    void compare() {
        Log.d(LOG_TAG, "intent1 = intent2: " + intent1.filterEquals(intent2));
        Log.d(LOG_TAG, "pIntent1 = pIntent2: " + pIntent1.equals(pIntent2));
    }

    //void sendNotif(int id, PendingIntent pIntent) {
    //    Notification notif = new Notification(R.mipmap.ic_launcher, "Notif "
    //            + id, System.currentTimeMillis());
    //    notif.flags |= Notification.FLAG_AUTO_CANCEL;
    //    notif.setLatestEventInfo(this, "Title " + id, "Content " + id, pIntent);
    //    nm.notify(id, notif);
    //}

    //void sendNotif(int id, PendingIntent pIntent) {
    //    Notification notification = new Notification.Builder(getApplicationContext())
    //            .setContentTitle("Title " + id)
    //            .setContentText("Content " + id)
    //            .setSmallIcon(R.mipmap.ic_launcher)
    //            .setAutoCancel(true)
    //            .setContentIntent(pIntent)
    //            .getNotification();
    //
    //    notificationManager.notify(id, notification);
    //}

    void sendNotif(int id, PendingIntent pIntent) {
        Notification notif = new Notification.Builder(this)
                .setContentTitle("Title " + id)
                .setContentText("Content " + id)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pIntent)
                .setAutoCancel(true)
                .setContentIntent(pIntent).build(); //добавляем PendingIntent
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(id, notif);//id должен быть уникальным, чтобы сообщений было несколько
    }
}