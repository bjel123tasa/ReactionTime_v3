package com.example.reactiontime_v1;

import android.database.Cursor;
import androidx.collection.LongSparseArray;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __deletionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __updateAdapterOfUser;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `users` (`id`,`name`,`mean`,`std`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getMean() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindDouble(3, value.getMean());
        }
        if (value.getStd() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getStd());
        }
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `users` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `users` SET `id` = ?,`name` = ?,`mean` = ?,`std` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getMean() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindDouble(3, value.getMean());
        }
        if (value.getStd() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getStd());
        }
        stmt.bindLong(5, value.getId());
      }
    };
  }

  @Override
  public void insert(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<UserWithTimeReaction>> getAll() {
    final String _sql = "SELECT * FROM users";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"timeReaction","users"}, true, new Callable<List<UserWithTimeReaction>>() {
      @Override
      public List<UserWithTimeReaction> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfMean = CursorUtil.getColumnIndexOrThrow(_cursor, "mean");
            final int _cursorIndexOfStd = CursorUtil.getColumnIndexOrThrow(_cursor, "std");
            final LongSparseArray<ArrayList<TimeReaction>> _collectionTimeReactions = new LongSparseArray<ArrayList<TimeReaction>>();
            while (_cursor.moveToNext()) {
              if (!_cursor.isNull(_cursorIndexOfId)) {
                final long _tmpKey = _cursor.getLong(_cursorIndexOfId);
                ArrayList<TimeReaction> _tmpTimeReactionsCollection = _collectionTimeReactions.get(_tmpKey);
                if (_tmpTimeReactionsCollection == null) {
                  _tmpTimeReactionsCollection = new ArrayList<TimeReaction>();
                  _collectionTimeReactions.put(_tmpKey, _tmpTimeReactionsCollection);
                }
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshiptimeReactionAscomExampleReactiontimeV1TimeReaction(_collectionTimeReactions);
            final List<UserWithTimeReaction> _result = new ArrayList<UserWithTimeReaction>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final UserWithTimeReaction _item;
              final User _tmpUser;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfMean) && _cursor.isNull(_cursorIndexOfStd))) {
                _tmpUser = new User();
                final int _tmpId;
                _tmpId = _cursor.getInt(_cursorIndexOfId);
                _tmpUser.setId(_tmpId);
                final String _tmpName;
                _tmpName = _cursor.getString(_cursorIndexOfName);
                _tmpUser.setName(_tmpName);
                final Double _tmpMean;
                if (_cursor.isNull(_cursorIndexOfMean)) {
                  _tmpMean = null;
                } else {
                  _tmpMean = _cursor.getDouble(_cursorIndexOfMean);
                }
                _tmpUser.setMean(_tmpMean);
                final Double _tmpStd;
                if (_cursor.isNull(_cursorIndexOfStd)) {
                  _tmpStd = null;
                } else {
                  _tmpStd = _cursor.getDouble(_cursorIndexOfStd);
                }
                _tmpUser.setStd(_tmpStd);
              }  else  {
                _tmpUser = null;
              }
              ArrayList<TimeReaction> _tmpTimeReactionsCollection_1 = null;
              if (!_cursor.isNull(_cursorIndexOfId)) {
                final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfId);
                _tmpTimeReactionsCollection_1 = _collectionTimeReactions.get(_tmpKey_1);
              }
              if (_tmpTimeReactionsCollection_1 == null) {
                _tmpTimeReactionsCollection_1 = new ArrayList<TimeReaction>();
              }
              _item = new UserWithTimeReaction();
              _item.user = _tmpUser;
              _item.timeReactions = _tmpTimeReactionsCollection_1;
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  private void __fetchRelationshiptimeReactionAscomExampleReactiontimeV1TimeReaction(
      final LongSparseArray<ArrayList<TimeReaction>> _map) {
    if (_map.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      LongSparseArray<ArrayList<TimeReaction>> _tmpInnerMap = new LongSparseArray<ArrayList<TimeReaction>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), _map.valueAt(_mapIndex));
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshiptimeReactionAscomExampleReactiontimeV1TimeReaction(_tmpInnerMap);
          _tmpInnerMap = new LongSparseArray<ArrayList<TimeReaction>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshiptimeReactionAscomExampleReactiontimeV1TimeReaction(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `reactionId`,`times`,`user_id` FROM `timeReaction` WHERE `user_id` IN (");
    final int _inputSize = _map.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int i = 0; i < _map.size(); i++) {
      long _item = _map.keyAt(i);
      _stmt.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "user_id");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfReactionId = CursorUtil.getColumnIndex(_cursor, "reactionId");
      final int _cursorIndexOfTimes = CursorUtil.getColumnIndex(_cursor, "times");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndex(_cursor, "user_id");
      while(_cursor.moveToNext()) {
        if (!_cursor.isNull(_itemKeyIndex)) {
          final long _tmpKey = _cursor.getLong(_itemKeyIndex);
          ArrayList<TimeReaction> _tmpRelation = _map.get(_tmpKey);
          if (_tmpRelation != null) {
            final TimeReaction _item_1;
            _item_1 = new TimeReaction();
            if (_cursorIndexOfReactionId != -1) {
              final int _tmpReactionId;
              _tmpReactionId = _cursor.getInt(_cursorIndexOfReactionId);
              _item_1.setReactionId(_tmpReactionId);
            }
            if (_cursorIndexOfTimes != -1) {
              final String _tmpTimes;
              _tmpTimes = _cursor.getString(_cursorIndexOfTimes);
              _item_1.setTimes(_tmpTimes);
            }
            if (_cursorIndexOfUserId != -1) {
              final int _tmpUser_id;
              _tmpUser_id = _cursor.getInt(_cursorIndexOfUserId);
              _item_1.setUser_id(_tmpUser_id);
            }
            _tmpRelation.add(_item_1);
          }
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
