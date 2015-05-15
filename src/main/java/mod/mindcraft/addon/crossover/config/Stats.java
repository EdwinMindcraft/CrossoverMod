package mod.mindcraft.addon.crossover.config;

import scala.annotation.meta.getter;

public class Stats {
	int materialId;
	int harvesetLevel;
	int durability;
	int miningSpeed;
	int attack;
	float handleModifier;
	int reinforced;
	float stonebound;
	int drawSpeed;
	float speedMax;
	float mass;
	float fragility;
	public Stats(int materialId, int harvesetLevel, int durability, int miningSpeed, int attack, float handleModifier, int reinforced, float stonebound, int drawSpeed, float speedMax, float mass, float fragility) {
		this.materialId = materialId;
		this.harvesetLevel = harvesetLevel;
		this.durability = durability;
		this.miningSpeed = miningSpeed;
		this.attack = attack;
		this.handleModifier = handleModifier;
		this.reinforced = reinforced;
		this.stonebound = stonebound;
		this.drawSpeed = drawSpeed;
		this.speedMax = speedMax;
		this.mass = mass;
		this.fragility = fragility;		
	}
	
	public int getAttack() {
		return attack;
	}

	public int getDrawSpeed() {
		return drawSpeed;
	}

	public int getDurability() {
		return durability;
	}

	public float getFragility() {
		return fragility;
	}

	public float getHandleModifier() {
		return handleModifier;
	}

	public int getHarvesetLevel() {
		return harvesetLevel;
	}

	public float getMass() {
		return mass;
	}

	public int getMaterialId() {
		return materialId;
	}

	public int getMiningSpeed() {
		return miningSpeed;
	}

	public int getReinforced() {
		return reinforced;
	}

	public float getSpeedMax() {
		return speedMax;
	}

	public float getStonebound() {
		return stonebound;
	}
}
