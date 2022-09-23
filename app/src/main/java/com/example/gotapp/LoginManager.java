package com.example.gotapp;

import android.content.Context;
import android.database.SQLException;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;

public class LoginManager {
    private static LoginManager instancia;
    Dao<Login, Integer> dao;

    public LoginManager(Context context) {
        OrmLiteSqliteOpenHelper helper = OpenHelperManager.getHelper(context, DBHelper.class);
        try{
            dao = helper.getDao(Login.class);
        } catch (SQLException | java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<Login, Integer> getDao() {
        return dao;
    }

    public void setDao(Dao<Login, Integer> dao) {
        this.dao = dao;
    }

    public static LoginManager getInstancia(Context context) {
        if(instancia == null) {
            instancia = new LoginManager(context);
        }
        return instancia;
    }

    public int getLogin(String usuario, String password) throws Exception {
        return dao.executeRaw("SELECT usuario, password WHERE usuario =" + usuario + "AND password=" + password + "LIMIT 1");
    }

    public void agregarLogin(Login login) throws Exception {
        dao.create(login);
    }
}
