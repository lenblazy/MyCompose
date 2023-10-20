package com.lenibonje.mycompose

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun SelectableItem(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    title: String,
    titleColor: Color =
        if (isSelected) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
    titleSize: TextUnit = MaterialTheme.typography.titleMedium.fontSize,
    titleWeight: FontWeight = FontWeight.Medium,
    subTitle: String? = null,
    subTitleColor: Color =
        if (isSelected) MaterialTheme.colorScheme.onSurface
        else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
    borderWidth: Dp = 1.dp,
    borderColor: Color =
        if (isSelected) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
    borderShape: Shape = RoundedCornerShape(size = 10.dp),
    icon: ImageVector = Icons.Default.CheckCircle,
    iconColor: Color =
        if (isSelected) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
    onClick: () -> Unit
) {

    Column(
        modifier = modifier
            .border(width = borderWidth, color = borderColor, shape = borderShape)
            .clickable { onClick() }
    ) {


        Row(
            modifier = Modifier
                .padding(start = 16.dp),
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {

            Text(
                modifier = Modifier.weight(8f),
                text = title,
                style = TextStyle(
                    color = titleColor,
                    fontSize = titleSize,
                    fontWeight = titleWeight
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,

                )
            IconButton(onClick = onClick, modifier = Modifier.weight(2f)) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Selectable Item Icon",
                    tint = iconColor
                )
            }
        }

        subTitle?.let {
            Text(
                text = subTitle,
                style = TextStyle(color = subTitleColor,),
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }

}

@Preview
@Composable
fun SelectableItemPreview() {
    SelectableItem(isSelected = false, title = "Yow") {}
}