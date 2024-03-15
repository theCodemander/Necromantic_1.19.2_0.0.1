package com.theCodemander.necromantic.block.custom;


import java.util.stream.Stream;

import javax.annotation.Nullable;

import it.unimi.dsi.fastutil.ints.Int2BooleanFunctions;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class __NecromanticInfusionAltar extends HorizontalDirectionalBlock{
    
    public static final DirectionProperty FACEING = BlockStateProperties.HORIZONTAL_FACING;
    
    
    public __NecromanticInfusionAltar(Properties properties){
        super(properties);
    }

    private static final VoxelShape SHAPE = Block.box(-16, 0, 0, 32, 15, 16);



    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_,
            CollisionContext p_60558_) {

        return SHAPE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext p_49820_) {

        return this.defaultBlockState().setValue(FACEING, p_49820_.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState p_54125_, Rotation p_54126_) {

        return p_54125_.setValue(FACEING, p_54126_.rotate(p_54125_.getValue(FACEING)));
    }

    @Override
    public BlockState mirror(BlockState p_54122_, Mirror p_54123_) {

        return p_54122_.rotate(p_54123_.getRotation(p_54122_.getValue(FACEING)));
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACEING);
    }
}
