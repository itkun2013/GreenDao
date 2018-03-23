package cn.hnshangyu.testgreendao;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.hnshangyu.testgreendao.adapter.MyAdapter;
import cn.hnshangyu.testgreendao.bean.Student;
import cn.hnshangyu.testgreendao.db.StudentDaoOpe;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.add)
    Button add;
    @InjectView(R.id.delete)
    Button delete;
    @InjectView(R.id.updata)
    Button updata;
    @InjectView(R.id.check)
    Button check;
    @InjectView(R.id.deleteAll)
    Button deleteAll;
    @InjectView(R.id.check_id)
    Button checkId;
    @InjectView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private Context mContext;
    private Student student;
    private List<Student> studentsList;
    private LinearLayoutManager manager;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        mContext = this;
        initData();
        initView();
        initListener();

    }

    private void initView() {
        studentsList = StudentDaoOpe.queryAll(mContext);
        mAdapter = new MyAdapter(mContext, studentsList);
        mRecyclerView.setAdapter(mAdapter);
    }

    private List<Student> studentList = new ArrayList<>();

    /**
     * 初始化数据
     */
    private void initData() {

        manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);

        for (int i = 0; i < 4; i++) {
            student = new Student((long) i, "ppp--9999 " + i, 25);
            studentList.add(student);
            StudentDaoOpe.saveData(mContext, student);
        }
    }

    private void initListener() {
        //增删改查
        CRUDListener();


    }

    private void CRUDListener() {
        /**
         *增
         */
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentDaoOpe.insertData(mContext, new Student(null,"liangkun",27));
                initView();
            }
        });
        /**
         * 删
         */
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student((long) 5, "haung" + 5, 25);
                /**
                 * 根据特定的对象删除
                 */
                StudentDaoOpe.deleteData(mContext, student);
                /**
                 * 根据主键删除
                 */
                StudentDaoOpe.deleteByKeyData(mContext, 7);
                initView();
            }
        });
        /**
         *删除所有
         */
        deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentDaoOpe.deleteAllData(mContext);
                initView();
            }
        });
        /**
         * 更新
         */
        updata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student((long) 2, "haungxiaoguo", 16516);
                StudentDaoOpe.updateData(mContext, student);
                initView();
            }
        });
        /**
         * 查询全部
         */
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Student> students = StudentDaoOpe.queryAll(mContext);
                for (int i = 0; i < students.size(); i++) {
                    Log.i("Log", students.get(i).getName());
                }
                initView();
            }
        });
        /**
         * 根据id查询
         */
        checkId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Student> students = StudentDaoOpe.queryForId(mContext, 50);
                for (int i = 0; i < students.size(); i++) {
                    Log.i("Log", students.get(i).getName());
                }
                initView();
            }
        });
    }
}
