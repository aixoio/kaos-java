package com.game.entities.player.items.tools.weapon;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.game.entities.base.DamageableEntity;
import com.game.entities.base.Entity;
import com.game.entities.player.items.base.ItemID;
import com.game.entities.player.items.base.WeaponItem;
import com.game.main.Game;
import com.game.particles.ParticleTypes;

public class SwordItem extends WeaponItem<SwordItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 480082285209695321L;

	public SwordItem(int count, ItemID id, BufferedImage image) {
		super(count, id, image, 1.43412f);
		
		
	}
	
	private SwordItem(int count, ItemID id, BufferedImage image, float damage) {
		super(count, id, image, damage);
		
		
	}

	@Override
	public SwordItem cloneType() {
		return new SwordItem(this.count, this.id, this.image, this.damage);
	}

	@Override
	public void use() {
		
		LinkedList<Entity> tempEList = Game.MAP_HANDLER().currentMap().getEntityHandler().getList();
		
		for (int i = 0; i < tempEList.size(); i++) {
			
			Entity e = tempEList.get(i);
			
			if (e.equals(Game.PLAYER)) continue;
			
			if (e instanceof DamageableEntity && Game.PLAYER.getRectangle().intersects(e.getRectangle()) && Math.random() < 0.50) {
				
				((DamageableEntity) e).damage(Game.PLAYER.calculateAttackDamage(this.damage));
				this.makeDamageParticle(e.getX(), e.getY());
				
			}
			
		}
		
	}
	
	private void makeDamageParticle(float x, float y) {
		
		ParticleTypes.FALL_3.make(x, y, 8, 8, new Color(140, 0, 0), null, null);
		
	}

}
