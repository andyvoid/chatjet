package com.chat.jet

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chat.jet.components.BuddyInfoView
import com.chat.jet.model.BuddyInfoModel
import com.chat.jet.model.ChatJetHeaderViewConfig


const val CIRCLE : String = "circle"
const val SQUARE : String = "square"

@Preview(
    showBackground = true,
    device = Devices.PIXEL_5)
@Composable
fun preview(

) {
    Scaffold(
        topBar = {
            ChatHeaderView(buddyInfoModel = BuddyInfoModel(
                firstName = "Obama",
                lastName = "Studio",
                profilePicture = "https://randomuser.me/api/portraits/men/1.jpg",
            ))
        }
    ){ padding ->

        Box(modifier = Modifier.padding(padding))

    }
}

@Composable
fun ChatHeaderView(
    chatJetHeaderViewConfig: ChatJetHeaderViewConfig = ChatJetHeaderViewConfig(
        backButtonIcon = R.drawable.ic_back,
        menuButtonIcon = R.drawable.ic_menu,
        showBuddyAvatars = true,
    ),
    modifier: Modifier = Modifier.fillMaxWidth().height(60.dp),
    buddyInfoModel: BuddyInfoModel,
) {

    Row(modifier = modifier,
        verticalAlignment = Alignment.CenterVertically) {

        ChatJetBackButton(
            buttonIcon = chatJetHeaderViewConfig.backButtonIcon ?: 0
        ) {  }

        BuddyInfoView(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            chatJetHeaderViewConfig = chatJetHeaderViewConfig,
            buddyInfoModel)

        HeaderMenuButton(){

        }

    }

}

@Composable
fun ChatJetBackButton(
    buttonIcon : Int,
    onBackPressed : () -> Unit
) {
    Image(
        modifier = Modifier
            .fillMaxHeight()
            .width(50.dp)
            .clickable(onClick = onBackPressed),
        painter = painterResource(buttonIcon),
        contentScale = ContentScale.Inside,
        colorFilter = ColorFilter.tint(color = Color.Black),
        contentDescription = "back")
}

@Composable
fun HeaderMenuButton(
    modifier: Modifier = Modifier.fillMaxHeight().width(50.dp),
    onClick: () -> Unit,
    ) {
    ImageButton(
        imageRes = R.drawable.ic_menu,
        onClick = {  },
        modifier = modifier,
        colorFilter = ColorFilter.tint(color = Color.Black),
    )
}


@Composable
fun ImageButton(
    imageRes : Int,
    onClick : () -> Unit,
    modifier : Modifier = Modifier,
    contentScale : ContentScale = ContentScale.Inside,
    contentDescription : String = "",
    colorFilter : ColorFilter? = null
) {
    Image(
        modifier = modifier.clickable(onClick = onClick),
        painter = painterResource(imageRes),
        contentScale = contentScale,
        contentDescription = contentDescription,
        colorFilter = colorFilter)
}

