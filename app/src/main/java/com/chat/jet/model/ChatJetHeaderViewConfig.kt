package com.chat.jet.model

import androidx.compose.ui.text.font.FontFamily
import com.chat.jet.R

data class ChatJetHeaderViewConfig(
    val backButtonIcon : Int? = null,
    val menuButtonIcon : Int? = null,
    val showBuddyAvatars: Boolean = true,
    val fontFamily: FontFamily = FontFamily.Default,
    val buddyAvatarStyle: AvatarStyle = AvatarStyle.Circle,
    val buddyAvatarPlaceHolder: Int = R.drawable.outline_account_circle_24,
    val buddyFullNameSize : FontSize = FontSize.Regular,
    val buddyStatusFontSize : FontSize = FontSize.Regular,
) {
}