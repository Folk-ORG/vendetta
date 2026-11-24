import TableRowAssetIcon from '@valenced/components/TableRowAssetIcon'
import { BuildEnvironment, FullVersion } from '~/constants'
import VendettaIcon from '~assets/VendettaIcon'
import { Setting } from '../constants'
import { CopyableSetting } from './shared'
import type { SettingsItem } from '@valenced/discord/modules/settings'

const ValencedVersionSetting: SettingsItem = CopyableSetting(
    {
        parent: Setting.Valenced,
        IconComponent: () => <TableRowAssetIcon id={VendettaIcon} />,
        useTitle: () => 'Vendetta',
    },
    () => `${FullVersion} (${BuildEnvironment})`,
)

export default ValencedVersionSetting
