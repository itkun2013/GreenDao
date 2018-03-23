package cn.hnshangyu.testgreendao.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import cn.hnshangyu.testgreendao.bean.Student;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "STUDENT".
*/
public class StudentDao extends AbstractDao<Student, Long> {

    public static final String TABLENAME = "STUDENT";

    /**
     * Properties of entity Student.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Age = new Property(2, int.class, "age", false, "AGE");
        public final static Property Num = new Property(3, String.class, "num", false, "NUM");
        public final static Property Shell = new Property(4, String.class, "shell", false, "SHELL");
        public final static Property Height = new Property(5, Double.class, "height", false, "HEIGHT");
        public final static Property Weight = new Property(6, String.class, "weight", false, "WEIGHT");
        public final static Property HealthNo = new Property(7, String.class, "healthNo", false, "HEALTH_NO");
    }


    public StudentDao(DaoConfig config) {
        super(config);
    }
    
    public StudentDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"STUDENT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"AGE\" INTEGER NOT NULL ," + // 2: age
                "\"NUM\" TEXT," + // 3: num
                "\"SHELL\" TEXT," + // 4: shell
                "\"HEIGHT\" REAL," + // 5: height
                "\"WEIGHT\" TEXT," + // 6: weight
                "\"HEALTH_NO\" TEXT);"); // 7: healthNo
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"STUDENT\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Student entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        stmt.bindLong(3, entity.getAge());
 
        String num = entity.getNum();
        if (num != null) {
            stmt.bindString(4, num);
        }
 
        String shell = entity.getShell();
        if (shell != null) {
            stmt.bindString(5, shell);
        }
 
        Double height = entity.getHeight();
        if (height != null) {
            stmt.bindDouble(6, height);
        }
 
        String weight = entity.getWeight();
        if (weight != null) {
            stmt.bindString(7, weight);
        }
 
        String healthNo = entity.getHealthNo();
        if (healthNo != null) {
            stmt.bindString(8, healthNo);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Student entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        stmt.bindLong(3, entity.getAge());
 
        String num = entity.getNum();
        if (num != null) {
            stmt.bindString(4, num);
        }
 
        String shell = entity.getShell();
        if (shell != null) {
            stmt.bindString(5, shell);
        }
 
        Double height = entity.getHeight();
        if (height != null) {
            stmt.bindDouble(6, height);
        }
 
        String weight = entity.getWeight();
        if (weight != null) {
            stmt.bindString(7, weight);
        }
 
        String healthNo = entity.getHealthNo();
        if (healthNo != null) {
            stmt.bindString(8, healthNo);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Student readEntity(Cursor cursor, int offset) {
        Student entity = new Student();
        readEntity(cursor, entity, offset);
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Student entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAge(cursor.getInt(offset + 2));
        entity.setNum(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setShell(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setHeight(cursor.isNull(offset + 5) ? null : cursor.getDouble(offset + 5));
        entity.setWeight(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setHealthNo(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Student entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Student entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Student entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
