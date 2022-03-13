package com.game.entities.player.items;

import java.awt.image.BufferedImage;

import com.game.collision.objects.PlayerObject;
import com.game.collision.objects.base.ObjectType;
import com.game.entities.player.items.base.Item;
import com.game.entities.player.items.base.ItemID;
import com.game.main.Game;

public class Tree1Item extends Item<Tree1Item> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5238918464923717123L;

	public Tree1Item(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image);
		
		
	}

	@Override
	public void use() {
		
		this.count--;
		
		if (this.count <= 0) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
		
		Game.MAP_HANDLER.currentMap().addObject(new PlayerObject(
																(int) Game.PLAYER.getX(),
																(int) Game.PLAYER.getY(),
																128,
																128,
																ObjectType.TREE_1,
																Game.OBJECT_TEXTRA_ALICE.getImageFrom(160, 0, 16, 16)
															));
		
	}

	@Override
	public Tree1Item cloneType() {
		return new Tree1Item(this.count, this.id, this.image);
	}

}
