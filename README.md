# Vertical-Slabs

Works like you would expect from regular slabs, but rotated! 
Placing the slab will orient it in the directional plane you are facing (north/south, east/west).
Depending on the hit placement (e.g. where you clicked on the block), the slab will be placed near you or further away. 
For example, while facing north, placing the slab while looking at the near half of the block will place it oriented north, while looking at the far half of the block will place it oriented south.
Similar to how vanilla slab placement works (looking at top half of block places top slab, and vice versa).

Additional features (or annoyances):

- Crafting recipes for chiseled blocks and other blocks made from horizontal slabs now exist to craft from vertical slab variants
- Stonecutting from base blocks now have vertical slabs at the same ratio of vanilla slabs
- Recipe discovery more or less the same as vanilla slab recipe discovery
- Wax On / Wax Off advancements now track vertical copper variants as well
- Vertical copper slab variants can be oxidized and waxed like normal copper
- Vertical smooth stone, cut sandstone, and cut red sandstone slabs are now directional
  - Imagine a rotated double smooth stone block orientable in any horizontal direction, that's what it looks like
  - The rest are uv-locked so they are not directional (which is good for consistency, since having a rotated stone texture in the middle of a stone outcrop would not look so great)
- All models taken from minecraft textures so it will carry over to other resource packs 
  - As long as the vanilla models are not touched, the vertical slab models will be consistent