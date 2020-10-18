package com.pmso.tugaflavours.client.blocks;

import com.pmso.tugaflavours.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class BlockFrancesinha extends Block{

	public BlockFrancesinha() {
		super(Block.Properties.create(Material.CAKE)
				.hardnessAndResistance(0.25f,3.0f)
				.sound(SoundType.GLASS)
				.harvestLevel(1));
	}

	    
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
    {
        this.eatFrancesinha(worldIn, pos, state, player);
        return ActionResultType.CONSUME;
    }

    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player)
    {
        //this.eatFrancesinha(worldIn, pos, worldIn.getBlockState(pos), playerIn);
    }
    
    private void eatFrancesinha(World worldIn, BlockPos pos, BlockState state, PlayerEntity player)
    {
        if (player.canEat(false))
        {
            player.getFoodStats().addStats(20, 1.5F);
                worldIn.setBlockState(pos, ModBlocks.DISH_BLOCK.get().getDefaultState());
                //player.addChatMessage(new ChatComponentText(player.getName()+" eat a big francesinha!"));
                /*double rand=Math.random()*100;
                if(rand<20){
                	player.setFire(3);
                	player.addChatMessage(new ChatComponentText(player.getName()+" eat a very spicy francesinha!"));
                }*/
        }
    }
   
}
