package lexwomy.verticalslabs.data;

import static net.minecraft.data.recipes.RecipeProvider.getHasName;

import java.util.List;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

// A recipe will be generated for every block in stonecutterInputs if stonecuttable,
// while a generic crafting recipe will be generated for the input block
public record VerticalSlabDetails(
    @NotNull String slabName,
    @NotNull Block slab,
    @NotNull Block textureSource,
    @NotNull VerticalSlabBlockModelGenerator verticalSlabBlockModelGenerator,
    @Nullable List<Block> craftingRecipeInput,
    @Nullable List<Block> stonecutterRecipeInputs) {

  public VerticalSlabDetails(
      @NotNull String slabName,
      @NotNull Block slab,
      @NotNull Block textureSource,
      @NotNull VerticalSlabBlockModelGenerator verticalSlabBlockModelGenerator,
      @Nullable List<Block> craftingRecipeInput) {
    this(
        slabName,
        slab,
        textureSource,
        verticalSlabBlockModelGenerator,
        craftingRecipeInput,
        null);
  }

  public VerticalSlabDetails(
      @NotNull String slabName,
      @NotNull Block slab,
      @NotNull Block textureSource,
      @NotNull VerticalSlabBlockModelGenerator verticalSlabBlockModelGenerator) {
    this(
        slabName,
        slab,
        textureSource,
        verticalSlabBlockModelGenerator,
        null,
        null);
  }

  public void generateBlockModels(BlockModelGenerators blockModelGenerators) {
    this.verticalSlabBlockModelGenerator.generateBlockModels(this.slab, this.textureSource, blockModelGenerators);
  }

  public void generateRecipes(RecipeProvider recipeProvider, RecipeOutput recipeOutput) {
    if (this.craftingRecipeInput != null) {
      ShapedRecipeBuilder slabRecipe =
          recipeProvider
              .shaped(RecipeCategory.BUILDING_BLOCKS, this.slab, 6)
              .define('#', Ingredient.of(this.craftingRecipeInput.stream()))
              .pattern("#")
              .pattern("#")
              .pattern("#");
      this.craftingRecipeInput.forEach(
          ingredient ->
              slabRecipe.unlockedBy(getHasName(ingredient), recipeProvider.has(ingredient)));
      slabRecipe.save(recipeOutput);
    }
    if (this.stonecutterRecipeInputs != null) {
      this.stonecutterRecipeInputs.forEach(
          stonecutterRecipeInput ->
              recipeProvider.stonecutterResultFromBase(
                  RecipeCategory.BUILDING_BLOCKS, this.slab, stonecutterRecipeInput, 2));
    }
  }

  public void generateTranslation(FabricLanguageProvider.TranslationBuilder translationBuilder) {
    translationBuilder.add(this.slab, this.slabName);
  }
}
