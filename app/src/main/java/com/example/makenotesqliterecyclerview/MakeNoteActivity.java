package com.example.makenotesqliterecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MakeNoteActivity extends AppCompatActivity {
    EditText tv_title, tv_Context;
    Button btn_save, btn_Delete, btn_Clear;
    DbManager dbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_note);

        tv_Context = findViewById(R.id.tv_Context);
        tv_title = findViewById(R.id.tv_title);
        btn_Clear = findViewById(R.id.btn_Clear);
        btn_Delete = findViewById(R.id.btn_Delete);
        btn_save = findViewById(R.id.btn_save);


        dbm = new DbManager(this);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sTitle = tv_title.getText().toString();
                String sContext = tv_Context.getText().toString();

                Text txtt = new Text();
                txtt.tTitle = sTitle;
                txtt.tContext = sContext;
                dbm.insertText(txtt);
                Toast.makeText(MakeNoteActivity.this, "Ok", Toast.LENGTH_SHORT).show();

            }
        });

    }

}
