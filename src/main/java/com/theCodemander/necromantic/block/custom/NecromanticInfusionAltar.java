package com.theCodemander.necromantic.block.custom;

import java.util.stream.Stream;


import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class NecromanticInfusionAltar extends Block{

    public static final DirectionProperty FACEING = BlockStateProperties.HORIZONTAL_FACING;


    public NecromanticInfusionAltar(Properties properties){
        super(properties);
    }


    private static final VoxelShape SHAPE_S = Stream.of(
        Block.box(0, 1, -1, 16, 15, 15), 
        Block.box(-8, 0, 0, 24, 13.5, 16)).reduce((v1,v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_E = Stream.of(
        Block.box(0.5, 1, -0.5, 16.5, 15, 15.5),
        Block.box(-0.5, 0, -8.5, 15.5, 13.5, 23.5)).reduce((v1,v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_N = Stream.of(
        Block.box(0, 1, 0, 16, 15, 16), 
        Block.box(-8, 0, -1, 24, 13.5, 15)).reduce((v1,v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_W = Stream.of(
        Block.box(-0.5, 1, -0.5, 15.5, 15, 15.5), 
        Block.box(0.5, 0, -8.5, 16.5, 13.5, 23.5)).reduce((v1,v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();



    
    @Override
    
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_,
            CollisionContext p_60558_) {
        switch (p_60555_.getValue(FACEING)) {
            case NORTH:   
                return SHAPE_N;
            case EAST:   
                return SHAPE_E;
            case WEST:   
                return SHAPE_W;
            case SOUTH:   
                return SHAPE_S;
            default:
                return SHAPE_E;
        }
    }

    /*  FACEING */

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
