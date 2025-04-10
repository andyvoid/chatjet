package com.chat.jet.model

data class BuddyInfoModel(
    val firstName: String = "",
    val lastName: String = "",
    val profilePicture: String = "",
    val userStatus: BuddyStatus = BuddyStatus.Offline
)


enum class BuddyStatus() {
    Online,
    Offline,
    Busy,
    Away,
}
