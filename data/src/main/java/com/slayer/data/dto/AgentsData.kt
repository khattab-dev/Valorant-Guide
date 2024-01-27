package com.slayer.data.dto


import com.squareup.moshi.Json

data class AgentsData(
    @Json(name = "abilities")
    val abilities: List<Ability?>?,
    @Json(name = "assetPath")
    val assetPath: String?,
    @Json(name = "background")
    val background: String?,
    @Json(name = "backgroundGradientColors")
    val backgroundGradientColors: List<String?>?,
    @Json(name = "bustPortrait")
    val bustPortrait: String?,
    @Json(name = "characterTags")
    val characterTags: List<String?>?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "developerName")
    val developerName: String?,
    @Json(name = "displayIcon")
    val displayIcon: String?,
    @Json(name = "displayIconSmall")
    val displayIconSmall: String?,
    @Json(name = "displayName")
    val displayName: String?,
    @Json(name = "fullPortrait")
    val fullPortrait: String?,
    @Json(name = "fullPortraitV2")
    val fullPortraitV2: String?,
    @Json(name = "isAvailableForTest")
    val isAvailableForTest: Boolean?,
    @Json(name = "isBaseContent")
    val isBaseContent: Boolean?,
    @Json(name = "isFullPortraitRightFacing")
    val isFullPortraitRightFacing: Boolean?,
    @Json(name = "isPlayableCharacter")
    val isPlayableCharacter: Boolean?,
    @Json(name = "killfeedPortrait")
    val killfeedPortrait: String?,
    @Json(name = "recruitmentData")
    val recruitmentData: RecruitmentData?,
    @Json(name = "role")
    val role: Role?,
    @Json(name = "uuid")
    val uuid: String?,
    @Json(name = "voiceLine")
    val voiceLine: Any?
)