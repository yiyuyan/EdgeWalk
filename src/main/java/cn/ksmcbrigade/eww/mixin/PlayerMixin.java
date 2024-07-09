package cn.ksmcbrigade.eww.mixin;

import cn.ksmcbrigade.eww.EdgeWalk;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import javax.annotation.Nullable;

@Mixin(LocalPlayer.class)
public abstract class PlayerMixin extends AbstractClientPlayer {

    @Shadow @Nullable public abstract MobEffectInstance removeEffectNoUpdate(@org.jetbrains.annotations.Nullable MobEffect p_108720_);

    @Shadow @Final protected Minecraft minecraft;

    public PlayerMixin(ClientLevel p_250460_, GameProfile p_249912_) {
        super(p_250460_, p_249912_);
    }

    @Unique
    protected boolean isStayingOnGroundSurface() {
        return super.isStayingOnGroundSurface() || EdgeWalk.edgeSneak.enabled;
    }

    @Unique
    protected @NotNull Vec3 maybeBackOffFromEdge(@NotNull Vec3 p_36201_, @NotNull MoverType p_36202_) {
        Vec3 vec3 = super.maybeBackOffFromEdge(p_36201_,p_36202_);
        EdgeWalk.edgeSneak.clip(!p_36201_.equals(vec3),this.minecraft,this.minecraft.player);
        return vec3;
    }
}
