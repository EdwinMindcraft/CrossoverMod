package mod.mindcraft.addon.crossover.tconstruct.metallurgy;

import java.util.ArrayList;

import mantle.pulsar.pulse.Handler;
import mantle.pulsar.pulse.Pulse;
import mod.mindcraft.addon.crossover.tconstruct.metallurgy.enums.EnumMetallurgyMaterials;
import mod.mindcraft.addon.crossover.tconstruct.utils.TiCUtils;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import tconstruct.TConstruct;
import tconstruct.library.crafting.FluidType;
import tconstruct.library.crafting.Smeltery;

import com.teammetallurgy.metallurgy.BlockList;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder("mcrossover")
@Pulse(id="Crossover Metallurgy", modsRequired = "Metallurgy")
public class MetallurgySupport {
	
	private static Block[] blocksBlase = new Block[39];

	public static String[] fluidNames = new String[39];

	public static Fluid[] Fluids = new Fluid[39];
	
	public static int ManganeseColor = 0xffcaca;
	public static int HepatizonColor = 0xd28844;
	public static int DamascusSteelColor = 0x755e75;
	public static int AngmallenColor = 0x996d4d;
	
	public static int EximiteColor = 0x7c5a96;
	public static int MeutoiteColor = 0x5f5269;
	public static int DesichalkosColor = 0x722fa8;
	
	public static int PrometheumColor = 0x5a8156;
	public static int DeepIronColor = 0x495b69;
	public static int InfuscoliumColor = 0x922156;
	public static int BlackSteelColor = 0x395679;
	public static int OureclaseColor = 0xb76215;
	public static int AstralSilverColor = 0xb8cacb;
	public static int CarmotColor = 0xd9cd8c;
	public static int MithrilColor = 0x88f0f9;
	public static int RubraciumColor = 0x972d2d;
	public static int QuickSilverColor = 0x7cd3c7;
	public static int HaderothColor = 0x77341e;
	public static int OrichalcumColor = 0x547a38;
	public static int CelenegilColor = 0x94cc48;
	public static int AdamantineColor = 0xaf0101;
	public static int AltarusColor = 0xccb300;
	public static int TartariteColor = 0xff763c;
	
	public static int IgnatusColor = 0xffa953;
	public static int ShadowIronColor = 0x5f4c3f;
	public static int LemuriteColor = 0xdbdbdb;
	public static int MidasiumColor = 0xffa826;
	public static int VyroxeresColor = 0x55e001;
	public static int CeruclaseColor = 0x458fab;
	public static int AlduoriteColor = 0xa3dede;
	public static int KalendriteColor = 0xaa5bbd;
	public static int VulcaniteColor = 0xff8448;
	public static int SanguiniteColor = 0xb90000;
	public static int ShadowSteelColor = 0x887362;
	public static int InolashiteColor = 0x40aa7d;
	public static int AmodrineColor = 0xa98db1;
	
	public static int ZincColor = 0xdcdfa4;
	public static int BrassColor = 0xd89634;
	public static int PlatiniumColor = 0xbbdadf;
	
	public static Integer[] Colors = new Integer[39];
	
	public static Integer[] Metadatas = new Integer[39];
	
	public static ItemStack[] blocks = new ItemStack[39];
	
	public static String[] Names = new String[39];
	
	public static Boolean[] isToolPart = new Boolean[39];

	public static ItemStack[] Ingots = new ItemStack[39];
	


	

	@Handler
	public void preInit(FMLPreInitializationEvent e) {
		initVaribles();
		initNames();
		initBool();
		initMetadatas();
	}
	

	@Handler
	public void init(FMLInitializationEvent e) {
		initMetals();
		initSmeltery();
	}
	
	@Handler
	public void postInit(FMLPostInitializationEvent e) {
		
	}
	
	private void initVaribles() {
		Colors[0] = ManganeseColor;
		Colors[1] = HepatizonColor;
		Colors[2] = DamascusSteelColor;
		Colors[3] = AngmallenColor;
		Colors[4] = EximiteColor;
		Colors[5] = MeutoiteColor;
		Colors[6] = DesichalkosColor;
		Colors[7] = PrometheumColor;
		Colors[8] = DeepIronColor;
		Colors[9] = InfuscoliumColor;
		Colors[10] = BlackSteelColor;
		Colors[11] = OureclaseColor;
		Colors[12] = AstralSilverColor;
		Colors[13] = CarmotColor;
		Colors[14] = MithrilColor;
		Colors[15] = RubraciumColor;
		Colors[16] = QuickSilverColor;
		Colors[17] = HaderothColor;
		Colors[18] = OrichalcumColor;
		Colors[19] = CelenegilColor;
		Colors[20] = AdamantineColor;
		Colors[21] = AltarusColor;
		Colors[22] = TartariteColor;
		Colors[23] = IgnatusColor;
		Colors[24] = ShadowIronColor;
		Colors[25] = LemuriteColor;
		Colors[26] = MidasiumColor;
		Colors[27] = VyroxeresColor;
		Colors[28] = CeruclaseColor;
		Colors[29] = AlduoriteColor;
		Colors[30] = KalendriteColor;
		Colors[31] = VulcaniteColor;
		Colors[32] = SanguiniteColor;
		Colors[33] = ShadowSteelColor;
		Colors[34] = InolashiteColor;
		Colors[35] = AmodrineColor;
		Colors[36] = ZincColor;
		Colors[37] = BrassColor;
		Colors[38] = PlatiniumColor;		
		
		Fluids[0] = FluidRegistry.getFluid("manganese.molten");
		Fluids[1] = FluidRegistry.getFluid("hepatizon.molten");
		Fluids[2] = FluidRegistry.getFluid("damascus.steel.molten");
		Fluids[3] = FluidRegistry.getFluid("angmallen.molten");
		Fluids[4] = FluidRegistry.getFluid("eximite.molten");
		Fluids[5] = FluidRegistry.getFluid("meutoite.molten");
		Fluids[6] = FluidRegistry.getFluid("desichalkos.molten");
		Fluids[7] = FluidRegistry.getFluid("prometheum.molten");
		Fluids[8] = FluidRegistry.getFluid("deep.iron.molten");
		Fluids[9] = FluidRegistry.getFluid("infuscolium.molten");
		Fluids[10] = FluidRegistry.getFluid("black.steel.molten");
		Fluids[11] = FluidRegistry.getFluid("oureclase.molten");
		Fluids[12] = FluidRegistry.getFluid("astral.silver.molten");
		Fluids[13] = FluidRegistry.getFluid("carmot.molten");
		Fluids[14] = FluidRegistry.getFluid("mithril.molten");
		Fluids[15] = FluidRegistry.getFluid("rubracium.molten");
		Fluids[16] = FluidRegistry.getFluid("quicksilver.molten");
		Fluids[17] = FluidRegistry.getFluid("haderoth.molten");
		Fluids[18] = FluidRegistry.getFluid("orichalcum.molten");
		Fluids[19] = FluidRegistry.getFluid("celenegil.molten");
		Fluids[20] = FluidRegistry.getFluid("adamantine.molten");
		Fluids[21] = FluidRegistry.getFluid("atlarus.molten");
		Fluids[22] = FluidRegistry.getFluid("tartarite.molten");
		Fluids[23] = FluidRegistry.getFluid("ignatius.molten");
		Fluids[24] = FluidRegistry.getFluid("shadow.iron.molten");
		Fluids[25] = FluidRegistry.getFluid("lemurite.molten");
		Fluids[26] = FluidRegistry.getFluid("midasium.molten");
		Fluids[27] = FluidRegistry.getFluid("vyroxeres.molten");
		Fluids[28] = FluidRegistry.getFluid("ceruclase.molten");
		Fluids[29] = FluidRegistry.getFluid("alduorite.molten");
		Fluids[30] = FluidRegistry.getFluid("kalendrite.molten");
		Fluids[31] = FluidRegistry.getFluid("vulcanite.molten");
		Fluids[32] = FluidRegistry.getFluid("sanguinite.molten");
		Fluids[33] = FluidRegistry.getFluid("shadow.steel.molten");
		Fluids[34] = FluidRegistry.getFluid("inolashite.molten");
		Fluids[35] = FluidRegistry.getFluid("amordrine.molten");
		Fluids[36] = FluidRegistry.getFluid("zinc.molten");
		Fluids[37] = FluidRegistry.getFluid("brass.molten");
		Fluids[38] = FluidRegistry.getFluid("platinum.molten");
		
		fluidNames[0] = "manganese.molten";
		fluidNames[1] = "hepatizon.molten";
		fluidNames[2] = "damascus.steel.molten";
		fluidNames[3] = "angmallen.molten";
		fluidNames[4] = "eximite.molten";
		fluidNames[5] = "meutoite.molten";
		fluidNames[6] = "desichalkos.molten";
		fluidNames[7] = "prometheum.molten";
		fluidNames[8] = "deep.iron.molten";
		fluidNames[9] = "infuscolium.molten";
		fluidNames[10] = "black.steel.molten";
		fluidNames[11] = "oureclase.molten";
		fluidNames[12] = "astral.silver.molten";
		fluidNames[13] = "carmot.molten";
		fluidNames[14] = "mithril.molten";
		fluidNames[15] = "rubracium.molten";
		fluidNames[16] = "quicksilver.molten";
		fluidNames[17] = "haderoth.molten";
		fluidNames[18] = "orichalcum.molten";
		fluidNames[19] = "celenegil.molten";
		fluidNames[20] = "adamantine.molten";
		fluidNames[21] = "altarus.molten";
		fluidNames[22] = "tartarite.molten";
		fluidNames[23] = "ignatus.molten";
		fluidNames[24] = "shadow.iron.molten";
		fluidNames[25] = "lemurite.molten";
		fluidNames[26] = "midasium.molten";
		fluidNames[27] = "vyroxeres.molten";
		fluidNames[28] = "ceruclase.molten";
		fluidNames[29] = "alduorite.molten";
		fluidNames[30] = "kalendrite.molten";
		fluidNames[31] = "vulcanite.molten";
		fluidNames[32] = "sanguinite.molten";
		fluidNames[33] = "shadow.steel.molten";
		fluidNames[34] = "inolashite.molten";
		fluidNames[35] = "amodrine.molten";
		fluidNames[36] = "zinc.molten";
		fluidNames[37] = "brass.molten";
		fluidNames[38] = "platinium.molten";

	}
	private void initBool() {
		isToolPart[0] = false;
		isToolPart[1] = true;
		isToolPart[2] = true;
		isToolPart[3] = true;
		isToolPart[4] = true;
		isToolPart[5] = false;
		isToolPart[6] = true;
		isToolPart[7] = true;
		isToolPart[8] = true;
		isToolPart[9] = false;
		isToolPart[10] = true;
		isToolPart[11] = true;
		isToolPart[12] = true;
		isToolPart[13] = true;
		isToolPart[14] = true;
		isToolPart[15] = false;
		isToolPart[16] = true;
		isToolPart[17] = true;
		isToolPart[18] = true;
		isToolPart[19] = true;
		isToolPart[20] = true;
		isToolPart[21] = true;
		isToolPart[22] = true;
		isToolPart[23] = true;
		isToolPart[24] = true;
		isToolPart[25] = false;
		isToolPart[26] = true;
		isToolPart[27] = true;
		isToolPart[28] = true;
		isToolPart[29] = false;
		isToolPart[30] = true;
		isToolPart[31] = true;
		isToolPart[32] = true;
		isToolPart[33] = true;
		isToolPart[34] = true;
		isToolPart[35] = true;
		isToolPart[36] = false;
		isToolPart[37] = true;
		isToolPart[38] = true;
		
	}

	private void initNames() {
		Names[0] = "Manganese";
		Names[1] = "Hepatizon";
		Names[2] = "DamascusSteel";
		Names[3] = "Angmallen";
		Names[4] = "Eximite";
		Names[5] = "Meutoite";
		Names[6] = "Desichalkos";
		Names[7] = "Prometheum";
		Names[8] = "DeepIron";
		Names[9] = "Infuscolium";
		Names[10] = "BlackSteel";
		Names[11] = "Oureclase";
		Names[12] = "AstralSilver";
		Names[13] = "Carmot";
		Names[14] = "Mithril";
		Names[15] = "Rubracium";
		Names[16] = "Quicksilver";
		Names[17] = "Haderoth";
		Names[18] = "Orichalcum";
		Names[19] = "Celenegil";
		Names[20] = "Adamantine";
		Names[21] = "Atlarus";
		Names[22] = "Tartarite";
		Names[23] = "Ignatius";
		Names[24] = "ShadowIron";
		Names[25] = "Lemurite";
		Names[26] = "Midasium";
		Names[27] = "Vyroxeres";
		Names[28] = "Ceruclase";
		Names[29] = "Alduorite";
		Names[30] = "Kalendrite";
		Names[31] = "Vulcanite";
		Names[32] = "Sanguinite";
		Names[33] = "ShadowSteel";
		Names[34] = "Inolashite";
		Names[35] = "Amordrine";
		Names[36] = "Zinc";
		Names[37] = "Brass";
		Names[38] = "Platinum";
	}

	private void initMetals() {
		
		EnumMetallurgyMaterials[] matList = {
				EnumMetallurgyMaterials.MATERIAL_MANGANESE,
				EnumMetallurgyMaterials.MATERIAL_HEPATIZON,
				EnumMetallurgyMaterials.MATERIAL_DAMASCUSSTEEL,
				EnumMetallurgyMaterials.MATERIAL_ANGMALLEN,
				EnumMetallurgyMaterials.MATERIAL_EXIMITE,
				EnumMetallurgyMaterials.MATERIAL_MEUTOITE,
				EnumMetallurgyMaterials.MATERIAL_DESICHALKOS,
				EnumMetallurgyMaterials.MATERIAL_PROMETHEUM,
				EnumMetallurgyMaterials.MATERIAL_DEEPIRON,
				EnumMetallurgyMaterials.MATERIAL_INFUSCOLIUM,
				EnumMetallurgyMaterials.MATERIAL_BLACKSTEEL,
				EnumMetallurgyMaterials.MATERIAL_OURECLASE,
				EnumMetallurgyMaterials.MATERIAL_ASTRALSILVER,
				EnumMetallurgyMaterials.MATERIAL_CARMOT,
				EnumMetallurgyMaterials.MATERIAL_MITHRIL,
				EnumMetallurgyMaterials.MATERIAL_RUBRACIUM,
				EnumMetallurgyMaterials.MATERIAL_QUICKSILVER,
				EnumMetallurgyMaterials.MATERIAL_HADEROTH,
				EnumMetallurgyMaterials.MATERIAL_ORICHALCUM,
				EnumMetallurgyMaterials.MATERIAL_CELENEGIL,
				EnumMetallurgyMaterials.MATERIAL_ADAMANTINE,
				EnumMetallurgyMaterials.MATERIAL_ALTARUS,
				EnumMetallurgyMaterials.MATERIAL_TARTARITE,
				EnumMetallurgyMaterials.MATERIAL_IGNATUS,
				EnumMetallurgyMaterials.MATERIAL_SHADOWIRON,
				EnumMetallurgyMaterials.MATERIAL_LEMURITE,
				EnumMetallurgyMaterials.MATERIAL_MIDASIUM,
				EnumMetallurgyMaterials.MATERIAL_VYROXERES,
				EnumMetallurgyMaterials.MATERIAL_CERUCLASE,
				EnumMetallurgyMaterials.MATERIAL_ALDUORITE,
				EnumMetallurgyMaterials.MATERIAL_KALENDRITE,
				EnumMetallurgyMaterials.MATERIAL_VULCANITE,
				EnumMetallurgyMaterials.MATERIAL_SANGUINITE,
				EnumMetallurgyMaterials.MATERIAL_SHADOWSTEEL,
				EnumMetallurgyMaterials.MATERIAL_INOLASHITE,
				EnumMetallurgyMaterials.MATERIAL_AMORDRINE,
				EnumMetallurgyMaterials.MATERIAL_ZINC,
				EnumMetallurgyMaterials.MATERIAL_BRASS, EnumMetallurgyMaterials.MATERIAL_PLATINIUM };
		for (int i = 0; i < Fluids.length; i++) {
			if (Fluids[i] != null) {
				FluidType.registerFluidType(Names[i], blocksBlase[i], blocks[i].getItemDamage(), 550, Fluids[i], isToolPart[i]);
				if (isToolPart[i]) {
					TiCUtils.registerPartMaterial(i+50, Names[i], matList[i]);
				}
			}
			else {
				System.out.println("Fluid not found : " + fluidNames[i]);
			}
		}
		
	}
	
	private void initSmeltery() {
		for (int i = 0; i < Fluids.length; i++) {
			if (Fluids[i] != null) {
				TiCUtils.addBasicMelting(Ingots[i], false, null, blocks[i], Fluids[i]);
				registerCastings(i);
			}
			else {
				System.out.println("Fluid not found : " + fluidNames[i]);
			}
		}
		Smeltery.addAlloyMixing(new FluidStack(FluidRegistry.getFluid("angmallen.molten"), TConstruct.nuggetLiquidValue * 2), new FluidStack[] { new FluidStack(FluidRegistry.getFluid("gold.molten"), TConstruct.nuggetLiquidValue), new FluidStack(FluidRegistry.getFluid("iron.molten"), TConstruct.nuggetLiquidValue) });
        Smeltery.addAlloyMixing(new FluidStack(FluidRegistry.getFluid("damascus.steel.molten"), TConstruct.nuggetLiquidValue * 2), new FluidStack[] { new FluidStack(FluidRegistry.getFluid("iron.molten"), TConstruct.nuggetLiquidValue), new FluidStack(FluidRegistry.getFluid("bronze.molten"), TConstruct.nuggetLiquidValue) });
        Smeltery.addAlloyMixing(new FluidStack(FluidRegistry.getFluid("hepatizon.molten"), TConstruct.nuggetLiquidValue * 2), new FluidStack[] { new FluidStack(FluidRegistry.getFluid("bronze.molten"), TConstruct.nuggetLiquidValue), new FluidStack(FluidRegistry.getFluid("gold.molten"), TConstruct.nuggetLiquidValue) });
        Smeltery.addAlloyMixing(new FluidStack(FluidRegistry.getFluid("steel.molten"), TConstruct.nuggetLiquidValue * 2), new FluidStack[] { new FluidStack(FluidRegistry.getFluid("iron.molten"), TConstruct.nuggetLiquidValue), new FluidStack(FluidRegistry.getFluid("manganese.molten"), TConstruct.nuggetLiquidValue) });
        Smeltery.addAlloyMixing(new FluidStack(FluidRegistry.getFluid("brass.molten"), TConstruct.nuggetLiquidValue * 2), new FluidStack[] { new FluidStack(FluidRegistry.getFluid("copper.molten"), TConstruct.nuggetLiquidValue * 2), new FluidStack(FluidRegistry.getFluid("zinc.molten"), TConstruct.nuggetLiquidValue * 2) });
        Smeltery.addAlloyMixing(new FluidStack(FluidRegistry.getFluid("amordrine.molten"), TConstruct.nuggetLiquidValue * 2), new FluidStack[] { new FluidStack(FluidRegistry.getFluid("kalendrite.molten"), TConstruct.nuggetLiquidValue), new FluidStack(FluidRegistry.getFluid("platinum.molten"), TConstruct.nuggetLiquidValue) });
        Smeltery.addAlloyMixing(new FluidStack(FluidRegistry.getFluid("inolashite.molten"), TConstruct.nuggetLiquidValue * 2), new FluidStack[] { new FluidStack(FluidRegistry.getFluid("alduorite.molten"), TConstruct.nuggetLiquidValue), new FluidStack(FluidRegistry.getFluid("ceruclase.molten"), TConstruct.nuggetLiquidValue) });
        Smeltery.addAlloyMixing(new FluidStack(FluidRegistry.getFluid("shadow.steel.molten"), TConstruct.nuggetLiquidValue * 2), new FluidStack[] { new FluidStack(FluidRegistry.getFluid("shadow.iron.molten"), TConstruct.nuggetLiquidValue), new FluidStack(FluidRegistry.getFluid("lemurite.molten"), TConstruct.nuggetLiquidValue) });
        Smeltery.addAlloyMixing(new FluidStack(FluidRegistry.getFluid("black.steel.molten"), TConstruct.nuggetLiquidValue * 2), new FluidStack[] { new FluidStack(FluidRegistry.getFluid("infuscolium.molten"), TConstruct.nuggetLiquidValue), new FluidStack(FluidRegistry.getFluid("deep.iron.molten"), TConstruct.nuggetLiquidValue) });
        Smeltery.addAlloyMixing(new FluidStack(FluidRegistry.getFluid("celenegil.molten"), TConstruct.nuggetLiquidValue * 2), new FluidStack[] { new FluidStack(FluidRegistry.getFluid("orichalcum.molten"), TConstruct.nuggetLiquidValue), new FluidStack(FluidRegistry.getFluid("platinum.molten"), TConstruct.nuggetLiquidValue) });
        Smeltery.addAlloyMixing(new FluidStack(FluidRegistry.getFluid("haderoth.molten"), TConstruct.nuggetLiquidValue * 2), new FluidStack[] { new FluidStack(FluidRegistry.getFluid("mithril.molten"), TConstruct.nuggetLiquidValue), new FluidStack(FluidRegistry.getFluid("rubracium.molten"), TConstruct.nuggetLiquidValue) });
        Smeltery.addAlloyMixing(new FluidStack(FluidRegistry.getFluid("quicksilver.molten"), TConstruct.nuggetLiquidValue * 2), new FluidStack[] { new FluidStack(FluidRegistry.getFluid("mithril.molten"), TConstruct.nuggetLiquidValue), new FluidStack(FluidRegistry.getFluid("silver.molten"), TConstruct.nuggetLiquidValue) });
        Smeltery.addAlloyMixing(new FluidStack(FluidRegistry.getFluid("tartarite.molten"), TConstruct.nuggetLiquidValue * 2), new FluidStack[] { new FluidStack(FluidRegistry.getFluid("adamantine.molten"), TConstruct.nuggetLiquidValue), new FluidStack(FluidRegistry.getFluid("atlarus.molten"), TConstruct.nuggetLiquidValue) });
        Smeltery.addAlloyMixing(new FluidStack(FluidRegistry.getFluid("desichalkos.molten"), TConstruct.nuggetLiquidValue * 2), new FluidStack[] { new FluidStack(FluidRegistry.getFluid("eximite.molten"), TConstruct.nuggetLiquidValue), new FluidStack(FluidRegistry.getFluid("meutoite.molten"), TConstruct.nuggetLiquidValue) });

	}
	
	private void registerCastings(int i) {
		if (isToolPart[i]) {
			TiCUtils.addCasting(Fluids[i], i+50);			
		}
		else {
			System.out.println("Material "+ fluidNames[i].replace(".molten", "") + " is not a toolpart ");
		}
	}

	private void initMetadatas() {
		
		for(int y = 0; y < Names.length; y++) {
			ArrayList<ItemStack> ingots = OreDictionary.getOres("ingot" + Names[y]);
			ArrayList<ItemStack> blocks = OreDictionary.getOres("block" + Names[y]);
			
			if (!ingots.isEmpty()) {
				for (ItemStack ingot : ingots) {
					Ingots [y] = ingot;
				}
			}
			else {
				System.out.println("Not Found : ingot" + Names[y]);
			}
			
			if (!blocks.isEmpty()) {
				for (ItemStack block : blocks) {
					this.blocks[y] = block;
				}
			}

		}
		
		
		
//		//base blocks
		blocksBlase[0] = BlockList.getSet("base").getDefaultBlock();
		blocksBlase[1] = BlockList.getSet("base").getDefaultBlock();
		blocksBlase[2] = BlockList.getSet("base").getDefaultBlock();
		blocksBlase[3] = BlockList.getSet("base").getDefaultBlock();
//		
//		Metadatas[0] = 2;
//		Metadatas[1] = 4;
//		Metadatas[2] = 5;
//		Metadatas[3] = 6;
//		//ender blocks
		blocksBlase[4] = BlockList.getSet("ender").getDefaultBlock();
		blocksBlase[5] = BlockList.getSet("ender").getDefaultBlock();
		blocksBlase[6] = BlockList.getSet("ender").getDefaultBlock();
//		
//		Metadatas[4] = 0;
//		Metadatas[5] = 1;
//		Metadatas[6] = 2;
//		
//		//fantasy blocks
		blocksBlase[7] = BlockList.getSet("fantasy").getDefaultBlock();
		blocksBlase[8] = BlockList.getSet("fantasy").getDefaultBlock();
		blocksBlase[9] = BlockList.getSet("fantasy").getDefaultBlock();
		blocksBlase[10] = BlockList.getSet("fantasy").getDefaultBlock();
		blocksBlase[11] = BlockList.getSet("fantasy").getDefaultBlock();
		blocksBlase[12] = BlockList.getSet("fantasy").getDefaultBlock();
		blocksBlase[13] = BlockList.getSet("fantasy").getDefaultBlock();
		blocksBlase[14] = BlockList.getSet("fantasy").getDefaultBlock();
		blocksBlase[15] = BlockList.getSet("fantasy").getDefaultBlock();
		blocksBlase[16] = BlockList.getSet("fantasy").getDefaultBlock();
		blocksBlase[17] = BlockList.getSet("fantasy").getDefaultBlock();
		blocksBlase[18] = BlockList.getSet("fantasy").getDefaultBlock();
		blocksBlase[19] = BlockList.getSet("fantasy").getDefaultBlock();
		blocksBlase[20] = BlockList.getSet("fantasy").getDefaultBlock();
		blocksBlase[21] = BlockList.getSet("fantasy").getDefaultBlock();
		blocksBlase[22] = BlockList.getSet("fantasy").getDefaultBlock();
//		
//		Metadatas[7] = 0;
//		Metadatas[8] = 1;
//		Metadatas[9] = 2;
//		Metadatas[10] = 3;
//		Metadatas[11] = 4;
//		Metadatas[12] = 5;
//		Metadatas[13] = 6;
//		Metadatas[14] = 7;
//		Metadatas[15] = 8;
//		Metadatas[16] = 9;
//		Metadatas[17] = 10;
//		Metadatas[18] = 11;
//		Metadatas[19] = 12;
//		Metadatas[20] = 13;
//		Metadatas[21] = 14;
//		Metadatas[22] = 15;
//		
//		//nether
		blocksBlase[23] = BlockList.getSet("nether").getDefaultBlock();
		blocksBlase[24] = BlockList.getSet("nether").getDefaultBlock();
		blocksBlase[25] = BlockList.getSet("nether").getDefaultBlock();
		blocksBlase[26] = BlockList.getSet("nether").getDefaultBlock();
		blocksBlase[27] = BlockList.getSet("nether").getDefaultBlock();
		blocksBlase[28] = BlockList.getSet("nether").getDefaultBlock();
		blocksBlase[29] = BlockList.getSet("nether").getDefaultBlock();
		blocksBlase[30] = BlockList.getSet("nether").getDefaultBlock();
		blocksBlase[31] = BlockList.getSet("nether").getDefaultBlock();
		blocksBlase[32] = BlockList.getSet("nether").getDefaultBlock();
		blocksBlase[33] = BlockList.getSet("nether").getDefaultBlock();
		blocksBlase[34] = BlockList.getSet("nether").getDefaultBlock();
		blocksBlase[35] = BlockList.getSet("nether").getDefaultBlock();
//		
//		Metadatas[23] = 0;
//		Metadatas[24] = 1;
//		Metadatas[25] = 2;
//		Metadatas[26] = 3;
//		Metadatas[27] = 4;
//		Metadatas[28] = 5;
//		Metadatas[29] = 6;
//		Metadatas[30] = 7;
//		Metadatas[31] = 8;
//		Metadatas[32] = 9;
//		Metadatas[33] = 10;
//		Metadatas[34] = 11;
//		Metadatas[35] = 12;
//
//		//precious
		blocksBlase[36] = BlockList.getSet("precious").getDefaultBlock();
		blocksBlase[37] = BlockList.getSet("precious").getDefaultBlock();
		blocksBlase[38] = BlockList.getSet("precious").getDefaultBlock();
//		
//		Metadatas[36] = 0;
//		Metadatas[37] = 2;
//		Metadatas[38] = 3;
}

}
