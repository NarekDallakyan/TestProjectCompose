package narek.testproject.ui.main.model

import androidx.annotation.DrawableRes

open class PageItemModel(
    var defaultTitle: String,
)

class DoorsItemModel(
    @DrawableRes val lockIcon: Int,
    @DrawableRes val unLockIcon: Int,
) : PageItemModel("Doors")

class EngineItemModel(
    val firstEngineText: String,
    val secondEngineText: String
) : PageItemModel("Engine")