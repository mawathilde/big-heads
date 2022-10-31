package fr.mawathilde.bigheads.mixin;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Function;

@Mixin(PlayerEntityModel.class)
public class MixinRenderPlayer<T extends LivingEntity> extends BipedEntityModel<T> {

    public MixinRenderPlayer(ModelPart root) {
        super(root);
    }

    public MixinRenderPlayer(ModelPart root, Function<Identifier, RenderLayer> renderLayerFactory) {
        super(root, renderLayerFactory);
    }

    @Inject(at = @At("TAIL"), method = "<init>")
    public void injectConstructor(ModelPart root, boolean thinArms, CallbackInfo ci) {
        head.scale(new Vec3f(2.0F, 2.0F, 2.0F));
    }

}
