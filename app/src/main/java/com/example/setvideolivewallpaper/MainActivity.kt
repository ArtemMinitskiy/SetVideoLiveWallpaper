package com.example.setvideolivewallpaper

import android.app.WallpaperManager
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.text)
        textView!!.setOnClickListener {
            val intent = Intent()
            intent.action = WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER
            val pkg: String = VideoLiveWallpaperService::class.java.getPackage().name
            val cls: String = VideoLiveWallpaperService::class.java.canonicalName
            intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT, ComponentName(pkg, cls))
            startActivityForResult(intent, 0)
        }
    }
}