package com.nearby.evassist.data.local;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class POIDao_Impl implements POIDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<POIEntity> __insertionAdapterOfPOIEntity;

  public POIDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPOIEntity = new EntityInsertionAdapter<POIEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `poi` (`uid`,`id`,`name`,`category`,`distanceKm`,`timestamp`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, POIEntity value) {
        stmt.bindLong(1, value.uid);
        if (value.id == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.id);
        }
        if (value.name == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.name);
        }
        if (value.category == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.category);
        }
        stmt.bindDouble(5, value.distanceKm);
        stmt.bindLong(6, value.timestamp);
      }
    };
  }

  @Override
  public void insert(final POIEntity poi) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPOIEntity.insert(poi);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<POIEntity> getAll() {
    final String _sql = "SELECT * FROM poi ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfDistanceKm = CursorUtil.getColumnIndexOrThrow(_cursor, "distanceKm");
      final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
      final List<POIEntity> _result = new ArrayList<POIEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final POIEntity _item;
        _item = new POIEntity();
        _item.uid = _cursor.getLong(_cursorIndexOfUid);
        if (_cursor.isNull(_cursorIndexOfId)) {
          _item.id = null;
        } else {
          _item.id = _cursor.getString(_cursorIndexOfId);
        }
        if (_cursor.isNull(_cursorIndexOfName)) {
          _item.name = null;
        } else {
          _item.name = _cursor.getString(_cursorIndexOfName);
        }
        if (_cursor.isNull(_cursorIndexOfCategory)) {
          _item.category = null;
        } else {
          _item.category = _cursor.getString(_cursorIndexOfCategory);
        }
        _item.distanceKm = _cursor.getDouble(_cursorIndexOfDistanceKm);
        _item.timestamp = _cursor.getLong(_cursorIndexOfTimestamp);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
