package net.p3pp3rf1y.sophisticatedbackpacks.upgrades.voiding;

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

@OnlyIn(Dist.CLIENT)
public class VoidUpgradeTab extends UpgradeSettingsTab<FilteredUpgradeContainer<VoidUpgradeWrapper>> {
	protected VoidUpgradeTab(FilteredUpgradeContainer<VoidUpgradeWrapper> upgradeContainer, Position position, Dimension openTabDimension, BackpackScreen screen, int slotsPerRow, ITextComponent tabLabel, ITextComponent closedTooltip) {
		super(upgradeContainer, position, openTabDimension, screen, slotsPerRow, tabLabel, closedTooltip);
	}

	public static class Basic extends VoidUpgradeTab {
		public Basic(FilteredUpgradeContainer<VoidUpgradeWrapper> upgradeContainer, Position position, BackpackScreen screen) {
			super(upgradeContainer, position, new Dimension(63, 106), screen, 3,
					new TranslationTextComponent(translUpgrade("void")), new TranslationTextComponent(translUpgradeTooltip("void")));
			addHideableChild(new FilterLogicControl.Basic(new Position(x + 3, y + 24), getContainer(), 3));
		}
	}

	public static class Advanced extends VoidUpgradeTab {
		public Advanced(FilteredUpgradeContainer<VoidUpgradeWrapper> upgradeContainer, Position position, BackpackScreen screen) {
			super(upgradeContainer, position, new Dimension(81, 124), screen, 4,
					new TranslationTextComponent(translUpgrade("advanced_void")), new TranslationTextComponent(translUpgradeTooltip("advanced_void")));
			addHideableChild(new FilterLogicControl.Advanced(new Position(x + 3, y + 24), getContainer(), 4));
		}
	}
}
