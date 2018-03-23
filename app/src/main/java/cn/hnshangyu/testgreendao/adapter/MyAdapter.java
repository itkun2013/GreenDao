package cn.hnshangyu.testgreendao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.hnshangyu.testgreendao.R;
import cn.hnshangyu.testgreendao.bean.Student;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context mContext;
    private List<Student> mStudentsList;

    public MyAdapter(Context context, List<Student> studentsList) {
        this.mContext = context;
        this.mStudentsList = studentsList;
    }

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void OnClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_textview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textview.setText(mStudentsList.get(position).toString());
    }


    @Override
    public int getItemCount() {
        return mStudentsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.textview)
        TextView textview;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }


}