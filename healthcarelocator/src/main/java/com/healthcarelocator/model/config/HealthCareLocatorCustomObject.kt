package com.healthcarelocator.model.config

import android.graphics.Typeface
import androidx.annotation.Size
import com.healthcarelocator.R
import com.healthcarelocator.extensions.MapService
import com.healthcarelocator.extensions.ScreenReference
import com.healthcarelocator.extensions.isNullable
import java.util.*

/**
 * OneKeyViewCustomObject provides fields where the implementation app could be changed the style(s) like:
 * text color, text size, font(s), icon(s).
 *
 * Implementation:
 *
 * • With Java: OneKeyViewCustomObject obj = new OneKeyViewCustomObject.Builder().editIcon(`value`).build();
 *
 * • With Kotlin: OneKeyViewCustomObject.Builder(editIcon=`value`).build() or OneKeyViewCustomObject.Builder()..editIcon(`value`).build()
 *
 * If the implementation app doesn't provide those styles, the default will be applied.
 * @param colorPrimary Set primary color in the hex [String] color (Must start with #).
 * @param colorSecondary Set secondary color in the hex [String] color (Must start with #).
 * @param textColor Set text color in the hex [String] color (Must start with #).
 * @param colorMarker Set marker color in colorId which will show on the map (Must start with #).
 * @param colorMarkerSelected Set selected marker color in colorId which will show on the map (Must start with #).
 * @param fontDefault Set default font size in integer.
 * @param fontSmall Set font size for small level in [HealthCareLocatorViewFontObject].
 * @param searchIcon Set search icon in drawableId.
 * @param editIcon Set edit icon in drawableId.
 * @param markerIcon Set marker icon in drawableId.
 */
data class HealthCareLocatorCustomObject private constructor(
        val colorPrimary: String = "#43b02a",// Color in hex, must start with #
        val colorSecondary: String = "#00a3e0",
        val textColor: String = "#2d3c4d",
        val colorMarker: String = "#fe8a12",
        val colorMarkerSelected: String = "#fd8670",
        val fontButton: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                id = "button",
                size = 14
        ).build(),
        val fontDefault: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                id = "default",
                size = 14
        ).build(),
        val searchIcon: Int = R.drawable.baseline_search_white_24dp,
        val editIcon: Int = R.drawable.baseline_edit_white_36dp,
        val markerIcon: Int = R.drawable.baseline_location_on_white_36dp,
        var fontSearchInput: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                id = "searchInput",
                size = 16
        ).build(),
        val fontSmall: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                id = "small",
                size = 12
        ).build(),
        val fontTitleMain: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                id = "titleMain",
                size = 20
        ).build(),
        val fontTitleSecondary: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                id = "titleSecondary",
                size = 16,
                weight = Typeface.BOLD
        ).build(),
        val fontSearchResultTotal: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                id = "searchResultTotal",
                size = 14,
                weight = Typeface.BOLD
        ).build(),
        val fontSearchResultTitle: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                id = "searchResultTitle",
                size = 16
        ).build(),
        val fontResultTitle: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                id = "resultTitle",
                size = 14
        ).build(),
        val fontResultSubTitle: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                id = "resultSubTitle",
                size = 14
        ).build(),
        val fontProfileTitle: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                id = "profileTitle",
                size = 18
        ).build(),
        val fontProfileSubTitle: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                id = "profileSubTitle",
                size = 16
        ).build(),
        val fontProfileTitleSection: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                id = "profileTitleSection",
                size = 16
        ).build(),
        val fontCardTitle: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                id = "cardTitle",
                size = 16,
                weight = Typeface.BOLD
        ).build(),
        val fontModalTitle: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                id = "modalTitle",
                size = 18
        ).build(),
        val fontSortCriteria: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                id = "sortCriteria",
                size = 16
        ).build(),
        val colorListBackground: String = "#f8f9fa", val colorDark: String, val colorGrey: String,
        val colorGreyDark: String, val colorGreyDarker: String, val colorGreyLight: String,
        val colorGreyLighter: String, val colorVoteUp: String, val colorVoteDown: String,
        val colorViewBackground: String, val colorCardBorder: String, val colorButtonBorder: String,
        val colorButtonBackground: String, val colorButtonAcceptBackground: String,
        val colorButtonDiscardBackground: String, val locale: String,
        val specialities: ArrayList<String>, @ScreenReference val screenReference: Int,
        @MapService val mapService: Int, val iconCross: Int, val iconGeoLoc: Int,
        val iconMarkerMin: Int, val iconSort: Int, val iconList: Int, val iconMap: Int,
        val iconArrowRight: Int, val iconMapGeoLoc: Int, val iconPhone: Int, val iconFax: Int,
        val iconWebsite: Int, val iconVoteUp: Int, val iconVoteDown: Int, val iconProfile: Int,
        val iconLocation: Int, val fontNoResultTitle: HealthCareLocatorViewFontObject,
        val fontNoResultDesc: HealthCareLocatorViewFontObject,
        val showModificationForm: Boolean, val env: String = "prod", val countries: ArrayList<String>,
        var defaultCountry: String = ""
) {

    @Suppress
    data class Builder(
            var colorPrimary: String = "#43b02a",// Color in hex, must start with #
            var colorSecondary: String = "#00a3e0",
            var textColor: String = "#2d3c4d",
            var colorMarker: String = "#fe8a12",
            var colorMarkerSelected: String = "#fd8670",
            var fontButton: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                    id = "button",
                    size = 16
            ).build(),
            var fontDefault: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                    id = "default",
                    size = 14
            ).build(),
            var searchIcon: Int = R.drawable.baseline_search_white_24dp,
            var editIcon: Int = R.drawable.baseline_edit_white_36dp,
            var markerIcon: Int = R.drawable.baseline_location_on_black_36dp,
            var fontSearchInput: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                    id = "searchInput",
                    size = 16
            ).build(),
            var fontSmall: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                    id = "small",
                    size = 12
            ).build(),
            var fontTitleMain: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                    id = "titleMain",
                    size = 20
            ).build(),
            var fontTitleSecondary: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                    id = "titleSecondary",
                    size = 16,
                    weight = Typeface.BOLD
            ).build(),
            var fontSearchResultTotal: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                    id = "searchResultTotal",
                    size = 14,
                    weight = Typeface.BOLD
            ).build(),
            var fontSearchResultTitle: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                    id = "searchResultTitle",
                    size = 16
            ).build(),
            var fontResultTitle: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                    id = "resultTitle",
                    size = 14
            ).build(),
            var fontResultSubTitle: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                    id = "resultSubTitle",
                    size = 14
            ).build(),
            var fontProfileTitle: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                    id = "profileTitle",
                    size = 18
            ).build(),
            var fontProfileSubTitle: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                    id = "profileSubTitle",
                    size = 16
            ).build(),
            var fontProfileTitleSection: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                    id = "profileTitleSection",
                    size = 16
            ).build(),
            var fontCardTitle: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                    id = "cardTitle",
                    size = 16,
                    weight = Typeface.BOLD
            ).build(),
            var fontModalTitle: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                    id = "modalTitle",
                    size = 18
            ).build(),
            var fontSortCriteria: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                    id = "sortCriteria",
                    size = 16
            ).build(),
            var colorListBackground: String = "#f8f9fa",
            var colorGreyLight: String = "#b8b8b8", var colorDark: String = "#2b3c4d",
            var colorGrey: String = "#a1a1a1",
            var colorGreyDark: String = "#7d7d7d",
            var colorGreyDarker: String = "#666666",
            var colorGreyLighter: String = "#ebebeb",
            var colorVoteDown: String = "#ff0000",
            var colorVoteUp: String = colorPrimary,
            var colorViewBackground: String = "#f8f9fa",
            var colorCardBorder: String = "#E3E3E3",
            var colorButtonBorder: String = "#dedede",
            var colorButtonBackground: String = "#fcfcfc",
            var colorButtonDiscardBackground: String = "#9aa0a7",
            var locale: String = "en",
            var specialities: ArrayList<String> = arrayListOf(),
            @ScreenReference var screenReference: Int = ScreenReference.HOME,
            @MapService var mapService: Int = MapService.OSM,
            var iconCross: Int = R.drawable.baseline_close_black_24dp,
            var iconGeoLoc: Int = R.drawable.baseline_location_searching_black_24dp,
            var iconMarkerMin: Int = R.drawable.outline_location_on_black_24dp,
            var iconSort: Int = R.drawable.baseline_sort_white_24dp,
            var iconList: Int = R.drawable.baseline_list_white_24dp,
            var iconMap: Int = R.drawable.baseline_map_white_24dp,
            var iconArrowRight: Int = R.drawable.baseline_keyboard_arrow_right_black_36dp,
            var iconMapGeoLoc: Int = R.drawable.baseline_my_location_black_24dp,
            var iconPhone: Int = R.drawable.baseline_call_black_36dp,
            var iconFax: Int = R.drawable.baseline_print_black_36dp,
            var iconWebsite: Int = R.drawable.ic_network,
            var iconVoteUp: Int = R.drawable.ic_like_gray,
            var iconVoteDown: Int = R.drawable.ic_dislike_gray,
            var iconProfile: Int = R.drawable.icon_profile,
            var iconLocation: Int = R.drawable.outline_location_on_black_36dp,
            var iconMapMarker: Int = R.drawable.baseline_location_on_black_36dp,
            var fontNoResultTitle: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                    id = "fontNoResultTitle",
                    size = 20
            ).build(),
            var fontNoResultDesc: HealthCareLocatorViewFontObject = HealthCareLocatorViewFontObject.Builder(
                    id = "fontNoResultDesc",
                    size = 16
            ).build(),
            var showModificationForm: Boolean = false,
            var env: String = "prod", var countries: ArrayList<String> = arrayListOf(),
            var defaultCountry: String = ""
    ) {

        fun colorPrimary(@Size(min = 7) primaryColor: String) =
                apply { this.colorPrimary = primaryColor }

        fun colorSecondary(secondaryColor: String) = apply { this.colorSecondary = secondaryColor }
        fun textColor(textColor: String) = apply { this.textColor = textColor }
        fun colorMarker(markerColor: String) = apply { this.colorMarker = markerColor }
        fun colorMarkerSelected(markerSelectedColor: String) =
                apply { this.colorMarkerSelected = markerSelectedColor }

        fun fontButton(fontButton: HealthCareLocatorViewFontObject?) = apply {
            this.fontButton = fontButton ?: this.fontButton
        }

        fun fontDefault(fontDefaultSize: HealthCareLocatorViewFontObject?) = apply {
            this.fontDefault = fontDefaultSize ?: this.fontDefault
        }

        fun iconSearch(searchIcon: Int) = apply { this.searchIcon = searchIcon }
        fun iconProfile(iconProfile: Int) = apply { this.iconProfile = iconProfile }
        fun iconEdit(editIcon: Int) = apply { this.editIcon = editIcon }
        fun iconMapMarker(markerIcon: Int) = apply { this.markerIcon = markerIcon }
        fun iconCross(iconCross: Int) = apply { this.iconCross = iconCross }
        fun iconSort(iconSort: Int) = apply { this.iconSort = iconSort }
        fun iconList(iconList: Int) = apply { this.iconList = iconList }
        fun iconMap(iconMap: Int) = apply { this.iconMap = iconMap }
        fun iconArrowRight(iconArrowRight: Int) = apply { this.iconArrowRight = iconArrowRight }
        fun iconVoteDown(iconVoteDown: Int) = apply { this.iconVoteDown = iconVoteDown }
        fun iconVoteUp(iconVoteUp: Int) = apply { this.iconVoteUp = iconVoteUp }
        fun iconFax(iconFax: Int) = apply { this.iconFax = iconFax }
        fun iconWebsite(iconPhone: Int) = apply { this.iconWebsite = iconWebsite }
        fun iconPhone(iconPhone: Int) = apply { this.iconPhone = iconPhone }
        fun iconMapGeoLoc(iconMapGeoLoc: Int) = apply { this.iconMapGeoLoc = iconMapGeoLoc }
        fun iconGeoLoc(iconGeoLoc: Int) = apply { this.iconGeoLoc = iconGeoLoc }
        fun iconMarkerMin(iconMarkerMin: Int) = apply { this.iconMarkerMin = iconMarkerMin }
        fun iconLocation(iconLocation: Int) = apply { this.iconLocation = iconLocation }

        fun fontSearchInput(fontSearchInput: HealthCareLocatorViewFontObject?) = apply {
            if (fontSearchInput.isNullable()) return@apply
            this.fontSearchInput = fontSearchInput!!
        }

        fun fontSmall(fontSmallSize: HealthCareLocatorViewFontObject?) = apply {
            if (fontSmallSize.isNullable()) return@apply
            this.fontSmall = fontSmallSize!!
        }

        fun fontTitleMain(fontTitleMain: HealthCareLocatorViewFontObject?) = apply {
            if (fontTitleMain.isNullable()) return@apply
            this.fontTitleMain = fontTitleMain!!
        }

        fun fontTitleSecondary(fontTitleSecondary: HealthCareLocatorViewFontObject?) = apply {
            if (fontTitleSecondary.isNullable()) return@apply
            this.fontTitleSecondary = fontTitleSecondary!!
        }

        fun fontSearchResultTotal(fontSearchResultTotal: HealthCareLocatorViewFontObject?) = apply {
            this.fontSearchResultTotal = fontSearchResultTotal ?: this.fontSearchResultTotal
        }

        fun fontSearchResultTitle(fontSearchResultTitle: HealthCareLocatorViewFontObject?) = apply {
            if (fontSearchResultTitle.isNullable()) return@apply
            this.fontSearchResultTitle = fontSearchResultTitle!!
        }

        fun fontResultTitle(fontResultTitle: HealthCareLocatorViewFontObject?) = apply {
            this.fontResultTitle = fontResultTitle ?: this.fontResultTitle
        }

        fun fontResultSubTitle(fontResultSubTitle: HealthCareLocatorViewFontObject?) = apply {
            this.fontResultSubTitle = fontResultSubTitle ?: this.fontResultSubTitle
        }

        fun fontProfileTitle(fontProfileTitle: HealthCareLocatorViewFontObject?) = apply {
            this.fontProfileTitle = fontProfileTitle ?: this.fontProfileTitle
        }

        fun fontProfileSubTitle(fontProfileSubTitle: HealthCareLocatorViewFontObject?) = apply {
            this.fontProfileSubTitle = fontProfileSubTitle ?: this.fontProfileSubTitle
        }

        fun fontProfileTitleSection(fontProfileTitleSection: HealthCareLocatorViewFontObject?) =
                apply {
                    this.fontProfileTitleSection =
                            fontProfileTitleSection ?: this.fontProfileTitleSection
                }

        fun fontCardTitle(fontCardTitle: HealthCareLocatorViewFontObject?) = apply {
            this.fontCardTitle = fontCardTitle ?: this.fontCardTitle
        }

        fun fontModalTitle(fontModalTitle: HealthCareLocatorViewFontObject?) = apply {
            this.fontModalTitle = fontModalTitle ?: this.fontModalTitle
        }

        fun fontSortCriteria(fontSortCriteria: HealthCareLocatorViewFontObject?) = apply {
            this.fontSortCriteria = fontSortCriteria ?: this.fontSortCriteria
        }

        fun fontNoResultTitle(fontNoResultTitle: HealthCareLocatorViewFontObject?) = apply {
            this.fontNoResultTitle = fontNoResultTitle ?: this.fontNoResultTitle
        }

        fun fontNoResultDesc(fontNoResultDesc: HealthCareLocatorViewFontObject?) = apply {
            this.fontNoResultDesc = fontNoResultDesc ?: this.fontNoResultDesc
        }

        fun colorListBackground(colorListBackground: String) =
                apply { this.colorListBackground = colorListBackground }

        fun colorGreyLight(color: String) = apply { this.colorGreyLight = color }
        fun colorGrey(color: String) = apply { this.colorGrey = color }
        fun colorGreyDark(color: String) = apply { this.colorGreyDark = color }
        fun colorGreyDarker(color: String) = apply { this.colorGreyDarker = color }
        fun colorGreyLighter(color: String) = apply { this.colorGreyLighter = color }
        fun colorVoteDown(color: String) = apply { this.colorVoteDown = color }
        fun colorVoteUp(color: String) = apply { this.colorVoteUp = color }
        fun colorViewBackground(color: String) = apply { this.colorViewBackground = color }
        fun colorCardBorder(color: String) = apply { this.colorCardBorder = color }
        fun colorButtonBorder(color: String) = apply { this.colorButtonBorder = color }
        fun colorButtonBackground(color: String) = apply { this.colorButtonBackground = color }
        fun colorButtonDiscardBackground(color: String) =
                apply { this.colorButtonDiscardBackground = color }

        fun locale(locale: String) = apply { this.locale = locale }
        fun specialities(specialities: ArrayList<String>) =
                apply { this.specialities = specialities }

        fun entryScreen(@ScreenReference screenReference: Int) =
                apply { this.screenReference = screenReference }

        fun mapService(@MapService mapService: Int) = apply { this.mapService = mapService }
        fun showModificationForm(showModificationForm: Boolean) =
                apply { this.showModificationForm = showModificationForm }

        fun env(env: String) = apply { this.env = env }
        fun countries(countries: ArrayList<String>) = apply { this.countries = countries }
        fun defaultCountry(defaultCountry: String) = apply { this.defaultCountry = defaultCountry }

        fun build() = HealthCareLocatorCustomObject(
                colorPrimary,
                colorSecondary,
                textColor,
                colorMarker,
                colorMarkerSelected,
                fontButton,
                fontDefault,
                searchIcon,
                editIcon,
                markerIcon,
                fontSearchInput,
                fontSmall,
                fontTitleMain,
                fontTitleSecondary,
                fontSearchResultTotal,
                fontSearchResultTitle,
                fontResultTitle,
                fontResultSubTitle,
                fontProfileTitle,
                fontProfileSubTitle,
                fontProfileTitleSection,
                fontCardTitle,
                fontModalTitle,
                fontSortCriteria,
                colorListBackground,
                colorDark,
                colorGrey,
                colorGreyDark,
                colorGreyDarker,
                colorGreyLight,
                colorGreyLighter, colorVoteUp,
                colorVoteDown,
                colorViewBackground,
                colorCardBorder,
                colorButtonBorder,
                colorButtonBackground,
                colorPrimary,
                colorButtonDiscardBackground,
                locale,
                specialities,
                screenReference,
                mapService,
                iconCross,
                iconGeoLoc,
                iconMarkerMin,
                iconSort,
                iconList,
                iconMap,
                iconArrowRight,
                iconMapGeoLoc,
                iconPhone,
                iconFax,
                iconWebsite,
                iconVoteUp,
                iconVoteDown,
                iconProfile,
                iconLocation,
                fontNoResultTitle,
                fontNoResultDesc,
                showModificationForm,
                env,
                countries,
                defaultCountry
        )
    }

    fun getLocaleCode(): String = if (locale.isNotEmpty()) {
        if (locale == "fr") "fr_CA" else locale
    } else Locale.getDefault().language
}