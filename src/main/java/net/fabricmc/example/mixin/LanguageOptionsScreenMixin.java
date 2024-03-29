package net.fabricmc.example.mixin;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(
	targets = {"net/minecraft/client/gui/screen/options/LanguageOptionsScreen$LanguageSelectionListWidget"}
)
public class LanguageOptionsScreenMixin {
	@Redirect(
		method = {"selectEntry"},
		at = @At(
		value = "INVOKE",
		target = "Lnet/minecraft/client/MinecraftClient;stitchTextures()V"
		)
	)
	private void replaceStitching(MinecraftClient client) {
		client.getLanguageManager().reload(client.getResourceManager());
	}
}
