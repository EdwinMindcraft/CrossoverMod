package mod.mindcraft.addon.crossover.christmas.world;

import java.util.Random;

import mod.mindcraft.addon.crossover.christmas.ChristmasThing;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class ChristmasWorldGenerator implements IWorldGenerator{

	WorldGenMinable yellowDecorative;
	WorldGenMinable redDecorative;
	WorldGenMinable blueDecorative;
	WorldGenMinable greenDecorative;
	WorldGenMinable whiteDecorative;
	WorldGenMinable blackDecorative;
	
	public ChristmasWorldGenerator() {
		yellowDecorative = new WorldGenMinable(ChristmasThing.oreYellowDecorative, 0, 8, Blocks.stone);
		redDecorative = new WorldGenMinable(ChristmasThing.oreRedDecorative, 0, 8, Blocks.stone);
		blueDecorative = new WorldGenMinable(ChristmasThing.oreBlueDecorative, 0, 8, Blocks.stone);
		greenDecorative = new WorldGenMinable(ChristmasThing.oreGreenDecorative, 0, 8, Blocks.stone);
		whiteDecorative = new WorldGenMinable(ChristmasThing.oreWhiteDecorative, 0, 8, Blocks.stone);
		blackDecorative = new WorldGenMinable(ChristmasThing.oreBlackDecorative, 0, 8, Blocks.stone);
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if ((world.provider.terrainType != WorldType.FLAT) && (!world.provider.isHellWorld)) {
			generateOres(random, chunkX * 16, chunkZ* 16, world);			
		}
	}
	
    void generateOres (Random random, int xChunk, int zChunk, World world)
    {
    	
    	WorldGenMinable ores[] = {yellowDecorative, redDecorative, blueDecorative, greenDecorative, whiteDecorative, blackDecorative};
        int xPos, yPos, zPos;
        for (int i = 0; i < ores.length; i++){
            for (int q = 0; q <= 5; q++)
            {
                xPos = xChunk + random.nextInt(16);
                yPos = 0 + random.nextInt(64);
                zPos = zChunk + random.nextInt(16);
                ores[i].generate(world, random, xPos, yPos, zPos);
            }
        }
    }

}
