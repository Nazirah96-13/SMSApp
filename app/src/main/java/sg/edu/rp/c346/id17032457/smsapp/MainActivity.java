package sg.edu.rp.c346.id17032457.smsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtTo, edtContent;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTo = findViewById(R.id.etTo);
        edtContent= findViewById(R.id.etContent);
        btnSend = findViewById(R.id.buttonSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edt =edtContent.getText().toString();

                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("5556", null, edt, null, null);

            }
        });

        //Receiver
        IntentFilter filter= new IntentFilter();
        filter.addAction("android.provider.Telephony.SMS_RECEIVED");
    }
}
