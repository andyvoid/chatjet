package com.chat.jet.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.chat.jet.CIRCLE
import com.chat.jet.model.BuddyInfoModel


@Preview(showBackground = true)
@Composable
fun ParticipantInfoViewPreview() {

    Box(modifier = Modifier.wrapContentWidth().height(50.dp)) {
        BuddyInfoView(BuddyInfoModel(
            firstName = "John",
            lastName = "Doe",
            profilePicture = "https://randomuser.me/api/portraits/men/1.jpg",
        ), participantInfoStyle = CIRCLE)
    }

}

@Composable
fun BuddyInfoView(
    buddyInfoModel: BuddyInfoModel,
    participantInfoStyle: String = CIRCLE,
    fontFamily : FontFamily = FontFamily.Default
) {
    Row (
        modifier = Modifier.fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically
    ){

        AsyncImage(
            modifier = Modifier.size(44.dp)
                .clip(if (participantInfoStyle == CIRCLE) CircleShape else RoundedCornerShape(4.dp))
                .background(Color.Blue),
            model = ImageRequest.Builder(LocalContext.current)
                .data(buddyInfoModel.profilePicture)
                .crossfade(true) // optional, for a fade-in effect
                .build(),
            contentDescription = "User Image",
        )

        Spacer(modifier = Modifier.width(6.dp))

        Column(
            modifier = Modifier.padding(end = 5.dp)
        ) {
            Text(
                fontFamily = fontFamily,
                text = buddyInfoModel.firstName + " " + buddyInfoModel.lastName,
                maxLines = 1
            )

            Text(
                fontSize = 12.sp,
                fontFamily = fontFamily,
                text = buddyInfoModel.userStatus.name,
                maxLines = 1
            )
        }
    }
}