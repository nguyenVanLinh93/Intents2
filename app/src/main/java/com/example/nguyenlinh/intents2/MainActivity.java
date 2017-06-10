package com.example.nguyenlinh.intents2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * make uri and pass values
     *
     * @param clickButon
     */
    public void passParammenterbyURI(View clickButon) {
        String adress = makeInput();
        Uri uri = Uri.parse(adress);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    /**
     * make adress and param
     *
     * @return adress
     */
    private String makeInput() {
        EditText xEdit = (EditText) findViewById(R.id.editX);
        Editable xText = xEdit.getText();
        String xParam = String.format("x=%s", xText);

        EditText yEdit = (EditText) findViewById(R.id.editY);
        Editable yText = yEdit.getText();
        String yParam = String.format("y=%s", yText);

        String baseAdress = "sum://example.com/add";
        String adress = String.format("%s?%s&%s", baseAdress, xParam, yParam); // phan tach cac param phai cos dau &
        return adress;
    }
}
