package cn.ksmcbrigade.eww.modules;

import cn.ksmcbrigade.vmr.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class NoClip extends Module {
    public NoClip() {
        super("hack.name.no_clip");
    }

    @Override
    public void playerTick(Minecraft MC, @Nullable Player player) {
        if(player==null) return;
        if(MC.cameraEntity==null) return;
        MC.cameraEntity.setNoGravity(true);
        player.setDeltaMovement(Vec3.ZERO);

        if(MC.options.keyShift.isDown()){
            player.setDeltaMovement(0,-0.6,0);
        }

        if(MC.options.keyJump.isDown()){
            player.setDeltaMovement(0,0.6,0);
        }
    }

    @Override
    public void disabled(Minecraft MC) {
        if (MC.cameraEntity != null) {
            MC.cameraEntity.setNoGravity(false);
        }
    }
}
