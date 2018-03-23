package cn.hnshangyu.testgreendao.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

import cn.hnshangyu.testgreendao.greendao.DaoMaster;
import cn.hnshangyu.testgreendao.greendao.StudentDao;

public class MyOpenHelper extends DaoMaster.OpenHelper {

    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    /**
     * 数据库升级
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        //操作数据库的更新 有几个表升级都可以传入到下面
        Log.e("kkk","oldVersion---- "+oldVersion+" newVersion "+newVersion);
        if (oldVersion < newVersion) {
           Log.e("kkk","升级------------------");
            MigrationHelper.getInstance().migrate(db, StudentDao.class);
        }
    }
}