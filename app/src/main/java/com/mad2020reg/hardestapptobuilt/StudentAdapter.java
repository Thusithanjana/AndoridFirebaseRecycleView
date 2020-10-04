package com.mad2020reg.hardestapptobuilt;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;



import org.w3c.dom.Text;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private List<Student> mDataset;
    private Context context;
    private static final String TAG = "StudentAdapter";

    public static class StudentViewHolder extends RecyclerView.ViewHolder{

        public CardView cardView;

        public StudentViewHolder(@NonNull CardView v) {
            super(v);
            cardView = v;
        }
    }

    public StudentAdapter (List<Student> myDataset){
        mDataset = myDataset;
    }

    @NonNull
    @Override
    public StudentAdapter.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // create a new view
        CardView v = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        context = parent.getContext();

        StudentViewHolder vh = new StudentViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.StudentViewHolder holder, int position) {
        //holder.textView.setText(mDataset[position]);
//        TextView name = new TextView(context);
//        name.setText(mDataset.get(position).getStudentName());
//        TextView id = new TextView(context);
//        id.setText(mDataset.get(position).getStudentId());
//        TextView email = new TextView(context);
//        email.setText(mDataset.get(position).getEmail());
//        TextView phone = new TextView(context);
//        phone.setText(mDataset.get(position).getPhoneNo());


        ConstraintLayout layout = (ConstraintLayout) holder.cardView.getChildAt(0);
        Log.i(TAG, "onBindViewHolder: "+layout);
        TextView tvName = (TextView) layout.getChildAt(0);
        TextView tvId = (TextView) layout.getChildAt(1);
        TextView tvEmail = (TextView) layout.getChildAt(2);
        TextView tvPhone = (TextView) layout.getChildAt(3);

        tvName.setText(mDataset.get(position).getStudentName());
        tvId.setText(mDataset.get(position).getStudentId());
        tvEmail.setText(mDataset.get(position).getEmail());
        tvPhone.setText(mDataset.get(position).getPhoneNo());

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
