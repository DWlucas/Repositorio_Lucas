package davila.lucas.uno.morintegracaocomjava.database_app;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executors;

import davila.lucas.uno.morintegracaocomjava.database_app.converter.Converters;

@TypeConverters({Converters.class})
public abstract class DatabaseApp extends RoomDatabase {
    private static final String DB_NAME = "db_app.db";
    private static volatile DatabaseApp sInstance;

    public DatabaseApp() {
    }

    public static synchronized DatabaseApp getInstance(Context context){
        return null;
    }

    private static DatabaseApp getConnection(Context contextActivity){
        return null;
    }

    static RoomDatabase.Callback initDB = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Executors.newSingleThreadScheduledExecutor().execute(() -> {
                //Executar métodos e\ou rotinas logo após a criaão do banco
                Log.d(TAG, "Banco criado com sucesso! Executar rotinas posteriores. ");
            });
        }

        @Override
        public void onOpen(SupportSQLiteDatabase db) {
        }
    };
}
