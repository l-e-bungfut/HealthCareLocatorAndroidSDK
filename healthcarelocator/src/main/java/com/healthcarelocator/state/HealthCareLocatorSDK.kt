package com.healthcarelocator.state

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import base.extensions.addFragment
import base.extensions.changeLocale
import base.extensions.pushFragment
import com.healthcarelocator.R
import com.healthcarelocator.activities.HCLActivity
import com.healthcarelocator.error.HCLException
import com.healthcarelocator.extensions.*
import com.healthcarelocator.fragments.home.HCLHomeMainFragment
import com.healthcarelocator.fragments.map.HCLNearMeFragment
import com.healthcarelocator.model.config.HealthCareLocatorCustomObject
import com.healthcarelocator.model.map.HCLPlace
import com.healthcarelocator.service.location.HCLMapService
import com.healthcarelocator.service.location.LocationAPI
import com.healthcarelocator.service.location.LocationClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject
import java.io.IOException

class HealthCareLocatorSDK private constructor() : HealthCareLocatorState {
    private object Instance {
        val instance: HealthCareLocatorState = HealthCareLocatorSDK()
    }

    private var config: HealthCareLocatorCustomObject = HealthCareLocatorCustomObject.Builder().build()
    private var appName: String = ""
    private var appDownloadLink: String = ""
    private var apiKey: String = ""
    private val defaultClientUrl = "https://www.blank.org/"
    private var clientUrl: String = ""
    private var modificationUrl: String = ""
    private val executor: LocationAPI by lazy {
        HCLMapService.Builder(LocationAPI.mapUrl, LocationAPI::class.java).build()
    }

    companion object {
        @JvmStatic
        fun getInstance(): HealthCareLocatorState = Instance.instance

        @JvmStatic
        fun init(apiKey: String): HealthCareLocatorState = Instance.instance.apply { this.setApiKey(apiKey) }
    }

    override fun setCustomObject(customObject: HealthCareLocatorCustomObject) {
        this.config = customObject
    }

    override fun setAppName(appName: String): HealthCareLocatorState {
        this.appName = appName
        return this
    }

    override fun setApiKey(apiKey: String): HealthCareLocatorState {
        this.apiKey = apiKey
        return this
    }

    override fun setAppDownloadLink(downloadLink: String): HealthCareLocatorState {
        this.appDownloadLink = downloadLink
        return this
    }

    override fun getApiKey(): String {
        return apiKey
    }

    override fun getAppName(): String {
        return appName
    }

    override fun getAppDownloadLink(): String {
        return appDownloadLink
    }

    fun getClientUrl(): String = if (clientUrl.isNotEmpty()) clientUrl else defaultClientUrl
    fun getModificationUrl(): String = modificationUrl

    override fun getConfiguration(): HealthCareLocatorCustomObject = config

    override fun startSDKFragment(activity: AppCompatActivity?, containerId: Int) {
        if (activity.isNullable())
            throw HCLException(ErrorReference.ACTIVITY_INVALID,
                    "The provided Activity must NOT be nullable.")
        else if (containerId == 0)
            throw HCLException(ErrorReference.ID_INVALID,
                    "The provided containerId must NOT be 0.")
        reverseGeoCoding(activity!!)
        readConfig(activity)
        if (config.mapService == MapService.GOOGLE_MAP &&
                activity?.getMetaDataFromManifest("com.google.android.geo.API_KEY").isNullOrEmpty())
            throw HCLException(ErrorReference.DATA_INVALID,
                    "Should provide the map API key for google map service.")
        when (config.screenReference) {
            ScreenReference.SEARCH_NEAR_ME -> {
                activity!!.changeLocale(config.locale)
                activity.pushFragment(
                        containerId, HCLNearMeFragment.newInstance(config, "", null,
                        HCLPlace(placeId = "near_me", displayName = activity.getString(R.string.hcl_near_me)),
                        config.specialities), true)
            }
//            ScreenReference.HOME_FULL -> activity!!.addFragment(containerId, OneKeyHomeFullFragment.newInstance(), true)
            else -> activity!!.addFragment(containerId, HCLHomeMainFragment.newInstance(), true)
        }
    }

    override fun startSDKActivity(activity: AppCompatActivity?) {
        if (activity.isNullable())
            throw HCLException(ErrorReference.ACTIVITY_INVALID,
                    "The provided Activity must NOT be nullable.")
        reverseGeoCoding(activity!!)
        readConfig(activity)
        activity!!.startActivity(Intent(activity, HCLActivity::class.java))
    }

    override fun getServices(context: Context): HealthCareLocatorService {
        if (getApiKey().isEmpty()) throw HCLException(ErrorReference.API_KEY_INVALID,
                "The provided API key must NOT be nullable or emtpy.")
        reverseGeoCoding(context)
        readConfig(context)
        return HealthCareLocatorService.getInstance(context)
    }

    private fun readConfig(context: Context?) {
        val json = context?.run {
            return@run try {
                val ip = assets.open("env/${getConfiguration().env}/hcl-config.json")
                val size: Int = ip.available()
                val buffer = ByteArray(size)
                ip.read(buffer)
                ip.close()
                JSONObject(String(buffer))
            } catch (ex: IOException) {
                ex.printStackTrace()
                JSONObject()
            }
        } ?: JSONObject()
        clientUrl = json.getString("clientHCLUrl")
        modificationUrl = json.getString("modificationUrl")
    }

    override fun reverseGeoCoding(context: Context) {
        if (ContextCompat.checkSelfPermission(context,
                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            val client = LocationClient(context)
            client.requestLastLocation().registerDataCallBack({ location ->
                client.removeLocationUpdate()
                client.releaseApiClient()
                val params = hashMapOf<String, String>()
                params["lat"] = "${location.latitude}"
                params["lon"] = "${location.longitude}"
                params["format"] = "json"
                executor.reverseGeoCoding(params).map {
                    it.address?.countryCode ?: ""
                }.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe({
                    if (it.isNotEmpty()) {
                        getConfiguration().defaultCountry = it
                    }
                }, { })
            }, {}, {})

        }
    }
}