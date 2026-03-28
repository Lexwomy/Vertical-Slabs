package lexwomy.verticalslabs.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.mojang.serialization.Codec;
import java.util.*;
import lexwomy.verticalslabs.VerticalSlabs;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.Criterion;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.ServerAdvancementManager;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ServerAdvancementManager.class)
public abstract class WaxAdvancementInjectionMixin
    extends SimpleJsonResourceReloadListener<Advancement> {
  protected WaxAdvancementInjectionMixin(
      HolderLookup.Provider registries,
      Codec<Advancement> codec,
      ResourceKey<? extends Registry<Advancement>> registryRef) {
    super(registries, codec, registryRef);
  }

  @WrapMethod(
      method =
          "apply(Ljava/util/Map;Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)V")
  private void injectWaxVerticalSlabs(
      Map<Identifier, Advancement> map,
      ResourceManager resourceManager,
      ProfilerFiller profiler,
      Operation<Void> original) {
    if (VerticalSlabs.VERTICAL_SLABS_WAX_ON_CRITERION == null
        || VerticalSlabs.VERTICAL_SLABS_WAX_OFF_CRITERION == null) {
      VerticalSlabs.LOGGER.warn(
          "One or more vertical slab criterions is empty! Unable to modify advancement - skipping");
    } else {
      // Since records are immutable (sadly), create a new wax on/wax off copy with the new
      // requirements tacked on and replace the entry in the map
      Advancement originalWaxOn = map.get(Identifier.withDefaultNamespace("husbandry/wax_on"));
      Advancement originalWaxOff = map.get(Identifier.withDefaultNamespace("husbandry/wax_off"));

      HashMap<String, Criterion<?>> newWaxOnCriteria = new HashMap<>(originalWaxOn.criteria());
      newWaxOnCriteria.put("vertical_slabs_wax_on", VerticalSlabs.VERTICAL_SLABS_WAX_ON_CRITERION);

      HashMap<String, Criterion<?>> newWaxOffCriteria = new HashMap<>(originalWaxOff.criteria());
      newWaxOffCriteria.put(
          "vertical_slabs_wax_off", VerticalSlabs.VERTICAL_SLABS_WAX_OFF_CRITERION);

      List<String> newWaxOnRequirements = new ArrayList<>();
      originalWaxOn.requirements().requirements().forEach(newWaxOnRequirements::addAll);
      newWaxOnRequirements.add("vertical_slabs_wax_on");

      List<String> newWaxOffRequirements = new ArrayList<>();
      originalWaxOff.requirements().requirements().forEach(newWaxOffRequirements::addAll);
      newWaxOffRequirements.add("vertical_slabs_wax_off");

      Advancement newWaxOn =
          new Advancement(
              originalWaxOn.parent(),
              originalWaxOn.display(),
              originalWaxOn.rewards(),
              newWaxOnCriteria,
              AdvancementRequirements.Strategy.OR.create(newWaxOnRequirements),
              originalWaxOn.sendsTelemetryEvent());
      Advancement newWaxOff =
          new Advancement(
              originalWaxOff.parent(),
              originalWaxOff.display(),
              originalWaxOff.rewards(),
              newWaxOffCriteria,
              AdvancementRequirements.Strategy.OR.create(newWaxOffRequirements),
              originalWaxOff.sendsTelemetryEvent());

      map.put(Identifier.withDefaultNamespace("husbandry/wax_on"), newWaxOn);
      map.put(Identifier.withDefaultNamespace("husbandry/wax_off"), newWaxOff);
    }
    original.call(map, resourceManager, profiler);
  }
}
