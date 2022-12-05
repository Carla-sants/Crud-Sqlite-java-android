package com.example.androidcrudwithsqlite.Class;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.androidcrudwithsqlite.R;
import com.example.androidcrudwithsqlite.UpdateCourseActivity;
import java.util.ArrayList;

public class CourseRVAdapter extends RecyclerView.Adapter<CourseRVAdapter.ViewHolder> {
    private ArrayList<CourseModal> courseModalArrayList;
    private Context context;

    public CourseRVAdapter(ArrayList<CourseModal> courseModalArrayList, Context context)
    {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.course_rv_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        CourseModal modal = courseModalArrayList.get(position);
        holder.courseNameTV.setText(modal.getCourseName());
        holder.courseDescTV.setText(modal.getCourseDescription());
        holder.courseDurationTV.setText(modal.getCourseDuration());
        holder.courseTracksTV.setText(modal.getCourseTracks());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, UpdateCourseActivity.class);

                i.putExtra("name", modal.getCourseName());
                i.putExtra("description", modal.getCourseDescription());
                i.putExtra("duration", modal.getCourseDuration());
                i.putExtra("tracks", modal.getCourseTracks());
                // starting our activity.
                context.startActivity(i);
            }
        });
    }
    @Override
    public int getItemCount() {
        return courseModalArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView courseNameTV, courseDescTV, courseDurationTV, courseTracksTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            courseNameTV = itemView.findViewById(R.id.idTVCourseName);
            courseDescTV = itemView.findViewById(R.id.idTVCourseDescription);
            courseDurationTV = itemView.findViewById(R.id.idTVCourseDuration);
            courseTracksTV = itemView.findViewById(R.id.idTVCourseTracks);
            courseNameTV.setBackgroundColor(Color.argb(255, 148, 242, 176));
            courseNameTV.setGravity(Gravity.CENTER);
            courseNameTV.setTextSize(18);
            courseDescTV.setBackgroundColor(Color.argb(255, 125, 201, 148));
            courseDurationTV.setBackgroundColor(Color.argb(255, 90, 145, 107));
            courseDurationTV.setBackgroundColor(Color.argb(255, 50, 50, 5));
            courseDurationTV.setTextColor(Color.argb(255, 255, 255, 255));
            courseDurationTV.setGravity(Gravity.CENTER);
        }
    }
}