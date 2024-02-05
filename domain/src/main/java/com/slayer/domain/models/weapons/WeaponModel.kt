package com.slayer.domain.models.weapons

data class WeaponModel(
    val uuid: String,
    val name: String,
    val image: String,
    val weaponStats : Map<String,String>,
    val adsStats : Map<String,String>,
    val damageRanges: List<Map<String, String>>
) {
    companion object {
        fun WeaponModel.test() {
            val damageRanges: List<Map<String, Number>> = listOf(
                mapOf(
                    "fireRate" to 12,
                    "magazineSize" to 100,
                    "runSpeedMultiplier" to 0.76,
                    "equipTimeSeconds" to 1.25,
                    "reloadTimeSeconds" to 5,
                    "firstBulletAccuracy" to 0.8,
                    "shotgunPelletCount" to 1
                ),
                mapOf(
                    "fireRate" to 12,
                    "magazineSize" to 100,
                    "runSpeedMultiplier" to 0.76,
                    "equipTimeSeconds" to 1.25,
                    "reloadTimeSeconds" to 5,
                    "firstBulletAccuracy" to 0.8,
                    "shotgunPelletCount" to 1
                ),
            )
        }
    }
}
