package com.test.provider

import android.content.ContentProvider
import android.content.ContentUris
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import androidx.room.Room
import com.test.provider.db.AppDatabase
import com.test.provider.db.dao.PersonDAO
import com.test.provider.db.entities.PersonEntity
import com.test.provider.db.entities.fromContentValues
import javax.annotation.Nullable

class MyProvider : ContentProvider() {
    companion object {
        //codigo aqui

    }
    val appDatabase by lazy {
        context?.let {
            Room.databaseBuilder(
                it,
                AppDatabase::class.java,
                "MyDataBase"
            ).fallbackToDestructiveMigration().build()
        }
    }

    override fun onCreate(): Boolean {
        return true
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String?>?
    ): Int {
        return -1
        //codigo aqui
    }

    override fun delete(
        uri: Uri, selection: String?,
        selectionArgs: Array<String?>?
    ): Int {
        return -1
        //codigo aqui
    }


    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        //codigo aqui
        return null
    }

    @Nullable
    override fun query(
        uri: Uri, @Nullable projection: Array<String>?, @Nullable selection: String?,
        @Nullable selectionArgs: Array<String>?, @Nullable sortOrder: String?
    ): Cursor? {
        return null
        //codigo aqui
    }

    @Nullable
    override fun getType(uri: Uri): String? {
        return null
        //codigo aqui
    }
}