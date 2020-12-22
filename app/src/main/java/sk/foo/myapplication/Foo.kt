package sk.foo.myapplication

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by Vlastimil Brečka (www.vlastimilbrecka.sk)
 * on 22. 12. 2020.
 */
@JsonClass(generateAdapter = true)
data class ApiProductsAndTexts(
    val products: ApiProducts,
    val texts: ApiTexts,
    val lastUpdated: Long
)

@JsonClass(generateAdapter = true)
data class ApiProducts(
    val product: List<ApiProduct>,
    val productOptions: List<ApiProductOption>?
)

@JsonClass(generateAdapter = true)
data class ApiProduct(
    val productId: String,
    val resetProductIdOverride: String?,
    val productName: String,
    val productLongName: String,
    val usageManagement: UsageManagement?,
    val hasUnlimitedFU: Boolean?,
    val serviceTerms: List<ApiServiceTerms>?,
    val productStaticAttributes: List<ProductStaticAttributes>?,
    val productClass: String?
)

@JsonClass(generateAdapter = true)
data class ProductStaticAttributes(
    val attributeName: String?,
    val attributeValue: String?
)

@JsonClass(generateAdapter = true)
data class UsageManagement(
    val resetProductId: String,
    val action: String?
)

@JsonClass(generateAdapter = true)
data class ApiServiceTerms(
    val termId: String,
    val termText: String
)

@JsonClass(generateAdapter = true)
data class ApiProductOption(
    val description: String,
    @Json(name = "option") val options: List<ApiOption>
)

@JsonClass(generateAdapter = true)
data class ApiOption(
    val optionId: String,
    val optionName: String,
    val optionLongName: String,
    val optionAutoResetCount: Int,
    val serviceProvider: String
)

@JsonClass(generateAdapter = true)
data class ApiTexts(
    @Json(name = "nbo-default") val nboDefault: ApiProductPromotions?,
    @Json(name = "nbo_css") val nboCss: String?,
    @Json(name = "tariffs") val tariffs: List<ApiTariff>?,
    @Json(name = "soda") val soda: List<ApiSoda>?,
    @Json(name = "urls") val urls: Map<String, String>?,
    @Json(name = "shops") val shops: Map<String, String>?,
    @Json(name = "countries") val countries: List<Map<String, String>>?,
    @Json(name = "IDDocuments") val idDocuments: ApiIdDocuments?,
    @Json(name = "texts") val texts: ApiTextsAndroid
)

@JsonClass(generateAdapter = true)
data class ApiProductPromotions(
    val productPromotion: List<ApiProductPromotion>
)

@JsonClass(generateAdapter = true)
data class ApiProductPromotion(
    val promotionId: String,
    val backgroundColour: String?,
    val backgroundImageURL: String?,
    val label: String?,
    val header: String?,
    val subHeader: String?,
    val content: String?,
    val text: String,
    val offerRestrictedPeriod: Long?,
    val operation: String?,
    val actionAcceptURL: String?,
    @Json(name = "promotionAnswer") val answers: List<Answer>?
) {
    @JsonClass(generateAdapter = true)
    data class Answer(
        val id: String,
        val priority: Int,
        val displayValue: String
    )
}


@JsonClass(generateAdapter = true)
data class ApiSoda(
    val label: String,
    val text: String,
    val image: String,
    val link: String
)

@JsonClass(generateAdapter = true)
data class ApiTextsAndroid(
    val common: Map<String, String>?,
    val android: Map<String, String>?
)

sealed class ApiTariff {
    abstract val id: String
    abstract val title: String
}

@JsonClass(generateAdapter = true)
data class ApiSimpleTariff(
    @Json(name = "tariffId") override val id: String,
    @Json(name = "tariffName") override val title: String
) : ApiTariff()

@JsonClass(generateAdapter = true)
data class ApiFullTariff(
    @Json(name = "tariffId") override val id: String,
    @Json(name = "tariffName") override val title: String,
    @Json(name = "bkgColorHex") val color: String,
    @Json(name = "rcAmount") val price: Double,
    @Json(name = "period") val period: Int,
    @Json(name = "dataQuantity") val dataQuantity: String,
    @Json(name = "voiceXMSQuantity") val voiceQuantity: String,
    @Json(name = "EUdataQuantity") val euRoamingAllowance: String
) : ApiTariff()

@JsonClass(generateAdapter = true)
data class ApiIdDocuments(
    @Json(name = "skIDCards") val skDefault: List<Map<String, String>>,
    @Json(name = "skAlternativeIDs") val skAlternative: List<Map<String, String>>,
    @Json(name = "otherIDs") val other: List<Map<String, String>>
)