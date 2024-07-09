package cn.ksmcbrigade.eww.modules;

import cn.ksmcbrigade.vmr.module.Module;
import cn.ksmcbrigade.vmr.uitls.ModuleUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;

public class EdgeSneak extends Module {

    public boolean sneak = false;

    public EdgeSneak() {
        super("hack.name.edge_sk");
    }

    @Override
    public void enabled(Minecraft MC) throws Exception {
        ModuleUtils.set("hack.name.edge_jump",false);
        this.sneak = false;
    }

    @Override
    public void disabled(Minecraft MC) {
        if (this.sneak) {
            set(false);
        }
    }

    public void clip(boolean clip,Minecraft MC, @Nullable Player player){
        if(player==null) return;
        if(MC.level==null) return;
        if(!enabled || !player.onGround()){
            if(sneak) set(false);
            return;
        }
        AABB box = player.getBoundingBox();
        AABB adjustedBox = box.expandTowards(0, -player.getStepHeight(), 0).inflate(-0.01, 0, -0.01);

        if(MC.level.noCollision(player, adjustedBox)) clip = true;

        set(clip);
    }

    public void set(boolean sneak){
        Minecraft MC = Minecraft.getInstance();
        if(sneak){
            MC.options.keyShift.setDown(true);
        }
        else{
            MC.options.keyShift.setDown(false);
        }
        this.sneak = sneak;
    }
}
