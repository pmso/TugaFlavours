package com.pmso.tugaflavours.client.blocks;

import java.util.stream.Stream;

import com.pmso.tugaflavours.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.ChatLine;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Chat;

public class FrancesinhaBlock extends Block{

	private final VoxelShape NORTH=Stream.of(
			Block.makeCuboidShape(4, 1, 4, 12, 4, 12),
			Block.makeCuboidShape(3, 0, 3, 13, 1, 13),
			Block.makeCuboidShape(2, 1, 1, 14, 2, 3),
			Block.makeCuboidShape(1, 1, 3, 3, 2, 14),
			Block.makeCuboidShape(2, 1, 13, 14, 2, 15),
			Block.makeCuboidShape(13, 1, 2, 15, 2, 14)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	public FrancesinhaBlock() {
		super(Block.Properties.create(Material.CAKE)
				.zeroHardnessAndResistance()
				.sound(SoundType.GLASS)
				.notSolid()
				.harvestLevel(1));
	}

	    
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
    {
    	if (worldIn.isRemote) {
               return ActionResultType.SUCCESS;
         }
        this.eatFrancesinha(worldIn, pos, state, player);
        return ActionResultType.SUCCESS;
    }
    
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
    	// TODO Auto-generated method stub
    	return NORTH;
    }
    
    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader reader, BlockPos pos) {
    	// TODO Auto-generated method stub
    	return NORTH;
    }
    
    private void eatFrancesinha(World worldIn, BlockPos pos, BlockState state, PlayerEntity player)
    {
        if (player.canEat(false))
        {
            player.getFoodStats().addStats(18, 1.5F);
            worldIn.setBlockState(pos, ModBlocks.DISH_BLOCK.get().getDefaultState());
        }
    }
    
    /**Change the block shadow -- Lower return values = more shadow*/
    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.6F;
    }
   
}
