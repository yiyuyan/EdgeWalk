package cn.ksmcbrigade.eww.modules;

import cn.ksmcbrigade.vmr.module.Module;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;

public class AutoLeft extends Module {
    public AutoLeft() {
        super("hack.name.auto_click_left");
    }

    @Override
    public void playerTick(Minecraft MC, @Nullable Player player) {
        KeyMapping.click(MC.options.keyAttack.getKey());
    }

    @Override
    public void disabled(Minecraft MC) {
        MC.options.keyAttack.setDown(false);
    }
}
