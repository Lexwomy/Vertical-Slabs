# Vertical-Slabs

Works like you would expect from regular slabs, but rotated!
Placing the slab will orient it in the opposite direction you are facing (north/south, east/west).
Depending on the hit placement (e.g. where you clicked on the block), the slab will be placed near you or further away.
Similar to how vanilla slab placement works (looking at top half of block places top slab, and vice versa).

Additional features:

- Crafting recipes for chiseled blocks and other blocks made from horizontal slabs now exist to craft from vertical slab
  variants
- Stonecutting from base blocks now have vertical slabs at the same ratio of vanilla slabs
- Recipe discovery more or less the same as vanilla slab recipe discovery
- Wax On / Wax Off advancements now track vertical copper variants as well
- Vertical copper slab variants can be oxidized and waxed like normal copper
- Vertical smooth stone, sandstone slabs and their variants (red and cut) are now directional
    - Imagine a rotated double smooth stone block orientable in any horizontal direction, that's what it looks like
    - The rest are uv-locked so they are not directional
- All models taken from minecraft textures so it will carry over to other resource packs
    - As long as the vanilla models are not touched, the vertical slab models will be consistent
- Walls will connect to vertical slabs
- Depend on this mod to access the code and easily create your own vertical slabs

Known issues:

- Placing a vertical slab while having the player hitbox near the new wall hitbox after connection will cause the player
  to be able to walk through the wall. This issues exists in vanilla as well, which can be replicated by using a regular
  block instead.

Issues addressed:

- Mud bricks use a north west mirrored model, but its variants use the regular cube model (MC-250692). Vertical mud
  brick slabs use the north west mirrored model.