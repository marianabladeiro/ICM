package com.example.phonedialer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSION_REQUEST = 1;
    HashMap<String, String> data = new HashMap<String, String>();

    //buttons variables
    Button bDelete;
    Button bZero;
    Button bOne;
    Button bTwo;
    Button bThree;
    Button bFour;
    Button bFive;
    Button bSix;
    Button bSeven;
    Button bEight;
    Button bNine;
    Button bStar;
    Button bHashTag;
    Button bDial;
    Button bQuickDialOne;
    Button bQuickDialTwo;
    Button bQuickDialThree;

    TextView input;
    String number = "";
    String name; //for pop up
    int flag;
    //button status
    int status = 0;
    int status2 = 0;
    int status3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSION_REQUEST);
            }
            else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSION_REQUEST);
            }
        }

        bDelete = (Button) findViewById(R.id.buttonDelete);
        bZero = (Button) findViewById(R.id.buttonZero);
        bOne = (Button) findViewById(R.id.buttonOne);
        bTwo = (Button) findViewById(R.id.buttonTwo);
        bThree = (Button) findViewById(R.id.buttonThree);
        bFour = (Button) findViewById(R.id.buttonFour);
        bFive = (Button) findViewById(R.id.buttonFive);
        bSix = (Button) findViewById(R.id.buttonSix);
        bSeven = (Button) findViewById(R.id.buttonSeven);
        bEight = (Button) findViewById(R.id.buttonEight);
        bNine = (Button) findViewById(R.id.buttonNine);
        bStar = (Button) findViewById(R.id.buttonStar);
        bHashTag = (Button) findViewById(R.id.buttonHashTag);
        bDial = (Button) findViewById(R.id.buttonDial);
        bQuickDialOne = (Button) findViewById(R.id.quickDialOne);
        bQuickDialTwo = (Button) findViewById(R.id.quickDialTwo);
        bQuickDialThree = (Button) findViewById(R.id.quickDialThree);
        input = (TextView) findViewById(R.id.editText);

        bQuickDialOne.setTag(1);
        bQuickDialTwo.setTag(1);
        bQuickDialThree.setTag(1);

        //numbers and symbols simple actions
        bZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + "0";
                input.setText(number);
            }

        });

        bOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + "1";
                input.setText(number);

            }

        });

        bTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + "2";
                input.setText(number);
            }

        });

        bThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + "3";
                input.setText(number);
            }

        });

        bFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + "4";
                input.setText(number);
            }

        });

        bFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + "5";
                input.setText(number);
            }

        });

        bSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + "6";
                input.setText(number);
            }

        });

        bSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + "7";
                input.setText(number);
            }

        });

        bEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + "8";
                input.setText(number);
            }

        });

        bNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + "9";
                input.setText(number);
            }

        });

        bStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + "*";
                input.setText(number);
            }

        });

        bHashTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + "#";
                input.setText(number);
            }

        });

        //press to delete one by one
        bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number != "") {
                    number = number.substring(0, number.length() - 1);
                    input.setText(number);
                }
            }
        });

        //long press to delete everything
        bDelete.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                number = "";
                input.setText(number);
                return true;
            }
        });

        bDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall();
                number = "";
            }

        });


        bQuickDialOne.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                number = "";
                if (status == 0) {

                    bQuickDialOne.setText("\u2713");

                    //disable buttons
                    bQuickDialTwo.setEnabled(false);
                    bQuickDialThree.setEnabled(false);
                    bDial.setEnabled(false);
                    status = 1;
                }
                return true;
            }


        });


        bQuickDialOne.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                flag = 1;

                if (status == 1) {
                    //enable buttons again
                    bQuickDialTwo.setEnabled(true);
                    bQuickDialThree.setEnabled(true);
                    bDial.setEnabled(true);
                    //pop up
                    showQuickDial(MainActivity.this);
                    status = 0;

                }
                if (bQuickDialOne.getText() != "+" && bQuickDialOne.getText() != "\u2713" ) {
                    String nameButton = (String) bQuickDialOne.getText();

                    if (data.containsKey(nameButton)) {
                        number = data.get(nameButton);
                        makeCall();
                    }
                }
            }
        });

        bQuickDialTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = 2;

                if (status2 == 1) {
                    //enable buttons again
                    bQuickDialOne.setEnabled(true);
                    bQuickDialThree.setEnabled(true);
                    bDial.setEnabled(true);
                    //pop up
                    showQuickDial(MainActivity.this);
                    status2 = 0;
                }
                if (bQuickDialTwo.getText() != "+" && bQuickDialTwo.getText() != "\u2713" ) {
                    CharSequence nameButton = bQuickDialTwo.getText();
                    if (data.containsKey(nameButton)) {
                        number = data.get(nameButton);
                        makeCall();
                    }
                }

            }
        });

        bQuickDialTwo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                number = "";
                if (status2 == 0) {

                    bQuickDialTwo.setText("\u2713");

                    //disable buttons
                    bQuickDialOne.setEnabled(false);
                    bQuickDialThree.setEnabled(false);
                    bDial.setEnabled(false);
                    status2 = 1;
                }
                return true;
            }
        });

        bQuickDialThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = 3;
                if (status3 == 1) {
                    //enable buttons again
                    bQuickDialOne.setEnabled(true);
                    bQuickDialTwo.setEnabled(true);
                    bDial.setEnabled(true);
                    //pop up
                    showQuickDial(MainActivity.this);
                    status3 = 0;
                }

                if (bQuickDialThree.getText() != "+" && bQuickDialThree.getText() != "\u2713" ) {
                    CharSequence nameButton = bQuickDialThree.getText();
                    if (data.containsKey(nameButton)) {
                        number = data.get(nameButton);
                        makeCall();
                    }
                }

            }
        });

        bQuickDialThree.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                number = "";
                if (status3 == 0) {

                    bQuickDialThree.setText("\u2713");

                    //disable buttons
                    bQuickDialOne.setEnabled(false);
                    bQuickDialTwo.setEnabled(false);
                    bDial.setEnabled(false);
                    status3 = 1;
                }
                return true;
            }
        });

    }

    //pop up method to ask for name to associate with number
    private void showQuickDial(Context c) {
        AlertDialog.Builder questionName = new AlertDialog.Builder(this);

        questionName.setTitle(" Enter name ");
        final EditText input=new EditText(this);

        LinearLayout.LayoutParams lp= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        questionName.setView(input);
        questionName.setNegativeButton(" Cancel ", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){

            }
        });

        questionName.setPositiveButton(" Save ", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                name = input.getText().toString();
                saveName();

            }
        });

        AlertDialog dialog = questionName.create();

        dialog.show();

    }

    //method that saves (name, number) for speed dial buttons
    public void saveName(){
        data.put(name, number);

        switch (flag) {
            case 1:
                bQuickDialOne.setText(name);
                break;
            case 2:
                bQuickDialTwo.setText(name);
                break;
            case 3:
                bQuickDialThree.setText(name);
                break;
        }
        input.setText("");

    }

    //method that handles the call to the built in caller
    public void makeCall() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        startActivity(intent);
        input.setText("");

    }

    //take off permission?
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch(requestCode) {
            case MY_PERMISSION_REQUEST:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(MainActivity.this, "Permission granted", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Permission not granted", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
        }
    }

}
