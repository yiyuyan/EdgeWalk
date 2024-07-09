package cn.ksmcbrigade.eww.mixin;

import cn.ksmcbrigade.eww.EdgeWalk;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.BlockStateBase.class)
public class BlockStateMixin {
    @Inject(method = "getCollisionShape(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/phys/shapes/CollisionContext;)Lnet/minecraft/world/phys/shapes/VoxelShape;",at = @At("RETURN"),cancellable = true)
    public void shape(BlockGetter p_60743_, BlockPos p_60744_, CollisionContext p_60745_, CallbackInfoReturnable<VoxelShape> cir){
        if(EdgeWalk.noClip.enabled){
            cir.setReturnValue(Shapes.empty());
        }
    }
}
