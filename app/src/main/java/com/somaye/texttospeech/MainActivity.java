package com.somaye.texttospeech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.somaye.texttospeech.databinding.ActivityMainBinding;
import java.security.KeyStore;
import java.util.Locale;
//---------------------------------------------------------------------------------------------------------
public class MainActivity extends AppCompatActivity {
//---------------------------------------------------------------------------------------------------------
EditText editTxt;
TextToSpeech textToSpeech;
Button btn ;
ActivityMainBinding binding;
//---------------------------------------------------------------------------------------------------------
@Override
protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    editTxt = binding.edittxt;
    btn =  binding.btn;
    textToSpeech = new TextToSpeech(getApplicationContext(), status -> {
        if (status ==TextToSpeech.SUCCESS)
        {
            int language = textToSpeech.setLanguage(Locale.ENGLISH);
        }
    });

    btn.setOnClickListener(v -> {
        String s = editTxt.getText().toString();
        int speech  =  textToSpeech.speak(s, textToSpeech.QUEUE_FLUSH , null);
    });
}
//---------------------------------------------------------------------------------------------------------
}