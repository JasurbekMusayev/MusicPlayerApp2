package com.example.musicplayerapp2.utils

import android.content.ContentResolver
import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import android.util.Log

// Function to fetch music files
fun fetchMusic(context: Context): List<MusicFile> {
    val musicList = mutableListOf<MusicFile>()

    // Define the columns you want to retrieve
    val projection = arrayOf(
        MediaStore.Audio.Media._ID,
        MediaStore.Audio.Media.TITLE,
        MediaStore.Audio.Media.ARTIST,
        MediaStore.Audio.Media.ALBUM,
        MediaStore.Audio.Media.DURATION,
        MediaStore.Audio.Media.DATA // Path to the actual file
    )

    // Get the content resolver
    val contentResolver: ContentResolver = context.contentResolver

    // Define the URI to query the external music content
    val uri: Uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI

    // Query external music content
    val cursor: Cursor? = contentResolver.query(
        uri,
        projection,
        null,
        null,
        null
    )

    cursor?.use { cursor ->
        val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID)
        val titleColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)
        val artistColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)
        val albumColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM)
        val durationColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION)
        val pathColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)

        while (cursor.moveToNext()) {
            val id = cursor.getLong(idColumn)
            val title = cursor.getString(titleColumn)
            val artist = cursor.getString(artistColumn)
            val album = cursor.getString(albumColumn)
            val duration = cursor.getLong(durationColumn)
            val path = cursor.getString(pathColumn)

            val contentUri: Uri = ContentUris.withAppendedId(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                id
            )

            val musicFile = MusicFile(id, title, artist, album, duration, path, contentUri)
            musicList.add(musicFile)
        }
    }
    Log.e("MUSICDATA", "fetchMusic: $musicList")
    return musicList
}

// Data class to represent a music file
data class MusicFile(
    val id: Long,
    val title: String,
    val artist: String,
    val album: String,
    val duration: Long,
    val path: String,
    val contentUri: Uri
)

// Example usage:
// val musicList = fetchMusic(context)
// Now you have a list of music files to work with
