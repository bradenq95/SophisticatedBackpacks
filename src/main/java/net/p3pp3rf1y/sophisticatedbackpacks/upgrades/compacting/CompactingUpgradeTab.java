package net.p3pp3rf1y.sophisticatedbackpacks.upgrades.compacting;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.p3pp3rf1y.sophisticatedbackpacks.client.gui.BackpackScreen;
import net.p3pp3rf1y.sophisticatedbackpacks.client.gui.Dimension;
import net.p3pp3rf1y.sophisticatedbackpacks.client.gui.Position;
import net.p3pp3rf1y.sophisticatedbackpacks.client.gui.UpgradeSettingsTab;
import net.p3pp3rf1y.sophisticatedbackpacks.upgrades.FilterLogicControl;
import net.p3pp3rf1y.sophisticatedbackpacks.upgrades.FilteredUpgradeContainer;

import static net.p3pp3rf1y.sophisticatedbackpacks.client.gui.TranslationHelper.translUpgrade;
import static net.p3pp3rf1y.sophisticatedbackpacks.client.gui.TranslationHelper.translUpgradeTooltip;
import static net.p3pp3rf1y.sophisticatedbackpacks.upgrades.FilterLogicControl.Button.ALLOW_LIST;
import static net.p3pp3rf1y.sophisticatedbackpacks.upgrades.FilterLogicControl.Button.PRIMARY_MATCH;

@OnlyIn(Dist.CLIENT)
public class CompactingUpgradeTab extends UpgradeSettingsTab<FilteredUpgradeContainer<CompactingUpgradeWrapper>> {
	protected CompactingUpgradeTab(FilteredUpgradeContainer<CompactingUpgradeWrapper> upgradeContainer, Position position, Dimension openTabDimension, BackpackScreen screen, int slotsPerRow, ITextComponent tabLabel, ITextComponent closedTooltip) {
		super(upgradeContainer, position, openTabDimension, screen, slotsPerRow, tabLabel, closedTooltip);
	}

	public static class Basic extends CompactingUpgradeTab {
		public Basic(FilteredUpgradeContainer<CompactingUpgradeWrapper> upgradeContainer, Position position, BackpackScreen screen) {
			super(upgradeContainer, position, new Dimension(63, 106), screen, 3,
					new TranslationTextComponent(translUpgrade("compacting")), new TranslationTextComponent(translUpgradeTooltip("compacting")));
			addHideableChild(new FilterLogicControl.Basic(new Position(x + 3, y + 24), getContainer(), 3));
		}
	}

	public static class Advanced extends CompactingUpgradeTab {
		public Advanced(FilteredUpgradeContainer<CompactingUpgradeWrapper> upgradeContainer, Position position, BackpackScreen screen) {
			super(upgradeContainer, position, new Dimension(81, 124), screen, 4,
					new TranslationTextComponent(translUpgrade("advanced_compacting")), new TranslationTextComponent(translUpgradeTooltip("advanced_compacting")));
			addHideableChild(new FilterLogicControl(new Position(x + 3, y + 24), getContainer(), 4, ALLOW_LIST, PRIMARY_MATCH));
		}
	}
}
