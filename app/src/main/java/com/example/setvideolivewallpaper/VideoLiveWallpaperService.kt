package com.example.setvideolivewallpaper

import android.media.MediaPlayer
import android.service.wallpaper.WallpaperService
import android.view.SurfaceHolder

class VideoLiveWallpaperService : WallpaperService() {

    override fun onCreateEngine(): WallpaperService.Engine {
        return VideoEngine()
    }

    internal inner class VideoEngine : WallpaperService.Engine() {
        private val mediaPlayer: MediaPlayer = MediaPlayer.create(baseContext, R.raw.animate_bg)

        init {
            mediaPlayer.isLooping = true
        }

        override fun onSurfaceCreated(holder: SurfaceHolder) {
            mediaPlayer.setSurface(holder.surface)
            mediaPlayer.start()
        }

        override fun onSurfaceDestroyed(holder: SurfaceHolder) {
            playTime = mediaPlayer.currentPosition
            mediaPlayer.reset()
            mediaPlayer.release()
        }
    }

    companion object {
        private var playTime = 0
    }

}