package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    int notificationID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view) {
        displayNotification();
    }
    protected void displayNotification()
    {
        //---PendingIntent to launch activity if the user selects
        // this notification---
        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        i.putExtra("notificationID", notificationID);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, i, 0);
        NotificationManager nm = (NotificationManager)getSystemService
                (NOTIFICATION_SERVICE);
        NotificationCompat.Builder notifBuilder;
        notifBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Meeting Reminder")
                .setContentText("Reminder: Meeting starts in 5 minutes");
        nm.notify(notificationID, notifBuilder.build());
    }
}