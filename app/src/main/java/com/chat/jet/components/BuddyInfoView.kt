package com.chat.jet.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.chat.jet.CIRCLE
import com.chat.jet.model.AvatarStyle
import com.chat.jet.model.BuddyInfoModel
import com.chat.jet.model.ChatJetHeaderViewConfig
import com.chat.jet.model.FontSize


/* Modificaiton required


 */

@Preview(showBackground = true)
@Composable
fun BuddyInfoViewPreview() {

    Box(modifier = Modifier.wrapContentWidth().height(50.dp)) {
        BuddyInfoView(buddyInfoModel = BuddyInfoModel(
            firstName = "Obama",
            lastName = "Studio",
            profilePicture = "https://randomuser.me/api/portraits/men/1.jpg",
        ))
    }

}

@Composable
fun BuddyInfoView(
    modifier: Modifier = Modifier,
    chatJetHeaderViewConfig: ChatJetHeaderViewConfig = ChatJetHeaderViewConfig(),
    buddyInfoModel: BuddyInfoModel,
    buddyAvatarStyle: AvatarStyle = chatJetHeaderViewConfig.buddyAvatarStyle,
    fontFamily : FontFamily = chatJetHeaderViewConfig.fontFamily,
    fontSize : FontSize = chatJetHeaderViewConfig.buddyStatusFontSize
) {
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){

        AsyncImage(
            modifier = Modifier.size(44.dp)
                .clip(if (buddyAvatarStyle == AvatarStyle.Circle) CircleShape else RoundedCornerShape(4.dp))
                .background(Color.Blue),
            model = ImageRequest.Builder(LocalContext.current)
                .data(buddyInfoModel.profilePicture)
                .crossfade(true) // optional, for a fade-in effect
                .build(),
            contentDescription = "User Image",
        )

        Spacer(modifier = Modifier.width(10.dp))

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(0.dp)
                .weight(1f)
                .padding(end = 5.dp),
            verticalArrangement = Arrangement.Center
        ) {


            // Buddy Name
            Text(
                fontSize = when (fontSize) {
                    FontSize.Small -> 14.sp
                    FontSize.Regular -> 18.sp
                    FontSize.Large -> 20.sp
                },
                fontWeight = FontWeight.Medium,
                fontFamily = fontFamily,
                text = buddyInfoModel.firstName + " " + buddyInfoModel.lastName,
                maxLines = 1
            )

            // Buddy Online Status
            Text(
                modifier = Modifier.alpha(0.5f),
                fontSize =  when (fontSize) {
                    FontSize.Small -> 10.sp
                    FontSize.Regular -> 12.sp
                    FontSize.Large -> 14.sp
                },
                fontFamily = fontFamily,
                text = buddyInfoModel.userStatus.name,
                maxLines = 1
            )
        }
    }
}