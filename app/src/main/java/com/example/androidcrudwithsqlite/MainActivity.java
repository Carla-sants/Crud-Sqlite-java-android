package com.example.androidcrudwithsqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.androidcrudwithsqlite.Class.DBHandler;
import com.example.androidcrudwithsqlite.Class.ViewCourses;

public class MainActivity extends AppCompatActivity {


    private EditText courseNameEdt, courseTracksEdt, courseDurationEdt,
            courseDescriptionEdt;
    private Button addCourseBtn, readCourseBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        courseNameEdt = findViewById(R.id.idEdtCourseName);
        courseTracksEdt = findViewById(R.id.idEdtCourseTracks);
        courseDurationEdt = findViewById(R.id.idEdtCourseDuration);
        courseDescriptionEdt = findViewById(R.id.idEdtCourseDescription);
        addCourseBtn = findViewById(R.id.idBtnAddCourse);
        readCourseBtn = findViewById(R.id.idBtnReadCourse);

        dbHandler = new DBHandler(MainActivity.this);

        addCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String courseName = courseNameEdt.getText().toString();
                String courseTracks = courseTracksEdt.getText().toString();
                String courseDuration = courseDurationEdt.getText().toString();
                String courseDescription = courseDescriptionEdt.getText().toString();

                if (courseName.isEmpty() || (courseTracks.isEmpty() &&
                        courseDuration.isEmpty() && courseDescription.isEmpty())) {
                    Toast.makeText(MainActivity.this, "Por favor, insira todos os dados..",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.addNewCourse(courseName, courseDuration, courseDescription,
                        courseTracks);

                Toast.makeText(MainActivity.this, "Adicionado",
                        Toast.LENGTH_SHORT).show();
                courseNameEdt.setText("");
                courseDurationEdt.setText("");
                courseTracksEdt.setText("");
                courseDescriptionEdt.setText("");
            }
        });

        readCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, ViewCourses.class);
                startActivity(i);
            }
        });
    }
}
