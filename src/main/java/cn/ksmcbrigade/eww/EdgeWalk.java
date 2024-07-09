package cn.ksmcbrigade.eww;

import cn.ksmcbrigade.eww.modules.*;
import cn.ksmcbrigade.vmr.uitls.ModuleUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(EdgeWalk.MODID)
@Mod.EventBusSubscriber
public class EdgeWalk {

    public static final String MODID = "eww";

    public static NoClip noClip = new NoClip();

    public static EdgeSneak edgeSneak = new EdgeSneak();
    public static EdgeJump edgeJump = new EdgeJump();

    public static AutoLeft autoLeft = new AutoLeft();
    public static AutoRight autoRight = new AutoRight();

    public EdgeWalk() {
        MinecraftForge.EVENT_BUS.register(this);
        ModuleUtils.add(noClip);

        ModuleUtils.add(edgeSneak);
        ModuleUtils.add(edgeJump);

        ModuleUtils.add(autoLeft);
        ModuleUtils.add(autoRight);
    }
}
