package mod.mindcraft.addon.crossover.tconstruct.metallurgy.enums;

import mod.mindcraft.addon.crossover.tconstruct.metallurgy.MetallurgySupport;
import net.minecraft.util.EnumChatFormatting;

public enum EnumMetallurgyMaterials {
	//done
	MATERIAL_MANGANESE(),
	MATERIAL_HEPATIZON(300, 2, 1, 1.2F,0.0F, 0, "", 40, 1.2F, 8.3F, 0.5F, MetallurgySupport.Colors[1], 1000),
	MATERIAL_DAMASCUSSTEEL(500, 3, 2, 1.3F, 0.0F, 2, "", 40, 1.2F, 8.3F, 0.5F, MetallurgySupport.Colors[2], 600),
	MATERIAL_ANGMALLEN(300, 2, 2, 1.2F,0.0F, 0, "", 40, 1.2F, 8.3F, 0.5F, MetallurgySupport.Colors[3], 1000),
	//done
	MATERIAL_EXIMITE(1000, 3, 3, 1.3F,0.0F, 0, "", 40, 1.2F, 6.3F, 0.25F, MetallurgySupport.Colors[4], 800),
	MATERIAL_MEUTOITE,
	MATERIAL_DESICHALKOS(1800, 4, 4, 2.75F,0.0F, 0, "", 40, 1.2F, 6.5F, 0.25F, MetallurgySupport.Colors[6], 1000),
	//done
	MATERIAL_PROMETHEUM(200, 1, 1, 1.0F,0.0F, 1, EnumChatFormatting.DARK_GREEN.toString(), 40, 1.2F, 7.2F, 0.25F, MetallurgySupport.Colors[7], 400),
	MATERIAL_DEEPIRON(250, 2, 2, 1.3F,0.0F, 1, EnumChatFormatting.BLUE.toString(), 40, 1.2F, 7.6F, 0.25F, MetallurgySupport.Colors[8], 600),
	//done
	MATERIAL_INFUSCOLIUM,
	MATERIAL_BLACKSTEEL(500, 2, 2, 1.3F,0.0F, 2, EnumChatFormatting.BLUE.toString(), 40, 1.2F, 7.6F, 0.25F, MetallurgySupport.Colors[10], 800),
	MATERIAL_OURECLASE(750, 3, 2, 1.3F,0.0F, 0, EnumChatFormatting.GOLD.toString(), 40, 1.2F, 7.9F, 0.25F, MetallurgySupport.Colors[11], 800),
	//done
	MATERIAL_ASTRALSILVER(35, 4, 1, 0.35F,0.0F, 0, EnumChatFormatting.GRAY.toString(), 40, 1.2F, 9F, 1F, MetallurgySupport.Colors[12], 1200),
	MATERIAL_CARMOT(50, 2, 1, 1.2F,0.0F, 0, EnumChatFormatting.YELLOW.toString(), 40, 1.2F, 9.2F, 0.25F, MetallurgySupport.Colors[13], 1200),
	//done
	MATERIAL_MITHRIL(1000, 4, 3, 1.5F,0.0F, 0, EnumChatFormatting.AQUA.toString(), 40, 1.2F, 7.8F, 0.25F, MetallurgySupport.Colors[14], 900),
	MATERIAL_RUBRACIUM,
	MATERIAL_QUICKSILVER(1100, 4, 3, 1.8F,0.0F, 0, EnumChatFormatting.AQUA.toString(), 40, 1.2F, 13.4F, 0.25F, MetallurgySupport.Colors[16], 1400),
	//done
	MATERIAL_HADEROTH(1250, 4, 3, 1.8F,0.0F, 0, EnumChatFormatting.DARK_RED.toString(), 40, 1.2F, 8.9F, 0.25F, MetallurgySupport.Colors[17], 1200),
	MATERIAL_ORICHALCUM(1350, 5, 3, 2.5F,0.0F, 0, EnumChatFormatting.DARK_GREEN.toString(), 40, 1.2F, 9.2F, 0.25F, MetallurgySupport.Colors[18], 900),
	MATERIAL_CELENEGIL(1600, 5, 3, 2.5F,0.0F, 0, "", 40, 1.2F, 9.5F, 0.25F, MetallurgySupport.Colors[19], 1400),
	//done
	MATERIAL_ADAMANTINE(1550, 6, 4, 2.75F,0.0F, 2, EnumChatFormatting.RED.toString(), 40, 1.2F, 9.2F, 0.25F, MetallurgySupport.Colors[20], 1000),
	MATERIAL_ALTARUS(1750, 6, 4, 2.5F,0.0F, 0, EnumChatFormatting.GOLD.toString(), 40, 1.2F, 11.2F, 0.25F, MetallurgySupport.Colors[21], 1000),
	MATERIAL_TARTARITE(3000, 7, 5, 3.0F, 0.0F, 2, EnumChatFormatting.GOLD.toString(), 40, 1.2F, 25.5F, 0.25F, MetallurgySupport.Colors[22], 1400),
	//done
	MATERIAL_IGNATUS(200, 1, 2, 1.0F,0.0F, 0, EnumChatFormatting.RED.toString(), 40, 1.2F, 9.2F, 1F, MetallurgySupport.Colors[23], 400), //TODO Ignite I
	MATERIAL_SHADOWIRON(300, 1, 2, 1.3F,0.0F, 1, EnumChatFormatting.GRAY.toString(), 40, 1.2F, 8.2F, 0.25F, MetallurgySupport.Colors[24], 400), //TODO Weakness I
	MATERIAL_LEMURITE,
	//done
	MATERIAL_MIDASIUM(100, 3, 3, 1.0F,0.0F, 0, EnumChatFormatting.GOLD.toString(), 40, 1.2F, 8.4F, 1F, MetallurgySupport.Colors[26], 1000),
	MATERIAL_VYROXERES(300, 3, 3, 1.3F,0.0F, 0, EnumChatFormatting.GREEN.toString(), 40, 1.2F, 7.9F, 0.25F, MetallurgySupport.Colors[27], 700), //TODO Poison I
	MATERIAL_CERUCLASE(500, 3, 3, 1.4F,0.0F, 0, EnumChatFormatting.AQUA.toString(), 40, 1.2F, 9F, 0.25F, MetallurgySupport.Colors[28], 700), //TODO Slowness
	//done
	MATERIAL_ALDUORITE,
	MATERIAL_KALENDRITE(1000, 4, 3, 1.75F,0.0F, 0, EnumChatFormatting.DARK_PURPLE.toString(), 40, 1.2F, 8.6F, 0.25F, MetallurgySupport.Colors[30], 800),
	MATERIAL_VULCANITE(1500, 5, 2, 2F,0.0F, 0, EnumChatFormatting.RED.toString(), 40, 1.2F, 9.6F, 0.25F, MetallurgySupport.Colors[31], 1000), //TODO Ignite II
	
	MATERIAL_SANGUINITE(1750, 6, 4, 2.3F,0.0F, 0, EnumChatFormatting.DARK_RED.toString(), 40, 1.2F, 9.2F, 0.25F, MetallurgySupport.Colors[32], 1200), //TODO Wither I
	MATERIAL_SHADOWSTEEL(400, 2, 3, 1.3F,0.0F, 2, EnumChatFormatting.GRAY.toString(), 40, 1.2F, 8.6F, 0.25F, MetallurgySupport.Colors[33], 600), //TODO Weakness II
	MATERIAL_INOLASHITE(900, 4, 3, 1.7F,0.0F, 0, EnumChatFormatting.DARK_GREEN.toString(), 40, 1.2F, 8.3F, 0.25F, MetallurgySupport.Colors[34], 800), //TODO Poison II
	MATERIAL_AMORDRINE(1300, 4, 3, 1.8F,0.0F, 0, EnumChatFormatting.LIGHT_PURPLE.toString(), 40, 1.2F, 8.8F, 0.25F, MetallurgySupport.Colors[35], 1400), //TODO Life Steal
	
	MATERIAL_ZINC,
	MATERIAL_BRASS(15, 0, 1, 0.2F,0.0F, 0, EnumChatFormatting.GOLD.toString(), 40, 1.2F, 8.7F, 1F, MetallurgySupport.Colors[37], 1200),
	MATERIAL_PLATINIUM(100, 2, 1, 0.75F,0.0F, 0, EnumChatFormatting.BLUE.toString(), 40, 1.2F, 21.4F, 1F, MetallurgySupport.Colors[38], 2400);

	
	private int durability;
	private int miningLevel;
	private int damage;
	private float handleModifier;
	private float stonebound;
	private int reinforced;
	private String enumChatFormattingColor;
	private int drawSpeed;
	private float speedMax;
	private float mass;
	private float fragility;
	private int color;
	private int miningSpeed;
	
	private EnumMetallurgyMaterials() {
	}
	
	private EnumMetallurgyMaterials(int durability, int miningLevel,
			int damage, float handleModifier, float stonebound, int reinforced,
			String enumChatFormattingColor, int drawSpeed, float speedMax,
			float mass, float fragility, int color, int miningSpeed) {
		
		this.durability = durability;
		this.miningLevel = miningLevel;
		this.damage = damage;
		this.handleModifier = handleModifier;
		this.stonebound = stonebound;
		this.reinforced = reinforced;
		this.enumChatFormattingColor = enumChatFormattingColor;
		this.drawSpeed = drawSpeed;
		this.speedMax = speedMax;
		this.mass = mass;
		this.fragility = fragility;
		this.color = color;
		this.miningSpeed = miningSpeed;
	}
	
	public int getDurability () {return durability;}
	public int getMiningLevel () {return miningLevel;}
	public int getDamage () {return damage;}
	public float getHandleModifier () {return handleModifier;}
	public float getStonebound () {return stonebound;}
	public int getReinforced () {return reinforced;}
	public String getChatColor () {return enumChatFormattingColor;}
	public int getDrawSpeed () {return drawSpeed;}
	public float getSpeedMax () {return speedMax;}
	public float getMass () {return mass;}
	public float getFragility () {return fragility;}
	public int getColor () {return color;}
	public int getMiningSpeed() {return miningSpeed;}
}
