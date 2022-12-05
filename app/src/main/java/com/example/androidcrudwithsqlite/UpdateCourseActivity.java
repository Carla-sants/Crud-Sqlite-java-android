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

public class UpdateCourseActivity extends AppCompatActivity {
    private EditText courseNameEdt, courseTracksEdt, courseDurationEdt,
            courseDescriptionEdt;
    private Button updateCourseBtn,deleteCourseBtn;
    private DBHandler dbHandler;
    String courseName, courseDesc, courseDuration, courseTracks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_course);

        courseNameEdt = findViewById(R.id.idEdtCourseName);
        courseTracksEdt = findViewById(R.id.idEdtCourseTracks);
        courseDurationEdt = findViewById(R.id.idEdtCourseDuration);
        courseDescriptionEdt = findViewById(R.id.idEdtCourseDescription);
        updateCourseBtn = findViewById(R.id.idBtnUpdateCourse);
        deleteCourseBtn = findViewById(R.id.idBtnDelete);

        dbHandler = new DBHandler(UpdateCourseActivity.this);


        courseName = getIntent().getStringExtra("name");
        courseDesc = getIntent().getStringExtra("description");
        courseDuration = getIntent().getStringExtra("duration");
        courseTracks = getIntent().getStringExtra("tracks");


        courseNameEdt.setText(courseName);
        courseDescriptionEdt.setText(courseDesc);
        courseTracksEdt.setText(courseTracks);
        courseDurationEdt.setText(courseDuration);

        updateCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dbHandler.updateCourse(courseName, courseNameEdt.getText().toString(),
                        courseDescriptionEdt.getText().toString(), courseTracksEdt.getText().toString(),
                        courseDurationEdt.getText().toString());


                Toast.makeText(UpdateCourseActivity.this, "Patrimônio Atualizado..",
                        Toast.LENGTH_SHORT).show();

                Intent i = new Intent(UpdateCourseActivity.this, ViewCourses.class);
                startActivity(i);
            }
        });

        deleteCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.deleteCourse(courseName);
                Toast.makeText(UpdateCourseActivity.this, "Patrimônio excluído",
                        Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateCourseActivity.this, ViewCourses.class);
                startActivity(i);
            }
        });
    }
}