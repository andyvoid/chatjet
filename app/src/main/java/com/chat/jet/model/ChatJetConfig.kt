package com.chat.jet.model

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import com.chat.jet.CIRCLE
import com.chat.jet.R

data class ChatJetConfig(
    val showBuddyAvatars: Boolean = true,
    val fontFamily: FontFamily = FontFamily.Default,
    val buddyAvatarStyle: AvatarStyle = AvatarStyle.Circle,
    val buddyAvatarPlaceHolder: Int = R.drawable.outline_account_circle_24,
    val buddyFullNameSize : FontSize = FontSize.Regular,
    val buddyStatusFontSize : FontSize = FontSize.Regular,
)

enum class AvatarStyle(){
    Circle,
    Square
}

enum class FontSize() {
    Small,
    Regular,
    Large
}


