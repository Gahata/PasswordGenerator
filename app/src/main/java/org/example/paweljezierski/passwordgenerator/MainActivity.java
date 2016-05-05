package org.example.paweljezierski.passwordgenerator;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // UI elements
    TextView passwordLengthTextView;
    SeekBar passwordLengthSeekBar;
    CheckBox checkBoxSmallLetters;
    CheckBox checkBoxBigLetters;
    CheckBox checkBoxNumbers;
    CheckBox checkBoxSpecialCharacters;
    Button generatePasswordButton;
    Button shareButton1, shareButton2, shareButton3, shareButton4, shareButton5, shareButton6, shareButton7, shareButton8, shareButton9, shareButton10;
    Button copyButton1, copyButton2, copyButton3, copyButton4, copyButton5, copyButton6, copyButton7, copyButton8, copyButton9, copyButton10;
    TextView passwordTextView1, passwordTextView2, passwordTextView3, passwordTextView4, passwordTextView5, passwordTextView6, passwordTextView7, passwordTextView8, passwordTextView9, passwordTextView10;
    ScrollView scrollList;

    // characters to use
    String smallLetters = "abcdefghijklmnopqrstuvwxyz";
    String bigLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String numbers = "1234567890";
    String specialCharacters = "!@#$%^&*(),.";
    String selectedCharacters = smallLetters + bigLetters + numbers + specialCharacters;
    char[] selectedCharactersArray = selectedCharacters.toCharArray();

    // password stuff
    String password = "";
    int passwordLength = 5;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI elements initialization
        passwordLengthTextView = (TextView) findViewById(R.id.passwordLengthTextViewInt);
        passwordLengthSeekBar = (SeekBar) findViewById(R.id.passwordLenghtSeekBar);
        checkBoxBigLetters = (CheckBox) findViewById(R.id.checkBoxBigLetters);
        checkBoxSmallLetters = (CheckBox) findViewById(R.id.checkBoxSmallLetters);
        checkBoxNumbers = (CheckBox) findViewById(R.id.checkBoxNumbers);
        checkBoxSpecialCharacters = (CheckBox) findViewById(R.id.checkBoxSpecialCharacters);
        generatePasswordButton = (Button) findViewById(R.id.generatePasswordButton);
        scrollList = (ScrollView) findViewById(R.id.scrollList);

        shareButton1 = (Button) findViewById(R.id.shareButton1);
        shareButton2 = (Button) findViewById(R.id.shareButton2);
        shareButton3 = (Button) findViewById(R.id.shareButton3);
        shareButton4 = (Button) findViewById(R.id.shareButton4);
        shareButton5 = (Button) findViewById(R.id.shareButton5);
        shareButton6 = (Button) findViewById(R.id.shareButton6);
        shareButton7 = (Button) findViewById(R.id.shareButton7);
        shareButton8 = (Button) findViewById(R.id.shareButton8);
        shareButton9 = (Button) findViewById(R.id.shareButton9);
        shareButton10 = (Button) findViewById(R.id.shareButton10);

        copyButton1 = (Button) findViewById(R.id.copyButton1);
        copyButton2 = (Button) findViewById(R.id.copyButton2);
        copyButton3 = (Button) findViewById(R.id.copyButton3);
        copyButton4 = (Button) findViewById(R.id.copyButton4);
        copyButton5 = (Button) findViewById(R.id.copyButton5);
        copyButton6 = (Button) findViewById(R.id.copyButton6);
        copyButton7 = (Button) findViewById(R.id.copyButton7);
        copyButton8 = (Button) findViewById(R.id.copyButton8);
        copyButton9 = (Button) findViewById(R.id.copyButton9);
        copyButton10 = (Button) findViewById(R.id.copyButton10);

        passwordTextView1 = (TextView) findViewById(R.id.passwordTextView1);
        passwordTextView2 = (TextView) findViewById(R.id.passwordTextView2);
        passwordTextView3 = (TextView) findViewById(R.id.passwordTextView3);
        passwordTextView4 = (TextView) findViewById(R.id.passwordTextView4);
        passwordTextView5 = (TextView) findViewById(R.id.passwordTextView5);
        passwordTextView6 = (TextView) findViewById(R.id.passwordTextView6);
        passwordTextView7 = (TextView) findViewById(R.id.passwordTextView7);
        passwordTextView8 = (TextView) findViewById(R.id.passwordTextView8);
        passwordTextView9 = (TextView) findViewById(R.id.passwordTextView9);
        passwordTextView10 = (TextView) findViewById(R.id.passwordTextView10);



        // making password list invisible at launch of application
        scrollList.setVisibility(View.INVISIBLE);

        // seekBar code
        passwordLengthSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // +5 because cannot set minimal value of seekBar to 5, it's always 0
                passwordLength = progress+5;
                passwordLengthTextView.setText(Integer.toString(passwordLength));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // checkBox code, it calls checkBox method on every checkBoxChangeCheck

        checkBoxBigLetters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCheckedMethod();
            }
        });

        checkBoxSmallLetters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCheckedMethod();
            }
        });

        checkBoxNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCheckedMethod();
            }
        });

        checkBoxSpecialCharacters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCheckedMethod();
            }
        });

        // generate password button code
        generatePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollList.setVisibility(View.VISIBLE);

                passwordTextView1.setText("");
                passwordTextView2.setText("");
                passwordTextView3.setText("");
                passwordTextView4.setText("");
                passwordTextView5.setText("");
                passwordTextView6.setText("");
                passwordTextView7.setText("");
                passwordTextView8.setText("");
                passwordTextView9.setText("");
                passwordTextView10.setText("");

                passwordGenerationAndDisplay();
            }
        });

        // share button code
        shareButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordTextView1.getText() != "") {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, passwordTextView1.getText());
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Please generate a password first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        shareButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordTextView2.getText() != "") {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, passwordTextView2.getText());
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Please generate a password first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        shareButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordTextView3.getText() != "") {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, passwordTextView3.getText());
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Please generate a password first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        shareButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordTextView4.getText() != "") {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, passwordTextView4.getText());
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Please generate a password first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        shareButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordTextView5.getText() != "") {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, passwordTextView5.getText());
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Please generate a password first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        shareButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordTextView6.getText() != "") {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, passwordTextView6.getText());
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Please generate a password first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        shareButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordTextView7.getText() != "") {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, passwordTextView7.getText());
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Please generate a password first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        shareButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordTextView8.getText() != "") {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, passwordTextView8.getText());
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Please generate a password first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        shareButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordTextView9.getText() != "") {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, passwordTextView9.getText());
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Please generate a password first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        shareButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordTextView10.getText() != "") {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, passwordTextView10.getText());
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Please generate a password first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // copy button code
        copyButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordTextView1.getText() != "") {
                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", passwordTextView1.getText());
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(MainActivity.this, "Text copied to Clipboard", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Please generate a password first", Toast.LENGTH_SHORT).show();
                }
            }
        });


        copyButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordTextView2.getText() != "") {
                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", passwordTextView2.getText());
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(MainActivity.this, "Text copied to Clipboard", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Please generate a password first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        copyButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordTextView3.getText() != "") {
                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", passwordTextView3.getText());
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(MainActivity.this, "Text copied to Clipboard", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Please generate a password first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        copyButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordTextView4.getText() != "") {
                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", passwordTextView4.getText());
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(MainActivity.this, "Text copied to Clipboard", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Please generate a password first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        copyButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordTextView5.getText() != "") {
                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", passwordTextView5.getText());
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(MainActivity.this, "Text copied to Clipboard", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Please generate a password first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        copyButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordTextView6.getText() != "") {
                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", passwordTextView6.getText());
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(MainActivity.this, "Text copied to Clipboard", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Please generate a password first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        copyButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordTextView7.getText() != "") {
                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", passwordTextView7.getText());
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(MainActivity.this, "Text copied to Clipboard", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Please generate a password first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        copyButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordTextView8.getText() != "") {
                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", passwordTextView8.getText());
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(MainActivity.this, "Text copied to Clipboard", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Please generate a password first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        copyButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordTextView9.getText() != "") {
                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", passwordTextView9.getText());
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(MainActivity.this, "Text copied to Clipboard", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Please generate a password first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        copyButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordTextView10.getText() != "") {
                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", passwordTextView10.getText());
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(MainActivity.this, "Text copied to Clipboard", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Please generate a password first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // unsure what that is
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    // checkBox method
    public void isCheckedMethod() {
        selectedCharacters = "";
        if (checkBoxBigLetters.isChecked() == true)
            selectedCharacters = selectedCharacters + bigLetters;
        if (checkBoxSmallLetters.isChecked() == true)
            selectedCharacters = selectedCharacters + smallLetters;
        if (checkBoxNumbers.isChecked() == true)
            selectedCharacters = selectedCharacters + numbers;
        if (checkBoxSpecialCharacters.isChecked() == true)
            selectedCharacters = selectedCharacters + specialCharacters;
    }

    // password generation
    public void passwordGenerationAndDisplay() {
        password = "";
        if (selectedCharacters != "") {
            password = "";
            while (password.length() < passwordLength) {
                selectedCharactersArray = selectedCharacters.toCharArray();
                int tempIndex = new Random().nextInt(selectedCharactersArray.length);
                char tempChar = selectedCharactersArray[tempIndex];
                password = password + tempChar;
                passwordTextView1.setText(password);
            }
            password = "";
            while (password.length() < passwordLength) {
                selectedCharactersArray = selectedCharacters.toCharArray();
                int tempIndex = new Random().nextInt(selectedCharactersArray.length);
                char tempChar = selectedCharactersArray[tempIndex];
                password = password + tempChar;
                passwordTextView2.setText(password);
            }password = "";
            while (password.length() < passwordLength) {
                selectedCharactersArray = selectedCharacters.toCharArray();
                int tempIndex = new Random().nextInt(selectedCharactersArray.length);
                char tempChar = selectedCharactersArray[tempIndex];
                password = password + tempChar;
                passwordTextView3.setText(password);
            }password = "";
            while (password.length() < passwordLength) {
                selectedCharactersArray = selectedCharacters.toCharArray();
                int tempIndex = new Random().nextInt(selectedCharactersArray.length);
                char tempChar = selectedCharactersArray[tempIndex];
                password = password + tempChar;
                passwordTextView4.setText(password);
            }password = "";
            while (password.length() < passwordLength) {
                selectedCharactersArray = selectedCharacters.toCharArray();
                int tempIndex = new Random().nextInt(selectedCharactersArray.length);
                char tempChar = selectedCharactersArray[tempIndex];
                password = password + tempChar;
                passwordTextView5.setText(password);
            }password = "";
            while (password.length() < passwordLength) {
                selectedCharactersArray = selectedCharacters.toCharArray();
                int tempIndex = new Random().nextInt(selectedCharactersArray.length);
                char tempChar = selectedCharactersArray[tempIndex];
                password = password + tempChar;
                passwordTextView6.setText(password);
            }password = "";
            while (password.length() < passwordLength) {
                selectedCharactersArray = selectedCharacters.toCharArray();
                int tempIndex = new Random().nextInt(selectedCharactersArray.length);
                char tempChar = selectedCharactersArray[tempIndex];
                password = password + tempChar;
                passwordTextView7.setText(password);
            }password = "";
            while (password.length() < passwordLength) {
                selectedCharactersArray = selectedCharacters.toCharArray();
                int tempIndex = new Random().nextInt(selectedCharactersArray.length);
                char tempChar = selectedCharactersArray[tempIndex];
                password = password + tempChar;
                passwordTextView8.setText(password);
            }password = "";
            while (password.length() < passwordLength) {
                selectedCharactersArray = selectedCharacters.toCharArray();
                int tempIndex = new Random().nextInt(selectedCharactersArray.length);
                char tempChar = selectedCharactersArray[tempIndex];
                password = password + tempChar;
                passwordTextView9.setText(password);
            }password = "";
            while (password.length() < passwordLength) {
                selectedCharactersArray = selectedCharacters.toCharArray();
                int tempIndex = new Random().nextInt(selectedCharactersArray.length);
                char tempChar = selectedCharactersArray[tempIndex];
                password = password + tempChar;
                passwordTextView10.setText(password);
            }
            passwordLength = passwordLengthSeekBar.getProgress() + 5;
        }
        else {
            Toast.makeText(MainActivity.this, "Please select characters from which password will be generated", Toast.LENGTH_SHORT).show();
        }
    }
}

/**
        while (password.length() <= 6) {
            int tempIndex = new Random().nextInt(alphabetArray.length);
            char tempChar = alphabetArray[tempIndex];
            password = password + tempChar;

        }
 */
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
/**
    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://org.example.paweljezierski.passwordgenerator/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://org.example.paweljezierski.passwordgenerator/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
*/
