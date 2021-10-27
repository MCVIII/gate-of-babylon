package draylar.gateofbabylon;

import draylar.gateofbabylon.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class GateOfBabylon implements ModInitializer {

    public static final ItemGroup GROUP = FabricItemGroupBuilder.build(id("group"), () -> new ItemStack(GOBItems.EXTENDED_STICK));

    public static Identifier id(String name) {
        return new Identifier("gateofbabylon", name);
    }

    @Override
    public void onInitialize() {
        GOBEffects.init();
        GOBItems.init();
        GOBEnchantments.init();
        GOBEntities.init();
        GOBBlocks.init();
        GOBSounds.init();
    }
}
