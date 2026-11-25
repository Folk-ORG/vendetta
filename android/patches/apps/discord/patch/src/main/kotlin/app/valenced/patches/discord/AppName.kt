// SPDX-FileCopyrightText: 2026 Cossale <hello@auna.li>
// SPDX-License-Identifier: AGPL-3.0-or-later

package app.valenced.patches.discord

import app.reseam.patch.patch

val changeAppName = patch(DiscordStrings.appNamePatch) {
    description(DiscordStrings.appNamePatchDescription)
    compatibleWith(DISCORD)

    val appNameOption = stringOption(
        "appName",
        title = DiscordStrings.appNameOptionTitle,
        description = DiscordStrings.appNameOptionDescription,
        default = "Vendetta",
    )

    execute {
        val name = options[appNameOption]
        manifest.edit {
            findByTag("application").single()["android:label"] = name
            // An activity's own label wins over the app's, and Discord's launcher activity has one.
            findByTag("activity").filter { it["android:label"] != null }.forEach { it["android:label"] = name }
        }
    }
}
