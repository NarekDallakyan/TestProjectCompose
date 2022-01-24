package narek.testproject.ui.main.model

import androidx.annotation.DrawableRes

open class SectionItemModel(
    var defaultTitle: String,
)

class DoorsItemModel(
    @DrawableRes val lockIcon: Int,
    @DrawableRes val unLockIcon: Int,
) : SectionItemModel("Doors")

class EngineItemModel(
    val firstEngineText: String,
    val secondEngineText: String
) : SectionItemModel("Engine")