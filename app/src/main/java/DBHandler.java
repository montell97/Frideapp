import android.database.sqlite.SQLiteDatabase;

import java.io.Closeable;

/**
 * Created by montell on 26/07/2018.
 */

interface DBHandler extends Closeable {
    //creating Tables
    void onCreate(SQLiteDatabase db);
}
