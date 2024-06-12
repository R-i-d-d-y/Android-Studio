package com.example.myapplication4;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class ThirdActivity extends AppCompatActivity {
    TextView full2, display2;
    ImageView img;
    Intent inte;
    private AlertDialog.Builder alertbuilder;

    DrawerLayout drawerLayout1;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    Uri uri;
    TextView userName;
    AlertDialog dialog;
    Button button;

    ImageView userPhoto;
    ImageButton imageButton;
    Objects object;
    private Context context;
    private BluetoothAdapter bluetoothAdapter;
    private ChatUtils chatUtils;

    private ListView listMainChat;
    private EditText edCreateMessage;
    private ImageButton btnSendMessage;
    View headerView;
    private ArrayAdapter<String> adapterMainChat;

    private final int LOCATION_PERMISSION_REQUEST = 101;
    private final int SELECT_DEVICE = 102;

    public static final int MESSAGE_STATE_CHANGED = 0;
    public static final int MESSAGE_READ = 1;
    public static final int MESSAGE_WRITE = 2;
    public static final int MESSAGE_DEVICE_NAME = 3;
    public static final int MESSAGE_TOAST = 4;

    public static final String DEVICE_NAME = "deviceName";
    public static final String TOAST = "toast";
    private String connectedDevice;
    Toolbar toolbar;


    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case MESSAGE_STATE_CHANGED:
                    switch (message.arg1) {
                        case ChatUtils.STATE_NONE:
                            setState("Not Connected");
                            break;
                        case ChatUtils.STATE_LISTEN:
                            setState("Not Connected");
                            break;
                        case ChatUtils.STATE_CONNECTING:
                            setState("Connecting...");
                            break;
                        case ChatUtils.STATE_CONNECTED:
                            setState("Connected: " + connectedDevice);
                            break;
                    }
                    break;
                case MESSAGE_WRITE:
                    byte[] buffer1 = (byte[]) message.obj;
                    String outputBuffer = new String(buffer1);
                    adapterMainChat.add("Me: " + outputBuffer);
                    break;
                case MESSAGE_READ:
                    byte[] buffer = (byte[]) message.obj;
                    String inputBuffer = new String(buffer, 0, message.arg1);
                    adapterMainChat.add(connectedDevice + ": " + inputBuffer);
                    break;
                case MESSAGE_DEVICE_NAME:
                    connectedDevice = message.getData().getString(DEVICE_NAME);
                    Toast.makeText(context, connectedDevice, Toast.LENGTH_SHORT).show();
                    break;
                case MESSAGE_TOAST:
                    Toast.makeText(context, message.getData().getString(TOAST), Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        }
    });

    private void setState(CharSequence subTitle) {
        getSupportActionBar().setSubtitle(subTitle);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        img = (ImageView) findViewById(R.id.profileid);
        display2=(TextView)findViewById(R.id.nmeid) ;
        drawerLayout1 = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigationid);


      toolbar = findViewById(R.id.toolbar);

       getSupportActionBar().setTitle("Wireless Whispering");

        inte = getIntent();
        Uri uri = (Uri) inte.getParcelableExtra("img");
        img.setImageURI(uri);

        Bundle b2=getIntent().getExtras();
        display2.setText(b2.getString("dispnme"));

       img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout1.openDrawer(GravityCompat.START);
            }
        });

        View headerView=navigationView.getHeaderView(0);
        userPhoto=(ImageView) headerView.findViewById(R.id.profile3id);
        userName=headerView.findViewById(R.id.nameid);
        Intent inte1=getIntent();
        Uri urii = (Uri) inte1.getParcelableExtra("img");
        userPhoto.setImageURI(uri);
        Bundle b1=getIntent().getExtras();
        userName.setText(b1.getString("fullnme"));
        drawerToggle = new ActionBarDrawerToggle(ThirdActivity.this, drawerLayout1, R.string.open, R.string.close);
        drawerLayout1.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        context = this;

        init();
        initBluetooth();
        chatUtils = new ChatUtils(context, handler);
    }
    public void profile(View view)
    {
        Intent i1=new Intent(ThirdActivity.this,EditProfile.class);
        Intent inte1=getIntent();
        Uri urii = (Uri) inte1.getParcelableExtra("img");
        i1.putExtra("image",urii);
        startActivityForResult(i1,1);
    }

    public void onClick3(View view)
    {
        Intent intent=new Intent(this,About.class);
        startActivity(intent);
    }
    public void onClick4(View view)
    {
        alertbuilder=new AlertDialog.Builder(ThirdActivity.this);
        alertbuilder.setCancelable(false);
        alertbuilder.setTitle("Log Out");
        alertbuilder.setMessage("Do you want to log out....?");
        alertbuilder.setIcon(R.drawable.what);
        alertbuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();

            }

        });

        alertbuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alert= alertbuilder.create();
        alert.show();
    }


    private void init() {
        listMainChat = findViewById(R.id.list_conversation);
        edCreateMessage = findViewById(R.id.ed_enter_message);
        btnSendMessage = findViewById(R.id.btn_send_msg);

        adapterMainChat = new ArrayAdapter<String>(context, R.layout.message_layout);
        listMainChat.setAdapter(adapterMainChat);

        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = edCreateMessage.getText().toString();
                if (!message.isEmpty()) {
                    edCreateMessage.setText("");
                    chatUtils.write(message.getBytes());
                }
            }
        });
    }

    private void initBluetooth() {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            Toast.makeText(context, "No bluetooth found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main_activity,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menu_search_devices)
        {
            checkPermissions();
            return true;}
        else if( item.getItemId()==R.id.menu_enable_bluetooth)
        {
            enableBluetooth();
            return true;}
        else
            return super.onOptionsItemSelected(item);
    }


    private void checkPermissions() {
        if (ContextCompat.checkSelfPermission(context, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ThirdActivity.this, new String[]{ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST);
        } else {
            Intent intent = new Intent(context, DeviceListActivity.class);
            startActivityForResult(intent, SELECT_DEVICE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1)
        {
            if(resultCode==RESULT_OK)
            {     View headerView=navigationView.getHeaderView(0);
                userPhoto=(ImageView) headerView.findViewById(R.id.profile3id);
                userName=headerView.findViewById(R.id.nameid);
                Intent inte1=getIntent();
                Uri urii = (Uri) data.getParcelableExtra("imgg");
                userPhoto.setImageURI(urii);
                Bundle bundle=data.getExtras();
                userName.setText(bundle.getString("full"));
                display2.setText(bundle.getString("disp"));
                img.setImageURI(urii);

            }
        }
      else  if (requestCode == SELECT_DEVICE && resultCode == RESULT_OK) {
            String address = data.getStringExtra("deviceAddress");
            chatUtils.connect(bluetoothAdapter.getRemoteDevice(address));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == LOCATION_PERMISSION_REQUEST) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(context, DeviceListActivity.class);
                startActivityForResult(intent, SELECT_DEVICE);
            } else {
                new AlertDialog.Builder(context)
                        .setCancelable(false)
                        .setMessage("Location permission is required.\n Please grant")
                        .setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                checkPermissions();
                            }
                        })
                        .setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ThirdActivity.this.finish();
                            }
                        }).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void enableBluetooth() {
        if (!bluetoothAdapter.isEnabled()) {
            bluetoothAdapter.enable();
        }

        if (bluetoothAdapter.getScanMode() != BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE) {
            Intent discoveryIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            discoveryIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
            startActivity(discoveryIntent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (chatUtils != null) {
            chatUtils.stop();
        }
    }

}