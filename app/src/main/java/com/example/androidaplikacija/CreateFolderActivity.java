package com.example.androidaplikacija;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class CreateFolderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_folder);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.create_folder_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        String folderName;
        EditText folder_txt = findViewById(R.id.edit_text_FolderName);
        folderName = folder_txt.getText().toString();

        switch (item.getItemId()) {

            case R.id.save_folder:
                if (!TextUtils.isEmpty(folderName)) {
                    Toast.makeText(CreateFolderActivity.this,
                            "Folder saved", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, FoldersActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(CreateFolderActivity.this,
                            "Invalid entry", Toast.LENGTH_SHORT).show();
                }
                return true;

            case R.id.back:
                Intent intent = new Intent(this, FoldersActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }}

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
