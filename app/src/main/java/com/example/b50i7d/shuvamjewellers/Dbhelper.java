package com.example.b50i7d.shuvamjewellers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;

/**
 * Created by B50i7D on 9/3/2016.
 */
public class Dbhelper extends SQLiteOpenHelper {
    static String dbname ="database";
    static int version = 1;
//if not exists`users`
    String createTableUserSql = "CREATE TABLE if not exists`users` (\n" +
        "\t`name`\tTEXT,\n" +
        "\t`address`\tTEXT,\n" +
        "\t`pan_no`\tINTEGER,\n" +
        "\t`no`\tINTEGER,\n" +
        "\t`id`\tINTEGER,\n" +
        "\t`date`\tINTEGER,\n" +
        "\t`order_date`\tINTEGER,\n" +
        "\t`particular`\tTEXT,\n" +
        "\t`weight`\tINTEGER,\n" +
        "\t`wastage`\tINTEGER,\n" +
        "\t`making`\tINTEGER,\n" +
        "\t`discount`\tINTEGER,\n" +
        "\t`total`\tINTEGER,\n" +
        "\t`rate`\tINTEGER\n" +
        ")";
    public Dbhelper(Context context) {
        super(context, dbname, null, version);

        getWritableDatabase().execSQL(createTableUserSql);
    }
    public void insertUser(ContentValues cv){
        if(isUserAlreadyInserted(cv.getAsString("pan_no")))
            getWritableDatabase().insert("users","",cv);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public ArrayList<UserInfo> getUserList(){
        ArrayList<UserInfo> list = new ArrayList<UserInfo>();
        String sql = "Select * from users";
        Cursor c =getWritableDatabase().rawQuery(sql,null);
        while (c.moveToNext()){
            UserInfo info = new UserInfo();
            info.pan_no = c.getString(c.getColumnIndex("pan_no"));
            info.name = c.getString(c.getColumnIndex("name"));
            info.address=c.getString(c.getColumnIndex("address"));
            info.no=c.getString(c.getColumnIndex("no"));
            info.weight=c.getString(c.getColumnIndex("weight"));
            info.westage=c.getString(c.getColumnIndex("wastage"));
            info.making=c.getString(c.getColumnIndex("making"));
            info.rate=c.getString(c.getColumnIndex("rate"));
            info.date=c.getString(c.getColumnIndex("date"));
            info.order_date=c.getString(c.getColumnIndex("order_date"));
            info.particular=c.getString(c.getColumnIndex("particular"));
            info.id = c.getString(c.getColumnIndex("id"));
            info.discount = c.getString(c.getColumnIndex("discount"));
            info.total = c.getString(c.getColumnIndex("total"));
            list.add(info);
        }
        c.close();
        return list;
    }
    public void deleteUser(String id){
        getWritableDatabase().delete("users","id="+id,null);
    }

    public boolean isUserAlreadyInserted(String pan_no0){
        String sql="Select count(*) from users where pan_no='"+ pan_no0 +"'";
        SQLiteStatement stm = getWritableDatabase().compileStatement(sql);

        long l = stm.simpleQueryForLong();
        if(l>0){
            return false;
        }
        else
            return true;
    }
}
