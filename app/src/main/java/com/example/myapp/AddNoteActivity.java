package com.example.myapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AddNoteActivity extends AppCompatActivity {
    public static final String EXTRA_TITLE = "com.glory.notetakingapproomdb.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION = "com.glory.notetakingapproomdb.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY = "com.glory.notetakingapproomdb.EXTRA_PRIORITY";

    private EditText editTextTitle;
    private EditText editTextDescription;
    private NumberPicker numberPickerPriority;
    private EditText mDateEditText;
    private EditText mTimeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        numberPickerPriority = findViewById(R.id.number_picker_priority);

        numberPickerPriority.setMinValue(1);
        numberPickerPriority.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_close_24);
        setTitle("Add Note");

//        mDateEditText = findViewById(R.id.newTodoDateEditText);
//        mTimeEditText = findViewById(R.id.newTodoTimeEditText);
//
//        mDateEditText.setOnClickListener(new View.OnClickListener(){
//
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onClick(View v) {
//                final Calendar cldr = Calendar.getInstance();
//                int day = cldr.get(Calendar.DAY_OF_MONTH);
//                int month = cldr.get(Calendar.MONTH);
//                int year = cldr.get(Calendar.YEAR);
//
//                DatePicker picker = new DatePickerDialog(MainActivity.this,
//                        new DatePickerDialog.OnDateSetListener(){
//
//                            @Override
//                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                                mDateEditText.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
//
//                            }
//                        }, year, month, day);
//                picker.show();
//            }
//        });

    }


    public void saveNote(){
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        int priority = numberPickerPriority.getValue();

        if(title.trim().isEmpty() || description.trim().isEmpty()){
            Toast.makeText(this, "Please insert a title and description", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_PRIORITY, priority);

        setResult(RESULT_OK, data);
        finish();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
