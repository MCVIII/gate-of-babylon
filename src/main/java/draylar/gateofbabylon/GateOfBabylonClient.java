package draylar.gateofbabylon;

import draylar.gateofbabylon.impl.client.BowPullPredicate;
import draylar.gateofbabylon.impl.client.BowPullingPredicate;
import draylar.gateofbabylon.impl.client.ShieldUsePredicate;
import draylar.gateofbabylon.item.CustomBowItem;
import draylar.gateofbabylon.registry.GOBEntities;
import draylar.gateofbabylon.registry.GOBItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class GateOfBabylonClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerBowPredicates(GOBItems.STONE_BOW);
        registerBowPredicates(GOBItems.IRON_BOW);
        registerBowPredicates(GOBItems.GOLDEN_BOW);
        registerBowPredicates(GOBItems.DIAMOND_BOW);
        registerBowPredicates(GOBItems.NETHERITE_BOW);

        FabricModelPredicateProviderRegistry.register(GOBItems.STONE_SHIELD, new Identifier("blocking"), new ShieldUsePredicate());
        FabricModelPredicateProviderRegistry.register(GOBItems.IRON_SHIELD, new Identifier("blocking"), new ShieldUsePredicate());
        FabricModelPredicateProviderRegistry.register(GOBItems.GOLDEN_SHIELD, new Identifier("blocking"), new ShieldUsePredicate());
        FabricModelPredicateProviderRegistry.register(GOBItems.DIAMOND_SHIELD, new Identifier("blocking"), new ShieldUsePredicate());
        FabricModelPredicateProviderRegistry.register(GOBItems.NETHERITE_SHIELD, new Identifier("blocking"), new ShieldUsePredicate());
    }

    public static void registerBowPredicates(CustomBowItem bow) {
        FabricModelPredicateProviderRegistry.register(bow, new Identifier("pull"), new BowPullPredicate(bow));
        FabricModelPredicateProviderRegistry.register(bow, new Identifier("pulling"), new BowPullingPredicate());
    }
}
