// SPDX-FileCopyrightText: 2026 Cossale <hello@auna.li>
// SPDX-License-Identifier: AGPL-3.0-or-later

package app.valenced.patches.discord

import app.reseam.patch.patch

val enableDebugging = patch(DiscordStrings.debuggablePatch) {
    description(DiscordStrings.debuggablePatchDescription)
    compatibleWith(DISCORD)
    enabledByDefault(false)

    execute {
        manifest.edit { findByTag("application").single()["android:debuggable"] = "true" }
    }
}
