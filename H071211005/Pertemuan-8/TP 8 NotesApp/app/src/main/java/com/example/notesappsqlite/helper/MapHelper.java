package com.example.notesappsqlite.helper;

import android.database.Cursor;

import com.example.notesappsqlite.data.db.DatabaseContract;
import com.example.notesappsqlite.data.model.Note;

import java.util.ArrayList;

public class MapHelper {
    public static ArrayList<Note> mapCursorToArrayList(Cursor notesCursor) {
        ArrayList<Note> notesList = new ArrayList<>();

        while (notesCursor.moveToNext()) {
            int id = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID));
            String title = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE));
            String description = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION));
            String date = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE));

            notesList.add(new Note(id, title, description, date));
        }

        return notesList;
    }
}