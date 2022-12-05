package com.example.androidcrudwithsqlite.Class;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidcrudwithsqlite.MainActivity;
import com.example.androidcrudwithsqlite.R;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ViewCourses extends AppCompatActivity {


    private ArrayList<CourseModal> courseModalArrayList;
    private DBHandler dbHandler;
    private CourseRVAdapter courseRVAdapter;
    private RecyclerView coursesRV;
    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_courses);


        addBtn = findViewById(R.id.idBtnaddCourse);
        courseModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewCourses.this);


        courseModalArrayList = dbHandler.readCourses();


        courseRVAdapter = new CourseRVAdapter(courseModalArrayList, ViewCourses.this);
        coursesRV = findViewById(R.id.idRVCourses);


        LinearLayoutManager linearLayoutManager = new
                LinearLayoutManager(ViewCourses.this, RecyclerView.VERTICAL, false);
        coursesRV.setLayoutManager(linearLayoutManager);


        coursesRV.setAdapter(courseRVAdapter);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewCourses.this, MainActivity.class );
                startActivity(intent);
            }
        });
    }
}