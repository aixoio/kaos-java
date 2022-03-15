package com.game.loot.tables;

import com.game.entities.player.items.base.ItemID;
import com.game.entities.player.items.objects.IronOre1Item;
import com.game.main.Game;

public class IronOre1ItemLootTable {
	
	public static void makeLootAtRandom() {
		
		float[] pos = Game.getRandomItemPos();
		
		Game.addItemEntity(
							pos[0],
							pos[1],
							new IronOre1Item(1, ItemID.IRON_ORE_1, Game.ITEM_TEXTRA_ALICE.getImageFrom(176, 0, 16, 16)),
							Game.ITEM_TEXTRA_ALICE.getImageFrom(176, 0, 16, 16),
							64
						);
		
	}

}
