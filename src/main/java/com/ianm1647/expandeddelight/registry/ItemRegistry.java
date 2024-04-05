package com.ianm1647.expandeddelight.registry;

import com.ianm1647.expandeddelight.ExpandedDelight;
import com.ianm1647.expandeddelight.block.BlockList;
import com.ianm1647.expandeddelight.item.ItemList;
import com.ianm1647.expandeddelight.item.JuiceItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class ItemRegistry {

    public static void registerItems() {
        //items
        ItemList.GLASS_JAR = item("glass_jar");

        ItemList.RAW_CINNAMON = item("raw_cinnamon");
        ItemList.GROUND_CINNAMON = item("ground_cinnamon");
        ItemList.SALT_ROCK = item("salt_rock");
        ItemList.GROUND_SALT = item("ground_salt");

        //seeds
        ItemList.ASPARAGUS_SEEDS = itemBlock("asparagus_seeds", BlockList.ASPARAGUS_CROP);
        ItemList.CHILI_PEPPER_SEEDS = itemBlock("chili_pepper_seeds", BlockList.CHILI_PEPPER_CROP);

        //crops
        ItemList.ASPARAGUS = food("asparagus", null,2, 0.3f);
        ItemList.SWEET_POTATO = foodSeed("sweet_potato", BlockList.SWEET_POTATO_CROP, 2, 0.4f);
        ItemList.CHILI_PEPPER = food("chili_pepper", null, 2, 0.3f);

        ItemList.PEANUT = foodSeed("peanut", BlockList.PEANUT_CROP, 1, 0.2f);

        //foods
        ItemList.BAKED_SWEET_POTATO = food("baked_sweet_potato", null, 5, 0.5f);

        ItemList.CHEESE_WHEEL = food("cheese_wheel",null, 8, 0.5f);
        ItemList.CHEESE_SLICE = food("cheese_slice",null, 2, 0.2f);
        ItemList.CHEESE_SANDWICH = food("cheese_sandwich", null, 3, 0.3f);
        ItemList.GRILLED_CHEESE = food("grilled_cheese", null, 5, 0.5f);

        ItemList.PEANUT_BUTTER = food("peanut_butter", Items.BOWL,2, 0.3f);
        ItemList.PEANUT_BUTTER_SANDWICH = food("peanut_butter_sandwich", null,4, 0.4f);
        ItemList.PEANUT_BUTTER_HONEY_SANDWICH = food("peanut_butter_honey_sandwich", null, 5, 0.5f);
        ItemList.SWEET_BERRY_JELLY_SANDWICH = food("sweet_berry_jelly_sandwich", null, 6, 0.5f);
        ItemList.GLOW_BERRY_JELLY_SANDWICH = food("glow_berry_jelly_sandwich", null, 6, 0.5f);

        ItemList.SWEET_ROLL = food("sweet_roll", null, 4, 0.3f);
        ItemList.BERRY_SWEET_ROLL = food("berry_sweet_roll", null, 5, 0.4f);
        ItemList.GLOW_BERRY_SWEET_ROLL = food("glow_berry_sweet_roll", null, 5, 0.4f);
        ItemList.CINNAMON_RICE = food("cinnamon_rice", Items.BOWL, 7, 0.5f);
        ItemList.CINNAMON_APPLES = food("cinnamon_apples", Items.BOWL, 6, 0.6f);

        ItemList.CHOCOLATE_COOKIE = food("chocolate_cookie", null, 2, 0.3f);
        ItemList.SUGAR_COOKIE = food("sugar_cookie", null, 1, 0.3f);
        ItemList.SNICKERDOODLE = food("snickerdoodle", null, 2, 0.3f);

        //juices
        ItemList.APPLE_JUICE = juice("apple_juice", 1, 1.2f, StatusEffects.SPEED);
        ItemList.SWEET_BERRY_JUICE = juice("sweet_berry_juice", 1, 1.2f, StatusEffects.HEALTH_BOOST);
        ItemList.GLOW_BERRY_JUICE = juice("glow_berry_juice", 1, 1.2f, StatusEffects.NIGHT_VISION);

        //jellies
        ItemList.SWEET_BERRY_JELLY = jelly("sweet_berry_jelly", 3, 0.6f, StatusEffects.HEALTH_BOOST);
        ItemList.GLOW_BERRY_JELLY = jelly("glow_berry_jelly", 3, 0.6f, StatusEffects.NIGHT_VISION);

        //salads
        ItemList.PEANUT_SALAD = salad("peanut_salad", 6, 0.6f);
        ItemList.SWEET_POTATO_SALAD = salad("sweet_potato_salad", 6, 0.6f);

        //soups
        ItemList.ASPARAGUS_SOUP = stew("asparagus_soup", 7, 0.8f);
        ItemList.ASPARAGUS_SOUP_CREAMY = stew("asparagus_soup_creamy", 8, 0.8f);
        ItemList.PEANUT_HONEY_SOUP = stew("peanut_honey_soup", 8, 0.8f);

        //meals
        ItemList.MAC_AND_CHEESE = meal("mac_and_cheese", 8, 0.8f);
        ItemList.ASPARAGUS_AND_BACON_CHEESY = meal("asparagus_and_bacon_cheesy", 10, 0.9f);
        ItemList.PEPERONATA = meal("peperonata", 10, 0.9f);

        //block items
        ItemList.MORTAR_AND_PESTLE = itemBlock("mortar_and_pestle_item", BlockList.MORTAR_AND_PESTLE);
        ItemList.JUICER_ITEM = itemBlock("juicer_item", BlockList.JUICER);

        //ExpandedDelight.LOGGER.info("ExpandedDelight items loaded");
    }

    private static Item item(String name) {
        Item item = Registry.register(Registries.ITEM, new Identifier(ExpandedDelight.MODID, name),
                new Item(new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(ExpandedDelight.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item itemBlock(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(ExpandedDelight.MODID, name),
                new AliasedBlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(ExpandedDelight.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item food(String name, Item remainder, int hunger, float saturation) {
        Item item = Registry.register(Registries.ITEM, new Identifier(ExpandedDelight.MODID, name),
                new Item(new FabricItemSettings().recipeRemainder(remainder)
                        .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation).build())));
        ItemGroupEvents.modifyEntriesEvent(ExpandedDelight.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item foodSeed(String name, Block block, int hunger, float saturation) {
        Item item = Registry.register(Registries.ITEM, new Identifier(ExpandedDelight.MODID, name),
                new AliasedBlockItem(block, new FabricItemSettings().recipeRemainder(null)
                        .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation).build())));
        ItemGroupEvents.modifyEntriesEvent(ExpandedDelight.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item juice(String name, int hunger, float saturation, StatusEffect effect) {
        Item item = Registry.register(Registries.ITEM, new Identifier(ExpandedDelight.MODID, name),
                new JuiceItem(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(16)
                        .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation).alwaysEdible()
                                .statusEffect(new StatusEffectInstance(effect, 200, 0), 1.0f).build())));
        ItemGroupEvents.modifyEntriesEvent(ExpandedDelight.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item jelly(String name, int hunger, float saturation, StatusEffect effect) {
        Item item = Registry.register(Registries.ITEM, new Identifier(ExpandedDelight.MODID, name),
                new Item(new FabricItemSettings().recipeRemainder(ItemList.GLASS_JAR).maxCount(16)
                        .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation)
                                .statusEffect(new StatusEffectInstance(effect, 400, 0), 1.0f).build())));
        ItemGroupEvents.modifyEntriesEvent(ExpandedDelight.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item salad(String name, int hunger, float saturation) {
        Item item = Registry.register(Registries.ITEM, new Identifier(ExpandedDelight.MODID, name),
                new Item(new FabricItemSettings().recipeRemainder(Items.BOWL).maxCount(16)
                        .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation)
                                .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0), 1.0f).build())));
        ItemGroupEvents.modifyEntriesEvent(ExpandedDelight.GROUP).register(entries -> entries.add(item));
        return item;

    }

    private static Item stew(String name, int hunger, float saturation) {
        Item item = Registry.register(Registries.ITEM, new Identifier(ExpandedDelight.MODID, name),
                new Item(new FabricItemSettings().recipeRemainder(Items.BOWL).maxCount(16)
                        .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation)
                                .statusEffect(new StatusEffectInstance(ModEffects.COMFORT.get(), 2400, 0), 1.0f).build())));
        ItemGroupEvents.modifyEntriesEvent(ExpandedDelight.GROUP).register(entries -> entries.add(item));
        return item;
    }

    private static Item meal(String name, int hunger, float saturation) {
        Item item = Registry.register(Registries.ITEM, new Identifier(ExpandedDelight.MODID, name),
                new Item(new FabricItemSettings().recipeRemainder(Items.BOWL).maxCount(16)
                        .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation)
                                .statusEffect(new StatusEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1.0f).build())));
        ItemGroupEvents.modifyEntriesEvent(ExpandedDelight.GROUP).register(entries -> entries.add(item));
        return item;
    }
}
