package com.example.intentexample2

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri


object IntentHandler {
    fun onFacebookButtonClick(context: Context) {
        val facebookUrl = "https://www.facebook.com/" // Replace with your Facebook page URL

        // Check if Facebook app is installed
        val packageManager: PackageManager = context.packageManager
        val intent = Intent(Intent.ACTION_VIEW)
        try {
            val facebookAppId = packageManager.getApplicationInfo("com.facebook.katana", 0).processName
            if (facebookAppId != null) {
                intent.data = Uri.parse("fb://facewebmodal/f?href=$facebookUrl")
            }
        } catch (e: PackageManager.NameNotFoundException) {
            // Facebook app is not installed, open in browser
            intent.data = Uri.parse(facebookUrl)
        }

        // Pass context to startActivity()
        context.startActivity(intent)
    }
    fun onInstagramButtonClick(context: Context) {
        val instagramUrl = "https://www.instagram.com/" // Replace with your Instagram page URL

        // Check if Instagram app is installed
        val packageManager: PackageManager = context.packageManager
        val intent = Intent(Intent.ACTION_VIEW)
        try {
            val instagramAppId = packageManager.getApplicationInfo("com.instagram.android", 0).processName
            if (instagramAppId != null) {
                intent.data = Uri.parse("http://instagram.com/_u/$instagramUrl")
            }
        } catch (e: PackageManager.NameNotFoundException) {
            // Instagram app is not installed, open in browser
            intent.data = Uri.parse(instagramUrl)
        }

        // Pass context to startActivity()
        context.startActivity(intent)
    }
    fun onTwitterButtonClick(context: Context) {
        val twitterUrl = "https://www.x.com/" // Replace with your Twitter page URL

        // Check if Twitter app is installed
        val packageManager: PackageManager = context.packageManager
        val intent = Intent(Intent.ACTION_VIEW)
        try {
            val twitterAppId = packageManager.getApplicationInfo("com.x.android", 0).processName
            if (twitterAppId != null) {
                intent.data = Uri.parse("twitter://user?screen_name=$twitterUrl")
            }
        } catch (e: PackageManager.NameNotFoundException) {
            // Twitter app is not installed, open in browser
            intent.data = Uri.parse(twitterUrl)
        }

        // Pass context to startActivity()
        context.startActivity(intent)
    }
    fun onGoogleButtonClick(context: Context) {
        val googleUrl = "https://www.google.com/" // Replace with your Google page URL

        // Check if Google app is installed
        val packageManager: PackageManager = context.packageManager
        val intent = Intent(Intent.ACTION_VIEW)
        try {
            val googleAppId = packageManager.getApplicationInfo("com.google.android.googlequicksearchbox", 0).processName
            if (googleAppId != null) {
                intent.data = Uri.parse("https://www.google.com/")
            }
        } catch (e: PackageManager.NameNotFoundException) {
            // Google app is not installed, open in browser
            intent.data = Uri.parse(googleUrl)
        }

        // Pass context to startActivity()
        context.startActivity(intent)
    }
    fun onCameraButtonClick(context: Context) {
        val intent = Intent("android.media.action.IMAGE_CAPTURE")
        context.startActivity(intent)
    }
    fun onPhotosButtonClick(context: Context) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.type = "image/*"
        context.startActivity(intent)
    }
}