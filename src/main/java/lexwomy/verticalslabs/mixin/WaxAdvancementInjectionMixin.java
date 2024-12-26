package lexwomy.verticalslabs.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.mojang.serialization.Codec;
import lexwomy.verticalslabs.VerticalSlabs;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.resource.JsonDataLoader;
import net.minecraft.resource.ResourceManager;
import net.minecraft.server.ServerAdvancementLoader;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;

import java.util.*;

@Mixin(ServerAdvancementLoader.class)
public abstract class WaxAdvancementInjectionMixin extends JsonDataLoader<Advancement> {
    protected WaxAdvancementInjectionMixin(RegistryWrapper.WrapperLookup registries, Codec<Advancement> codec, RegistryKey<? extends Registry<Advancement>> registryRef) {
        super(registries, codec, registryRef);
    }

    @WrapMethod(method = "apply(Ljava/util/Map;Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)V")
    private void injectWaxVerticalSlabs(Map<Identifier, Advancement> map, ResourceManager resourceManager, Profiler profiler, Operation<Void> original) {
        if (VerticalSlabs.VERTICAL_SLABS_WAX_ON_CRITERION.isEmpty() || VerticalSlabs.VERTICAL_SLABS_WAX_OFF_CRITERION.isEmpty()) {
            VerticalSlabs.LOGGER.warn("One or more vertical slab criterions is empty! Unable to modify advancement - skipping");
        } else {
            //Since records are immutable (sadly), create a new wax on/wax off copy with the new requirements tacked on and replace the entry in the map
            Advancement originalWaxOn = map.get(Identifier.ofVanilla("husbandry/wax_on"));
            Advancement originalWaxOff = map.get(Identifier.ofVanilla("husbandry/wax_off"));

            HashMap<String, AdvancementCriterion<?>> newWaxOnCriteria = new HashMap<>(originalWaxOn.criteria());
            newWaxOnCriteria.put("vertical_slabs_wax_on", VerticalSlabs.VERTICAL_SLABS_WAX_ON_CRITERION.get());

            HashMap<String, AdvancementCriterion<?>> newWaxOffCriteria = new HashMap<>(originalWaxOff.criteria());
            newWaxOffCriteria.put("vertical_slabs_wax_off", VerticalSlabs.VERTICAL_SLABS_WAX_OFF_CRITERION.get());

            List<String> newWaxOnRequirements = new ArrayList<>();
            originalWaxOn.requirements().requirements().forEach(newWaxOnRequirements::addAll);
            newWaxOnRequirements.add("vertical_slabs_wax_on");

            List<String> newWaxOffRequirements = new ArrayList<>();
            originalWaxOff.requirements().requirements().forEach(newWaxOffRequirements::addAll);
            newWaxOffRequirements.add("vertical_slabs_wax_off");

            Advancement newWaxOn = new Advancement(originalWaxOn.parent(), originalWaxOn.display(), originalWaxOn.rewards(),
                    newWaxOnCriteria, AdvancementRequirements.CriterionMerger.OR.create(newWaxOnRequirements), originalWaxOn.sendsTelemetryEvent());
            Advancement newWaxOff = new Advancement(originalWaxOff.parent(), originalWaxOff.display(), originalWaxOff.rewards(),
                    newWaxOffCriteria, AdvancementRequirements.CriterionMerger.OR.create(newWaxOffRequirements), originalWaxOff.sendsTelemetryEvent());

            map.put(Identifier.ofVanilla("husbandry/wax_on"), newWaxOn);
            map.put(Identifier.ofVanilla("husbandry/wax_off"), newWaxOff);
        }
        original.call(map, resourceManager, profiler);
    }
}
