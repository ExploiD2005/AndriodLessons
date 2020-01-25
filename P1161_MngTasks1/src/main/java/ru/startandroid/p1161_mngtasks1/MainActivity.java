package ru.startandroid.p1161_mngtasks1;

import android.support.v7.app.AppCompatActivity;
import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public abstract class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    List<ActivityManager.RunningTaskInfo> list;
    ActivityManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(getResources().getString(R.string.app_name) + " : " + getLocalClassName());
        am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
    }

    public void onInfoClick(View v) {
        list = am.getRunningTasks(10);
        for (RunningTaskInfo task : list) {
            if (task.baseActivity.flattenToShortString().startsWith("ru.startandroid.p116")){
                Log.d(LOG_TAG, "------------------");
                Log.d(LOG_TAG, "Count: " + task.numActivities);
                Log.d(LOG_TAG, "Root: " + task.baseActivity.flattenToShortString());
                Log.d(LOG_TAG, "Top: " + task.topActivity.flattenToShortString());
            }
        }
    }

    abstract public void onClick(View v);

    //abstract void onClick(View view);
}
/*
Флаги для Intent
Флаги применяются к Intent с помощью метода addFlags. Эти флаги повлияют на поведение вызываемого Activity.



FLAG_ACTIVITY_NEW_TASK
FLAG_ACTIVITY_NEW_TASK - в хелпе пишут, что этот флаг аналогичен значению singleTask в launchMode. У меня почему-то не совсем так. Activity находит свой таск, но не ищет в этом таске себя, а просто создает новое Activity сверху.



FLAG_ACTIVITY_SINGLE_TOP
FLAG_ACTIVITY_SINGLE_TOP – аналогичен значению singleTop для launchMode.



FLAG_ACTIVITY_CLEAR_TOP
FLAG_ACTIVITY_CLEAR_TOP – ищет в таске создаваемое Activity. Если находит, то открывает, а все, что выше – закрывает. Можно сказать, что этот флаг в комбинации с FLAG_ACTIVITY_NEW_TASK является аналогом singleTask в launchMode.



FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET
FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET –  помечает вызванное Activity. При следующем вызове таска из Home, это Activity и все вышерасположенные будут закрыты. В качестве примера можно привести почтовую программу. Вы открываете письмо, щелкаете на вложение и переходите в некую программу просмотра вложения. Затем сворачиваете приложение. Когда вы в следующий раз запустите почту, вы увидите верхнее Activity таска, т.е. просмотр вложения. А если вызывать просмотр вложения с вышеуказанным флагом, то при следующем запуске почты просмотр вложения будет закрыт и вы увидите письмо.



Рассмотрим на примере.  В MainActivity второго приложения перепишем метод onClick:

public void onClick(View v) {
  startActivity(new Intent("mngtasks1_activity_c")
      .addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET));
}

Будем вызывать ActivityC с этим флагом. Сохраняем, запускаем второе приложение. Жмем Start, открывается ActivityC, жмем еще раз Start, открывается ActivityD. Таск сейчас такой: Main-C-D.

Свернем приложение, нажав Home. Далее запускаем его с рабочего стола. Система находит таск и открывает его. На экране MainActivity второго приложения. Т.к. ActivityC было запущено с вышеуказанным флагом, оно и все вышестоящие Activity были закрыты при запуске приложения. В таске теперь только MainActivity.



FLAG_ACTIVITY_NO_HISTORY
FLAG_ACTIVITY_NO_HISTORY – Activity не будет сохранено в таске. Например, мы вызываем B с таким флагом из A. Далее из B вызываем C. Теперь жмем Назад и попадаем сразу в A, т.к. B не сохранилось в таске.



FLAG_ACTIVITY_REORDER_TO_FRONT
FLAG_ACTIVITY_REORDER_TO_FRONT – если Activity уже есть в таске оно переместится в топ. Например, есть таск A-B-C-D. Если D вызывает B с таким флагом, то таск станет таким A-C-D-B.



Пара флагов, появившихся с API Level 11. Используются совместно с FLAG_ACTIVITY_NEW_TASK.

FLAG_ACTIVITY_CLEAR_TASK
FLAG_ACTIVITY_CLEAR_TASK – таск для вызываемого Activity будет очищен, а вызываемое Activity станет в нем корневым. Сделаем пример.

В MainActivity второго приложения перепишем метод onClick:

public void onClick(View v) {
  startActivity(new Intent("mngtasks1_activity_c").addFlags(
      Intent.FLAG_ACTIVITY_CLEAR_TASK).addFlags(
      Intent.FLAG_ACTIVITY_NEW_TASK));
}
Очистим таски. Запускаем первое приложение, жмем три раза Start, получаем A-B-C-D. Запускаем второе приложение, жмем Start, открывается ActivityC. Жмем Info:

Count: 1
Root: ru.startandroid.develop.p1161mngtasks1/.ActivityC
Top: ru.startandroid.develop.p1161mngtasks1/.ActivityC
------------------
Count: 1
Root: ru.startandroid.develop.p1162mngtasks2/.MainActivity
Top: ru.startandroid.develop.p1162mngtasks2/.MainActivity

Таск первого приложения полностью очистился, в нем теперь только ActivityC.



FLAG_ACTIVITY_TASK_ON_HOME
FLAG_ACTIVITY_TASK_ON_HOME – таск для вызываемого Activity будет располагаться сразу после Home. Если из этого нового таска выходить кнопкой Назад, то попадешь не в предыдущий таск, а в Home. Сделаем пример.

В MainActivity второго приложения перепишем метод onClick:

public void onClick(View v) {
  startActivity(new Intent("mngtasks1_activity_c").addFlags(
      Intent.FLAG_ACTIVITY_TASK_ON_HOME).addFlags(
      Intent.FLAG_ACTIVITY_NEW_TASK));
}
Очистим таски. Запускаем второе приложение. Жмем Start. Открывается таск первого приложения, ActivityC. В нормальном режиме, если нажать сейчас Назад, то мы бы вернулись в таск второго приложения, в MainActivity. Но мы использовали флаг, поэтому нажимаем Назад и попадаем в Home.



Affinities
taskAffinity
Вернемся к атрибуту affinity. Его точное название  – taskAffinity. Как я уже рассказал выше, этот атрибут используется для определения своего таска для Activity. По умолчанию для каждого Activity этот атрибут равен пакету приложения. Таск же принимает значение affinity от корневого Activity.

Чтобы лучше понять принцип, давайте реализуем пример. У нас есть первое приложение, которое при запуске использует таск с affinity = ru.startandroid.develop.p1161mngtasks1. Второе приложение использует таск с affinity = ru.startandroid.develop.p1162mngtasks2.

Если мы из второго приложения вызовем ActivityC с флагом FLAG_ACTIVITY_NEW_TASK, то ActivityC будет искать свой таск с affinity = ru.startandroid.develop.p1161mngtasks1. Найдет таск первого приложения и запустится там, либо, если такого таска пока нет, то само создаст такой таск.

Попробуем для ActivityC прописать какой-нибудь левый affinity, например: ru.startandroid.develop.p1163testaffinity. В этом случае таск первого приложения ему не подойдет, и он точно создаст свой таск. Давайте проверим. Пропишите affinity для ActivityC



Сохраняем и запускаем первое приложение, формируем таск A-B-C-D. Свернем первое приложение, запустим второе. Жмем Info:

Count: 1
Root: ru.startandroid.develop.p1162mngtasks2/.MainActivity
Top: ru.startandroid.develop.p1162mngtasks2/.MainActivity|
------------------
Count: 4
Root: ru.startandroid.develop.p1161mngtasks1/.ActivityA
Top: ru.startandroid.develop.p1161mngtasks1/.ActivityD



Жмем Start во втором приложении, открылось ActivityC. Жмем Info:

Count: 1
Root: ru.startandroid.develop.p1161mngtasks1/.ActivityC
Top: ru.startandroid.develop.p1161mngtasks1/.ActivityC
------------------
Count: 1
Root: ru.startandroid.develop.p1162mngtasks2/.MainActivity
Top: ru.startandroid.develop.p1162mngtasks2/.MainActivity
------------------
Count: 4
Root: ru.startandroid.develop.p1161mngtasks1/.ActivityA
Top: ru.startandroid.develop.p1161mngtasks1/.ActivityD

К сожалению, я не знаю, как вытащить значение affinity для таска или его корневого Activity. Но четко видно, что для ActivityC не подошел таск первого приложения (из-за разных affinity), и оно выделилось в отдельный таск.

Очистите атрибут affinity для ActivityC и очистите таски.



allowTaskReparenting
У Activity есть атрибут allowTaskReparenting.Он позволяет перекидывать Activity из фоновых в активные таски.



Сделаем пример.

Установим этот параметр для ActivityD

Во втором приложении перепишем onClick:

public void onClick(View v) {
  startActivity(new Intent("mngtasks1_activity_c"));
}
Все сохраняем, запускаем второе приложение. Жмем Start, получаем ActivityC, жмем Start получаем ActivityD.

Жмем Info:

Count: 3
Root: ru.startandroid.develop.p1162mngtasks2/.MainActivity
Top: ru.startandroid.develop.p1161mngtasks1/.ActivityD



Таск Main-C-D. Сворачиваем этот таск. Запускаем первое приложение (из Eclipse ,т.к. были изменения) и видим сразу ActivityD. Жмем Info:

Count: 2
Root: ru.startandroid.develop.p1161mngtasks1/.ActivityA
Top: ru.startandroid.develop.p1161mngtasks1/.ActivityD
------------------
Count: 2
Root: ru.startandroid.develop.p1162mngtasks2/.MainActivity
Top: ru.startandroid.develop.p1161mngtasks1/.ActivityC

ActivityD, для которого мы указали атрибут allowTaskReparenting, перешло из фонового таска второго приложения в запущенный свой таск (первого приложения).



Очистка таска
Если пользователь долгое время не использует свернутый таск, то система его чистит, за исключением корневого Activity. Система ведет себя так исходя из предположения, что, если пользователь долго не возвращался к выполняемой задаче, то эта задача ему более не интересна.

Мы можем повлиять на это поведение системы. Существуют атрибуты для Activity:

alwaysRetainTaskState – если установлено в true для Activity, которое является корневым в таске, то этот таск сохранит свои Activity даже спустя долгое время

clearTaskOnLaunch – если установлено в true для Activity, которое является корневым в таске, то при каждом запуске таск очищается. Причем, именно при запуске, а не при выборе таска из списка последних.

finishOnTaskLaunch – аналогичен clearTaskOnLaunch, но действует для конкретного Activity. Например, включим этот атрибут для ActivityC. Запустим первое приложение и сформируем таск A-B-C-D. Свернем его и запустим снова первое приложение, получим таск A-B-D. ActivityC при новом запуске закрылось.



Большой получился материал. Сразу все это в голове, конечно, не уложится. Но, думаю, вполне пригодится как справка или памятка, когда понадобится задать нестандартное поведение для своего приложения.
 */