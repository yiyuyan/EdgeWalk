package cn.ksmcbrigade.eww.modules;

import cn.ksmcbrigade.vmr.module.Module;
import cn.ksmcbrigade.vmr.uitls.ModuleUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

public class EdgeJump extends Module {

    public EdgeJump() {
        super("hack.name.edge_jump");
    }

    @Override
    public void enabled(Minecraft MC) throws Exception {
        ModuleUtils.set("hack.name.edge_sk",false);
    }

    @Override
    public void playerTick(Minecraft MC, @Nullable Player player) {
        if(player==null) return;
        if(MC.level==null) return;
        if(!player.onGround() || MC.options.keyJump.isDown())
            return;

        if((player.isShiftKeyDown() || MC.options.keyShift.isDown()))
            return;

        AABB box = player.getBoundingBox();
        AABB adjustedBox = box.expandTowards(0, -0.05, 0).inflate(-0.01, 0, -0.01);

        if(!MC.level.noCollision(player, adjustedBox))
            return;

        player.jumpFromGround();
    }
}
