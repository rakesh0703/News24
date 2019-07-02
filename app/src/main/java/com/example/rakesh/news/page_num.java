package com.example.rakesh.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class page_num extends AppCompatActivity {
    private Button btn;
    private EditText edittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_num);
        btn = (Button) findViewById(R.id.btn_finish);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edittext = (EditText) findViewById(R.id.pagenum_get);
               String pagenumber = edittext.getText().toString();
                Intent i = new Intent(page_num.this,MainActivity.class);
                i.putExtra("pagenum",pagenumber);
                setResult(RESULT_OK,i);
                finish();

            }
        });
    }

}
